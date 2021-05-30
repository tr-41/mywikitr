package com.zhuanye.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuanye.wiki.domain.*;
import com.zhuanye.wiki.exception.BusinessException;
import com.zhuanye.wiki.exception.BusinessExceptionCode;
import com.zhuanye.wiki.mapper.*;
import com.zhuanye.wiki.req.DocQueryReq;
import com.zhuanye.wiki.req.DocSaveReq;
import com.zhuanye.wiki.resp.DocQueryResp;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.util.CopyUtil;
import com.zhuanye.wiki.util.RedisUtil;
import com.zhuanye.wiki.util.RequestContext;
import com.zhuanye.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class DocService {

    private static final Logger LOG = LoggerFactory.getLogger(DocService.class);

    @Resource
    private DocMapper docMapper;

    @Resource
    private DocMapperCust docMapperCust;

    @Resource
    private ContentMapper contentMapper;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    public RedisUtil redisUtil;

    @Resource
    public WsService wsService;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    HttpServletRequest request;

    @Resource
    private DocEditMapper docEditMapper;

    @Resource
    private DocDeleteMapper docDeleteMapper;

    public List<DocQueryResp> all(Long ebookId) {
        DocExample docExample = new DocExample();
        docExample.createCriteria().andEbookIdEqualTo(ebookId);
        docExample.setOrderByClause("sort asc");
        List<Doc> docList = docMapper.selectByExample(docExample);

        // 列表复制
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);

        return list;
    }

    public PageResp<DocQueryResp> list(DocQueryReq req) {
        DocExample docExample = new DocExample();
        docExample.setOrderByClause("sort asc");
        DocExample.Criteria criteria = docExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Doc> docList = docMapper.selectByExample(docExample);

        PageInfo<Doc> pageInfo = new PageInfo<>(docList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        // 列表复制
        List<DocQueryResp> list = CopyUtil.copyList(docList, DocQueryResp.class);

        PageResp<DocQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    /**
     * 保存
     */
    @Transactional
    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        Content content = CopyUtil.copy(req, Content.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            long id=snowFlake.nextId();
            doc.setId(id);
            doc.setViewCount(0);
            doc.setVoteCount(0);
            docMapper.insert(doc);

            String token = request.getHeader("token");
            String string = (String) redisTemplate.opsForValue().get(token);
            int s=string.indexOf(":");
            char[] ch=string.toCharArray();
            String id1="";
            int i=0;
            for(s=s+1;s<ch.length;s++){
                if(Character.isDigit(ch[s])) {
                    id1 += ch[s];
                }else{
                    break;
                }
            }
            String name1="";
            for(s=s+14;s<ch.length;s++){
                if(ch[s]!='"'){
                    name1+=ch[s];
                }else{
                    break;
                }
            }
            DocEdit docEdit=new DocEdit(Long.parseLong(id1),id,name1,doc.getName());
            if((docEditMapper.selectByPrimaryKey(Long.parseLong(id1),doc.getId())==null)){
                docEditMapper.insert(docEdit);
            }

            content.setId(doc.getId());
            contentMapper.insert(content);
        } else {
            // 更新
            String token = request.getHeader("token");
            String string = (String) redisTemplate.opsForValue().get(token);
            int s=string.indexOf(":");
            char[] ch=string.toCharArray();
            String id1="";
            int i=0;
            for(s=s+1;s<ch.length;s++){
                if(Character.isDigit(ch[s])) {
                    id1 += ch[s];
                }else{
                    break;
                }
            }
            String name1="";
            for(s=s+14;s<ch.length;s++){
                if(ch[s]!='"'){
                    name1+=ch[s];
                }else{
                    break;
                }
            }
            DocEdit docEdit=new DocEdit( Long.parseLong(id1),doc.getId(),name1,doc.getName());

            if((docEditMapper.selectByPrimaryKey(Long.parseLong(id1),doc.getId())==null)){
                docEditMapper.insert(docEdit);
            }
            docMapper.updateByPrimaryKey(doc);
            int count = contentMapper.updateByPrimaryKeyWithBLOBs(content);
            if (count == 0) {
                contentMapper.insert(content);
            }
        }
    }

    public void delete(Long id) {
        String token = request.getHeader("token");
        String string = (String) redisTemplate.opsForValue().get(token);
        int s=string.indexOf(":");
        char[] ch=string.toCharArray();
        String id1="";
        int i=0;
        for(s=s+1;s<ch.length;s++){
            if(Character.isDigit(ch[s])) {
                id1 += ch[s];
            }else{
                break;
            }
        }
        String name1="";
        for(s=s+14;s<ch.length;s++){
            if(ch[s]!='"'){
                name1+=ch[s];
            }else{
                break;
            }
        }
        Doc doc=docMapper.selectByPrimaryKey(id);
        DocDelete docDelete=new DocDelete( Long.parseLong(id1),doc.getId(),name1,doc.getName());
        if((docDeleteMapper.selectByPrimaryKey(Long.parseLong(id1),doc.getId())==null)){
            docDeleteMapper.insert(docDelete);
        }
        docMapper.deleteByPrimaryKey(id);
    }

    public void delete(List<String> ids) {
        DocExample docExample = new DocExample();
        DocExample.Criteria criteria = docExample.createCriteria();
        criteria.andIdIn(ids);

        String token = request.getHeader("token");
        String string = (String) redisTemplate.opsForValue().get(token);
        int s=string.indexOf(":");
        char[] ch=string.toCharArray();
        String id1="";
        int i=0;
        for(s=s+1;s<ch.length;s++){
            if(Character.isDigit(ch[s])) {
                id1 += ch[s];
            }else{
                break;
            }
        }
        String name1="";
        for(s=s+14;s<ch.length;s++){
            if(ch[s]!='"'){
                name1+=ch[s];
            }else{
                break;
            }
        }
        for(int aa=0;aa<ids.size();aa++){
            Doc doc=docMapper.selectByPrimaryKey(Long.parseLong(ids.get(aa)));
            DocDelete docDelete=new DocDelete( Long.parseLong(id1),doc.getId(),name1,doc.getName());
            if((docDeleteMapper.selectByPrimaryKey(Long.parseLong(id1),doc.getId())==null)){
                docDeleteMapper.insert(docDelete);
            }
        }
        docMapper.deleteByExample(docExample);
    }

    public String findContent(Long id) {
        Content content = contentMapper.selectByPrimaryKey(id);
        // 文档阅读数+1
        docMapperCust.increaseViewCount(id);
        if (ObjectUtils.isEmpty(content)) {
            return "";
        } else {
            return content.getContent();
        }
    }

    /**
     * 点赞
     */
    public void vote(Long id) {
        // docMapperCust.increaseVoteCount(id);
        // 远程IP+doc.id作为key，24小时内不能重复
        String ip = RequestContext.getRemoteAddr();
        if (redisUtil.validateRepeat("DOC_VOTE_" + id + "_" + ip, 5000)) {
            docMapperCust.increaseVoteCount(id);
        } else {
            throw new BusinessException(BusinessExceptionCode.VOTE_REPEAT);
        }

        // 推送消息
        Doc docDb = docMapper.selectByPrimaryKey(id);
        String logId = MDC.get("LOG_ID");
        wsService.sendInfo("【" + docDb.getName() + "】被点赞！", logId);
    }

    public void updateEbookInfo() {
        docMapperCust.updateEbookInfo();
    }
}

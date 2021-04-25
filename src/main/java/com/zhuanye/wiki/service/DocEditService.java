package com.zhuanye.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuanye.wiki.domain.DocEdit;
import com.zhuanye.wiki.domain.DocEdit;
import com.zhuanye.wiki.domain.DocEditExample;
import com.zhuanye.wiki.mapper.DocEditMapper;
import com.zhuanye.wiki.req.DocEditQueryReq;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.resp.DocEditQueryResp;
import com.zhuanye.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocEditService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Resource
    private DocEditMapper docEditMapper;

    public PageResp<DocEditQueryResp> list(DocEditQueryReq req) {
        DocEditExample docEditExample = new DocEditExample();
        DocEditExample.Criteria criteria = docEditExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getUserId())) {
            criteria.andUserIdEqualTo(req.getUserId());
        }
        if (!ObjectUtils.isEmpty(req.getWordId())) {
            criteria.andWordIdEqualTo(req.getWordId());
        }
        PageHelper.startPage(req.getPage(), req.getSize());
        List<DocEdit> docEditList = docEditMapper.selectByExample(docEditExample);

        PageInfo<DocEdit> pageInfo = new PageInfo<>(docEditList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        List<DocEditQueryResp> list = CopyUtil.copyList(docEditList, DocEditQueryResp.class);

        PageResp<DocEditQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    public void insert(DocEdit record) {
        docEditMapper.insert(record);
    }
}

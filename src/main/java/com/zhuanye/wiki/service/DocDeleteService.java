package com.zhuanye.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuanye.wiki.domain.DocDelete;
import com.zhuanye.wiki.domain.DocDeleteExample;
import com.zhuanye.wiki.domain.DocEdit;
import com.zhuanye.wiki.domain.DocEditExample;
import com.zhuanye.wiki.mapper.DocDeleteMapper;
import com.zhuanye.wiki.mapper.DocEditMapper;
import com.zhuanye.wiki.req.DocDeleteQueryReq;
import com.zhuanye.wiki.req.DocEditQueryReq;
import com.zhuanye.wiki.resp.DocDeleteQueryResp;
import com.zhuanye.wiki.resp.DocEditQueryResp;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DocDeleteService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Resource
    private DocDeleteMapper docDeleteMapper;

    public PageResp<DocDeleteQueryResp> list(DocDeleteQueryReq req) {
        DocDeleteExample docDeleteExample = new DocDeleteExample();
        DocDeleteExample.Criteria criteria = docDeleteExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getUserId())) {
            criteria.andUserIdEqualTo(req.getUserId());
        }
        if (!ObjectUtils.isEmpty(req.getWordId())) {
            criteria.andWordIdEqualTo(req.getWordId());
        }
        PageHelper.startPage(req.getPage(), req.getSize());
        List<DocDelete> docDeleteList = docDeleteMapper.selectByExample(docDeleteExample);

        PageInfo<DocDelete> pageInfo = new PageInfo<>(docDeleteList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
        List<DocDeleteQueryResp> list = CopyUtil.copyList(docDeleteList, DocDeleteQueryResp.class);

        PageResp<DocDeleteQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    public void insert(DocDelete record) {
        docDeleteMapper.insert(record);
    }
}

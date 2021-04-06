package com.zhuanye.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuanye.wiki.domain.Demo;
import com.zhuanye.wiki.domain.Ebook;
import com.zhuanye.wiki.domain.EbookExample;
import com.zhuanye.wiki.mapper.DemoMapper;
import com.zhuanye.wiki.mapper.EbookMapper;
import com.zhuanye.wiki.req.EbookReq;
import com.zhuanye.wiki.resp.EbookResp;
import com.zhuanye.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    private static final Logger LOG= LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        PageHelper.startPage(1,3);
        List<Ebook> eBookList=ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo=new PageInfo<>(eBookList);
        LOG.info("总行数:{}",pageInfo.getTotal());
        LOG.info("总页数:{}",pageInfo.getPages());

//        List<EbookResp> respList=new ArrayList<>();
//        for (Ebook ebook : eBookList) {
////            EbookResp ebookResp = new EbookResp();
////            BeanUtils.copyProperties(ebook,ebookResp);
//            EbookResp ebookResp=CopyUtil.copy(ebook,EbookResp.class);
//        }
        List<EbookResp> list = CopyUtil.copyList(eBookList, EbookResp.class);
        return list;
    }
}

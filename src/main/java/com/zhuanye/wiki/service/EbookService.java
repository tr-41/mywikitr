package com.zhuanye.wiki.service;

import com.zhuanye.wiki.domain.Demo;
import com.zhuanye.wiki.domain.Ebook;
import com.zhuanye.wiki.mapper.DemoMapper;
import com.zhuanye.wiki.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }
}

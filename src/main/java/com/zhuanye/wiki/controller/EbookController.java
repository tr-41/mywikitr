package com.zhuanye.wiki.controller;

import com.zhuanye.wiki.domain.Demo;
import com.zhuanye.wiki.domain.Ebook;
import com.zhuanye.wiki.service.DemoService;
import com.zhuanye.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public List<Ebook> list(){
        return ebookService.list();
    }
}

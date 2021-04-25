package com.zhuanye.wiki.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhuanye.wiki.req.DocEditQueryReq;
import com.zhuanye.wiki.resp.CommonResp;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.resp.DocEditQueryResp;
import com.zhuanye.wiki.service.DocEditService;
import com.zhuanye.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/tanrui")
public class DocEditController {

    private static final Logger LOG = LoggerFactory.getLogger(DocEditController.class);

    @Resource
    private DocEditService docEditService;


    @GetMapping("/list")
    public CommonResp list(@Valid DocEditQueryReq req) {
        CommonResp<PageResp<DocEditQueryResp>> resp = new CommonResp<>();
        PageResp<DocEditQueryResp> list = docEditService.list(req);
        resp.setContent(list);
        return resp;
    }
}

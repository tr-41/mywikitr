package com.zhuanye.wiki.controller;

import com.zhuanye.wiki.domain.User;
import com.zhuanye.wiki.req.DocDeleteQueryReq;
import com.zhuanye.wiki.req.DocEditQueryReq;
import com.zhuanye.wiki.resp.CommonResp;
import com.zhuanye.wiki.resp.DocDeleteQueryResp;
import com.zhuanye.wiki.resp.DocEditQueryResp;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.service.DocDeleteService;
import com.zhuanye.wiki.service.DocEditService;
import com.zhuanye.wiki.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/mydelete")
public class DocDeleteController {

    private static final Logger LOG = LoggerFactory.getLogger(DocDeleteController.class);

    @Resource
    private DocDeleteService docDeleteService;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/list")
    public CommonResp list(@Valid DocDeleteQueryReq req) {
        CommonResp<PageResp<DocDeleteQueryResp>> resp = new CommonResp<>();
        PageResp<DocDeleteQueryResp> list = docDeleteService.list(req);
        resp.setContent(list);
        return resp;
    }
}

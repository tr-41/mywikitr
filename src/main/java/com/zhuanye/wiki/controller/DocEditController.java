package com.zhuanye.wiki.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhuanye.wiki.domain.User;
import com.zhuanye.wiki.req.DocEditQueryReq;
import com.zhuanye.wiki.resp.CommonResp;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.resp.DocEditQueryResp;
import com.zhuanye.wiki.service.DocEditService;
import com.zhuanye.wiki.service.UserService;
import com.zhuanye.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/tanrui")
public class DocEditController {

    private static final Logger LOG = LoggerFactory.getLogger(DocEditController.class);

    @Resource
    private DocEditService docEditService;

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    HttpServletRequest request;


    @GetMapping("/list")
    public CommonResp list(@Valid DocEditQueryReq req) {
        CommonResp<PageResp<DocEditQueryResp>> resp = new CommonResp<>();

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
        User user=userService.select1(Long.parseLong(id1));
        if(user.getBlock()==true){
            resp.setSuccess(false);
            resp.setMessage("对不起！您为系统拉黑用户！已阻止您本次操作！");
        }else {
            PageResp<DocEditQueryResp> list = docEditService.list(req);
            resp.setContent(list);
        }
        return resp;
    }
}

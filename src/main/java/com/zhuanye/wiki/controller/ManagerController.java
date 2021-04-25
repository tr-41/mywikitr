package com.zhuanye.wiki.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhuanye.wiki.req.ManagerLoginReq;
import com.zhuanye.wiki.req.ManagerQueryReq;
import com.zhuanye.wiki.req.ManagerResetPasswordReq;
import com.zhuanye.wiki.req.ManagerSaveReq;
import com.zhuanye.wiki.resp.CommonResp;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.resp.ManagerLoginResp;
import com.zhuanye.wiki.resp.ManagerQueryResp;
import com.zhuanye.wiki.service.ManagerService;
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
@RequestMapping("/manager")
public class ManagerController {

    private static final Logger LOG = LoggerFactory.getLogger(ManagerController.class);

    @Resource
    private ManagerService managerService;

    @Resource
    private SnowFlake snowFlake;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/list")
    public CommonResp list(@Valid ManagerQueryReq req) {
        CommonResp<PageResp<ManagerQueryResp>> resp = new CommonResp<>();
        PageResp<ManagerQueryResp> list = managerService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody ManagerSaveReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        managerService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>();
        managerService.delete(id);
        return resp;
    }

    @PostMapping("/reset-password")
    public CommonResp resetPassword(@Valid @RequestBody ManagerResetPasswordReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>();
        managerService.resetPassword(req);
        return resp;
    }

    @PostMapping("/login")
    public CommonResp login(@Valid @RequestBody ManagerLoginReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp<ManagerLoginResp> resp = new CommonResp<>();
        ManagerLoginResp managerLoginResp = managerService.login(req);

        Long token = snowFlake.nextId();
        LOG.info("生成单点登录token：{}，并放入redis中", token);
        managerLoginResp.setToken(token.toString());
        redisTemplate.opsForValue().set(token.toString(), JSONObject.toJSONString(managerLoginResp), 3600 * 24, TimeUnit.SECONDS);

        resp.setContent(managerLoginResp);
        return resp;
    }

    @GetMapping("/logout/{token}")
    public CommonResp logout(@PathVariable String token) {
        CommonResp resp = new CommonResp<>();
        redisTemplate.delete(token);
        LOG.info("从redis中删除token: {}", token);
        return resp;
    }
}

package com.zhuanye.wiki.controller;

import com.zhuanye.wiki.domain.DocEdit;
import com.zhuanye.wiki.domain.User;
import com.zhuanye.wiki.mapper.DocEditMapper;
import com.zhuanye.wiki.req.DocQueryReq;
import com.zhuanye.wiki.req.DocSaveReq;
import com.zhuanye.wiki.req.UserSaveReq;
import com.zhuanye.wiki.resp.DocQueryResp;
import com.zhuanye.wiki.resp.CommonResp;
import com.zhuanye.wiki.resp.PageResp;
import com.zhuanye.wiki.service.DocEditService;
import com.zhuanye.wiki.service.DocService;
import com.zhuanye.wiki.service.UserService;
import com.zhuanye.wiki.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.soap.MimeHeaders;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {

    @Resource
    private DocService docService;
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/all/{ebookId}")
    public CommonResp all(@PathVariable Long ebookId) {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        List<DocQueryResp> list = docService.all(ebookId);
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/list")
    public CommonResp list(@Valid DocQueryReq req) {
        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        PageResp<DocQueryResp> list = docService.list(req);

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
            resp.setContent(list);
        }

        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req) {
        CommonResp resp = new CommonResp<>();


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
        }else if(user.getLevel()==true){
            resp.setSuccess(false);
            resp.setMessage("对不起！您未达到有效编辑级别！已阻止您本次操作！");
        }else {
            docService.save(req);
        }

        return resp;
    }

    @DeleteMapping("/delete/{idsStr}")
    public CommonResp delete(@PathVariable String idsStr) {
        CommonResp resp = new CommonResp<>();
        List<String> list = Arrays.asList(idsStr.split(","));

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
        }else if(user.getLevel()==true){
            resp.setSuccess(false);
            resp.setMessage("对不起！您未达到有效编辑级别！已阻止您本次操作！");
        }else {
            docService.delete(list);
        }
        return resp;
    }

    @GetMapping("/find-content/{id}")
    public CommonResp findContent(@PathVariable Long id) {
        CommonResp<String> resp = new CommonResp<>();

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
        if(user.getBlock()==true) {
            resp.setSuccess(false);
            resp.setMessage("对不起！您为系统拉黑用户！已阻止您本次操作！");
            return resp;
        }else {
            String content = docService.findContent(id);
            resp.setContent(content);
            return resp;
        }
    }

    @GetMapping("/vote/{id}")
    public CommonResp vote(@PathVariable Long id) {
        CommonResp commonResp = new CommonResp();

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
            commonResp.setSuccess(false);
            commonResp.setMessage("对不起！您为系统拉黑用户！系统禁止拉黑用户点赞！");
        }else{
            docService.vote(id);
        }
        return commonResp;
    }
}

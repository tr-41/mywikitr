package com.zhuanye.wiki.controller;

import com.zhuanye.wiki.domain.User;
import com.zhuanye.wiki.resp.CommonResp;
import com.zhuanye.wiki.resp.StatisticResp;
import com.zhuanye.wiki.service.EbookSnapshotService;
import com.zhuanye.wiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/ebook-snapshot")
public class EbookSnapshotController {

    @Resource
    private EbookSnapshotService ebookSnapshotService;
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/get-statistic")
    public CommonResp getStatistic() {
        CommonResp<List<StatisticResp>> commonResp = new CommonResp<>();

        String token = request.getHeader("token");
        if(token!=null) {
            String string = (String) redisTemplate.opsForValue().get(token);
            int s = string.indexOf(":");
            char[] ch = string.toCharArray();
            String id1 = "";
            int i = 0;
            for (s = s + 1; s < ch.length; s++) {
                if (Character.isDigit(ch[s])) {
                    id1 += ch[s];
                } else {
                    break;
                }
            }
            User user = userService.select1(Long.parseLong(id1));
            if (user.getBlock() == true) {
                commonResp.setSuccess(false);
                commonResp.setMessage("对不起！您为系统拉黑用户！没有查看文档点赞阅读信息相关权限！");
            } else {
                List<StatisticResp> statisticResp = ebookSnapshotService.getStatistic();
                commonResp.setContent(statisticResp);
            }
        }else {
            List<StatisticResp> statisticResp = ebookSnapshotService.getStatistic();
            commonResp.setContent(statisticResp);
        }
        return commonResp;
    }

    @GetMapping("/get-30-statistic")
    public CommonResp get30Statistic() {
        List<StatisticResp> statisticResp = ebookSnapshotService.get30Statistic();
        CommonResp<List<StatisticResp>> commonResp = new CommonResp<>();
        commonResp.setContent(statisticResp);
        return commonResp;
    }

}

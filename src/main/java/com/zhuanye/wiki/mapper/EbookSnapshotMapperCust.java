package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.resp.StatisticResp;

import java.util.List;

public interface EbookSnapshotMapperCust {
    //获得电子书快照信息
    public void genSnapshot();
    //统计电子书阅读数、点赞量等信息
    List<StatisticResp> getStatistic();
    //统计电子书30天的阅读量、点赞量等信息
    List<StatisticResp> get30Statistic();
}

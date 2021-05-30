package com.zhuanye.wiki.mapper;

import org.apache.ibatis.annotations.Param;

public interface DocMapperCust {
    //增加阅读数
    public void increaseViewCount(@Param("id") Long id);
    //增加点赞数
    public void increaseVoteCount(@Param("id") Long id);
    //更新电子书信息
    public void updateEbookInfo();
}

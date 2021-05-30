package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.Ebook;
import com.zhuanye.wiki.domain.EbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EbookMapper {
    //按条件计数
    long countByExample(EbookExample example);
    //按条件删除
    int deleteByExample(EbookExample example);
    //按主键删除
    int deleteByPrimaryKey(Long id);
    //插入数据
    int insert(Ebook record);
    //插入值不为null的字段
    int insertSelective(Ebook record);
    //按条件查询
    List<Ebook> selectByExample(EbookExample example);
    //按主键查询
    Ebook selectByPrimaryKey(Long id);
    //按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") Ebook record, @Param("example") EbookExample example);
    //按条件更新
    int updateByExample(@Param("record") Ebook record, @Param("example") EbookExample example);
    //按主键更新值不为null的字段
    int updateByPrimaryKeySelective(Ebook record);
    //按主键更新
    int updateByPrimaryKey(Ebook record);
}
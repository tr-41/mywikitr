package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.Doc;
import com.zhuanye.wiki.domain.DocExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocMapper {
    //按条件计数
    long countByExample(DocExample example);
    //按条件删除
    int deleteByExample(DocExample example);
    //按主键删除
    int deleteByPrimaryKey(Long id);
    //插入数据
    int insert(Doc record);
    //插入值不为null的字段
    int insertSelective(Doc record);
    //按条件查询
    List<Doc> selectByExample(DocExample example);
    //按主键查询
    Doc selectByPrimaryKey(Long id);
    //按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") Doc record, @Param("example") DocExample example);
    //按条件更新
    int updateByExample(@Param("record") Doc record, @Param("example") DocExample example);
    //按主键更新值不为null的字段
    int updateByPrimaryKeySelective(Doc record);
    //按主键更新
    int updateByPrimaryKey(Doc record);
}
package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.DocEdit;
import com.zhuanye.wiki.domain.DocEditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocEditMapper {
    //按条件计数
    long countByExample(DocEditExample example);
    //按条件删除
    int deleteByExample(DocEditExample example);
    //按主键删除
    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("wordId") Long wordId);
    //插入数据
    int insert(DocEdit record);
    //插入值不为null的字段
    int insertSelective(DocEdit record);
    //按条件查询
    List<DocEdit> selectByExample(DocEditExample example);
    //按主键查询
    DocEdit selectByPrimaryKey(@Param("userId") Long userId, @Param("wordId") Long wordId);
    //按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") DocEdit record, @Param("example") DocEditExample example);
    //按条件更新
    int updateByExample(@Param("record") DocEdit record, @Param("example") DocEditExample example);
    //按主键更新值不为null的字段
    int updateByPrimaryKeySelective(DocEdit record);
    //按主键更新
    int updateByPrimaryKey(DocEdit record);
}
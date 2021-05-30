package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.Content;
import com.zhuanye.wiki.domain.ContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
    //按条件计数
    long countByExample(ContentExample example);
    //按条件删除
    int deleteByExample(ContentExample example);
    //按主键删除
    int deleteByPrimaryKey(Long id);
    //插入数据
    int insert(Content record);
    //插入值不为null的字段
    int insertSelective(Content record);
    //按条件查询（包括BLOB字段）。只有当数据表中的字段类型有为二进制的才会产生。
    List<Content> selectByExampleWithBLOBs(ContentExample example);
    //按条件查询
    List<Content> selectByExample(ContentExample example);
    //按主键查询
    Content selectByPrimaryKey(Long id);
    //按主键更新值不为null的字段
    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);
    //按条件更新BLOB类型字段
    int updateByExampleWithBLOBs(@Param("record") Content record, @Param("example") ContentExample example);
    //按条件更新
    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);
    //按条件更新值不为null的字段
    int updateByPrimaryKeySelective(Content record);
    //按主键更新BLOB类型字段
    int updateByPrimaryKeyWithBLOBs(Content record);
}
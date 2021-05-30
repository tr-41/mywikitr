package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.Manager;
import com.zhuanye.wiki.domain.ManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    //按条件计数
    long countByExample(ManagerExample example);
    //按条件删除
    int deleteByExample(ManagerExample example);
    //按主键删除
    int deleteByPrimaryKey(Long managerId);
    //插入数据
    int insert(Manager record);
    //插入值不为null的字段
    int insertSelective(Manager record);
    //按条件查询
    List<Manager> selectByExample(ManagerExample example);
    //按主键查询
    Manager selectByPrimaryKey(Long managerId);
    //按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);
    //按条件更新
    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);
    //按主键更新值不为null的字段
    int updateByPrimaryKeySelective(Manager record);
    //按主键更新
    int updateByPrimaryKey(Manager record);
}
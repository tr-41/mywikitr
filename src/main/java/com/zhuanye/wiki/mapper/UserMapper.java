package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.User;
import com.zhuanye.wiki.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //按条件计数
    long countByExample(UserExample example);
    //按条件删除
    int deleteByExample(UserExample example);
    //按主键删除
    int deleteByPrimaryKey(Long id);
    //插入数据
    int insert(User record);
    //插入值不为null的字段
    int insertSelective(User record);
    //按条件查询
    List<User> selectByExample(UserExample example);
    //按主键查询
    User selectByPrimaryKey(Long id);
    //按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    //按条件更新
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    //按主键更新值不为null的字段
    int updateByPrimaryKeySelective(User record);
    //按主键更新
    int updateByPrimaryKey(User record);
}
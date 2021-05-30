package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.DocDelete;
import com.zhuanye.wiki.domain.DocDeleteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocDeleteMapper {
    long countByExample(DocDeleteExample example);

    int deleteByExample(DocDeleteExample example);

    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("wordId") Long wordId);

    int insert(DocDelete record);

    int insertSelective(DocDelete record);

    List<DocDelete> selectByExample(DocDeleteExample example);

    DocDelete selectByPrimaryKey(@Param("userId") Long userId, @Param("wordId") Long wordId);

    int updateByExampleSelective(@Param("record") DocDelete record, @Param("example") DocDeleteExample example);

    int updateByExample(@Param("record") DocDelete record, @Param("example") DocDeleteExample example);

    int updateByPrimaryKeySelective(DocDelete record);

    int updateByPrimaryKey(DocDelete record);
}
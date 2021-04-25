package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.DocEdit;
import com.zhuanye.wiki.domain.DocEditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocEditMapper {
    long countByExample(DocEditExample example);

    int deleteByExample(DocEditExample example);

    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("wordId") Long wordId);

    int insert(DocEdit record);

    int insertSelective(DocEdit record);

    List<DocEdit> selectByExample(DocEditExample example);

    DocEdit selectByPrimaryKey(@Param("userId") Long userId, @Param("wordId") Long wordId);

    int updateByExampleSelective(@Param("record") DocEdit record, @Param("example") DocEditExample example);

    int updateByExample(@Param("record") DocEdit record, @Param("example") DocEditExample example);

    int updateByPrimaryKeySelective(DocEdit record);

    int updateByPrimaryKey(DocEdit record);
}
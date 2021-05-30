package com.zhuanye.wiki.mapper;

import com.zhuanye.wiki.domain.EbookSnapshot;
import com.zhuanye.wiki.domain.EbookSnapshotExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EbookSnapshotMapper {
    //按条件计数
    long countByExample(EbookSnapshotExample example);
    //按条件删除
    int deleteByExample(EbookSnapshotExample example);
    //按主键删除
    int deleteByPrimaryKey(Long id);
    //插入数据
    int insert(EbookSnapshot record);
    //插入值不为null的字段
    int insertSelective(EbookSnapshot record);
    //按条件查询
    List<EbookSnapshot> selectByExample(EbookSnapshotExample example);
    //按主键查询
    EbookSnapshot selectByPrimaryKey(Long id);
    //按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") EbookSnapshot record, @Param("example") EbookSnapshotExample example);
    //按条件更新
    int updateByExample(@Param("record") EbookSnapshot record, @Param("example") EbookSnapshotExample example);
    //按主键更新值不为null的字段
    int updateByPrimaryKeySelective(EbookSnapshot record);
    //按主键更新
    int updateByPrimaryKey(EbookSnapshot record);
}
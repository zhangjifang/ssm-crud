package com.atguigu.crud.dao;

import com.atguigu.crud.bean.ScoreInfo;
import com.atguigu.crud.bean.ScoreInfoExample;
import com.atguigu.crud.bean.ScoreInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreInfoMapper {
    long countByExample(ScoreInfoExample example);

    int deleteByExample(ScoreInfoExample example);

    int deleteByPrimaryKey(ScoreInfoKey key);

    int insert(ScoreInfo record);

    int insertSelective(ScoreInfo record);

    List<ScoreInfo> selectByExample(ScoreInfoExample example);

    ScoreInfo selectByPrimaryKey(ScoreInfoKey key);

    int updateByExampleSelective(@Param("record") ScoreInfo record, @Param("example") ScoreInfoExample example);

    int updateByExample(@Param("record") ScoreInfo record, @Param("example") ScoreInfoExample example);

    int updateByPrimaryKeySelective(ScoreInfo record);

    int updateByPrimaryKey(ScoreInfo record);

	void deleteByPrimaryKey(Long rowid);

	ScoreInfo selectByPrimaryKey(Long id);
}
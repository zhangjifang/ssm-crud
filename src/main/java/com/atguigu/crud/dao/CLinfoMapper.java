package com.atguigu.crud.dao;

import com.atguigu.crud.bean.CLinfo;
import com.atguigu.crud.bean.CLinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CLinfoMapper {
    long countByExample(CLinfoExample example);

    int deleteByExample(CLinfoExample example);

    int deleteByPrimaryKey(String clid);

    int insert(CLinfo record);

    int insertSelective(CLinfo record);

    List<CLinfo> selectByExample(CLinfoExample example);

    CLinfo selectByPrimaryKey(String clid);

    int updateByExampleSelective(@Param("record") CLinfo record, @Param("example") CLinfoExample example);

    int updateByExample(@Param("record") CLinfo record, @Param("example") CLinfoExample example);

    int updateByPrimaryKeySelective(CLinfo record);

    int updateByPrimaryKey(CLinfo record);
}
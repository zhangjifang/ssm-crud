package com.atguigu.crud.dao;

import com.atguigu.crud.bean.professioninfo;
import com.atguigu.crud.bean.professioninfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface professioninfoMapper {
    long countByExample(professioninfoExample example);

    int deleteByExample(professioninfoExample example);

    int deleteByPrimaryKey(String professionid);

    int insert(professioninfo record);

    int insertSelective(professioninfo record);

    List<professioninfo> selectByExample(professioninfoExample example);
    List<professioninfo> selectByPrimaryKey(professioninfoExample example);

    professioninfo selectByPrimaryKey(String professionid);

    int updateByExampleSelective(@Param("record") professioninfo record, @Param("example") professioninfoExample example);

    int updateByExample(@Param("record") professioninfo record, @Param("example") professioninfoExample example);

    int updateByPrimaryKeySelective(professioninfo record);

    int updateByPrimaryKey(professioninfo record);
}
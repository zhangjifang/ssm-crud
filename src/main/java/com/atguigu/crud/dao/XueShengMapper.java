package com.atguigu.crud.dao;

import com.atguigu.crud.bean.XueSheng;
import com.atguigu.crud.bean.XueShengExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XueShengMapper {
    long countByExample(XueShengExample example);

    int deleteByExample(XueShengExample example);

    int deleteByPrimaryKey(String studentid);

    int insert(XueSheng record);

    int insertSelective(XueSheng record);

    List<XueSheng> selectByExample(XueShengExample example);

    XueSheng selectByPrimaryKey(String studentid);

    int updateByExampleSelective(@Param("record") XueSheng record, @Param("example") XueShengExample example);

    int updateByExample(@Param("record") XueSheng record, @Param("example") XueShengExample example);

    int updateByPrimaryKeySelective(XueSheng record);

    int updateByPrimaryKey(XueSheng record);
}
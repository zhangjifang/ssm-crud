package com.atguigu.crud.dao;

import com.atguigu.crud.bean.ClassInfoList;
import com.atguigu.crud.bean.ClassInfoListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassInfoListMapper {
    long countByExample(ClassInfoListExample example);

    int deleteByExample(ClassInfoListExample example);

    int deleteByPrimaryKey(String classid);

    int insert(ClassInfoList record);

    int insertSelective(ClassInfoList record);

    List<ClassInfoList> selectByExample(ClassInfoListExample example);

    ClassInfoList selectByPrimaryKey(String classid);

    int updateByExampleSelective(@Param("record") ClassInfoList record, @Param("example") ClassInfoListExample example);

    int updateByExample(@Param("record") ClassInfoList record, @Param("example") ClassInfoListExample example);

    int updateByPrimaryKeySelective(ClassInfoList record);

    int updateByPrimaryKey(ClassInfoList record);

	void deleteByPrimaryKey(Integer id);

	ClassInfoList selectByPrimaryKey(Integer id);
}
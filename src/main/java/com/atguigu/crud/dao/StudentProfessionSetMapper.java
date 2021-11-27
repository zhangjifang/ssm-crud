package com.atguigu.crud.dao;

import com.atguigu.crud.bean.StudentProfessionSet;
import com.atguigu.crud.bean.StudentProfessionSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentProfessionSetMapper {
    long countByExample(StudentProfessionSetExample example);

    int deleteByExample(StudentProfessionSetExample example);

    int deleteByPrimaryKey(String studentid);

    int insert(StudentProfessionSet record);

    int insertSelective(StudentProfessionSet record);

    List<StudentProfessionSet> selectByExample(StudentProfessionSetExample example);
    
    List<StudentProfessionSet> selectByExampleWithProfession(StudentProfessionSetExample example);


    StudentProfessionSet selectByPrimaryKey(String studentid);

    int updateByExampleSelective(@Param("record") StudentProfessionSet record, @Param("example") StudentProfessionSetExample example);

    int updateByExample(@Param("record") StudentProfessionSet record, @Param("example") StudentProfessionSetExample example);

    int updateByPrimaryKeySelective(StudentProfessionSet record);

    int updateByPrimaryKey(StudentProfessionSet record);

	
}
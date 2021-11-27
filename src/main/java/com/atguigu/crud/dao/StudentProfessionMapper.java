package com.atguigu.crud.dao;

import com.atguigu.crud.bean.StudentProfession;
import com.atguigu.crud.bean.StudentProfessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentProfessionMapper {
    long countByExample(StudentProfessionExample example);

    int deleteByExample(StudentProfessionExample example);

    int deleteByPrimaryKey(String studentid);

    int insert(StudentProfession record);

    int insertSelective(StudentProfession record);

    List<StudentProfession> selectByExample(StudentProfessionExample example);
    List<StudentProfession> selectByExampleWithProfession(StudentProfessionExample example);

    StudentProfession selectByPrimaryKey(String studentid);

    int updateByExampleSelective(@Param("record") StudentProfession record, @Param("example") StudentProfessionExample example);

    int updateByExample(@Param("record") StudentProfession record, @Param("example") StudentProfessionExample example);

    int updateByPrimaryKeySelective(StudentProfession record);

    int updateByPrimaryKey(StudentProfession record);

	List<StudentProfession> selectByExampleWithProfession(Object object);
}
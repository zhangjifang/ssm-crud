package com.atguigu.crud.dao;

import com.atguigu.crud.bean.StudentWish;
import com.atguigu.crud.bean.StudentWishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentWishMapper {
    long countByExample(StudentWishExample example);

    int deleteByExample(StudentWishExample example);

    int deleteByPrimaryKey(String studentid);

    int insert(StudentWish record);

    int insertSelective(StudentWish record);

    List<StudentWish> selectByExample(StudentWishExample example);

    StudentWish selectByPrimaryKey(String studentid);

    int updateByExampleSelective(@Param("record") StudentWish record, @Param("example") StudentWishExample example);

    int updateByExample(@Param("record") StudentWish record, @Param("example") StudentWishExample example);

    int updateByPrimaryKeySelective(StudentWish record);

    int updateByPrimaryKey(StudentWish record);

	List<StudentWish> selectStudentWish(Object object);

	StudentWish selectStudentWishById(String id);
}
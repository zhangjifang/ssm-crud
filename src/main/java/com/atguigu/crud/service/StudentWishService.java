package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.StudentWish;
import com.atguigu.crud.bean.StudentWishExample;
import com.atguigu.crud.bean.StudentWishExample.Criteria;
import com.atguigu.crud.dao.StudentWishMapper;

@Service
public class StudentWishService {
	
	@Autowired
	StudentWishMapper studentWishMapper;
	public List<StudentWish> getAll() {
		// TODO Auto-generated method stub
		return studentWishMapper.selectByExample(null);
	}
	public List<StudentWish> getbyStudentID(String studentid) {
		// TODO Auto-generated method stub
		StudentWishExample studentWishExample=new StudentWishExample();
		Criteria criteria=studentWishExample.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		return studentWishMapper.selectByExample(studentWishExample);
	}
	public void saveStw(StudentWish studentWish) {
		// TODO Auto-generated method stub
		studentWishMapper.insertSelective(studentWish);
	}
	public void deleteStuwish(String studentid) {
		// TODO Auto-generated method stub
		studentWishMapper.deleteByPrimaryKey(studentid);
	}
	public void deleteBatch(List<String> ids) {
		// TODO Auto-generated method stub
		StudentWishExample example = new StudentWishExample();
		Criteria criteria = example.createCriteria();
	
		criteria.andStudentidIn(ids);
		studentWishMapper.deleteByExample(example);
	}
	public StudentWish getStuwish(String id) {
		// TODO Auto-generated method stub
		StudentWish studentWish = studentWishMapper.selectByPrimaryKey(id);
		return studentWish;
	}
	
	public void updateStuwish(StudentWish studentWish) {
		// TODO Auto-generated method stub
		studentWishMapper.updateByPrimaryKeySelective(studentWish);
	}
}
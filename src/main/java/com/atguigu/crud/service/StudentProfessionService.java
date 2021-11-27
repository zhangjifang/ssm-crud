package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.StudentProfession;
import com.atguigu.crud.bean.StudentProfessionExample;
import com.atguigu.crud.bean.StudentProfessionExample.Criteria;
import com.atguigu.crud.dao.StudentProfessionMapper;

@Service
public class StudentProfessionService {
	
	@Autowired
	StudentProfessionMapper studentProfessionMapper;
	public List<StudentProfession> getAll() {
		// TODO Auto-generated method stub
		//return studentProfessionMapper.selectByExample(null);
		return studentProfessionMapper.selectByExampleWithProfession(null);
	}
	public List<StudentProfession> getbyStudentID(String studentid){
		// TODO Auto-generated method stub
		//return studentProfessionMapper.selectByExample(null);
		StudentProfessionExample studentProfessionExample=new StudentProfessionExample();
		Criteria criteria=studentProfessionExample.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		return studentProfessionMapper.selectByExampleWithProfession(studentProfessionExample);
	}

}

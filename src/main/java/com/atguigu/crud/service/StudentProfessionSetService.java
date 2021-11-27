package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.StudentProfessionSet;
import com.atguigu.crud.bean.StudentProfessionSetExample;
import com.atguigu.crud.bean.Teacher;
import com.atguigu.crud.bean.StudentProfessionSetExample.Criteria;
import com.atguigu.crud.dao.StudentProfessionSetMapper;

@Service
public class StudentProfessionSetService {
	
	@Autowired
	StudentProfessionSetMapper studentProfessionSetMapper;
	public List<StudentProfessionSet> getAll() {
		// TODO Auto-generated method stub
		//return studentInfoMapper.selectByExample(null);
		//return studentProfessionSetMapper.selectByExample(null);
		return studentProfessionSetMapper.selectByExampleWithProfession(null);
	}
	public boolean checkUserAndPsw(String studentID,String password) {
		// TODO Auto-generated method stub
		StudentProfessionSet studentProfessionSet=studentProfessionSetMapper.selectByPrimaryKey(studentID);
		if(studentProfessionSet==null)
			return false;
		else
		{
			if(studentProfessionSet.getPwd().compareTo(password)==0)
			{
				return true;
			}
			else
				return false;
		}
	}
	public void savePro(StudentProfessionSet studentProfessionSet) {
		// TODO Auto-generated method stub
		studentProfessionSetMapper.insertSelective(studentProfessionSet);
	}
	
	public void deletePro(String studentid) {
		// TODO Auto-generated method stub
		studentProfessionSetMapper.deleteByPrimaryKey(studentid);
	}
	
	public void deleteBatch(List<String> ids) {
		// TODO Auto-generated method stub
		StudentProfessionSetExample example = new StudentProfessionSetExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidIn(ids);
		studentProfessionSetMapper.deleteByExample(example);
	}
	
	public StudentProfessionSet getPro(String id) {
		// TODO Auto-generated method stub
		StudentProfessionSet studentProfessionSet = studentProfessionSetMapper.selectByPrimaryKey(id);
		return studentProfessionSet;
	}
	
	public void updatePro(StudentProfessionSet studentProfessionSet) {
		// TODO Auto-generated method stub
		studentProfessionSetMapper.updateByPrimaryKeySelective(studentProfessionSet);
	}




}

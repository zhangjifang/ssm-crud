package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.StudentInfo;
import com.atguigu.crud.bean.StudentInfoExample;
import com.atguigu.crud.bean.Teacher;
import com.atguigu.crud.bean.StudentInfoExample.Criteria;
import com.atguigu.crud.dao.StudentInfoMapper;

@Service
public class StudentInfoService {
	
	@Autowired
	StudentInfoMapper studentInfoMapper;
	public List<StudentInfo> getAll() {
		// TODO Auto-generated method stub
		//return studentInfoMapper.selectByExample(null);
		return studentInfoMapper.selectByExampleWithClass(null);
	}
	public boolean checkUserAndPsw(String studentID,String password) {
		// TODO Auto-generated method stub
		StudentInfo studentInfo=studentInfoMapper.selectByPrimaryKey(studentID);
		if(studentInfo==null)
			return false;
		else
		{
			if(studentInfo.getPwd().compareTo(password)==0)
			{
				return true;
			}
			else
				return false;
		}
	}
	public void saveStu(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		studentInfoMapper.insertSelective(studentInfo);
	}
	
	public void deleteStu(String studentid) {
		// TODO Auto-generated method stub
		studentInfoMapper.deleteByPrimaryKey(studentid);
	}
	
	public void deleteBatch(List<String> ids) {
		// TODO Auto-generated method stub
		StudentInfoExample example = new StudentInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidIn(ids);
		studentInfoMapper.deleteByExample(example);
	}
	
	public StudentInfo getStu(String id) {
		// TODO Auto-generated method stub
		StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(id);
		return studentInfo;
	}
	
	public void updateStu(StudentInfo studentInfo) {
		// TODO Auto-generated method stub
		studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
	}




}

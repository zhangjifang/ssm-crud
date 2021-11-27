package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Teacher;
import com.atguigu.crud.bean.TeacherExample;
import com.atguigu.crud.bean.TeacherExample.Criteria;
import com.atguigu.crud.dao.TeacherMapper;

@Service
public class TeacherService {
	
	@Autowired
	TeacherMapper teacherMapper;

	/**
	 * 鏌ヨ鎵�鏈夊憳宸�
	 * @return
	 */
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return teacherMapper.selectByExample(null);
	}
	public boolean checkUserAndPsw(String teacherID,String password) {
		// TODO Auto-generated method stub
		Teacher teacher=teacherMapper.selectByPrimaryKey(teacherID);
		if(teacher==null)
			return false;
		else
		{
			if(teacher.getPassword().compareTo(password)==0)
			{
				return true;
			}
			else
				return false;
		}
	}
	/**
	 * 鍛樺伐淇濆瓨
	 * @param employee
	 */
	public void saveEmp(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherMapper.insertSelective(teacher);
	}
}

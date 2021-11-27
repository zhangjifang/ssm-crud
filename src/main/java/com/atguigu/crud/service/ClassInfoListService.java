package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.ClassInfoList;
import com.atguigu.crud.bean.ClassInfoListExample;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.StudentInfo;
import com.atguigu.crud.bean.ClassInfoListExample.Criteria;
import com.atguigu.crud.dao.ClassInfoListMapper;
import com.atguigu.crud.dao.EmployeeMapper;

@Service
public class ClassInfoListService {
	
	@Autowired
	ClassInfoListMapper classInfoListMapper;
	
	public List<ClassInfoList> getAll() {
		// TODO Auto-generated method stub
		return classInfoListMapper.selectByExample(null);
	}
	
	public void saveEmp(ClassInfoList classInfoList) {
		// TODO Auto-generated method stub
		classInfoListMapper.insertSelective(classInfoList);
	}

	public void deleteBatch(List<Integer> ids) {
		ClassInfoListExample example = new ClassInfoListExample();
		Criteria criteria = example.createCriteria();
		criteria.andClassinfoidIn(ids);
		classInfoListMapper.deleteByExample(example);
	}
	
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		classInfoListMapper.deleteByPrimaryKey(id);
	}
	
	public ClassInfoList getEmp(Integer id) {
		ClassInfoList classInfoList = classInfoListMapper.selectByPrimaryKey(id);
		return classInfoList;
	}
	
	public void updateEmp(ClassInfoList classInfoList) {
		// TODO Auto-generated method stub
		classInfoListMapper.updateByPrimaryKeySelective(classInfoList);
	}

}
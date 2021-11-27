package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.BorrowInfo;
import com.atguigu.crud.bean.BorrowInfoExample;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.Partner;
import com.atguigu.crud.bean.PartnerExample;
import com.atguigu.crud.bean.ReturnInfo;
import com.atguigu.crud.bean.ReturnInfoExample;
import com.atguigu.crud.bean.Teacher;
import com.atguigu.crud.bean.ReturnInfoExample.Criteria;
import com.atguigu.crud.dao.ReturnInfoMapper;

@Service
public class Tab_ReturnService {
	
	@Autowired
	ReturnInfoMapper returnInfoMapper;
	public List<ReturnInfo> getAll() {
		// TODO Auto-generated method stub
		//return studentInfoMapper.selectByExample(null);
		return returnInfoMapper.selectByExampleWithStudent(null);
	}
	public List<ReturnInfo> getbyStudentID(String sid){
		// TODO Auto-generated method stub
		//return studentProfessionMapper.selectByExample(null);
		ReturnInfoExample returnInfoExample=new ReturnInfoExample();
		Criteria criteria=returnInfoExample.createCriteria();
		criteria.andStudentidEqualTo(sid);
		return returnInfoMapper.selectByExampleWithStudent(returnInfoExample);
	}
	public void deleteRut(String studentid) {
		// TODO Auto-generated method stub
		returnInfoMapper.deleteByPrimaryKey(studentid);
	}
	public void deleteBat(List<String> ids) {
		// TODO Auto-generated method stub
		ReturnInfoExample example = new ReturnInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidIn(ids);
		returnInfoMapper.deleteByExample(example);
	}
	public List<ReturnInfo> getAll(String sid) {
		// TODO Auto-generated method stub
		return null;
	}



}

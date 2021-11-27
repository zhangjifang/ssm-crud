package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.Partner;
import com.atguigu.crud.bean.PartnerExample;
import com.atguigu.crud.bean.BorrowInfo;
import com.atguigu.crud.bean.BorrowInfoExample;
import com.atguigu.crud.bean.Teacher;
import com.atguigu.crud.bean.BorrowInfoExample.Criteria;
import com.atguigu.crud.dao.BorrowInfoMapper;

@Service
public class SendInfoService {
	
	@Autowired
	BorrowInfoMapper borrowInfoMapper;
	public List<BorrowInfo> getAll() {
		// TODO Auto-generated method stub
		//return studentInfoMapper.selectByExample(null);
		return borrowInfoMapper.selectByExampleWithStudent(null);
	}
	
	public boolean checkUserAndPsw(String studentID,String password) {
		// TODO Auto-generated method stub
		BorrowInfo borrowInfo=borrowInfoMapper.selectByPrimaryKey(studentID);
		if(borrowInfo==null)
			return false;
		else
		{
			if(borrowInfo.getPwd().compareTo(password)==0)
			{
				return true;
			}
			else
				return false;
		}
	}
	public void savePor(BorrowInfo borrowInfo) {
		// TODO Auto-generated method stub
		borrowInfoMapper.insertSelective(borrowInfo);
	}
	
	public void deletePor(String studentid) {
		// TODO Auto-generated method stub
		borrowInfoMapper.deleteByPrimaryKey(studentid);
	}
	
	public void deleteBatc(List<String> ids) {
		// TODO Auto-generated method stub
		BorrowInfoExample example = new BorrowInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidIn(ids);
		borrowInfoMapper.deleteByExample(example);
	}
	
	public BorrowInfo getPor(String id) {
		// TODO Auto-generated method stub
		BorrowInfo borrowInfo = borrowInfoMapper.selectByPrimaryKey(id);
		return borrowInfo;
	}
	
	public void updatePor(BorrowInfo borrowInfo) {
		// TODO Auto-generated method stub
		borrowInfoMapper.updateByPrimaryKeySelective(borrowInfo);
	}




}

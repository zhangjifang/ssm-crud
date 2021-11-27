package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.Partner;
import com.atguigu.crud.bean.XueSheng;
import com.atguigu.crud.bean.XueShengExample;
import com.atguigu.crud.bean.Teacher;
import com.atguigu.crud.bean.XueShengExample.Criteria;
import com.atguigu.crud.dao.XueShengMapper;

@Service
public class XueShengService {
	
	@Autowired
	XueShengMapper xueShengMapper;
	public List<XueSheng> getAll() {
		// TODO Auto-generated method stub
		//return studentInfoMapper.selectByExample(null);
		return xueShengMapper.selectByExample(null);
	}
	public boolean checkUserAndPsw(String studentID,String password) {
		// TODO Auto-generated method stub
		XueSheng xueSheng=xueShengMapper.selectByPrimaryKey(studentID);
		if(xueSheng==null)
			return false;
		else
		{
			if(xueSheng.getPwd().compareTo(password)==0)
			{
				return true;
			}
			else
				return false;
		}
	}
	public void saveStu(XueSheng xueSheng) {
		// TODO Auto-generated method stub
		xueShengMapper.insertSelective(xueSheng);
	}
	
	
	public void saveParss(List<String[]> ss) {
		// TODO Auto-generated method stub
		for(int i=0;i<ss.size();i++)
		{
			XueSheng xueSheng=new XueSheng();
			xueSheng.setStudentid(ss.get(i)[0]);
			xueSheng.setStudentname(ss.get(i)[1]);
			xueSheng.setCla(ss.get(i)[2]);
			xueSheng.setTel(ss.get(i)[3]);
			xueSheng.setYear(Integer.parseInt(ss.get(i)[4]));
			xueSheng.setSex(Boolean.parseBoolean(ss.get(i)[5]));
		xueShengMapper.insertSelective(xueSheng);
		}}
	
	public void deleteStu(String studentid) {
		// TODO Auto-generated method stub
		xueShengMapper.deleteByPrimaryKey(studentid);
	}
	
	public void deleteBatch(List<String> ids) {
		// TODO Auto-generated method stub
		XueShengExample example = new XueShengExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidIn(ids);
		xueShengMapper.deleteByExample(example);
	}
	
	public XueSheng getStu(String id) {
		// TODO Auto-generated method stub
		XueSheng xueSheng = xueShengMapper.selectByPrimaryKey(id);
		return xueSheng;
	}
	
	public void updateStu(XueSheng xueSheng) {
		// TODO Auto-generated method stub
		xueShengMapper.updateByPrimaryKeySelective(xueSheng);
	}




}

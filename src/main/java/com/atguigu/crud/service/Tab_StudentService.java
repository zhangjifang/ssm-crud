package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.Partner;
import com.atguigu.crud.bean.PartnerExample;
import com.atguigu.crud.bean.StudentProfession;
import com.atguigu.crud.bean.StudentProfessionExample;
import com.atguigu.crud.bean.Teacher;
import com.atguigu.crud.bean.PartnerExample.Criteria;
import com.atguigu.crud.dao.PartnerMapper;

@Service
public class Tab_StudentService {
	
	@Autowired
	PartnerMapper partnerMapper;
	public List<Partner> getAll() {
		// TODO Auto-generated method stub
		//return studentInfoMapper.selectByExample(null);
		return partnerMapper.selectByExample(null);
	}
	public List<Partner> getbyStudentID(String studentid){
		// TODO Auto-generated method stub
		//return studentProfessionMapper.selectByExample(null);
		PartnerExample partnerExample=new PartnerExample();
		Criteria criteria=partnerExample.createCriteria();
		criteria.andStudentidEqualTo(studentid);
		return partnerMapper.selectByExample(partnerExample);
	}
	public boolean checkUserAndPsw(String studentID,String password) {
		// TODO Auto-generated method stub
		Partner partner=partnerMapper.selectByPrimaryKey(studentID);
		if(partner==null)
			return false;
		else
		{
			if(partner.getPwd().compareTo(password)==0)
			{
				return true;
			}
			else
				return false;
		}
	}
	public void savePar(Partner partner) {
		// TODO Auto-generated method stub
		partnerMapper.insertSelective(partner);
	}
	
	public void savePars(List<String[]> ss) {
		// TODO Auto-generated method stub
		for(int i=0;i<ss.size();i++)
		{
			Partner partner=new Partner();
			partner.setStudentid(ss.get(i)[0]);
			partner.setStudentname(ss.get(i)[1]);
			partner.setCla(ss.get(i)[2]);
			partner.setTel(ss.get(i)[3]);
			partner.setYear(Integer.parseInt(ss.get(i)[4]));
			partner.setSex(Boolean.parseBoolean(ss.get(i)[5]));
		partnerMapper.insertSelective(partner);
		}}
	
	public void deletePar(String studentid) {
		// TODO Auto-generated method stub
		partnerMapper.deleteByPrimaryKey(studentid);
	}
	
	public void deleteBat(List<String> ids) {
		// TODO Auto-generated method stub
		PartnerExample example = new PartnerExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentidIn(ids);
		partnerMapper.deleteByExample(example);
	}
	
	public Partner getPar(String id) {
		// TODO Auto-generated method stub
		Partner partner = partnerMapper.selectByPrimaryKey(id);
		return partner;
	}
	
	public void updatePar(Partner partner) {
		// TODO Auto-generated method stub
		partnerMapper.updateByPrimaryKeySelective(partner);
	}




}

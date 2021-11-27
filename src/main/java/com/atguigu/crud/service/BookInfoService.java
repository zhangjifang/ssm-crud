package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.Partner;
import com.atguigu.crud.bean.BookInfo;
import com.atguigu.crud.bean.BookInfoExample;
import com.atguigu.crud.bean.Teacher;
import com.atguigu.crud.bean.BookInfoExample.Criteria;
import com.atguigu.crud.dao.BookInfoMapper;

@Service
public class BookInfoService {
	
	@Autowired
	BookInfoMapper bookInfoMapper;
	public List<BookInfo> getAll() {
		// TODO Auto-generated method stub
		//return studentInfoMapper.selectByExample(null);
		return bookInfoMapper.selectByExample(null);
	}
	public boolean checkUserAndPsw(String studentID,String password) {
		// TODO Auto-generated method stub
		BookInfo bookInfo=bookInfoMapper.selectByPrimaryKey(studentID);
		if(bookInfo==null)
			return false;
		else
		{
			if(bookInfo.getPwd().compareTo(password)==0)
			{
				return true;
			}
			else
				return false;
		}
	}
	public void saveStu(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		bookInfoMapper.insertSelective(bookInfo);
	}
	
	public void deleteStu(String studentid) {
		// TODO Auto-generated method stub
		bookInfoMapper.deleteByPrimaryKey(studentid);
	}
	
	public void deleteBatch(List<String> ids) {
		// TODO Auto-generated method stub
		BookInfoExample example = new BookInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andBookidIn(ids);
		bookInfoMapper.deleteByExample(example);
	}
	
	public BookInfo getStu(String id) {
		// TODO Auto-generated method stub
		BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(id);
		return bookInfo;
	}
	
	
	public void savePars(List<String[]> ss) {
		// TODO Auto-generated method stub
		for(int i=0;i<ss.size();i++)
		{
			BookInfo bookInfo=new BookInfo();
			bookInfo.setBookid(ss.get(i)[0]);
			bookInfo.setBookname(ss.get(i)[1]);
			bookInfo.setBooktype(ss.get(i)[2]);
			bookInfo.setBooknumbers(ss.get(i)[3]);
			bookInfo.setBorrowednumbers(ss.get(i)[4]);
			bookInfo.setRemainingnumbers(ss.get(i)[5]);
			bookInfoMapper.insertSelective(bookInfo);
		}}
	
	public void updateBoo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		bookInfoMapper.updateByPrimaryKeySelective(bookInfo);
	}




}

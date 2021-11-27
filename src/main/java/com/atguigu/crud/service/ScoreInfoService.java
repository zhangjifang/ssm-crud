package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.ScoreInfo;
import com.atguigu.crud.bean.ScoreInfoExample;
import com.atguigu.crud.bean.ScoreInfoExample.Criteria;
import com.atguigu.crud.dao.ScoreInfoMapper;

@Service
public class ScoreInfoService {
	
	@Autowired
	ScoreInfoMapper scoreInfoMapper;
	public List<ScoreInfo> getAll() {
		// TODO Auto-generated method stub
		return scoreInfoMapper.selectByExample(null);
	}
	
	public void saveSco(ScoreInfo scoreInfo) {
		// TODO Auto-generated method stub
		scoreInfoMapper.insertSelective(scoreInfo);
	}
	public void deleteSco(Long rowid) {
		// TODO Auto-generated method stub
		scoreInfoMapper.deleteByPrimaryKey(rowid);
	}
	public void deleteBatch(List<String> ids) {
		// TODO Auto-generated method stub
		ScoreInfoExample example = new ScoreInfoExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andStudentidIn(ids);
		scoreInfoMapper.deleteByExample(example);
	}
	public ScoreInfo getSco(Long id) {
		// TODO Auto-generated method stub
		ScoreInfo scoreInfo = scoreInfoMapper.selectByPrimaryKey(id);
		return scoreInfo;
	}
	public void updateSco(ScoreInfo scoreInfo) {
		// TODO Auto-generated method stub
		scoreInfoMapper.updateByPrimaryKeySelective(scoreInfo);
	}
}
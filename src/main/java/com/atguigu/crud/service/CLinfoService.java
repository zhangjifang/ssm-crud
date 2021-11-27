package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.CLinfo;
import com.atguigu.crud.dao.CLinfoMapper;

@Service
public class CLinfoService {
	
	@Autowired
	private CLinfoMapper clinfoMapper;

	public List<CLinfo> getCLinfo() {
		// TODO Auto-generated method stub
		List<CLinfo> list = clinfoMapper.selectByExample(null);
		return list;
	}

}

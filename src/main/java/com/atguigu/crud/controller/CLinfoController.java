package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.CLinfo;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.CLinfoService;

/**
 * 澶勭悊鍜岄儴闂ㄦ湁鍏崇殑璇锋眰
 * @author fly
 *
 */
@Controller
public class CLinfoController {
	
	@Autowired
	private CLinfoService clinfoService;
	
	/**
	 * 杩斿洖鎵�鏈夌殑閮ㄩ棬淇℃伅
	 */
	@RequestMapping("/clinfo")
	@ResponseBody
	public Msg getCLinfo(){
		//鏌ュ嚭鐨勬墍鏈夐儴闂ㄤ俊鎭�
		List<CLinfo> list = clinfoService.getCLinfo();
		return Msg.success().add("clinfo", list);
	}

}

package com.atguigu.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crud.bean.ReturnInfo;
import com.atguigu.crud.bean.BorrowInfo;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Partner;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.service.Tab_ReturnService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工CRUD请求
 * 
 * @author fly
 * 
 */
@Controller
public class Tab_ReturnController {

	@Autowired
	Tab_ReturnService tab_ReturnService;
	
	@RequestMapping("/return")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpServletRequest request) {
		PageHelper.startPage(pn, 5);
		HttpSession session = request.getSession();
		String sid = session.getAttribute("student").toString();
		
		List<ReturnInfo> emps = tab_ReturnService.getbyStudentID(sid);
		
		PageInfo page = new PageInfo(emps, 5);
		
		return Msg.success().add("pageInfo", page);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delRut/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<String>();
			String[] str_ids = ids.split("-");
			for (String string : str_ids) {
				del_ids.add(string);
			}
			tab_ReturnService.deleteBat(del_ids);
		}else{
			tab_ReturnService.deleteRut(ids);
		}
		return Msg.success();
	}
}

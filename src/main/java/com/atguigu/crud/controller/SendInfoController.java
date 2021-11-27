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

import com.atguigu.crud.bean.BorrowInfo;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.Partner;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.service.SendInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工CRUD请求
 * 
 * @author fly
 * 
 */
@Controller
public class SendInfoController {

	@Autowired
	SendInfoService sendInfoService;
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/send")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpServletRequest request) {
		PageHelper.startPage(pn, 5);
		
		List<BorrowInfo> emps = sendInfoService.getAll();
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value="/sed",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(@Valid BorrowInfo borrowInfo,BindingResult result){
		if(result.hasErrors()){
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			sendInfoService.savePor(borrowInfo);
			return Msg.success();
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delsed/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<String>();
			String[] str_ids = ids.split("-");
			for (String string : str_ids) {
				del_ids.add(string);
			}
			sendInfoService.deleteBatc(del_ids);
		}else{
			sendInfoService.deletePor(ids);
		}
		return Msg.success();
	}
	
	@RequestMapping(value="/getsed/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")String id){
		
		BorrowInfo BorrowInfo = sendInfoService.getPor(id);
		return Msg.success().add("sed", BorrowInfo);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatesed/{borrowid}",method=RequestMethod.PUT)
	public Msg saveEmp(BorrowInfo borrowInfo,HttpServletRequest request){
		sendInfoService.updatePor(borrowInfo);
		return Msg.success()	;
	}
	

}

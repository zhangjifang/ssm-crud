package com.atguigu.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.atguigu.crud.bean.StudentProfessionSet;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.service.StudentProfessionSetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工CRUD请求
 * 
 * @author fly
 * 
 */
@Controller
public class StudentProfessionSetController {

	@Autowired
	StudentProfessionSetService studentProfessionSetService;
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/professions")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);		
		List<StudentProfessionSet> emps = studentProfessionSetService.getAll();
		PageInfo<StudentProfessionSet> page = new PageInfo<StudentProfessionSet>(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value="/pro",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(@Valid StudentProfessionSet studentProfessionSet,BindingResult result){
		if(result.hasErrors()){
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			studentProfessionSetService.savePro(studentProfessionSet);
			return Msg.success();
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delpro/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<String>();
			String[] str_ids = ids.split("-");
			for (String string : str_ids) {
				del_ids.add(string);
			}
			studentProfessionSetService.deleteBatch(del_ids);
		}else{
			studentProfessionSetService.deletePro(ids);
		}
		return Msg.success();
	}
	
	@RequestMapping(value="/getPro/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")String id){
		
		StudentProfessionSet studentProfessionSet = studentProfessionSetService.getPro(id);
		return Msg.success().add("pro", studentProfessionSet);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePro/{studentid}",method=RequestMethod.PUT)
	public Msg saveEmp(StudentProfessionSet studentProfessionSet,HttpServletRequest request){
		studentProfessionSetService.updatePro(studentProfessionSet);
		return Msg.success()	;
	}
	

}

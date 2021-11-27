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

import com.atguigu.crud.bean.StudentWish;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.service.StudentWishService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工CRUD请求
 * 
 * @author lfy
 * 
 */
@Controller
public class StudentWishController {

	@Autowired
	StudentWishService studentwishService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/studentwishs")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpServletRequest request) {
		
		PageHelper.startPage(pn, 5);
		HttpSession session = request.getSession();
		String sid = session.getAttribute("student").toString();
		List<StudentWish> studentwishs = studentwishService.getbyStudentID(sid);
		
		PageInfo page = new PageInfo(studentwishs, 5);
		return Msg.success().add("pageInfo", page);
	}
	@RequestMapping(value="/stw",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStw(@Valid StudentWish studentWish,BindingResult result){
		if(result.hasErrors()){
			
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			studentwishService.saveStw(studentWish);
			return Msg.success();
		}
	
}
	
	@ResponseBody
	@RequestMapping(value="/delstuwish/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			
			for (String string : str_ids) {
				del_ids.add(string);
			}
			studentwishService.deleteBatch(del_ids);
		}else{
			
			studentwishService.deleteStuwish(ids);
		}
		return Msg.success();
	}
	@RequestMapping(value="/getStuwish/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")String id){
		
		StudentWish studentWish = studentwishService.getStuwish(id);
		return Msg.success().add("stuwish", studentWish);
	}
	@ResponseBody
	@RequestMapping(value="/updateStuwish/{studentid}",method=RequestMethod.PUT)
	public Msg saveEmp(StudentWish studentWish,HttpServletRequest request){
		studentwishService.updateStuwish(studentWish);
		return Msg.success()	;
	}
}
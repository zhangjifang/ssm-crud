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

import com.atguigu.crud.bean.ClassInfoList;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.StudentInfo;
import com.atguigu.crud.service.ClassInfoListService;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工CRUD请求
 * 
 * @author lfy
 * 
 */
@Controller
public class ClassInfoListController {

	@Autowired
	ClassInfoListService classInfoListService;

	
	@RequestMapping("/class")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<ClassInfoList> emps = classInfoListService.getAll();
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value="/cladd",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid ClassInfoList classInfoList,BindingResult result){
		if(result.hasErrors()){
		Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			classInfoListService.saveEmp(classInfoList);
			return Msg.success();
		}	
	}
	
	@ResponseBody
	@RequestMapping(value="/delcla/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){

		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");

			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			classInfoListService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			classInfoListService.deleteEmp(id);
		}
		return Msg.success();
	}
	
	@RequestMapping(value="/getcla/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Integer id){
		ClassInfoList classInfoList = classInfoListService.getEmp(id);
		return Msg.success().add("cladd", classInfoList);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatecla/{classinfoid}",method=RequestMethod.PUT)
	public Msg saveEmp(ClassInfoList classInfoList,HttpServletRequest request){
		classInfoListService.updateEmp(classInfoList);
		return Msg.success()	;
	}

}
	
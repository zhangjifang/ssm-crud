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

import com.atguigu.crud.bean.ScoreInfo;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.service.ScoreInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工CRUD请求
 * 
 * @author lfy
 * 
 */
@Controller
public class ScoreInfoController {
	@Autowired
	EmployeeService employeeService;

	@Autowired
	ScoreInfoService scoreinfoService;	
	
	
	@RequestMapping("/scores")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
			PageHelper.startPage(pn, 5);
		List<ScoreInfo> emps = scoreinfoService.getAll();
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	@RequestMapping(value="/sco",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSco(@Valid ScoreInfo scoreInfo,BindingResult result){
		if(result.hasErrors()){
		Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			scoreinfoService.saveSco(scoreInfo);
			return Msg.success();
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delsco/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			for (String string : str_ids) {
				del_ids.add(string);
			}
			scoreinfoService.deleteBatch(del_ids); 
		}else{
			Long id = Long.parseLong(ids);
			scoreinfoService.deleteSco(id);
		}
		return Msg.success();
	}
	@RequestMapping(value="/getSco/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Long id){
		
		ScoreInfo scoreInfo = scoreinfoService.getSco(id);
		return Msg.success().add("sco", scoreInfo);
	}
	@ResponseBody
	@RequestMapping(value="/updateSco/{rowid}",method=RequestMethod.PUT)
	public Msg saveEmp(ScoreInfo scoreInfo,HttpServletRequest request){
		scoreinfoService.updateSco(scoreInfo);
		return Msg.success()	;
	}
}
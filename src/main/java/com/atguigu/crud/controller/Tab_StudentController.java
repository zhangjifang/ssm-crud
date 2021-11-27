package com.atguigu.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

import com.atguigu.crud.bean.Partner;
import com.atguigu.crud.bean.StudentProfession;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.service.Tab_StudentService;
import com.atguigu.crud.service.ExcelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工CRUD请求
 * 
 * @author fly
 * 
 */
@Controller
public class Tab_StudentController {

	@Autowired
	Tab_StudentService tab_StudentService;
	
	@RequestMapping("/partner")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpServletRequest request) {
		PageHelper.startPage(pn, 5);
		HttpSession session = request.getSession();
		String sid = session.getAttribute("student").toString();
		List<Partner> emps = tab_StudentService.getbyStudentID(sid);
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value="/par",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(@Valid Partner partner,BindingResult result){
		if(result.hasErrors()){
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			tab_StudentService.savePar(partner);
			return Msg.success();
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delPar/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<String>();
			String[] str_ids = ids.split("-");
			for (String string : str_ids) {
				del_ids.add(string);
			}
			tab_StudentService.deleteBat(del_ids);
		}else{
			tab_StudentService.deletePar(ids);
		}
		return Msg.success();
	}
	
	@RequestMapping(value="/getPar/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")String id){
		
		Partner partner = tab_StudentService.getPar(id);
		return Msg.success().add("par", partner);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePar/{studentid}",method=RequestMethod.PUT)
	public Msg saveEmp(Partner partner,HttpServletRequest request){
		tab_StudentService.updatePar(partner);
		return Msg.success()	;
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)	 
	 public Msg uploadFile(HttpServletRequest request) {
	  
	  try {
	   DiskFileItemFactory factory = new DiskFileItemFactory();
	   ServletFileUpload upload = new ServletFileUpload(factory);
	   List<FileItem> list = upload.parseRequest(request);
	   if(list.size()>0){
	       FileItem item = list.get(0);
	     List<String[]> ss=ExcelService.readExcel(item);
	     tab_StudentService.savePars(ss);
	     
	   }
	   
	  } catch (Exception e) {
	   
	  }
	  return Msg.success()	;
	  
	 }
	

}

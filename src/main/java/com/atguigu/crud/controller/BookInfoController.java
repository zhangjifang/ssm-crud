package com.atguigu.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.atguigu.crud.bean.BookInfo;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.service.ExcelService;
import com.atguigu.crud.service.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工CRUD请求
 * 
 * @author fly
 * 
 */
@Controller
public class BookInfoController {

	@Autowired
	BookInfoService bookInfoService;
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/books")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);		
		List<BookInfo> emps = bookInfoService.getAll();
		PageInfo<BookInfo> page = new PageInfo<BookInfo>(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	@RequestMapping(value="/boo",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(@Valid BookInfo bookInfo,BindingResult result){
		if(result.hasErrors()){
			Map<String, Object> map = new HashMap<String, Object>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			bookInfoService.saveStu(bookInfo);
			return Msg.success();
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delboo/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		if(ids.contains("-")){
			List<String> del_ids = new ArrayList<String>();
			String[] str_ids = ids.split("-");
			for (String string : str_ids) {
				del_ids.add(string);
			}
			bookInfoService.deleteBatch(del_ids);
		}else{
			bookInfoService.deleteStu(ids);
		}
		return Msg.success();
	}
	
	@RequestMapping(value="/getBoo/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")String id){
		
		BookInfo bookInfo = bookInfoService.getStu(id);
		return Msg.success().add("boo", bookInfo);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateBoo/{bookid}",method=RequestMethod.PUT)
	public Msg saveEmp(BookInfo bookInfo,HttpServletRequest request){
		bookInfoService.updateBoo(bookInfo);
		return Msg.success()	;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/BuploadFile",method=RequestMethod.POST)	 
	 public Msg uploadFile(HttpServletRequest request) {
	  
	  try {
	   DiskFileItemFactory factory = new DiskFileItemFactory();
	   ServletFileUpload upload = new ServletFileUpload(factory);
	   List<FileItem> list = upload.parseRequest(request);
	   if(list.size()>0){
	       FileItem item = list.get(0);
	     List<String[]> ss=ExcelService.readExcel(item);
	     bookInfoService.savePars(ss);
	     
	   }
	   
	  } catch (Exception e) {
	   
	  }
	  return Msg.success()	;
	  
	 }

}

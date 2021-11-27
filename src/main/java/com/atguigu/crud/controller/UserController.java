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

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.crud.service.TeacherService;
import com.atguigu.crud.service.StudentInfoService;
import com.atguigu.crud.service.Tab_StudentService;
/**
 * 澶勭悊鍛樺伐CRUD璇锋眰
 * 
 * @author lfy
 * 
 */
@Controller
public class UserController {
	@Autowired
    private TeacherService teacherService;
	@Autowired
	private Tab_StudentService tab_StudentService;
	
	@RequestMapping(value="/adminlogin.action",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getLogin(HttpServletRequest request){		
		ModelAndView model = new ModelAndView();
		 
		//登录角色
		int role = Integer.parseInt(request.getParameter("role"));
		//用户名
		String username = request.getParameter("username");
		//密码
		String password = request.getParameter("password");
		//管理员
		if(role==1)//管理员
		{
			boolean flag=teacherService.checkUserAndPsw(username, password);
			if(flag)
			{
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(604800);
				session.setAttribute("teacheruser",username);
				model.setViewName("../../main");
			}
			else
				model.setViewName("../../login");
		}
		else if(role==2)//学生
		{
			boolean flag=tab_StudentService.checkUserAndPsw(username, password);
			if(flag)
			{
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(604800);
				session.setAttribute("student",username);
				model.setViewName("../../main");
			}
			else
				model.setViewName("../../login");
		}
		return model;
	}
	
	@RequestMapping(value="/Teacherlogout.action",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView LogOut(HttpServletRequest request){		
		ModelAndView model = new ModelAndView();
		HttpSession session=request.getSession();
		session.removeAttribute("teacheruser");
		model.setViewName("../../login");
		return model;
	
	
	}
	@RequestMapping(value="/studentlogout.action",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView LogOutt(HttpServletRequest request){		
		ModelAndView model = new ModelAndView();
		HttpSession session=request.getSession();
		session.removeAttribute("student");
		model.setViewName("../../login");
		return model;
	
	
	}
	
}
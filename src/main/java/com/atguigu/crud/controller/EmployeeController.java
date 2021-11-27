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

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 澶勭悊鍛樺伐CRUD璇锋眰
 * 
 * @author lfy
 * 
 */
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	/**
	 * 鍗曚釜鎵归噺浜屽悎涓�
	 * 鎵归噺鍒犻櫎锛�1-2-3
	 * 鍗曚釜鍒犻櫎锛�1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//鎵归噺鍒犻櫎
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//缁勮id鐨勯泦鍚�
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		return Msg.success();
	}
	
	
	
	/**
	 * 濡傛灉鐩存帴鍙戦�乤jax=PUT褰㈠紡鐨勮姹�
	 * 灏佽鐨勬暟鎹�
	 * Employee 
	 * [empId=1014, empName=null, gender=null, email=null, dId=null]
	 * 
	 * 闂锛�
	 * 璇锋眰浣撲腑鏈夋暟鎹紱
	 * 浣嗘槸Employee瀵硅薄灏佽涓嶄笂锛�
	 * update tbl_emp  where emp_id = 1014;
	 * 
	 * 鍘熷洜锛�
	 * Tomcat锛�
	 * 		1銆佸皢璇锋眰浣撲腑鐨勬暟鎹紝灏佽涓�涓猰ap銆�
	 * 		2銆乺equest.getParameter("empName")灏变細浠庤繖涓猰ap涓彇鍊笺��
	 * 		3銆丼pringMVC灏佽POJO瀵硅薄鐨勬椂鍊欍��
	 * 				浼氭妸POJO涓瘡涓睘鎬х殑鍊硷紝request.getParamter("email");
	 * AJAX鍙戦�丳UT璇锋眰寮曞彂鐨勮妗堬細
	 * 		PUT璇锋眰锛岃姹備綋涓殑鏁版嵁锛宺equest.getParameter("empName")鎷夸笉鍒�
	 * 		Tomcat涓�鐪嬫槸PUT涓嶄細灏佽璇锋眰浣撲腑鐨勬暟鎹负map锛屽彧鏈塒OST褰㈠紡鐨勮姹傛墠灏佽璇锋眰浣撲负map
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 
	 * 
	 * 瑙ｅ喅鏂规锛�
	 * 鎴戜滑瑕佽兘鏀寔鐩存帴鍙戦�丳UT涔嬬被鐨勮姹傝繕瑕佸皝瑁呰姹備綋涓殑鏁版嵁
	 * 1銆侀厤缃笂HttpPutFormContentFilter锛�
	 * 2銆佷粬鐨勪綔鐢紱灏嗚姹備綋涓殑鏁版嵁瑙ｆ瀽鍖呰鎴愪竴涓猰ap銆�
	 * 3銆乺equest琚噸鏂板寘瑁咃紝request.getParameter()琚噸鍐欙紝灏变細浠庤嚜宸卞皝瑁呯殑map涓彇鏁版嵁
	 * 鍛樺伐鏇存柊鏂规硶
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public Msg saveEmp(Employee employee,HttpServletRequest request){
		System.out.println("璇锋眰浣撲腑鐨勫�硷細"+request.getParameter("gender"));
		System.out.println("灏嗚鏇存柊鐨勫憳宸ユ暟鎹細"+employee);
		employeeService.updateEmp(employee);
		return Msg.success()	;
	}
	
	/**
	 * 鏍规嵁id鏌ヨ鍛樺伐
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Integer id){
		
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}
	
	
	/**
	 * 妫�鏌ョ敤鎴峰悕鏄惁鍙敤
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName")String empName){
		//鍏堝垽鏂敤鎴峰悕鏄惁鏄悎娉曠殑琛ㄨ揪寮�;
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(regx)){
			return Msg.fail().add("va_msg", "鐢ㄦ埛鍚嶅繀椤绘槸6-16浣嶆暟瀛楀拰瀛楁瘝鐨勭粍鍚堟垨鑰�2-5浣嶄腑鏂�");
		}
		
		//鏁版嵁搴撶敤鎴峰悕閲嶅鏍￠獙
		boolean b = employeeService.checkUser(empName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "鐢ㄦ埛鍚嶄笉鍙敤");
		}
	}
	
	
	/**
	 * 鍛樺伐淇濆瓨
	 * 1銆佹敮鎸丣SR303鏍￠獙
	 * 2銆佸鍏ibernate-Validator
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()){
			//鏍￠獙澶辫触锛屽簲璇ヨ繑鍥炲け璐ワ紝鍦ㄦā鎬佹涓樉绀烘牎楠屽け璐ョ殑閿欒淇℃伅
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("閿欒鐨勫瓧娈靛悕锛�"+fieldError.getField());
				System.out.println("閿欒淇℃伅锛�"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{
			employeeService.saveEmp(employee);
			return Msg.success();
		}
		
	}

	/**
	 * 瀵煎叆jackson鍖呫��
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 杩欎笉鏄竴涓垎椤垫煡璇�
		// 寮曞叆PageHelper鍒嗛〉鎻掍欢
		// 鍦ㄦ煡璇箣鍓嶅彧闇�瑕佽皟鐢紝浼犲叆椤电爜锛屼互鍙婃瘡椤电殑澶у皬
		PageHelper.startPage(pn, 5);
		// startPage鍚庨潰绱ц窡鐨勮繖涓煡璇㈠氨鏄竴涓垎椤垫煡璇�
		List<Employee> emps = employeeService.getAll();
		// 浣跨敤pageInfo鍖呰鏌ヨ鍚庣殑缁撴灉锛屽彧闇�瑕佸皢pageInfo浜ょ粰椤甸潰灏辫浜嗐��
		// 灏佽浜嗚缁嗙殑鍒嗛〉淇℃伅,鍖呮嫭鏈夋垜浠煡璇㈠嚭鏉ョ殑鏁版嵁锛屼紶鍏ヨ繛缁樉绀虹殑椤垫暟
		PageInfo page = new PageInfo(emps, 5);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 鏌ヨ鍛樺伐鏁版嵁锛堝垎椤垫煡璇級
	 * 
	 * @return
	 */
	// @RequestMapping("/emps")
	public String getEmps(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		// 杩欎笉鏄竴涓垎椤垫煡璇紱
		// 寮曞叆PageHelper鍒嗛〉鎻掍欢
		// 鍦ㄦ煡璇箣鍓嶅彧闇�瑕佽皟鐢紝浼犲叆椤电爜锛屼互鍙婃瘡椤电殑澶у皬
		PageHelper.startPage(pn, 5);
		// startPage鍚庨潰绱ц窡鐨勮繖涓煡璇㈠氨鏄竴涓垎椤垫煡璇�
		List<Employee> emps = employeeService.getAll();
		// 浣跨敤pageInfo鍖呰鏌ヨ鍚庣殑缁撴灉锛屽彧闇�瑕佸皢pageInfo浜ょ粰椤甸潰灏辫浜嗐��
		// 灏佽浜嗚缁嗙殑鍒嗛〉淇℃伅,鍖呮嫭鏈夋垜浠煡璇㈠嚭鏉ョ殑鏁版嵁锛屼紶鍏ヨ繛缁樉绀虹殑椤垫暟
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);

		return "list";
	}

}

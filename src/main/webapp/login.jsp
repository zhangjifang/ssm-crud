<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
//获取服务器全部名称
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path ;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>安全教育考试系统后台登录</title>
	<link rel="shortcut icon" href="favicon.ico">
    <link href="<%=basePath %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath %>/static/css/style.min.css" rel="stylesheet">
	<link href="<%=basePath %>/static/css/css.css" rel="stylesheet">
</head>
<body class="gray-bg" onload="changeImg()">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div class="box10">
        <h3>图书借阅系统</h3>
        <form class="m-t" method="post" action="adminlogin.action" onsubmit="return checkForm(this)"> 
            <div class="form-group">
                <input type="text" id="username" name="username" class="form-control" placeholder="用户名" required>
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
            </div>
            <div class="form-group">
				
                <div class="col-sm-4">
                	<label class="control-label">
                		<input name="role" type="radio" value="1" />管理员
                	</label> 
                </div>
                <div class="col-sm-4">
                	<label class="control-label">
                		<input name="role" type="radio" value="2" />学生
                	</label>
                </div>
            </div>
            <div class="form-group">
            	<div class="col-sm-8">
            		<input type="text" class="form-control" placeholder="请输入验证码" id="vcode" required >
            	</div>
            	<div class="col-sm-4">
            		<span id="code" title="看不清？换一张" onclick="changeImg()"></span>
            	</div>
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <p class="text-muted text-center" hidden>
                <a href="chongzhi.action">
                	<small>重置密码</small>
                </a> 
                |
                <a href="register.action">
                	注册一个新账号
                </a>
            </p>
            <div id="copyright">
            	版权所有计算机科学与技术系-©CopyRight 2019
            </div>
        </form>
    </div>
</div>
<script src="<%=basePath %>/static/js/jquery.min.js"></script>
<script src="<%=basePath %>/static/js/bootstrap.min.js"></script>

</body>
<script type="text/javascript">
	
	function checkForm(){
		return check();
	}
	function changeImg() {
	    var arrays =['1','2','3','4','5','6','7','8','9','0',
	        'a','b','c','d','e','f','g','h','i','j',
	        'k','l','m','n','o','p','q','r','s','t',
	        'u','v','w','x','y','z',
	        'A','B','C','D','E','F','G','H','I','J',
	        'K','L','M','N','O','P','Q','R','S','T',
	        'U','V','W','X','Y','Z'];
	    code='';
	    for(var i=0;i<4;i++){
	        var r=parseInt(Math.random()*arrays.length);
	        code+=arrays[r];
	    }
	    document.getElementById('code').innerHTML=code;
	}
	
	function check() {
	    var input_code=document.getElementById("vcode").value;
	    if(input_code.toLowerCase()===code.toLowerCase()){
	        return true;
	    }else {
	        alert("验证码不正确,请重新输入！");
	        changeImg();
	        return false;
	    }
	}
</script>
</html>
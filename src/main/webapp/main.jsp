<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path ;
%>
<%
 //获取服务器当前时间
 Date d = new Date();
 SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
 String nowdate = df.format(d);
%>
<c:set var="user" value="${sessionScope.manageruser}"/>
<c:set var="teacheruser" value="${sessionScope.teacheruser}"/>
<c:set var="student" value="${sessionScope.student}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>专业分流系统</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/><![endif]-->

	<!-- favicon.ico 网站头图标 -->
    <link rel="shortcut icon" href="favicon.ico">
	
	<!-- CSS开始 -->
    <link href="<%=basePath %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath %>/static/css/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath %>/static/css/style.min.css" rel="stylesheet">
	<!-- CSS结束 -->
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close">
			<i class="fa fa-times-circle">
			</i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
							<span class="clear">
								<span style="font-size:25px"><b>图书借阅查询系统</b></span>
                            </span>
                        </a>
                    </div>
                    <div class="logo-element">
						Exam
                    </div>
                </li>
				
				

				<c:if test="${user!=null }">
					<!-- 管理员首页 -->
	                <li>
	                    <a class="J_menuItem" href=BookInfo.jsp data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">首页</span>
	                    </a>
	                    
	                </li>
		  		</c:if>
		  		<c:if test="${teacheruser!=null }">
		  			<!-- 教师首页 -->
	                <li>
	                    <a class="J_menuItem" href="XueSheng.jsp" target="iframe01" data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">学生信息</span>
	                    </a>
	                    <a class="J_menuItem" href="BookInfo.jsp" target="iframe01" data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">书籍信息</span>
	                    </a>
	                    <a class="J_menuItem" href="SendInfo.jsp" target="iframe01" data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">查阅借书学生</span>
	                    </a>
	                    
	                </li>
	                 
		  		</c:if>
		  		<!-- 学生首页 -->
		  		<c:if test="${student!=null }">
		  		    
	                <li>
	                    <a class="J_menuItem" href="Tab_Student.jsp" target="iframe01" data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">学生信息</span>
	                    </a>
	                   <a class="J_menuItem" href="StudentBook.jsp" target="iframe01" data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">书籍信息</span>
	                    </a>
	                    <a class="J_menuItem" href="BorrowInfo.jsp" target="iframe01" data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">借阅信息</span>
	                    </a>
	                    <a class="J_menuItem" href="Tab_Return.jsp" target="iframe01" data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">还书操作</span>
	                    </a>
	                    <a class="J_menuItem" href="ReturnInfo.jsp" target="iframe01" data-index="0">
							<i class="fa fa-home"></i> 
							<span class="nav-label">查阅已借书籍</span>
	                    </a>
	                </li>
	           
	                
		  		</c:if>
	  		
                
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
		<!-- 快捷工具栏开始 -->
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#">
						<i class="fa fa-bars"></i>
                    </a>
					<!-- 搜索，键入回车键即为搜索 -->
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html" style="display:none">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                
                <ul class="nav navbar-top-links navbar-right">
					<!-- 系统公告 -->
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i>系统公告
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <c:forEach items="${MessageList }" var="message" begin="0" end="4">
                            	<li class="m-t-xs">
                                <div class="dropdown-messages-box">
                                    <div class="media-body">
                                        <span>${message.newstitle }</span>
                                        <small style="float:right;" class="text-muted">${message.createtime }</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            </c:forEach>
                            <li>
                                <div class="text-center link-block">
                                    <a class="J_menuItem" href="getMessageInfoView.action">
                                        <i class="fa fa-envelope"></i> <strong>查看所有公告</strong> <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li> 
					
					<c:if test="${user!=null }">
	  				<li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="glyphicon glyphicon-user"></i> 用户中心
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
							<!-- <li>
                                <a class="J_menuItem" href="userinfo.action">个人资料</a>
                            </li> -->
							<li>
                                <a class="J_menuItem" href="Update_pwd.action">修改密码</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="adminlogout.action">退出</a>
                            </li>
                        </ul>
                    </li>
	  				</c:if>
			  		<c:if test="${teacheruser!=null }">
			  		<li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="glyphicon glyphicon-user"></i> 用户中心
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
							<!-- <li>
                                <a class="J_menuItem" href="userinfo.action">个人资料</a>
                            </li> -->
							<li>
                                <a class="J_menuItem" href="teacheruserUpdate_pwd.action">修改密码</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="Teacherlogout.action">退出</a>
                            </li>
                        </ul>
                    </li>
			  		</c:if>
					<!-- 系统中心 -->
					<c:if test="${user!=null }">
					<li class="dropdown">
	                	<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
	                    	<i class="glyphicon glyphicon-user"></i> 系统中心
	                    </a>
	                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
							<li>
		                    	<a class="J_menuItem" href="Searchdatabackup.action">数据备份恢复</a>
		                    </li>
		                    <li>
			                    <a class="J_menuItem" href="">添加管理员</a>
			                </li>
			                <li>
			                    <a class="J_menuItem" href="">管理员信息查询</a>
			                </li>
		                    <li>
		                        <a class="J_menuItem" href="AddDicType.action">添加数据字典类型</a>
		                    </li>
		                    <li>
		                        <a class="J_menuItem" href="SearchDicType.action">数据字典查询</a>
		                    </li>
		                    <li>
		                       	<a class="J_menuItem" href="AddDicItem.action">添加数据字典类型项目</a>
		                    </li>
		                    <li class="divider"></li>
							<li>
						  		<a href="adminlogout.action">退出系统</a>
		                    </li>
	                    </ul>
	                </li>
	                </c:if>
                </ul>
            </nav>
        </div>
		<!-- 快捷工具栏结束 -->
		
		<!-- 内容选项卡开始 -->
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i></button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i></button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span></button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive">
                        <a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll">
                        <a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther">
                        <a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            
	  		<c:if test="${teacheruser!=null }">
	  			<a href="Teacherlogout.action" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i>退出</a>
	  		</c:if>
	  		<c:if test="${student!=null }">
	  			<a href="studentlogout.action" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i>退出</a>
	  		</c:if>
        </div>
		<!-- 内容选项卡结束 -->
		
		<!-- 内容网页开始 -->
        <div class="row J_mainContent" id="content-main">
        	<iframe class="J_iframe" name="iframe01" width="100%" height="100%" src="BookInfo.jsp" frameborder="0" data-id="" seamless></iframe>
	  	
			<!-- src="此处放置后台首页" -->
			<c:if test="${user!=null }">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="SearchNews.action" frameborder="0" data-id="" seamless></iframe>
	  		</c:if>
	  		<!--<c:if test="${teacheruser!=null }">-->
	  			<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index.jsp" frameborder="0" data-id="" seamless></iframe>
	  		<!--</c:if>-->
	  		<c:if test="${student!=null }">
	  			<iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="studentPaper.action" frameborder="0" data-id="" seamless></iframe>
	  		</c:if>
	  		
        </div>
		<!-- 内容网页结束 -->
		
		<!-- 网站底部开始 -->
		
        <div class="footer">
	  		<div class="col-md-4" style="color:blue;">
	  			今天是：<%=nowdate %>
	  			欢迎：<c:if test="${user!=null }">
	  					管理员——${user}
	  				 </c:if>
	  				 <c:if test="${teacheruser!=null }">
	  					${teacheruser}
	  				 </c:if>
	  				 <c:if test="${student!=null }">
	  					${student}
	  				 </c:if>
	  		</div>
	  		<div class="col-md-4 col-md-offset-4">&copy; 2017-2018
	  			<a href="#" target="_blank">河北经贸大学经济管理实验中心</a>
	  		</div>
        </div>
		<!-- 网站底部结束 -->
    </div>
    <!--右侧部分结束-->
</div>
</body>
	<script src="<%=basePath %>/static/js/jquery.min.js"></script>
	<script src="<%=basePath %>/static/js/bootstrap.min.js"></script>
	<script src="<%=basePath %>/static/js/jquery.metismenu.js"></script>
	<script src="<%=basePath %>/static/js/jquery.slimscroll.min.js"></script>
	<script src="<%=basePath %>/static/js/layer.min.js"></script>
	<script src="<%=basePath %>/static/js/hplus.min.js"></script>
	<!-- 选项卡js -->
	<script type="text/javascript" src="<%=basePath %>/static/js/contabs.min.js"></script>
	<script src="<%=basePath %>/static/js/pace.min.js"></script>
	<script type="text/javascript">
		
	</script>
	

</html>

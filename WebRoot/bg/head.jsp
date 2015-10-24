<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String name="";
String usertype = "";
String fastid = "";
if(ActionContext.getContext().getSession().isEmpty())
{
	response.setContentType("text/html; charset=utf-8");
	response.sendRedirect(basePath+"indexzhoubian.action"); 
	return;
}
String[] url = request.getRequestURI().toString().split("/");
String nowurl = url[url.length-1];
if(nowurl.equals("yongjin.jsp")||nowurl.equals("main_menu.jsp")||nowurl.equals("members.jsp")||
	nowurl.equals("modulcategory.jsp")||nowurl.equals("role.jsp")||nowurl.equals("usercategory.jsp")||
	nowurl.equals("platformactivity.jsp")||nowurl.equals("newinformation.jsp")||nowurl.equals("left.jsp")||
	nowurl.equals("memberinformation.jsp")||nowurl.equals("memberyongjin.jsp")||nowurl.equals("head.jsp"))
	{
		List aduser = (ArrayList)ActionContext.getContext().getSession().get("userlogin");
		HashMap adu = (HashMap)aduser.get(0);
		name = adu.get("name").toString();
		if(aduser.size()==0)
		{
			response.setContentType("text/html; charset=utf-8");
			response.sendRedirect(basePath+"indexzhoubian.action"); 
			return;
		}
	}
%>
<html lang="en">
<head>
 <script type="text/javascript" src="<%=basePath %>js/jquery-1.11.1.min.js"></script>
 <script type="text/javascript" src="<%=basePath %>js/jquery.form.js"></script>
 <script type="text/javascript" src="<%=basePath %>js/tooltips.js"></script>
<script type="text/javascript">
	var varfastid = "<%=fastid%>";
	var path = "<%=basePath%>";
</script>
</head>
<body>
	<div class="topbar-wrap white">
		<div class="topbar-inner clearfix">
			<div class="topbar-logo-wrap clearfix">
				<h1 class="topbar-logo none">
					<a href="index.jsp" class="navbar-brand">后台管理</a>
				</h1>
				<ul class="navbar-list clearfix">
					<li><a class="on" href="<%=basePath%>yjgetYJ.action">首页</a>
					</li>
					<li><a href="<%=basePath%>indexzhoubian.action">网站首页</a></li>
				</ul>
			</div>
			<div class="top-info-wrap">
				<ul class="top-info-list clearfix">
					<li><%=name%>
					</li>
					<li><a href="<%=basePath%>indexgetUpPass.action">修改密码</a>
					</li>
					<li><a href="<%=basePath%>indexzhoubian.action">退出</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
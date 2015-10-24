<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="left.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css" />
<script type="text/javascript" src="<%=basePath%>js/modernizr.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/role.js"></script>
</head>
<body>
	<div class="container clearfix">
		<!-- <jsp:include page="left.jsp"></jsp:include>
    <!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="<%=basePath%>yjgetYJ.action">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">系统参数</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-content">
					<form action="" method="post" id="urform" name="urform"
						enctype="multipart/form-data">
						<table class="insert-tab" width="100%">
							<tbody>

								<tr>
									<th><i class="require-red">*</i>单日最大抢使用券次数</th>
									<td><input class="common-text required" id="maxnum"
										name="maxnum" size="50" type="text" value="${maxnum}">
									</td>
								</tr>
								<tr>
									<th></th>
									<td><input class="btn btn-primary btn6 mr10" value="确认修改"
										type="button" id="urbtn" name="urbtn" onclick="editmaxnum()">
										<input class="btn btn6" onclick="history.go(-1)" value="返回"
										type="button">
									</td>
								</tr>

							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
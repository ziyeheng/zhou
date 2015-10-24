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
<script type="text/javascript" src="<%=basePath%>js/price.js"></script>
</head>
<body>
	<div class="container clearfix">
		<!-- <jsp:include page="left.jsp"></jsp:include>
    <!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="<%=basePath%>yjgetYJ.action">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">修改发布信息</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-content">
					<form action="" method="post" id="upadminform" name="upadminform"
						enctype="multipart/form-data">
						<table class="insert-tab" width="100%">
							<tbody>

								<c:forEach items="${yongjinlist}" var="uobj">
									<tr>
										<th><i class="require-red">*</i>商家名称：(可修改)</th>
										<td><input class="common-text required" id="businessname"
											name="businessname" size="50" type="text"
											value="${uobj.businessname }"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>商家地址：(可修改)</th>
										<td><input class="common-text required" id="sjaddress"
											name="sjaddress" size="50" type="text"
											value="${uobj.sjaddress }"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>详情描述：(可修改)</th>
										<td><textarea class="common-text required"
												id="discription" name="discription"
												value="${uobj.discription }"
												style="height:150px; width:400px;overflow-y:hidden;">${uobj.discription }
											</textarea></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>联系方式：(可修改)</th>
										<td><input class="common-text required" id="phone"
											name="phone" size="50" type="text" value="${uobj.phone }">
										</td>

									</tr>
									<tr>
										<th><i class="require-red">*</i>广告投放区域：(可修改)</th>
										<td><input class="common-text required" id="range1"
											name="range1" size="50" type="text" value="${uobj.range1}">
									</tr>
									<tr>
										<th><i class="require-red">*</i>截止时间：</th>
										<td><input class="common-text required" id="end_time"
											name="end_time" size="50" type="text"
											value="${uobj.end_time }"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>营业时间：</th>
										<td><input class="common-text required" id="bushour"
											name="bushour" size="50" type="text" value="${uobj.bushour }">
										</td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>广告类型：</th>
										<td><input class="common-text required" id="first_name"
											name="first_name" size="50" type="text"
											value="${uobj.first_name }"></td>
									</tr>

									<tr>
										<th><i class="require-red">*</i>红包概率：</th>
										<td><input class="common-text required" id="probability"
											name="probability" size="50" type="text"
											value="${uobj.probability}"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>红包数量：</th>
										<td><input class="common-text required" id="num"
											name="num" size="50" type="text" value="${uobj.num}"></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>红包单价：</th>
										<td><input class="common-text required" id="price"
											name="price" size="50" type="text" value="${uobj.price }"></td>
									</tr>


									<tr>
										<th></th>
										<td><input class="btn btn-primary btn6 mr10" value="确定"
											type="button" id="upbtn" name="upbtn"
											onclick="upyongjin(${uobj.Id});"> <input
											class="btn btn6" onclick="history.go(-1)" value="返回"
											type="button"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
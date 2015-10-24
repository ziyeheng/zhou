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
<script type="text/javascript" src="<%=basePath%>js/member.js"></script>

</head>
<body>
	<div class="container clearfix">
		<!-- <jsp:include page="left.jsp"></jsp:include>-->
		<!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="<%=basePath%>yjgetYJ.action">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">充值记录</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="search-content">
					<form action="#" method="post">
						<table class="search-tab">
							<tr>
                                <th width="80">
								<th width="100">联系方式筛选:</th>
								<td><input class="common-text required" id="mobel"
									name="mobel" size="30" type="text" value="${mobel}"></td>
								<th width="80">
									<td><input class="btn btn-primary btn2" id="yjbtn1"
									name="yjbtn1" value="查询" type="button" onclick="chaxunrecharge()"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-title">
						<div class="result-list">

							<!-- <a href="<%=basePath%>"><i class="icon-font"></i>新增用户信息</a>
							<a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                        -->
						</div>
					</div>
					<div class="result-content">
						<table class="result-tab" width="100%">
							<tr>
								<th class="tc" width="5%"><input class="allChoose" name=""
									type="checkbox"></th>
								<th>用户名</th>
								<th>手机</th>
								<th>充值金额</th>
								<th>充值时间</th>
								<th>余额</th>
								<th>商家密钥</th>
							</tr>
							<c:forEach items="${rechargelist}" var="uobj">
								<tr>
									<td class="tc">
									<input id="user" name="user"
										value="${uobj.Id}" type="checkbox">
										</td>
									<td width="50px">${uobj.name}</td>
									<td width="70px">${uobj.mobel}</td>
									<td width="50px">${uobj.charge_money}</td>
									<td width="100px">${uobj.charge_time}</td>
									<td width="50px">${uobj.yongjin}</td>
									<td width="70px">${uobj.recognise_id}</td>

								</tr>
							</c:forEach>
						</table>
						<div class="list-page">
							<a href="<%=basePath%>regetrecharge.action?nowpage=1">首页</a>
							<c:if test="${nowpage>1}">
								<a
									href="<%=basePath %>regetrecharge.action?nowpage=${nowpage-1 }">上一页</a>
							</c:if>
							<c:if test="${nowpage==1}">
								<a href="<%=basePath %>regetrecharge.action?nowpage=${nowpage}">上一页</a>
							</c:if>
							第${nowpage }页，共${totalpage }页
							<c:if test="${nowpage<totalpage}">
								<a
									href="<%=basePath %>regetrecharge.action?nowpage=${nowpage+1 }">下一页</a>
							</c:if>
							<c:if test="${nowpage==totalpage}">
								<a href="<%=basePath %>regetrecharge.action?nowpage=${nowpage }">下一页</a>
							</c:if>
							<a href="<%=basePath %>regetrecharge.action?nowpage=${totalpage }">尾页</a>
						</div>
					</div>
				</form>
			</div>

		</div>
		<!--/main-->
	</div>
</body>
</html>
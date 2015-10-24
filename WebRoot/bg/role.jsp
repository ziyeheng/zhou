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
	href="<%=basePath %>css/common.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css" />
<script type="text/javascript" src="<%=basePath %>js/modernizr.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/role.js"></script>

</head>
<body>
	<div class="container clearfix">
		<!-- <jsp:include page="left.jsp"></jsp:include>-->
		<!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="<%=basePath %>yjgetYJ.action">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">角色信息</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="search-content">
					<form action="#" method="post">
						<table class="search-tab">
							<!--<tr>
                            <th width="120">快递公司:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">中通快递</option>
                                    <option value="20">申通快递</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>-->
						</table>
					</form>
				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-title">
						<div class="result-list">

							<a href="<%=basePath %>raddRole.action"><i class="icon-font"></i>新增角色信息</a>
							<!--<a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                        -->
						</div>
					</div>
					<div class="result-content">
						<table class="result-tab" width="100%">
							<tr>
								<th class="tc" width="5%"><input class="allChoose" name=""
									type="checkbox"></th>
								<th>角色名</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${rolelist}" var="robj">
								<tr>
									<td class="tc"><input id="role" name="role"
										value="${robj.Id}" type="checkbox"></td>
									<td width="70px">${robj.name}</td>
								    <c:if test="${robj.state==1}">
										<td width="50px">当前启用</td>
									</c:if>
									<c:if test="${robj.state==0}">
										<td width="50px">已删除</td>
									</c:if>
									<td width="70px">
									<a class="link-update"href="<%=basePath %>rupRole.action?rid=${robj.Id }">修改</a> 
									 <c:if test="${robj.state==1}">
									<input class="btn btn-primary btn1 mr10" value="删除" type="button" id="yjrdbtn" name="yjrdbtn" onclick="yjrd(${robj.Id});">
									</c:if>
									 <c:if test="${robj.state==0}">
									<input class="btn btn-primary btn1 mr10" value="启用" type="button" id="yjrdbtn" name="yjrdbtn" onclick="yjrok(${robj.Id});">
									</c:if>
									</td>
								</tr>
							</c:forEach>
						</table>
						<div class="list-page">
						<a href = "<%=basePath %>rgetRole.action?nowpage=1">首页</a>
                      <c:if test="${nowpage>1}">
                       <a href = "<%=basePath %>rgetRole.action?nowpage=${nowpage-1 }">上一页</a>
                       </c:if>
                       <c:if test="${nowpage==1}">
                       <a href = "<%=basePath %>rgetRole.action?nowpage=${nowpage}">上一页</a>
                       </c:if>
					第${nowpage }页，共${totalpage }页
					 <c:if test="${nowpage<totalpage}">
					<a href = "<%=basePath %>rgetRole.action?nowpage=${nowpage+1 }">下一页</a>
					</c:if>
					 <c:if test="${nowpage==totalpage}">
					<a href = "<%=basePath %>rgetRole.action?nowpage=${nowpage }">下一页</a>
					</c:if>
					<a href = "<%=basePath %>rgetRole.action?nowpage=${totalpage }">尾页</a>
					</div>
					</div>
				</form>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>
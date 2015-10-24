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
<script type="text/javascript" src="<%=basePath%>js/addcategory.js"></script>
</head>
<body>
	<div class="container clearfix">
		<!-- <jsp:include page="left.jsp"></jsp:include>
    <!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="<%=basePath%>yjgetYJ.action">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">更新主菜单</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-content">
					<form action="" method="post" id="ucform" name="ucform"
						enctype="multipart/form-data">
						<table class="insert-tab" width="100%">
							<tbody>
								<!-- <tr>
                            <th width="120"><i class="require-red">*</i>分类：</th>
                            <td>
                                <select name="colId" id="catid" class="required">
                                    <option value="">请选择</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                        </tr>
                        -->
								<c:forEach items="${categorylist}" var="cobj">
									<tr>
										<th><i class="require-red">*</i>名称：</th>
										<td><input class="common-text required" id="ucname"
											name="ucname" size="50" type="text" value="${cobj.name }">
										</td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>模块值：</th>
										<td><input class="common-text required" id="ucmodul"
											name="ucmodul" size="50" type="text" value="${cobj.modul }">
										</td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>类型值：</th>
										<td><input class="common-text required" id="uctype"
											name="uctype" size="50" type="text" value="${cobj.type }">
										</td>
									</tr>
									<tr>
										<th><i class="require-red"></i>显示顺序：</th>
										<td><input class="common-text" id="ucorder"
											name="ucorder" size="50" type="text" value="${cobj.order }">
										</td>
									</tr>
									<tr>
										<th>内容：</th>
										<td><textarea name="uccontent" class="common-textarea"
												id="uccontent" cols="30" style="width: 98%;" rows="10">${cobj.content}</textarea>
										</td>
									</tr>
									<tr>
										<th></th>
										<td><input class="btn btn-primary btn6 mr10" value="确定"
											type="button" onclick="upcat(${cobj.Id});" id="ucbtn"
											name="ucbtn"> <input class="btn btn6"
											onclick="history.go(-1);" value="返回" type="button">
										</td>
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
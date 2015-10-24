<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="left.jsp"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/common.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>css/main.css"/>
    <script type="text/javascript" src="<%=basePath %>js/modernizr.min.js"></script>
     <script type="text/javascript" src="<%=basePath %>js/admin.js"></script>
</head>
<body>
<div class="container clearfix">
   <!-- <jsp:include page="left.jsp"></jsp:include>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="<%=basePath%>yjgetYJ.action">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">修改管理员</span></div>
        </div>
       <div class="result-wrap">
            <div class="result-content">
                <form action="" method="post" id="upadminform" name="upadminform" enctype="multipart/form-data">
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
                        <c:forEach items="${adminlist}" var="uobj">
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="upname" name="upname" size="50" type="text" value="${uobj.name }">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>手机：</th>
                                <td>
                                    <input class="common-text required" id="upmoble" name="upmoble" size="50" type="text" value="${uobj.mobel }">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>邮箱：</th>
                                <td>
                                    <input class="common-text required" id="upemail" name="upemail" size="50" type="text" value="${uobj.email }">
                                </td>
                            </tr>
                            <!--<tr>
                                <th>内容：</th>
                                <td><textarea name="content" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10"></textarea></td>
                            </tr>
                            -->
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="确定" type="button" id="upbtn" name="upbtn" onclick="upad();">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody></table>
                </form>
            </div>
        </div>
        </div>
</div>
</body>
</html>
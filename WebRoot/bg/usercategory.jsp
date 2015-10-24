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
</head>
<body>
<div class="container clearfix">
   <!-- <jsp:include page="left.jsp"></jsp:include>-->
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="<%=basePath%>yjgetYJ.action">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">权限维护</span></div>
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
                        <a href="<%=basePath %>"><i class="icon-font"></i>新增权限信息</a>
                        <!--
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                        -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>名称</th>
                            <th>类别</th>
                            <th>权限</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${uclist}" var="ucobj">
                        <tr>
                         	<td class="tc"><input name="uc" id="uc" value="${ucobj.Id}" type="checkbox"></td>
                            <td width="30px">${ucobj.name}</td>
                            <c:if test="${ucobj.flag==0}" var="flag">
                            <td width="50px">超级管理员</td>
                            </c:if>
                       		 <c:if test="${ucobj.flag==1}" var="flag">
                            <td width="50px">分店管理员</td>
                            </c:if>
                            <c:if test="${ucobj.permit==0}">
                            <td width="50px">所有权限</td>
                            </c:if>
                            <c:if test="${ucobj.permit==1}">
                            <td width="50px">分店权限</td>
                            </c:if>
                            <td width="30px">
                                <a class="link-del" href="#">修改</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <div class="list-page"> 2 条 1/1 页</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
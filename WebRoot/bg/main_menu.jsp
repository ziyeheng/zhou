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
    <script type="text/javascript" src="<%=basePath %>js/mainmenu.js"></script>
</head>
<body>
<div class="container clearfix">
   <!-- <jsp:include page="left.jsp"></jsp:include>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="<%=basePath%>yjgetYJ.action">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">主菜单信息</span></div>
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
                        <a href="<%=basePath %>caddCat.action"><i class="icon-font"></i>新增主菜单信息</a>
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
                            <th>Id</th>
                            <th>类别名</th>
                            <th>模块值</th>
                            <th>类型值</th>
                            <th>顺序</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${categorylist}" var="cobj">
                        <tr>
                         	<td class="tc"><input name="cate" id="cate" value="${cobj.Id}" type="checkbox"></td>
                            <td width="50px">${cobj.Id}</td>
                            <td width="100px">${cobj.name}</td>
                            <td width="50px">${cobj.modul}</td>
                            <td width="50px">${cobj.type}</td>
                            <td width="50px">${cobj.order}</td>
                            <td width="50px">${cobj.state}</td>
                            <td width="70px">
      								<a class="link-update" href="#">查看</a> 
									<a class="link-update"href="<%=basePath %>cupCat.action?cid=${cobj.Id}">修改</a> 
									<input class="btn btn-primary btn1 mr10" value="删除" type="button" id="yjmdbtn" name="yjmdbtn" onclick="yjmd(${cobj.Id});">
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <div class="list-page">
							<a href="<%=basePath %>cgetCategory.action?nowpage=1">首页</a>
							<c:if test="${nowpage>1}">
								<a
									href="<%=basePath %>cgetCategory.action?nowpage=${nowpage-1 }">上一页</a>
							</c:if>
							<c:if test="${nowpage==1}">
								<a
									href="<%=basePath %>cgetCategory.action?nowpage=${nowpage}">上一页</a>
							</c:if>
							第${nowpage }页，共${totalpage }页
							<c:if test="${nowpage<totalpage}">
								<a
									href="<%=basePath %>cgetCategory.action?nowpage=${nowpage+1 }">下一页</a>
							</c:if>
							<c:if test="${nowpage==totalpage}">
								<a
									href="<%=basePath %>cgetCategory.action?nowpage=${nowpage }">下一页</a>
							</c:if>
							<a
								href="<%=basePath %>cgetCategory.action?nowpage=${totalpage }">尾页</a>
						</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
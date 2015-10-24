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
<script type="text/javascript">
	var path = "<%=basePath%>";
	   $(function(){
 		   var maincat=$("#maincat").val();
// 		   var firstcat=$("#firstcat").val();
// 		   var secondcat=$("#secondcat").val();
// 		   var yjpro=$("#yjpro").val();
// 		   var yjcity=$("#yjcity").val();
// 		   var yjqu=$("#yjqu").val();
 		   $("#maincat").find("option[value='"+maincat+"']").attr("selected","selected");
		   //在这里获取了主分类的数据
		   indexmaincat();
//         $("#firstcat").find("option[value='"+firstcat+"']").attr("selected","selected");
// 		   indexfirstcat();
// 		   $("#secondcat").find("option[value='"+secondcat+"']").attr("selected","selected");
// 		   indexsecondcat();
// 		   $("#yjpro").find("option[value='"+yjpro+"']").attr("selected","selected");
// 		   indexyjpro();
// 		   $("#yjcity").find("option[value='"+yjcity+"']").attr("selected","selected");
// 		   indexyjcity();
// 		   $("#yjqu").find("option[value='"+yjqu+"']").attr("selected","selected");
// 		   indexyjqu();
	   });
</script>
</head>
<body>
	<div class="container clearfix">
		<!-- <jsp:include page="left.jsp"></jsp:include>-->
		<!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><a href="<%=basePath%>yjgetYJ.action">首页</a><span
						class="crumb-step">&gt;</span><span class="crumb-name">周边商家信息</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="search-content">
					<form action="#" method="post">
						<table class="search-tab">
							<tr>
								<th width="80">
								<th width="100">分类筛选:</th>
								<td>
									<!-- 有变化之后执行indexfirstcat()--> <select name="search-sort"
									id="maincat" name="maincat" onchange="">
										<option value=""></option>
										<c:forEach items="${maincategory}" var="acobj">
											<option value="${acobj.Id}">${acobj.name}</option>
											${acobj.name}
										</c:forEach>
								</select>
								</td>
								<th width="140">联系方式筛选:</th>
								<td><input class="common-text required" id="mobel"
									name="mobel" size="30" type="text" value="${mobel}"></td>
								<th width="40">
								<td><input class="btn btn-primary btn2" id="yjbtn"
									name="yjbtn" value="查询" type="button" onclick="yjcx()"></td>

							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-title">
						<div class="result-list">

							<!--<a href="<%=basePath%>"><i class="icon-font"></i>新增佣金信息</a>
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
								<th>发布用户</th>
								<th>商店名称</th>
								<th>联系方式</th>
								<th>商家密钥</th>
								<th>分类</th>
								<th>单价</th>
								<th>数量</th>
								<th>概率</th>
								<th>结束时间</th>
								<th>经度</th>
								<th>纬度</th>
								<!-- 								<th>描述</th> -->
								<th>范围</th>
								<th>开业区间</th>
								<th>地址</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${yongjinlist}" var="yjobj">
								<tr>
									<td class="tc"><input id="yj" name="yj"
										value="${yjobj.Id}" type="checkbox"></td>
									<td width="50px">${yjobj.name}</td>
									<td width="50px">${yjobj.businessname}</td>
									<td width="70px">${yjobj.phone}</td>
									<td width="70px">${yjobj.recognise_id}</td>
									<td width="70px">${yjobj.first_name}</td>
									<td width="30px">${yjobj.price}</td>
									<td width="30px">${yjobj.num}</td>
									<td width="30px">${yjobj.probability}</td>
									<td width="70px">${yjobj.end_time}</td>
									<td width="70px">${yjobj.longitude}</td>
									<td width="70px">${yjobj.latitude}</td>
									<!-- 									<td width="370px">${yjobj.discription}</td> -->
									<td width="70px">方圆${yjobj.range1}公里</td>
									<td width="70px">${yjobj.bushour}</td>
									<td width="70px">${yjobj.sjaddress}</td>
									<td width="70px">
										<!-- <a class="link-update" href="#">查看</a> <br> --> <!-- 										<input -->
										<!-- 										class="btn btn-primary btn1 mr10" value="认证" type="button" -->
										<!-- 										id="yjrzbtn" name="yjrzbtn" onclick="yjrz(${yjobj.Id});"> -->
										
										<a class="link-update"
										href="<%=basePath %>yjupyongjin.action?yongjinid=${yjobj.Id}">编辑</a>

										<input class="btn btn-primary btn1 mr10" value="删除"
										type="button" id="yjdbtn" name="yjdbtn"
										onclick="yjd(${yjobj.Id});">
								</tr>
							</c:forEach>
						</table>
						<div class="list-page">
							<a
								href="<%=basePath %>yjgetYJ.action?categoryid=${categoryid }&firstmcid=${firstmcid }&secondid=${secondid }&provinceid=${provinceid }&cityid=${cityid }&zoneid=${zoneid }&yjisOk=${yjisOk }&nowpage=1">首页</a>
							<c:if test="${nowpage>1}">
								<a
									href="<%=basePath %>yjgetYJ.action?categoryid=${categoryid }&firstmcid=${firstmcid }&secondid=${secondid }&provinceid=${provinceid }&cityid=${cityid }&zoneid=${zoneid }&yjisOk=${yjisOk }&nowpage=${nowpage-1 }">上一页</a>
							</c:if>
							<c:if test="${nowpage==1}">
								<a
									href="<%=basePath %>yjgetYJ.action?categoryid=${categoryid }&firstmcid=${firstmcid }&secondid=${secondid }&provinceid=${provinceid }&cityid=${cityid }&zoneid=${zoneid }&yjisOk=${yjisOk }&nowpage=${nowpage}">上一页</a>
							</c:if>
							第${nowpage }页，共${totalpage }页
							<c:if test="${nowpage<totalpage}">
								<a
									href="<%=basePath %>yjgetYJ.action?categoryid=${categoryid }&firstmcid=${firstmcid }&secondid=${secondid }&provinceid=${provinceid }&cityid=${cityid }&zoneid=${zoneid }&yjisOk=${yjisOk }&nowpage=${nowpage+1 }">下一页</a>
							</c:if>
							<c:if test="${nowpage==totalpage}">
								<a
									href="<%=basePath %>yjgetYJ.action?categoryid=${categoryid }&firstmcid=${firstmcid }&secondid=${secondid }&provinceid=${provinceid }&cityid=${cityid }&zoneid=${zoneid }&yjisOk=${yjisOk }&nowpage=${nowpage }">下一页</a>
							</c:if>
							<a
								href="<%=basePath %>yjgetYJ.action?categoryid=${categoryid }&firstmcid=${firstmcid }&secondid=${secondid }&provinceid=${provinceid }&cityid=${cityid }&zoneid=${zoneid }&yjisOk=${yjisOk }&nowpage=${totalpage }">尾页</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>
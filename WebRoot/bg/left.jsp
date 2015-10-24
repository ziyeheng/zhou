<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<body>
	<div class="sidebar-wrap">
		<div class="sidebar-title">
			<h1>菜单</h1>
		</div>
		<div class="sidebar-content">
			<ul class="sidebar-list">
				<li><a href="#"><i class="icon-font">&#xe001;</i>商家发布数据</a>
					<ul class="sub-menu">
						<li><a
							href="<%=basePath%>yjgetYJ.action?categoryid=-1&mobel="><i
								class="icon-font">&#xe008;</i>周边商家信息</a></li>
						<li><a href="<%=basePath%>mcgetModulCategory.action"><i
								class="icon-font">&#xe008;</i>商家分类</a></li>
					</ul></li>
				<li><a href="#"><i class="icon-font">&#xe003;</i>交易记录</a>
					<ul class="sub-menu">
						<li><a
							href="<%=basePath%>regetrecharge.action?nowpage=1&mobel="><i
								class="icon-font">&#xe008;</i>充值记录</a></li>
						<li><a
							href="<%=basePath%>regetcoupon.action?nowpage=1&mobel=&mobel2="><i
								class="icon-font">&#xe008;</i>消费记录</a></li>
						<li><a
							href="<%=basePath%>regetredmoney.action?nowpage=1&mobel=&mobel2="><i
								class="icon-font">&#xe008;</i>抢红包记录</a></li>
						<li><a
							href="<%=basePath%>regetcoupon2.action?nowpage=1&mobel=&mobel2="><i
								class="icon-font">&#xe008;</i>抢使用券记录</a></li>
					</ul></li>


				<li><a href="#"><i class="icon-font">&#xe003;</i>用户管理</a>
					<ul class="sub-menu">
						<li><a
							href="<%=basePath%>indexgetUser.action?nowpage=1&mobel=&categoryname="><i
								class="icon-font">&#xe008;</i>用户信息</a></li>
						<li><a
							href="<%=basePath%>indexgetUser2.action?nowpage=1&mobel=&categoryname="><i
								class="icon-font">&#xe008;</i>已删用户</a></li>
						<li><a href="<%=basePath%>indexgetAdmin.action?nowpage=1"><i
								class="icon-font">&#xe008;</i>管理员信息</a></li>
						<li><a href="<%=basePath%>rgetRole.action?nowpage=1"><i
								class="icon-font">&#xe008;</i>角色管理</a></li>
						<li><a href="<%=basePath%>rgetredmaxnum.action"><i
								class="icon-font">&#xe008;</i>系统参数</a></li>
					</ul></li>
				<li><a href="#"><i class="icon-font">&#xe018;</i>侧边栏管理</a>
					<ul class="sub-menu">
						<li><a
							href="<%=basePath%>pagetHelp.action?nowpage=1&category_id=23"><i
								class="icon-font">&#xe008;</i>新手上路</a></li>
						<li><a
							href="<%=basePath%>pagetHelp.action?nowpage=1&category_id=24"><i
								class="icon-font">&#xe008;</i>常见问题</a></li>
						<li><a
							href="<%=basePath%>pagetHelp.action?nowpage=1&category_id=25"><i
								class="icon-font">&#xe008;</i>服务规则</a></li>
						<li><a
							href="<%=basePath%>pagetHelp.action?nowpage=1&category_id=22"><i
								class="icon-font">&#xe008;</i>关于我们</a></li>
						<li><a
							href="<%=basePath%>nigetNewInformation.action?nowpage=1"><i
								class="icon-font">&#xe008;</i>用户反馈</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</body>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<title>周边商家后台登录界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->

<link rel="stylesheet" href="<%=basePath%>css/supersized.css">
<link rel="stylesheet" href="<%=basePath%>css/login.css">
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>js/tooltips.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login.js"></script>
<script type="text/javascript">
    var path = "<%=basePath%>";
</script>
</head>

<body>
	<div class="page-container">
		<div class="main_box">
			<div class="login_box">
				<div class="login_logo">
					<img src="<%=basePath%>images/bclogo.png">
				</div>
				<div class="login_form">
					<form action="" id="login_form" method="post">
						<div class="form-group">
							<label for="j_username" class="t">账 号：</label> <input id="email"
								value="" name="email" type="text" class="form-control x319 in"
								autocomplete="off">
						</div>
						<div class="form-group">
							<label for="j_password" class="t">密 码：</label> <input
								id="password" value="" name="password" type="password"
								class="password form-control x319 in">
						</div>

						<div class="form-group space">
							<label class="t"></label>
							<table class="search-tab">
								<tr>
									<th width="150">
									<td>
										<button width="200" type="button" id="submit_btn"
											name="submit_btn" onclick="loginbutton();"
											class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp</button>
									</td>

									<th width="80">
									<td><input width="800" type="reset"
										value="&nbsp;重&nbsp;置&nbsp;" class="btn    btn-default btn-lg">
							</table>
							</td>
							</tr>
						</div>
					</form>
				</div>
			</div>
			<div class="bottom">
				Copyright &copy; 2015 - 2016 <a href="#">周边商家</a>
			</div>
		</div>
	</div>

	<!-- Javascript -->

	<script src="<%=basePath%>js/supersized.3.2.7.min.js"></script>
	<script src="<%=basePath%>js/supersized-init.js"></script>
	<script src="<%=basePath%>js/scripts.js"></script>
</body>
</html>
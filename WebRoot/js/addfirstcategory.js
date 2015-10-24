///获取url中指定参数
//<param name="paras">参数名称</param>
///
function request(paras) {
	var url = location.href;
	var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
	var paraObj = {}
	for ( var i = 0; j = paraString[i]; i++) {
		paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j
				.indexOf("=") + 1, j.length);
	}
	var returnValue = paraObj[paras.toLowerCase()];
	if (typeof (returnValue) == "undefined") {
		return "";
	} else {
		return returnValue;
	}
}
// 添加小分类
function addfirstcat() {
	// 提交表单
	if ($('#fcname').val() == '') {
		show_err_msg('请输入名称');
		$('#fcname').focus();
	} else if (isNaN(document.getElementById('fcorder').value)) {
		show_err_msg('顺序栏请输入数字');
		$('#fcorder').focus();
	} else {
		var fcname = $("#fcname").val();
		var fcorder = $("#fcorder").val();
		var fcid = request('cid');
		var ftp = request('tp');
		if (fcorder == '')
			fcorder = 0;
		$("#fcbtn").ready(
				function() {
					$.ajax({
						type : "POST",
						url : path + "mcaddFirstCategoryok.action",
						dataType : "json",
						data : {
							"mcname" : fcname,
							"mcorder" : fcorder,
							"cid" : fcid,
							"tp" : ftp
						},
						success : function(data) {
							if (data.notice != "添加成功")
								show_msg('添加失败！请查看数据', path
										+ 'mcaddFirstCategoryok.action?cid='
										+ fcid + '&tp=' + ftp);
							else {
								show_msg('添加成功！', path
										+ 'mcgetFirstModulCategory.action?cid='
										+ fcid + '&tp=' + ftp + "&nowpage=1");
							}
						}
					});
				});
	}
}

// 修改小分类
function upfirstcat() {
	// 提交表单
	if ($('#ufcname').val() == '') {
		show_err_msg('请输入名称');
		$('#ufcname').focus();
	} else if (isNaN(document.getElementById('ufcorder').value)) {
		show_err_msg('顺序栏请输入数字');
		$('#ufcorder').focus();
	} else {
		var fcname = $("#ufcname").val();
		var fcorder = $("#ufcorder").val();
		var fcid = request("cid");
		var ftp = request("tp");
		var mid = request("mcid");
		$("#ufcbtn")
				.ready(
						function() {
							$
									.ajax({
										type : "POST",
										url : path
												+ "mcupfirstcategoryok.action",
										dataType : "json",
										data : {
											"mcname" : fcname,
											"mcorder" : fcorder,
											"mcid" : mid
										},
										success : function(data) {
											if (data.notice != "修改成功")
												show_msg(
														'修改失败！请查看数据',
														path
																+ 'mcupfirstcategoryok.action?mcid='
																+ mcid
																+ '&cid='
																+ fcid + '&tp='
																+ ftp);
											else {
												show_msg(
														'修改成功！',
														path
																+ 'mcgetFirstModulCategory.action?cid='
																+ fcid + '&tp='
																+ ftp
																+ "&nowpage=1");
											}
										}
									});
						});
	}
}

// 删除小分类 注意.这里有传参
function delfirstcat(id) {

	// getModulCategory

	// 提交表单
	var fcid = request("cid");
	var ftp = request("tp");
	$("#dfcbtn").ready(
			function() {
				$.ajax({
					type : "POST",
					url : path + "mcdelfirstcategoryok.action",
					dataType : "json",
					data : {
						"mcid" : id
					},
					success : function(data) {
						if (data.notice != "删除成功")
							show_msg('删除失败！请查看数据', path
									+ 'mcgetFirstModulCategory.action?cid='
									+ fcid + '&tp=' + ftp + "&nowpage=1");
						else {
							show_msg('删除成功！', path
									+ 'mcgetFirstModulCategory.action?cid='
									+ fcid + '&tp=' + ftp + "&nowpage=1");
						}
					}
				});
			});
}
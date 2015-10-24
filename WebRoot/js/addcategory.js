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

// 添加大分类
function addmodcat() {
	// 提交表单
	var cname = document.getElementById("cname").value;
	if (cname == '') {
		alert('请输入名称');
		document.getElementById("cname").focus();
	} else if (isNaN(document.getElementById('corder').value)) {
		show_err_msg('顺序栏请输入数字');
		$('#corder').focus();
	} else {
		var cname = document.getElementById("cname").value;
		var corder = document.getElementById("corder").value;
		if (corder == '')
			corder = 0;
		$.ajax({
			type : "POST",
			url : path + "caddCategoryok.action",
			dataType : "json",
			data : {
				"cname" : cname,
				"corder" : corder
			},
			success : function(data) {
				if (data.notice != "添加成功")
					show_msg('添加失败，请检查数据！', path + 'caddCategory.action');
				else {
					show_msg('添加成功！', path + 'mcgetModulCategory.action');
				}
			}
		});
	}
}

// 修改大分类
function upmodcat() {
	// 提交表单
	var cname = document.getElementById("ucname").value;
	if (cname == '') {
		alert('请输入名称');
		document.getElementById("ucname").focus();
	} else if (isNaN(document.getElementById('ucorder').value)) {
		show_err_msg('顺序栏请输入数字');
		$('#ucorder').focus();
	}

	else {
		var ucname = document.getElementById("ucname").value;
		var ucorder = document.getElementById("ucorder").value;
		var cid = request('cid');
		$.ajax({
			type : "POST",
			url : path + "cupCategoryok.action",
			dataType : "json",
			data : {
				"cname" : ucname,
				"corder" : ucorder,
				"cid" : cid
			},
			success : function(data) {
				if (data.notice != "修改成功")
					show_msg('修改失败，请检查数据！', path + 'cupCategory.action?cid='
							+ cid);
				else {
					show_msg('修改成功！', path + 'mcgetModulCategory.action');
				}
			}
		});
	}
}

// 删除大分类
function delmodcat(id) {
	// 删除表单
	var cid = document.getElementById("fastcom").value;
	$.ajax({
		type : "POST",
		url : path + "cdelCategoryok.action",
		dataType : "json",
		data : {
			"cid" : id
		},
		success : function(data) {
			if (data.notice != "删除成功")
				show_msg('删除失败，不能删除', path + 'mcgetModulCategory.action');
			else {
				show_msg('删除成功！', path + 'mcgetModulCategory.action');
			}
		}
	});
}

function addcat() {
	if ($('#acname').val() == '') {
		show_err_msg('请输入名称');
		$('#acname').focus();
	} else if ($('#acmodul').val() == '') {
		show_err_msg('请输入模块值');
		$('#acmodul').focus();
	} else if ($('#actype').val() == '') {
		show_err_msg('请输入类型值');
		$('#actype').focus();
	} else {
		var acname = $("#acname").val();
		var acmodul = $("#acmodul").val();
		var actype = $("#actype").val();
		var acorder = $("#acorder").val();
		var accontent = $("#accontent").val();
		if (acorder == '')
			acorder = 0;
		$("#acbtn")
				.ready(
						function() {
							$
									.ajax({
										type : "POST",
										url : path + "caddAllCategoryok.action",
										dataType : "json",
										data : {
											"cname" : acname,
											"corder" : acorder,
											"ctype" : actype,
											"cmodul" : acmodul,
											"ccontent" : accontent
										},
										success : function(data) {
											if (data.notice != "添加成功")
												show_msg('添加失败！请查看数据', path
														+ 'caddCat.action');
											else {
												show_msg(
														'添加成功！',
														path
																+ 'cgetCategory.action?nowpage=1');
											}
										}
									});
						});
	}
}

function upcat(id) {
	if ($('#ucname').val() == '') {
		show_err_msg('请输入名称');
		$('#ucname').focus();
	} else if ($('#ucmodul').val() == '') {
		show_err_msg('请输入模块值');
		$('#ucmodul').focus();
	} else if ($('#uctype').val() == '') {
		show_err_msg('请输入类型值');
		$('#uctype').focus();
	} else {
		var acname = $("#ucname").val();
		var acmodul = $("#ucmodul").val();
		var actype = $("#uctype").val();
		var acorder = $("#ucorder").val();
		var accontent = $("#uccontent").val();
		if (acorder == '')
			acorder = 0;
		$("#ucbtn").ready(
				function() {
					$.ajax({
						type : "POST",
						url : path + "cupAllCategoryok.action",
						dataType : "json",
						data : {
							"cname" : acname,
							"corder" : acorder,
							"ctype" : actype,
							"cmodul" : acmodul,
							"ccontent" : accontent,
							"cid" : id
						},
						success : function(data) {
							if (data.notice != "修改成功")
								show_msg('修改失败！请查看数据', path
										+ 'cupCat.action?cid=' + id);
							else {
								show_msg('修改成功！', path
										+ 'cgetCategory.action?nowpage=1');
							}
						}
					});
				});
	}
}
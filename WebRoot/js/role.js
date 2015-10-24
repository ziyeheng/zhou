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

function yjrd(id) {
	$("#yjrdbtn").ready(function() {
		$.ajax({
			type : "POST",
			url : path + "rupyjrd.action",
			dataType : "json",
			data : {
				"rid" : id
			},
			success : function(data) {
				if (data.notice != "删除成功")
					show_msg('删除失败！', path + 'rgetRole.action?nowpage=1');
				else {
					show_msg('删除成功！', path + 'rgetRole.action?nowpage=1');
				}
			}
		});
	});
}

function yjrok(id) {
	$("#yjrdbtn").ready(function() {
		$.ajax({
			type : "POST",
			url : path + "rupyjrok.action",
			dataType : "json",
			data : {
				"rid" : id
			},
			success : function(data) {
				if (data.notice != "启用成功")
					show_msg('启用失败！', path + 'rgetRole.action?nowpage=1');
				else {
					show_msg('启用成功！', path + 'rgetRole.action?nowpage=1');
				}
			}
		});
	});
}

function yjar() {
	if ($('#arname').val() == '') {
		show_err_msg('请输入名称');
		$('#arname').focus();
	} else {
		var adname = $("#arname").val();
		$("#arbtn").ready(function() {
			$.ajax({
				type : "POST",
				url : path + "raddRoleok.action",
				dataType : "json",
				data : {
					"rname" : adname
				},
				success : function(data) {
					if (data.notice != "添加成功")
						show_msg('添加失败！请查看数据', path + 'raddRole.action');
					else {
						show_msg('添加成功！', path + 'rgetRole.action?nowpage=1');
					}
				}
			});
		});
	}
}

// 修改单日最大抢使用券数量
function editmaxnum() {

	// alert(111);
	var num = document.getElementById('maxnum').value;
	// alert(num);
	if ($('#maxnum').val() == '') {
		show_err_msg('不能为空!请输入数字');
		$('#maxnum').focus();
	} else {
		if (isNaN(num)) {
			show_err_msg('请输入数字');
			$('#maxnum').focus();
		} else {
			$("#urbtn").ready(
					function() {
						$.ajax({
							type : "POST",
							url : path + "rupmaxnum.action",
							dataType : "json",
							data : {
								"maxnum" : num
							},
							success : function(data) {
								if (data.notice != "修改成功")
									show_msg('修改失败！请查看数据', path
											+ 'rgetredmaxnum.action');
								else {
									show_msg('修改成功！', path
											+ 'rgetredmaxnum.action');
								}
							}
						});
					});
		}
	}

}

function yjur() {
	if ($('#urname').val() == '') {
		show_err_msg('请输入名称');
		$('#urname').focus();
	} else {
		var adname = $("#urname").val();
		var id = request('rid');
		$("#urbtn").ready(
				function() {
					$.ajax({
						type : "POST",
						url : path + "rupRoleok.action",
						dataType : "json",
						data : {
							"rname" : adname,
							"rid" : id
						},
						success : function(data) {
							if (data.notice != "修改成功")
								show_msg('修改失败！请查看数据', path
										+ 'rupRole.action?rid=' + id);
							else {
								show_msg('修改成功！', path
										+ 'rgetRole.action?nowpage=1');
							}
						}
					});
				});
	}
}
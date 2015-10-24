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

// 添加侧边栏的信息
function adhcat() {
	// alert(111);

	// alert(document.getElementById('adhorder').value);
	if ($('#adhname').val() == '') {
		show_err_msg('请输入名称');
		$('#adhname').focus();
	} else if (isNaN(document.getElementById('adhorder').value)) {
		show_err_msg('顺序栏请输入数字');
		$('#adhorder').focus();
	} else {
		var planame = $("#adhname").val();
		var plaorder = $("#adhorder").val();
		var placontent = $("#adhcontent").val();
		// var category_id = id
		if (plaorder == '' || plaorder == null)
			plaorder = 0;
		$('#adhbtn').ready(
				function() {
					$.ajax({
						type : "POST",
						url : path + "payjaddHelpok.action",
						dataType : "json",
						data : {
							"patitle" : planame,
							"paorder" : plaorder,
							"pacontent" : placontent,
						},
						success : function(data) {
							if (data.notice != "添加成功")
								show_msg('添加失败！请查看数据', path
										+ 'paaddHelpInformation.action');
							else {
								show_msg('添加成功！', path
										+ 'pagetHelp.action?nowpage=1');
							}
						}
					});
				});
	}
}

// 编辑新手上路的内容
function uphcat() {

	if ($('#uphname').val() == '') {
		show_err_msg('请输入名称');
		$('#uphname').focus();
	} else if (isNaN(document.getElementById('uphorder').value)) {
		show_err_msg('顺序栏请输入数字');
		$('#uphorder').focus();
	} else {
		var planame = $("#uphname").val();
		var plaorder = $("#uphorder").val();
		var placontent = $("#uphcontent").val();
		// var category_id =id

		var id = request('paid');
		if (plaorder == '' || plaorder == null)
			plaorder = 0;
		$('#uphbtn').ready(
				function() {
					$.ajax({
						type : "POST",
						url : path + "payjupHelpok.action",
						dataType : "json",
						data : {
							"patitle" : planame,
							"paorder" : plaorder,
							"pacontent" : placontent,
							"paid" : id
						},
						success : function(data) {
							if (data.notice != "修改成功")
								show_msg('修改失败！请查看数据', path
										+ 'paupHelpInformation.action?paid='
										+ id);
							else {
								show_msg('修改成功！', path
										+ 'pagetHelp.action?nowpage=1');
							}
						}
					});
				});
	}
}
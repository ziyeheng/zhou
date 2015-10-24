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

// 查询主分类.第一类
function indexmaincat() {
	var maincat = $("#maincat").val();
	var catid = request('categoryid');
	if (maincat != "0") {
		$.ajax({
			type : "POST",
			url : path + "yjMainCategory.action",
			dataType : "json",
			async : false,
			cache : false,
			// var id = request('mid');
			data : {
				categoryid : catid
			},
			success : function(data) {
				var coms = data.maincategory;
				if (catid <= 0)
					$("#maincat").html("<option value='-1'>全部</option>");
				else {

					// 下拉框初始化的第一条
					$("#maincat").html(
							"<option value='" + catid + "'>" + data.catname
									+ "</option>");
					// 往后边加数据
					$("#maincat").append("<option value='-1'>全部</option>");
				}
				for ( var i = 0; i < coms.length; i++) {
					// 再用for循环接着加数据
					$("#maincat").append(
							"<option value='" + coms[i].Id + "'>"
									+ coms[i].name + "</option>");
				}
			}
		});
	}
}

// 第一类筛选,点击筛选调用
function indexfirstcat() {
	var firstcat = $("#firstcat").val();
	var maincat = $("#maincat").val();
	if (firstcat != "0") {
		$.ajax({
			type : "POST",
			url : path + "yjyjFirstCategory.action",
			dataType : "json",
			async : false,
			cache : false,
			data : {
				"categoryid" : maincat
			},
			// 将返回来的数据展示在下拉框中
			success : function(data, status) {
				var coms = data.firstcategory;
				$("#firstcat").html("<option value='-1'>全部</option>");
				for ( var i = 0; i < coms.length; i++) {
					$("#firstcat").append(
							"<option value='" + coms[i].Id + "'>"
									+ coms[i].name + "</option>");
				}
			}
		});
	}
}

function indexsecondcat() {
	var secondcat = $("#secondcat").val();
	var firstcat = $("#firstcat").val();
	if (secondcat != "0") {
		$.ajax({
			type : "POST",
			url : path + "yjyjSecondCategory.action",
			dataType : "json",
			async : false,
			cache : false,
			data : {
				"firstmcid" : firstcat
			},
			success : function(data, status) {
				var coms = data.secondcategory;
				$("#secondcat").html("<option value='-1'>全部</option>");
				for ( var i = 0; i < coms.length; i++) {
					$("#secondcat").append(
							"<option value='" + coms[i].Id + "'>"
									+ coms[i].name + "</option>");
				}
			}
		});
	}
}

function indexyjpro() {
	var yjpro = $("#yjpro").val();
	if (yjpro != "0") {
		$.ajax({
			type : "POST",
			url : path + "yjyjProvince.action",
			dataType : "json",
			async : false,
			cache : false,
			success : function(data, status) {
				var coms = data.province;
				$("#yjpro").html("<option value='-1'>全部</option>");
				for ( var i = 0; i < coms.length; i++) {
					$("#yjpro").append(
							"<option value='" + coms[i].Id + "'>"
									+ coms[i].name + "</option>");
				}
			}
		});
	}
}

function indexyjcity() {
	var yjcity = $("#yjcity").val();
	var yjpro = $("#yjpro").val();
	if (yjcity != "0") {
		$.ajax({
			type : "POST",
			url : path + "yjyjCity.action",
			dataType : "json",
			async : false,
			cache : false,
			data : {
				"provinceid" : yjpro
			},
			success : function(data, status) {
				var coms = data.city;
				$("#yjcity").html("<option value='-1'>全部</option>");
				for ( var i = 0; i < coms.length; i++) {
					$("#yjcity").append(
							"<option value='" + coms[i].Id + "'>"
									+ coms[i].name + "</option>");
				}
			}
		});
	}
}

function indexyjqu() {
	var yjqu = $("#yjqu").val();
	var yjcity = $("#yjcity").val();
	if (yjqu != "0") {
		$.ajax({
			type : "POST",
			url : path + "yjyjZone.action",
			dataType : "json",
			async : false,
			cache : false,
			data : {
				"cityid" : yjcity
			},
			success : function(data, status) {
				var coms = data.zone;
				$("#yjqu").html("<option value='-1'>全部</option>");
				for ( var i = 0; i < coms.length; i++) {
					$("#yjqu").append(
							"<option value='" + coms[i].Id + "'>"
									+ coms[i].name + "</option>");
				}
			}
		});
	}
}

// yognjin查询
function yjcx() {

	var maincat = $("#maincat").val();
	var mobel = $("#mobel").val();
	// var firstcat=$("#firstcat").val();
	// var secondcat=$("#secondcat").val();
	// var yjpro=$("#yjpro").val();
	// var yjcity=$("#yjcity").val();
	// var yjqu=$("#yjqu").val();
	// var yjok=$("#yjok").val();
	window.location.href = path + "yjgetYJ.action?categoryid=" + maincat
			+ "&mobel=" + mobel + "&page=1";

	// window.location.href=path +
	// "yjgetYJ.action?categoryid="+maincat+"&firstmcid="+firstcat+"&secondid="+secondcat+"&provinceid="+yjpro+"&cityid="+yjcity+"&zoneid="+yjqu+"&yjisOk="+yjok+"&page=1";
}

function yjrz(id) {
	// 提交表单
	$("#yjrzbtn")
			.ready(
					function() {
						$
								.ajax({
									type : "POST",
									url : path + "yjupyjrz.action",
									dataType : "json",
									data : {
										"yjid" : id
									},
									success : function(data) {
										if (data.notice == "认证失败")
											show_msg(
													'认证失败！',
													path
															+ 'yjgetYJ.action?categoryid=0&firstmcid=0&secondid=0&provinceid=0&cityid=0&zoneid=0&yjisOk=-1&nowpage=1');
										else if (data.notice == "已经认证") {
											show_msg(
													'已经认证！',
													path
															+ 'yjgetYJ.action?categoryid=0&firstmcid=0&secondid=0&provinceid=0&cityid=0&zoneid=0&yjisOk=-1&nowpage=1');
										} else {
											show_msg(
													'认证成功！',
													path
															+ 'yjgetYJ.action?categoryid=0&firstmcid=0&secondid=0&provinceid=0&cityid=0&zoneid=0&yjisOk=-1&nowpage=1');
										}
									}
								});
					});
}

function yjd(id) {
	$("#yjdbtn")
			.ready(
					function() {
						$
								.ajax({
									type : "POST",
									url : path + "yjupyjd.action",
									dataType : "json",
									data : {
										"yjid" : id
									},
									success : function(data) {
										if (data.notice != "删除成功")
											show_msg(
													'删除失败！',
													path
															+ 'yjgetYJ.action?categoryid=0&nowpage=1');
										else {
											show_msg(
													'删除成功！',
													path
															+ 'yjgetYJ.action?categoryid=0&&nowpage=1');
										}
									}
								});
					});
}

// 修改发布消息
function upyongjin(id) {

	var businessname = $("#businessname").val();
	var sjaddress = $("#sjaddress").val();
	var discription = $("#discription").val();
	var phone = $("#phone").val();
	var range1 = $("#range1").val();
	if (isNaN(document.getElementById('range1').value)) {
		show_err_msg('发布范围输入数字');
		$('#range1').focus();

	} else if (range1 > 20) {
		show_err_msg('发布范围需小于20');
		$('#range1').focus();
	} else {
		$("#upbtn")
				.ready(
						function() {
							$
									.ajax({
										type : "POST",
										url : path + "yjupyjd1.action",
										dataType : "json",
										data : {
											"yongjinid" : id,
											"businessname" : businessname,
											"sjaddress" : sjaddress,
											"discription" : discription,
											"phone" : phone,
											"range1" : range1
										},
										success : function(data) {
											if (data.notice != "修改成功")
												show_msg(
														'修改失败！',
														path
																+ 'yjupyongjin.action?yongjinid='
																+ id);
											else {
												show_msg(
														'修改成功！',
														path
																+ 'yjgetYJ.action?categoryid=-1&mobel=');
											}
										}
									});
						});
	}
}

// 删除反馈信息
function yjnid(id) {
	$("#yjnidbtn").ready(
			function() {
				$.ajax({
					type : "POST",
					url : path + "niupyjnidm.action",
					dataType : "json",
					data : {
						"niid" : id
					},
					success : function(data) {
						if (data.notice != "删除成功")
							show_msg('删除失败！', path
									+ 'nigetNewInformation.action?nowpage=1');
						else {
							show_msg('删除成功！', path
									+ 'nigetNewInformation.action?nowpage=1');
						}
					}
				});
			});
}

function yjmyjd(id) {

	$("#yjmyjdbtn").ready(
			function() {
				$.ajax({
					type : "POST",
					url : path + "myjyjmyyjdm.action",
					dataType : "json",
					data : {
						"myid" : id
					},
					success : function(data) {
						if (data.notice != "删除成功")
							show_msg('删除失败！', path
									+ 'myjgetMemberYongjin.action?nowpage=1');
						else {
							show_msg('删除成功！', path
									+ 'myjgetMemberYongjin.action?nowpage=1');
						}
					}
				});
			});

}

function yjmid(id) {
	$("#yjmidbtn")
			.ready(
					function() {
						$
								.ajax({
									type : "POST",
									url : path + "miyjmid.action",
									dataType : "json",
									data : {
										"miid" : id
									},
									success : function(data) {
										if (data.notice != "删除成功")
											show_msg(
													'删除失败！',
													path
															+ 'migetMemberInformation.action?nowpage=1');
										else {
											show_msg(
													'删除成功！',
													path
															+ 'migetMemberInformation.action?nowpage=1');
										}
									}
								});
					});
}
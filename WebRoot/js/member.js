function yjrzm(id) {
	// 提交表单
	$("#yjrzmbtn").ready(function() {
		$.ajax({
			type : "POST",
			url : path + "indexupyjrzm.action",
			dataType : "json",
			data : {
				"mid" : id
			},
			success : function(data) {
				if (data.notice == "认证失败")
					show_msg('认证失败！', path + 'indexgetUser.action?nowpage=1');
				else if (data.notice == "已经认证") {
					show_msg('已经认证！', path + 'indexgetUser.action?nowpage=1');
				} else {
					show_msg('认证成功！', path + 'indexgetUser.action?nowpage=1');
				}
			}
		});
	});
}

function yjdm(id) {
	$("#yjdmbtn").ready(function() {
		$.ajax({
			type : "POST",
			url : path + "indexupyjdm.action",
			dataType : "json",
			data : {
				"mid" : id
			},
			success : function(data) {
				if (data.notice != "删除成功")
					show_msg('删除失败！', path + 'indexgetUser.action?nowpage=1');
				else {
					show_msg('删除成功！', path + 'indexgetUser.action?nowpage=1');
				}
			}
		});
	});
}
// 恢复数据
function yjdm2(id) {
	$("#yjdmbtn").ready(function() {
		$.ajax({
			type : "POST",
			url : path + "indexupyjdm2.action",
			dataType : "json",
			data : {
				"mid" : id
			},
			success : function(data) {
				if (data.notice != "恢复成功")
					show_msg('恢复失败！', path + 'indexgetUser2.action?nowpage=1');
				else {
					show_msg('恢复成功！', path + 'indexgetUser2.action?nowpage=1');
				}
			}
		});
	});
}
function yjrza(id) {
	// 提交表单
	$("#yjrzabtn").ready(function() {
		$.ajax({
			type : "POST",
			url : path + "indexupyjrzm.action",
			dataType : "json",
			data : {
				"mid" : id
			},
			success : function(data) {
				if (data.notice == "认证失败")
					show_msg('认证失败！', path + 'indexgetAdmin.action?nowpage=1');
				else if (data.notice == "已经认证") {
					show_msg('已经认证！', path + 'indexgetAdmin.action?nowpage=1');
				} else {
					show_msg('认证成功！', path + 'indexgetAdmin.action?nowpage=1');
				}
			}
		});
	});
}

// 查询联系人
function chaxun() {

	var mobel = $("#mobel").val();

	// alert(111);

	$("#yjbtn1").ready(
			function() {
				$.ajax({
					success : function(data) {
						location.replace(path
								+ "indexgetUser.action?nowpage=1&mobel="
								+ mobel);
					}
				});
			});
}
// 查询充值记录
function chaxunrecharge() {

	var mobel = $("#mobel").val();

	// alert(mobel)
	$("#yjbtn1").ready(
			function() {
				$.ajax({
					success : function(data) {
						location.replace(path
								+ "regetrecharge.action?nowpage=1&mobel="
								+ mobel);
					}
				});
			});
}

// 查询消费记录

function chaxuncoupon() {

	var mobel = $("#mobel").val();
	var mobel2 = $("#mobel2").val();
	$("#yjbtn1").ready(
			function() {
				$.ajax({
					success : function(data) {
						location.replace(path
								+ "regetcoupon.action?nowpage=1&mobel=" + mobel
								+ "&mobel2=" + mobel2);
					}
				});
			});
}

// 查询消费记录

function chaxuncoupon2() {

	var mobel = $("#mobel").val();
	var mobel2 = $("#mobel2").val();
	$("#yjbtn1").ready(
			function() {
				$.ajax({
					success : function(data) {
						location.replace(path
								+ "regetcoupon2.action?nowpage=1&mobel="
								+ mobel + "&mobel2=" + mobel2);
					}
				});
			});
}

// 查询抢到红包记录

function chaxunredmoney() {

	var mobel = $("#mobel").val();
	var mobel2 = $("#mobel2").val();
	$("#yjbtn1").ready(
			function() {
				$.ajax({
					success : function(data) {
						location.replace(path
								+ "regetredmoney.action?nowpage=1&mobel="
								+ mobel + "&mobel2=" + mobel2);
					}
				});
			});
}

function yjda(id) {
	$("#yjdabtn").ready(function() {
		$.ajax({
			type : "POST",
			url : path + "indexupyjdm.action",
			dataType : "json",
			data : {
				"mid" : id
			},
			success : function(data) {
				if (data.notice != "删除成功")
					show_msg('删除失败！', path + 'indexgetAdmin.action?nowpage=1');
				else {
					show_msg('删除成功！', path + 'indexgetAdmin.action?nowpage=1');
				}
			}
		});
	});
}
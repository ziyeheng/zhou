function request(paras) {
	var url = location.href;
	var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
	var paraObj = {}
	for (var i = 0; j = paraString[i]; i++) {
		paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
	}
	var returnValue = paraObj[paras.toLowerCase()];
	if (typeof (returnValue) == "undefined") {
		return "";
	} else {
		return returnValue;
	}
}

//添加管理员
function adad() {
	if($('#adname').val() == ''){
		show_err_msg('请输入名称');	
		$('#adname').focus();
	}else if($('#admoble').val() == ''){
		show_err_msg('请输入手机号');	
		$('#admoble').focus();
	}else if($('#ademail').val() == ''){
		show_err_msg('请输入邮箱');	
		$('#ademail').focus();
	}else if($('#adpass').val() == ''){
		show_err_msg('请输入初始密码');	
		$('#adpass').focus();
	}else if($('#adpassok').val() == ''){
		show_err_msg('请再次输入密码');	
		$('#adpassok').focus();
	}else if($('#adpass').val()!=$('#adpassok').val()){
		show_err_msg('两次输入的密码不一致');	
		$('#adpassok').focus();
	}else{
		var adname = $("#adname").val();
		var admobel = $("#admoble").val();
		var ademail = $("#ademail").val();
		var adpass = $("#adpass").val();
		$("#adbtn").ready(function(){
			$.ajax({
				type: "POST",
				url: path+"indexaddAdminok.action",
				dataType: "json",
				data:{
					"mname":adname,
					"mpassword":adpass,
					"memail":ademail,
					"mmobel":admobel
				},
				success:function(data){
					if(data.notice!="添加成功")
						show_msg('添加失败！请查看数据',path+'indexaddAdmin.action');
					else
					{
						show_msg('添加成功！',path+'indexgetAdmin.action?nowpage=1');
					}
				}
			});
		});
	}
}

function upad() {
	if($('#upname').val() == ''){
		show_err_msg('请输入名称');	
		$('#upname').focus();
	}else if($('#upmoble').val() == ''){
		show_err_msg('请输入手机号');	
		$('#upmoble').focus();
	}else if($('#upemail').val() == ''){
		show_err_msg('请输入邮箱');	
		$('#upemail').focus();
	}else if($('#adpass').val() == ''){
		show_err_msg('请输入初始密码');	
		$('#adpass').focus();
	}else{
		var adname = $("#upname").val();
		var admobel = $("#upmoble").val();
		var ademail = $("#upemail").val();
		var id = request('mid');
		$("#upbtn").ready(function(){
			$.ajax({
				type: "POST",
				url: path+"indexupAdminok.action",
				dataType: "json",
				data:{
					"mname":adname,
					"memail":ademail,
					"mmobel":admobel,
					"mid":id
				},
				success:function(data){
					if(data.notice!="修改成功")
						show_msg('修改失败！请查看数据',path+'indexupAdmin.action?mid='+id);
					else
					{
						show_msg('修改成功！',path+'indexgetAdmin.action?nowpage=1');
					}
				}
			});
		});
	}
}

//修改商家密钥

function upmem() {


		var id = request('mid');
		var name=$("#upname").val();
		var miyue=$("#upmiyue").val();
		$("#upbtn").ready(function(){
			$.ajax({
				type: "POST",
				url: path+"indexupMemok.action",
				dataType: "json",
				data:{
					"mname":name,
					"mmiyue":miyue,
					"mid":id
				},
				success:function(data){
					if(data.notice!="修改成功")
						show_msg('修改失败！请查看数据',path+'indexupMiYue.action?mid='+id);
					else
					{
						show_msg('修改成功！',path+'indexgetUser.action?nowpage=1');
					}
				}
			});
		});
	
}

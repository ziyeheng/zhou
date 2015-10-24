
//修改密码
function uppbutton() {
	//提交表单
	var opass = document.getElementById("opass").value;
	var npass = document.getElementById("npass").value;
	var npassok = document.getElementById("npassok").value;
	if(opass == ''){
		alert('请输入原密码');	
		document.getElementById("opass").focus();
	}else if(npass==''){
		alert('请输入新密码');
		document.getElementById("npass").focus();
	}else if(npassok=='') {
		alert('请确认新密码');
		document.getElementById("npassok").focus();
	}
	else if(npass != npassok) {
		alert('两次输入的密码不一致，请重新输入');
		document.getElementById("npassok").focus();
	}
	else{
		opass = document.getElementById("opass").value;
		npass = document.getElementById("npass").value;
		$("#upbtn").ready(function(){
			$.ajax({
				type: "POST",
				url: path+"indexupPassok.action",
				dataType: "json",
				data:{
					"opass":opass,
					"npass":npass
				},
				success:function(data){
					if(data.notice!="修改成功")
						show_msg('密码修改失败！',path+'indexgetUpPass.action');
					else
					{
						show_msg('密码修改成功，请重新登陆！',path+'indexzhoubian.action');
					}
				}
			});
		});
	}
}
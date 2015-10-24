//JavaScript Document
//支持Enter键登录
document.onkeydown = function(e){
	if($(".bac").length==0)
	{
		if(!e) e = window.event;
		if((e.keyCode || e.which) == 13){
			var obtnLogin=document.getElementById("submit_btn")
			obtnLogin.focus();
		}
	}
}


//var request = false;
//
//function createXMLHTTPlogin() {
//	try {
//		request = new XMLHttpRequest();
//	}catch(trymicrosoft) {
//		try {
//			request = new ActiveXObject("Msxml2.XMLHTTP");
//		}catch(othermicrosoft) {
//			try {
//				request = new ActiveXObject("Microsoft.XMLHTTP");
//			}catch(failed) {
//				request = false;
//			}
//		}
//	}
//	if(!request)
//		alter("Error initializing XMLHttpRequest!");
//	url = path+"loginsys.action";
//	request.open("post",url,true);
//	request.onreadystatechange = loginbutton;
//	request.send(null);
//}

function loginbutton() {
	//提交表单
	{//if(request.readyState == 4 && request.status == 200){
		show_loading();
		//var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
		if($('#email').val() == ''){
			show_err_msg('请输入用户名');	
			$('#email').focus();
		}else if($('#password').val() == ''){
			show_err_msg('请输入密码');
			$('#password').focus();
		}else{
			var auusername = $("#email").val();
			var aupassword = $("#password").val();
			$("#submit_btn").ready(function(){
				$.ajax({
					type: "POST",
					url: path+"indexlogin.action",
					dataType: "json",
					data:{
						"mname":auusername,
						"mpassword":aupassword
					},
					success:function(data){
						if(data.notice!="登陆成功")
							show_msg('登录失败！请重新登录...',path+'indexzhoubian.action');
						else
						{
							show_msg('登录成功！正在为您跳转...',path+'yjgetYJ.action?categoryid=0&nowpage=1&mobel=');
						}
					}
				});
			});
		}
	}
}
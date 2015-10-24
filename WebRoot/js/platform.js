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

function yjpad(id) {
	$("#yjpabtn").ready(function(){
		$.ajax({
			type: "POST",
			url: path+"paupyjpaok.action",
			dataType: "json",
			data:{
				"paid":id
			},
			success:function(data){
				if(data.notice!="删除成功")
					show_msg('删除失败！',path+'pagetPlatformActivity.action?nowpage=1');
				else
				{
					show_msg('删除成功！',path+'pagetPlatformActivity.action?nowpage=1');
				}
			}
		});
	});
}

function yjhd(id) {
	$("#yjhbtn").ready(function(){
		$.ajax({
			type: "POST",
			url: path+"paupyjpaok.action",
			dataType: "json",
			data:{
				"paid":id
			},
			success:function(data){
				if(data.notice!="删除成功")
					show_msg('删除失败！',path+'pagetHelp.action?nowpage=1');
				else
				{
					show_msg('删除成功！',path+'pagetHelp.action?nowpage=1');
				}
			}
		});
	});
}

function addplacat() {
	if($('#addplaname').val() == ''){
		show_err_msg('请输入名称');	
		$('#addplaname').focus();
	}else{
		var planame = $("#addplaname").val();
		var plaorder = $("#addplaorder").val();
		var placontent = $("#addplacontent").val();
		if(plaorder==''||plaorder==null)
			plaorder=0;
		$('#addplabtn').ready(function(){
			$.ajax({
				type: "POST",
				url: path+"payjaddPlatFormActivityok.action",
				dataType: "json",
				data:{
					"patitle":planame,
					"paorder":plaorder,
					"pacontent":placontent
				},
				success:function(data){
					if(data.notice!="添加成功")
						show_msg('添加失败！请查看数据',path+'paaddPlatFormActivity.action');
					else
					{
						show_msg('添加成功！',path+'pagetPlatformActivity.action?nowpage=1');
					}
				}
			});
		});
	}
}

function upplacat() {
	if($('#upplaname').val() == ''){
		show_err_msg('请输入名称');	
		$('#upplaname').focus();
	}else{
		var planame = $("#upplaname").val();
		var plaorder = $("#upplaorder").val();
		var placontent = $("#upplacontent").val();
		var id = request('paid');
		if(plaorder==''||plaorder==null)
			plaorder=0;
		$('#upplabtn').ready(function(){
			$.ajax({
				type: "POST",
				url: path+"payjupPlatFormActivityok.action",
				dataType: "json",
				data:{
					"patitle":planame,
					"paorder":plaorder,
					"pacontent":placontent,
					"paid":id
				},
				success:function(data){
					if(data.notice!="修改成功")
						show_msg('修改失败！请查看数据',path+'paupPlatFormActivity.action?paid='+id);
					else
					{
						show_msg('修改成功！',path+'pagetPlatformActivity.action?nowpage=1');
					}
				}
			});
		});
	}
}
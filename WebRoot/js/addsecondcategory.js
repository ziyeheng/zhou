///获取url中指定参数
//<param name="paras">参数名称</param>
///
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

function addsecondcat() {
	//提交表单
	if($('#scname').val() == ''){
		show_err_msg('请输入名称');	
		$('#scname').focus();
	}else{
		var scname = $("#scname").val();
		var scorder = $("#scorder").val();
		var scid = request('cid');
		var stp = request('tp');
			if(scorder=='')
				scorder=0;
		$("#scbtn").ready(function(){
			$.ajax({
				type: "POST",
				url: path+"mcaddFirstCategoryok.action",
				dataType: "json",
				data:{
					"mcname":scname,
					"mcorder":scorder,
					"cid":scid,
					"tp":stp
				},
				success:function(data){
					if(data.notice!="添加成功")
						show_msg('添加失败！请查看数据',path+'mcaddSecondCategory.action?cid='+scid+'&tp='+stp);
					else
					{
						show_msg('添加成功！',path+'mcgetSecondModulCategory.action?cid='+scid+'&tp='+stp+'&nowpage=1');
					}
				}
			});
		});
	}
}

function upsecondcat() {
	//提交表单
	if($('#uscname').val() == ''){
		show_err_msg('请输入名称');	
		$('#uscname').focus();
	}else{
		var scname = $("#uscname").val();
		var scorder = $("#uscorder").val();
		var scid = request('cid');
		var stp = request('tp');
		var mcid = request('mcid');
			if(scorder=='')
				scorder=0;
		$("#uscbtn").ready(function(){
			$.ajax({
				type: "POST",
				url: path+"mcupfirstcategoryok.action",
				dataType: "json",
				data:{
					"mcname":scname,
					"mcorder":scorder,
					"mcid":mcid
				},
				success:function(data){
					if(data.notice!="修改成功")
						show_msg('修改失败！请查看数据',path+'mcupSecondCategory.action?mcid='+mcid+'&cid='+scid+'&tp='+stp);
					else
					{
						show_msg('修改成功！',path+'mcgetSecondModulCategory.action?mcid='+mcid+'&cid='+scid+'&tp='+stp+'&nowpage=1');
					}
				}
			});
		});
	}
}

function delsecondcat(id) {
	//提交表单
	var fcid = request("cid");
	var ftp = request("tp");
	$("#dscbtn").ready(function(){
		$.ajax({
			type: "POST",
			url: path+"mcdelfirstcategoryok.action",
			dataType: "json",
			data:{
				"mcid":id
			},
			success:function(data){
				if(data.notice!="删除成功")
					show_msg('删除失败！请查看数据',path+'mcgetSecondModulCategory.action?cid='+fcid+'&tp='+ftp+"&nowpage=1");
				else
				{
					show_msg('删除成功！',path+'mcgetSecondModulCategory.action?cid='+fcid+'&tp='+ftp+"&nowpage=1");
				}
			}
		});
	});
}
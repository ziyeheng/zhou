function indexcompany(){
	var tcom=$("#tcompany").val();
	if(tcom!="-1"){
		$.ajax({
			type: "POST",
			url: path+"indexgetCompanyList.action",
			dataType: "json",
			async:false,
			cache:false,
			data:{"code":tcom},
			success:function(data,status){
				var coms = data.company;
				$("#tcompany").html("<option value='-1'>快递公司</option>");
				for(var i=0;i<coms.length;i++){
					$("#tcompany").append("<option value='"+coms[i].Id+"'>"+coms[i].name+"</option>");
				}
			}
		});
	}
}

function indexfadd(){
	var fadd=$("#fadd").val();
	if(fadd!="-1"){
		$.ajax({
			type: "POST",
			url: path+"indexgetFaddList.action",
			dataType: "json",
			async:false,
			cache:false,
			data:{"fa":fadd},
			success:function(data,status){
				var fadds = data.faddlist;
				$("#fadd").html("<option value='-1'>快递点</option>");
				for(var i=0;i<fadds.length;i++){
					$("#fadd").append("<option value='"+fadds[i].Id+"'>"+fadds[i].name+"</option>");
				}
			}
		});
	}
}


function indexshen(){
	var tpro=$("#tprovince").val();
	if(tpro!="-1"){
		$.ajax({
			type: "POST",
			url: path+"indexgetShenList.action",
			dataType: "json",
			async:false,
			cache:false,
			data:{"pro":tpro},
			success:function(data,status){
				var shens = data.shenlist;
				$("#tprovince").html("<option value='-1'>省份</option>");
				for(var i=0;i<shens.length;i++){
					$("#tprovince").append("<option value='"+shens[i].Id+"'>"+shens[i].name+"</option>");
				}
			}
		});
	}
}
function indexCity(){
	var tcity=$("#tcity").val();
	var tpro=$("#tprovince").val();
	if(tcity!=''){
		$.ajax({
			type: "POST",
			url: path + "indexgetCityList.action",
			dataType: "json",
			async:false,
			cache:false,
			data:{"pro":tpro},
			success: function(data, status){
				var citys=data.citylist;
				$("#tcity").html("<option value='0'>城市</option>");
				for(var i=0;i<citys.length;i++){
					$("#tcity").append("<option value='"+citys[i].Id+"'>"+citys[i].name+"</option>");
				}
			}
		});
	}
}

function indexqu(){
	var tarea=$("#tarea").val();
	var tcity=$("#tcity").val();
	if(tarea!=''){
		$.ajax({
			type: "POST",
			url: path + "indexgetquList.action",
			dataType: "json",
			async:false,
			cache:false,
			data:{"city":tcity},
			success: function(data, status){
				var qus=data.qulist;
				$("#tarea").html("<option value='0'>区域</option>");
				for(var i=0;i<qus.length;i++){
					$("#tarea").append("<option value='"+qus[i].Id+"'>"+qus[i].name+"</option>");
				}
			}
		});
	}
}

function indexfshen(){
	var fpro=$("#fprovince").val();
	if(fpro!="25"){
		$.ajax({
			type: "POST",
			url: path+"indexgetfShenList.action",
			dataType: "json",
			async:false,
			cache:false,
			data:{"fpro":fpro},
			success:function(data,status){
				var fshens = data.fshenlist;
				$("#fprovince").html("<option value='25'>云南省</option>");
				for(var i=0;i<fshens.length;i++){
					$("#fprovince").append("<option value='"+fshens[i].Id+"'>"+fshens[i].name+"</option>");
				}
			}
		});
	}
}
function indexfCity(){
	var fcity=$("#fcity").val();
	var fpro=$("#fprovince").val();
	if(fcity!=''){
		$.ajax({
			type: "POST",
			url: path + "indexgetfCityList.action",
			dataType: "json",
			async:false,
			cache:false,
			data:{"fpro":fpro},
			success: function(data, status){
				var fcitys=data.fcitylist;
				$("#fcity").html("<option value='299'>昆明市</option>");
				for(var i=0;i<fcitys.length;i++){
					$("#fcity").append("<option value='"+fcitys[i].Id+"'>"+fcitys[i].name+"</option>");
				}
			}
		});
	}
}

function indexfqu(){
	var farea=$("#farea").val();
	var fcity=$("#fcity").val();
	if(farea!=''){
		$.ajax({
			type: "POST",
			url: path + "indexgetfquList.action",
			dataType: "json",
			async:false,
			cache:false,
			data:{"fcity":fcity},
			success: function(data, status){
				var fqus=data.fqulist;
				$("#farea").html("<option value='0'>区域</option>");
				for(var i=0;i<fqus.length;i++){
					$("#farea").append("<option value='"+fqus[i].Id+"'>"+fqus[i].name+"</option>");
				}
			}
		});
	}
}

function postinfo(){
	var flag = postcheck();
	if(flag){
		var fromname=$("#fromname").val();
		var frommob=$("#frommob").val();
		var fromcom=$("#fromcom").val();
		var fprovince=$("#fprovince").val();
		var fcity=$("#fcity").val();
		var farea=$("#farea").val();
		var fromquyu=$("#fromquyu").val();
		var toname=$("#toname").val();
		var tomob=$("#tomob").val();
		var tprovince=$("#tprovince").val();
		var tcity=$("#tcity").val();
		var tarea=$("#tarea").val();
		var toquyu=$("#toquyu").val();
		var tocom=$("#tocom").val();
		var tcompany=$("#tcompany").val();
		var wupin=$("#wupin").val();
		var fadd=$("#fadd").val();
		$("#submit_ok").ready(function(){
			$.ajax({
				type: "POST",
				url: path + "indexgetaddUser.action",
				dataType: "json",
				data:{
					"fname":fromname,
					"fmobel":frommob,
					"fcompanyName":fromcom,
					"fprovince":fprovince,
					"fromcity":fcity,
					"farea":farea,
					"fquyu":fromquyu,
					"tname":toname,
					"tmobel":tomob,
					"tprovince":tprovince,
					"tocity":tcity,
					"toarea":tarea,
					"tquyu":toquyu,
					"tcompanyName":tocom,
					"tocompany":tcompany,
					"wupin":wupin,
					"fadd":fadd
				},
				success:function(data){
					alert(data.notice);
				}
			});
		});
	}
	else
		return false;
}
$(document).ready(function(){
	$("#fromname").focus(function(){
		if($(this).val()=="寄件人姓名" )
		{
			$(this).val('');
		}
	});
	$("#fromname").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("寄件人姓名");
		}
	});

	$("#frommob").focus(function(){
		if($(this).val()=="寄件人手机号" )
		{
			$(this).val('');
		}
	});
	$("#frommob").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("寄件人手机号");
		}
	});

	$("#fromcom").focus(function(){
		if($(this).val()=="寄件人单位" )
		{
			$(this).val('');
		}
	});
	$("#fromcom").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("寄件人单位");
		}
	});

	$("#fromquyu").focus(function(){
		if($(this).val()=="寄件人乡镇街道" )
		{
			$(this).val('');
		}
	});
	$("#fromquyu").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("寄件人乡镇街道");
		}
	});


	$("#toname").focus(function(){
		if($(this).val()=="收件人姓名" )
		{
			$(this).val('');
		}
	});
	$("#toname").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("收件人姓名");
		}
	});

	$("#tomob").focus(function(){
		if($(this).val()=="收件人手机号" )
		{
			$(this).val('');
		}
	});
	$("#tomob").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("收件人手机号");
		}
	});

	$("#tocom").focus(function(){
		if($(this).val()=="收件人单位" )
		{
			$(this).val('');
		}
	});
	$("#tocom").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("收件人单位");
		}
	});

	$("#toquyu").focus(function(){
		if($(this).val()=="收件人乡镇街道" )
		{
			$(this).val('');
		}
	});
	$("#toquyu").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("收件人乡镇街道");
		}
	});


	$("#wupin").focus(function(){
		if($(this).val()=="物品描述" )
		{
			$(this).val('');
		}
	});
	$("#wupin").blur(function(){
		var str = $(this).val();
		if(str == "" )
		{
			$(this).val("物品描述");
		}
	});

});	

function postcheck(){
	var fa=document.getElementById("fadd").value;
	if(fa=="-1"||fa=="快递点")
	{
		alert('请选择快递点');
		document.getElementById("fadd").focus();
		return false;
	}
	else
	{
		var fn=document.getElementById("fromname").value;
		if(fn=="寄件人姓名"||fn=="")
		{
			alert('请输入寄件人姓名');
			document.getElementById("fromname").focus();
			return false;
		}
		else
		{
			var fm=document.getElementById("frommob").value;
			if(fm=="寄件人手机号"||fm=="")
			{
				alert('请输入寄件人手机号');
				document.getElementById("frommob").focus();
				return false;
			}
			else
			{

				var fmob = /^1[3,4,5,8]\d{9}$/;
				if (!fmob.test(document.getElementById("frommob").value)){
					alert('寄件人手机号不正确');
					document.getElementById("frommob").focus();
					return false;
				}
				else
				{

					var wp=document.getElementById("wupin").value;
					if(wp=="物品"||wp=="")
					{
						alert("请输入物品");
						document.getElementById("wupin").focus();
						return false;
					}
					else
					{

						var tn = document.getElementById("toname").value;
						if(tn=="收件人姓名"||tn=="")
						{
							alert('请输入收件人姓名');
							document.getElementById("toname").focus();
							return false;
						}
						else
						{

							var tp=document.getElementById("tprovince").value;
							if(tp=="-1")
							{
								alert('请选择收件人所在省份');
								document.getElementById("tprovince").focus();
								return false;
							}
							else
							{

								if (document.meform.tomob.value=="收件人手机号"||document.meform.tomob.value==""){
									alert('请输入收件人手机号');
									document.meform.tomob.focus();
									return false;
								}
								else
								{
									var fmob = /^1[3,4,5,8]\d{9}$/;
									if (!fmob.test(document.meform.tomob.value)){
										alert('收件人手机号不正确');
										document.meform.tomob.focus();
										return false;
									}
									else
									{

										if (document.meform.toquyu.value=="收件人乡镇街道"||document.meform.toquyu.value==""){
											alert('请输入收件人乡镇街道');
											document.meform.toquyu.focus();
											return false;
										}
										else
										{

											if (document.meform.tcompany.value=="-1"||document.meform.tcompany.value=="快递公司"){
												alert('请选择快递公司');
												document.meform.tcompany.focus();
												return false;
											}
											else
											{
												return true;
											}
										}
									}
								}

							}
						}
					}

				}

			}
		}
	}
}
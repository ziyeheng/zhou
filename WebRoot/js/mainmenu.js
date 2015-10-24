function yjmd(id) {
	$("#yjmdbtn").ready(function(){
		$.ajax({
			type: "POST",
			url: path+"cdelCategoryok.action",
			dataType: "json",
			data:{
				"cid":id
			},
			success:function(data){
				if(data.notice!="删除成功")
					show_msg('删除失败！',path+'cgetCategory.action?nowpage=1');
				else
				{
					show_msg('删除成功！',path+'cgetCategory.action?nowpage=1');
				}
			}
		});
	});
}
	/**
	 * 根据类型名称找到全部的类型项目名称
	 * @param myid 准备填充下拉框的id，例如(#lyid)
	 * @param DicName 字典类型名称，例如(学院)
	 * @returns
	 */
	function getDicItemByDicName(myid,DicName){
		$.ajax({     
			url:"getDicItemByDicName.action?DicName="+DicName,
			type:"post",
			success:function(result){
				if(result!=null){
					$(myid+" option[value!=0]").remove();
					var datalist = result.extend.DicItemList;
					$.each(datalist,function(index,item){
						var code = codeHtmlDic(index,item); 
                        $(myid).append(code);  //动态加载查询结果 
					});
				}
			}
		});
	}
	
	function codeHtmlDic(index,item){
		var html = '<option value='+item.itemValue+'>'+item.itemName+'</option>';
		return html;
	}
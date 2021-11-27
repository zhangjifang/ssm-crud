
	/**
	 * 添加或修改
	 * @param myurl xxx.action
	 * @returns
	 */
	function AddOrUpdate(myurl){
		var jsonStr = $("#myForm").HY_SerializeJsonStr();
		$.ajax({
			url:myurl,
			type:"post",
			contentType:"application/json;charset=utf-8",
			dataType:"json",
			data:jsonStr,
			success:function(result){
				alert(result.msg)
				//刷新当前页面
				window.location.reload();
			}
		});
	}
	
	
	/**
	 * 删除行记录
	 * @param myurl xxx.action?id=
	 * @param id 
	 * @returns
	 */
    function Del(myurl,id){
    	if(confirm("确认删除该行记录吗？")){    
   			$.ajax({
    			url: myurl+id,
    			type: "Post",
    			success: function(result){
    				getNewsInfo();
    				alert(result.msg);
    			}
    		});
  		}else{
   			return;
  		}
    }
    
    /**
     * 后台查询页面
     * @param myurl
     * @param mysize
     * @param myid
     * @param showid
     * @returns
     */
	function getInfo(myurl,mysize,myid){
		//查询的条件从表单中获取  
		var jsonStr = $("#myForm").HY_SerializeJsonStr();
		  
		$.ajax({
			url:myurl+"?size="+mysize, 
			type:"post",
			contentType:"application/json;charset=utf-8",
			dataType:"json", 
			data:jsonStr,
			success:function(result){
				if(result!=null){ 
					$(myid).empty();  //清空节点内容不删除节点
					//$.each(遍历的集合,function(索引,单个集合))
					var datalist = result.extend.pageInfo.list;
					$.each(datalist,function(index,item){
						var code = codeHtml(index,item); 
                        $(myid).append(code);  //动态加载查询结果 
					});
					
					//总页数
                    var pageCount = result.extend.pageInfo.pages;
                    //当前页数
					var currentPage = result.extend.pageInfo.pageNum;
                    var options = {
                        bootstrapMajorVersion: 3, //版本
                        currentPage: currentPage, //当前页数
                        totalPages: pageCount,    //总页数
                        itemTexts: function (type, page, current) {
                            switch (type) {
                                case "first":
                                    return "首页";
                                case "prev":
                                    return "上一页";
                                case "next":
                                    return "下一页";
                                case "last":
                                    return "末页";
                                case "page":
                                    return page;
                            }
                        },//点击事件，用于通过Ajax来刷新整个list列表
                        onPageClicked: function (event, originalEvent, type, page) {
                        	$.ajax({
                                url:myurl+"?size="+mysize+"&pn=" + page,  
                                type:"post",
                    			contentType:"application/json;charset=utf-8",
                    			dataType:"json", 
                    			data:jsonStr,
                                success: function (result1) {
                                    if (result1 != null) {
                                    	$(myid).empty();  //清空节点内容不删除节点
                    					//$.each(遍历的集合,function(索引,单个集合))
                    					var datalist1 = result1.extend.pageInfo.list;
                    					$.each(datalist1,function(index,item){
                    						var code = codeHtml(index,item); 
                                            $(myid).append(code);  //动态加载查询结果 
                    					});
                                    }
                                }
                            });
                        }
                    };
                    if (pageCount != 0) {
                        $("#example").empty();
                        $("#cost").empty();
                        $("#head").show();
                        $("#example").bootstrapPaginator(options);
                    }
                    else {
                        $("#example").empty();
                        $("#cost").empty();
                        $("#head").hide();
                        $("#cost").html("没有符合条件的记录！");
                    }
				}	
			}
		});
	}
	
	//新闻
	function getNewsInfoTopX(myurl,mysize,myid){
		$.ajax({
			url:myurl+"?size="+mysize,
			type:"post",
			success:function(result){
				$(myid).empty();
				var datalist = result.extend.pageInfo.list;
				$.each(datalist,function(index,item){
					var code = codeNewsHtml(item);
                    $(myid).append(code);  //动态加载查询结果
				});
			}
		});
	}
	
	//通告
	function getTGInfoTopX(myurl,mysize,myid){
		$.ajax({
			url:myurl+"?size="+mysize,
			type:"post",
			success:function(result){
				$(myid).empty();
				var datalist = result.extend.pageInfo.list;
				$.each(datalist,function(index,item){
					var code = codeTGNewsHtml(item);
                    $(myid).append(code);  //动态加载查询结果
				});
			}
		});
	}
	
	//党建
	function getDJInfoTopX(myurl,mysize,myid){
		$.ajax({
			url:myurl+"?size="+mysize,
			type:"post",
			success:function(result){
				$(myid).empty();
				var datalist = result.extend.pageInfo.list;
				$.each(datalist,function(index,item){
					var code = codeDJNewsHtml(item);
                    $(myid).append(code);  //动态加载查询结果
				});
			}
		});
	}
	
	/**
	 * 展示更多信息
	 * @param myurl
	 * @param mysize
	 * @param myid
	 * @param showid
	 * @returns
	 */
	function getInfoMoreX(myurl,mysize,myid){
		$.ajax({
			url:myurl+"?size="+mysize,
			type:"post",
			success:function(result){
				$(myid).empty();
				var datalist = result.extend.pageInfo.list;
				$.each(datalist,function(index,item){
					var code = codeHtml(item);
                    $(myid).append(code);  //动态加载查询结果
				});
				
				//总页数
                var pageCount = result.extend.pageInfo.pages;
                //当前页数
				var currentPage = result.extend.pageInfo.pageNum;
                var options = {
                    bootstrapMajorVersion: 3, //版本
                    currentPage: currentPage, //当前页数
                    totalPages: pageCount,    //总页数
                    itemTexts: function (type, page, current) {
                        switch (type) {
                            case "first":
                                return "首页";
                            case "prev":
                                return "上一页";
                            case "next":
                                return "下一页";
                            case "last":
                                return "末页";
                            case "page":
                                return page;
                        }
                    },//点击事件，用于通过Ajax来刷新整个list列表
                    onPageClicked: function (event, originalEvent, type, page) {
                        $.ajax({
                            url:  myurl+"?size="+ mysize +"&pn=" + page,  
                            type: "post",
                            success: function (result1) {
                                if (result1 != null) {
                                	$(myid).empty();  //清空节点内容不删除节点
                					//$.each(遍历的集合,function(索引,单个集合))
                					var datalist1 = result1.extend.pageInfo.list;
                					$.each(datalist1,function(index,item){
                						var code = codeHtml(item); 
                	                    $(myid).append(code);  //动态加载查询结果
                					});
                                }
                            }
                        });
                    }
                };
                $("#example").bootstrapPaginator(options);
			}
		});
	}
	
	
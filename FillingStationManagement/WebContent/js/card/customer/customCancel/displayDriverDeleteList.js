$(function() {
	$('#dg').datagrid({
		iconCls : 'icon-ok',
		width:'auto',
		height:'auto',
		nowrap : false,
		striped : true,
		fit : true,// 自动大小
		collapsible : true,
		singleSelect : true,
		loadMsg : '数据装载中......',
		sortName : 'code',
		sortOrder : 'desc',
		remoteSort : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : driverColumns,
		pagination : true,
		rownumbers : true,
		AllowPaging : true
	});

	// 设置分页控件
	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		onSelectPage : function(pageNumber, pageSize) {
			searchData(pageNumber, pageSize);
		}
	});

	$(p).pagination({
		pageSize : 20,// 每页显示的记录条数，默认为10
		pageList : [ 20 ],// 可以设置每页记录条数的列表
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页    共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
});

$(document).ready(function() {
			$("#readCard").click(function(){
				alert("读卡");
			});
			$("#search").click(function(){
				//alert("查询");
				var cardNo = $("#cardNo").val();
				var guestNo = $("#guestNo").val();
				var guestName = $("#guestName").val();
				if (cardNo == "" && guestNo =="" && guestName=="") {
					$.messager.alert('错误', '查询条件不能全空!');
					return;
				}
						searchData();
				});
			$("#haveCardDelete").click(function(){
				
					var customerDeleteBean = $('#dg').datagrid('getSelected');
					 if (!customerDeleteBean){
						  $.messager.alert('错误','请选择记录!');
						  return;
					  }
					if(confirm('确定是有卡注销?')){
					if(customerDeleteBean.guestNo ==''||customerDeleteBean.cardNo == ''){
						$.messager.alert('错误','卡号和客户编号不能为空!');
						  return;
					}
					//卡片类型是否为多用户
					if(customerDeleteBean.cardType != '12'){
						$.messager.alert('错误','卡片类型必须为多用户!');
						  return;
					}
					//卡状态是否为启用
					if(customerDeleteBean.cardStatus != '1'){
						$.messager.alert('错误','卡状态必须为启用!');
						  return;
					}
					//是否是主卡
					if(customerDeleteBean.mainCardFlag != false){
						$.messager.alert('错误','不能是主卡!');
						  return;
					}
					deleteDriverCard(customerDeleteBean);
				}else{
					alert("结束");
				}
				
			});
			$("#noHaveCardDelete").click(function(){
				
					var customerDeleteBean = $('#dg').datagrid('getSelected');
					 if (!customerDeleteBean){
						  $.messager.alert('错误','请选择记录!');
						  return;
					  }
					 if(confirm('确定无卡注销')){
					 if(confirm('无卡注销必须要先挂失,确定已经挂失经过48小时?')){
						 //卡号和客户编号不能为空
						 if(customerDeleteBean.guestNo ==''||customerDeleteBean.cardNo == ''){
								$.messager.alert('错误','卡号和客户编号不能为空!');
								  return;
							}
							//卡片类型是否为多用户
							if(customerDeleteBean.cardType != '12'){
								$.messager.alert('错误','卡片类型必须为多用户!');
								  return;
							}
							//卡状态是否为挂失
							if(customerDeleteBean.cardStatus != '2'){
								$.messager.alert('错误','卡状态必须为挂失!');
								  return;
							}
							//是否是主卡
							if(customerDeleteBean.mainCardFlag != false){
								$.messager.alert('错误','不能是主卡!');
								  return;
							}
							deleteDriverCardNoCard(customerDeleteBean);
					 }else{
						 if(confirm('是否进行挂失?')){
							//卡状态是否为启用,防止多次挂失
							if(customerDeleteBean.cardStatus != '1'){
								$.messager.alert('错误','卡状态必须为启用!');
									 return;
							}
							 cardLost(customerDeleteBean.cardNo);
						 }else{
							 alert("结束");
						 }
					 }
					 }else{
						 alert("结束");
					 }
				
			});
		
		
	});
//查询
function searchData(pageNumber, pageSize) {
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/customerDelete/showDriverInfo',
		data : {
			"customerDeleteBean.cardNo" : $("#cardNo").val(),
			"customerDeleteBean.guestNo" : $("#guestNo").val(),
			"customerDeleteBean.guestName" : $("#guestName").val(),
			"customerDeleteBean.pageNumber" : pageNumber,
			"customerDeleteBean.pageSize" : pageSize
		},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if (gridData == null) {
				$('#dg').datagrid('loadData', {
					total : 0,
					rows : []
				});
			}
			var data = $.parseJSON(gridData);
			$('#dg').datagrid('loadData', data);
		},
		error : function() {
			$.messager.alert('错误', '查询失败!');
		}
	});
}
//司机卡有卡注销
function deleteDriverCard(customerDeleteBean){
	$.ajax({
		type : 'post',
		url : server_context+'/customerDelete/deleteDriverCard',
		data : {
			"customerDeleteBean.cardNo" : customerDeleteBean.cardNo,
			"customerDeleteBean.guestNo" : customerDeleteBean.guestNo
		},
		cache : false,
		dataType : 'json',
		success : function(){
			$.messager.alert('成功', '司机卡有卡注销成功,卡账户转至单位账户!');
			$('#printCardIFrame')[0].src= server_context + '/view/card/customer/customCancel/printDriverDelete.jsp'
			+'?cardNo='+customerDeleteBean.cardNo
			+'&deposit='+parseFloat(customerDeleteBean.deposit)
			+'&guestNo='+customerDeleteBean.guestNo
			+'&guestName='+encodeURI(encodeURI(customerDeleteBean.guestName))
			+'&cardScore='+parseFloat(customerDeleteBean.cardScore)
			+'&cardAccount='+parseFloat(customerDeleteBean.cardAccount)
			+'&preAccount='+parseFloat(customerDeleteBean.preAccount)
			+'&refundAmount='+parseFloat(customerDeleteBean.deposit);
			$('#printCardDialog').dialog({
				closed : false,
                title : '司机卡注销打印',
                shadow : true,
                modal : true,
                collapsible : true,
                buttons : [{
                	text : '返回',
                    id : 'returnBtn',
                    handler:function(){
                    	//alert("返回");
                    	$("#printCardDialog").dialog("close");
                    	searchData();
                    }
                }]
		});
			
		},
		error : function(){
			$.messager.alert('错误', '司机卡有卡注销失败!');
		}
	});
}
//司机卡无卡注销
function deleteDriverCardNoCard(customerDeleteBean){
	$.ajax({
		type : 'post',
		url : server_context+'/customerDelete/deleteDriverCardNoCard',
		data : {
			"customerDeleteBean.cardNo" : customerDeleteBean.cardNo,
			"customerDeleteBean.guestNo" : customerDeleteBean.guestNo
		},
		cache : false,
		dataType : 'json',
		success : function(){
			$.messager.alert('成功', '司机卡无卡注销成功,卡账户转至单位账户!');
			$('#printCardIFrame')[0].src= server_context + '/view/card/customer/customCancel/printDriverDelete.jsp'
			+'?cardNo='+customerDeleteBean.cardNo
			+'&deposit='+parseFloat(customerDeleteBean.deposit)
			+'&guestNo='+customerDeleteBean.guestNo
			+'&guestName='+encodeURI(encodeURI(customerDeleteBean.guestName))
			+'&cardScore='+parseFloat(customerDeleteBean.cardScore)
			+'&cardAccount='+parseFloat(customerDeleteBean.cardAccount)
			+'&preAccount='+parseFloat(customerDeleteBean.preAccount)
			+'&refundAmount='+parseFloat('0');
			$('#printCardDialog').dialog({
				closed : false,
                title : '司机卡注销打印',
                shadow : true,
                modal : true,
                collapsible : true,
                buttons : [{
                	text : '返回',
                    id : 'returnBtn',
                    handler:function(){
                    	//alert("返回");
                    	$("#printCardDialog").dialog("close");
                    	searchData();
                    }
                }]
		});
		},
		error : function(){
			$.messager.alert('错误', '你挂失未满48小时,注销失败!');
		}
	});
}
//卡挂失
function cardLost(cardNo){
	$.ajax({
		url:encodeURI(server_context+'/cardMaintain/cardLost'),type:'POST',timeout:3000,dataType:'html',
		data : {
			"cardMaintainBean.cardNo" : cardNo
			},
		cache : false,
		success : function() {
			$.messager.alert('成功', '卡挂失成功!');
			searchData();
		},
		error : function() {
			$.messager.alert('失败', '卡挂失失败!');
		}
	});
}
//dataGrid显示一览
var driverColumns = [ [
		{field : 'guestNo',title : '客户编号',width : 100,align : 'left'},
		{field : 'guestName',title : '客户名称',width : 100,align : 'left'},
		{field : 'cardNo',title : '卡号',width : 180,align : 'left'}, 
		{field : 'cardType',title : '卡类型',width : 80,formatter: function(value,row,index){
			var key = "option[value='" + value + "']";
			var text = $("#cardType").find(key).text();
			return text;
		},align : 'left'}, 
		{field : 'cardStatus',title : '卡状态',width : 80,formatter: function(value,row,index){
			var key = "option[value='" + value + "']";
			var text = $("#cardStatus").find(key).text();
			return text;
		},align : 'left'}, 
		{field : 'deposit',title : '卡押金',width : 80,align : 'left'}, 
		{field : 'mainCardFlag',title : '是否主卡',width : 80,formatter: function(value,row,index){
			return value == true?'是':'否';
		},align : 'left'},
		{field : 'cardAccount',title : '卡内余额',width : 100,align : 'left'}, 
		{field : 'preAccount',title : '备用金余额',width : 100,align : 'left'}, 
		{field : 'cardScore',title : '卡积分',width : 100,align : 'left'}
	] ];
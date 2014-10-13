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
		columns : allCardColumns,
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
				if (cardNo =="" && guestNo == "" && guestName == "") {
					$.messager.alert('错误', '查询条件不能全为空!');
					return;
				}
						searchData();
				});
			$("#allCardDelete").click(function(){
				//alert("单位注销");
				var cardNo = $("#cardNo").val();
				var guestNo = $("#guestNo").val();
				var guestName = $("#guestName").val();
				if (cardNo =="" && guestNo == "" && guestName == "") {
					$.messager.alert('错误', '条件不能全为空!');
					return;
				}
				 searchAllCard(cardNo,guestNo,guestName);
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
//searchAllCard
function searchAllCard(cardNo,guestNo,guestName) {
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/customerDelete/showAllCardInfo',
		data : {
			"customerDeleteBean.cardNo" : cardNo,
			"customerDeleteBean.guestNo" : guestNo,
			"customerDeleteBean.guestName" :guestName
		},
		cache : false,
		dataType : 'html',
		success : function() {
			$('#printCardIFrame')[0].src= server_context + '/view/card/customer/customCancel/displayAllCardList.jsp';
			$('#printCardDialog').dialog({
				closed : false,
                title : '卡片信息',
                shadow : true,
                modal : true,
                collapsible : true,
                buttons : [{
                	text : '返回',
                    id : 'returnBtn',
                    handler:function(){
                    	//alert("返回");
                    	$("#printCardDialog").dialog("close");
                    }
                }]
		});
		},
		error : function() {
			$.messager.alert('错误', '查询失败!');
		}
	});
}
//dataGrid显示一览
var allCardColumns = [ [
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
		{field : 'mainCardFlag',title : '是否主卡',width : 100,formatter: function(value,row,index){
			return value == true?'是':'否';
		},align : 'left'},
		{field : 'cardAccount',title : '卡内余额',width : 100,align : 'left'}, 
		{field : 'preAccount',title : '备用金余额',width : 100,align : 'left'}, 
		{field : 'cardScore',title : '卡积分',width : 100,align : 'left'}
	] ];
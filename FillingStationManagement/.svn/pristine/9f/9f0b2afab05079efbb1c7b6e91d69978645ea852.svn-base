 //include in saleMultiUserCard.jsp
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
		columns : drivercolumns,
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

$(document).ready(function(){
	$("#searchDriver").click(function(){
				//alert("查询司机");
				var cardNo = $("#cardNo").val();
				var guestNo = $("#guestNo").val();
				var guestName = $("#guestName").val();
				if (cardNo =='' && guestNo =='' && guestName ==''){
					$.messager.alert('错误', '查询条件不能全为空');
					return;
				}
				// 3.$.ajax拼接url的异步请求
				searchData();
			});
	$("#readCard").click(function(){
		alert("读卡");
	});
});

function searchData(pageNumber, pageSize) {
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/registMultiCustomer/showDriverList',
		data : {
			"registerCustomerBean.cardNo" : $("#cardNo").val(),
			"registerCustomerBean.guestNo" : $("#guestNo").val(),
			"registerCustomerBean.guestName" : $("#guestName").val(),
			"registerCustomerBean.pageNumber" : pageNumber,
			"registerCustomerBean.pageSize" : pageSize
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
				alert("查询记录为空");
			}
			var data = $.parseJSON(gridData);
			$('#dg').datagrid('loadData', data);
		},
		error : function() {
			alert("数据传输失败");
		}
	});
}

//检索一览列
//结合具体的RegisterCustomerBean.java看，
var drivercolumns = [ [
		{field : 'guestNo',title : '客户编号',width : 80,align : 'left'},
		{field : 'guestName',title : '持卡人姓名',width : 80,align : 'left'},
		{field : 'guestStatus',title : '客户状态',width : 80,formatter: function(value,row,index){
			var key = "option[value='" + value + "']";
			var text = $("#guestStatus").find(key).text();
			return text;
		},align : 'left'},
		{field : 'guestNum',title : '证件号',width : 160,align : 'left'},
		{field : 'cardNo',title : '卡号',width : 180,align : 'left'},
		{field : 'cardType',title : '卡类型',width : 100,formatter: function(value,row,index){
			var key = "option[value='" + value + "']";
			var text = $("#cardType").find(key).text();
			return text;
		},align : 'left'},
		{field : 'cardStatus',title : '卡状态',width : 60,formatter: function(value,row,index){
			var key = "option[value='" + value + "']";
			var text = $("#cardStatus").find(key).text();
			return text;
		},align : 'left'},
		{field : 'mainCardFlag',title:'是否主卡',width:60,formatter: function(value,row,index){
			return value == true?'是':'否';
		},align:'left'},
		{field : 'depName',title : '所属部门',width : 100,align : 'left'},
		{field : 'action',title : '操作',width : 100,align : 'left',formatter:function(value,row,index){
        	var s = '<a href="javascript:void(0)" onclick="changeDep('+index+');">更改部门</a> ';
            return s;
        }
		}
	] ];
function changeDep(index){
	//alert(index);
	var row = $('#dg').datagrid('getRows');
	if(row[index].mainCardFlag != false){
		$.messager.alert('错误', '主卡不能更改部门!');
		return;
	}
	var cardNo = row[index].cardNo;
	var guestNo = row[index].guestNo;
	var cardStatus = row[index].cardStatus;
	if(cardNo == ''){
		$.messager.alert('错误', '卡号不能为空!');
		return;
	}
	if(guestNo == ''){
		$.messager.alert('错误', '客户编号不能为空!');
		return;
	}
	if(cardStatus != '1'){
		$.messager.alert('错误', '卡状态必须为启用!');
		return;
	}
	$('#changeDepIFrame')[0].src= server_context + '/registMultiCustomer/departmentChangeInit?registerCustomerBean.cardNo='+cardNo
	+'&registerCustomerBean.guestNo='+guestNo;
	$('#changeDepDialog').dialog({
		closed : false,
        title : '部门更改',
        shadow : true,
        modal : true,
        collapsible : true,
        buttons : [ {
            text : '保存',
            id : 'saveBtn',
            handler : function() {
                //alert("保存更改部门");
                var dDocument = document.getElementById("changeDepIFrame").contentWindow.document;
                var cardNo = dDocument.getElementById("cardNo").value;
                if(cardNo == ''){
                	alert("卡号不能为空");
                	return;
                }
                var DepChange_form = dDocument.getElementsByTagName('form');
                alert($(DepChange_form).serialize());
                $.ajax({
        			data:$(DepChange_form).serialize(),
        			url:encodeURI(server_context +"/registMultiCustomer/changeDriverDepNo"),type:'POST',timeout:3000,dataType:'html',
        			success:function(data){
        				$("#changeDepDialog").dialog("close");
        				searchData();
        			
        			},
        			error:function(){
        				$.messager.alert('错误','司机部门更改保存失败，请重试!');
        			}
    		});
            }
        },{
            text : '返回',
            id : 'returnBtn',
            handler : function() {
                $('#changeDepDialog').dialog('close');
            }
        } ]
	});
}
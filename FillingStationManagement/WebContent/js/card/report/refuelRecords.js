$.fn.extend({
 /**
  * 修改DataGrid对象的默认大小，以适应页面宽度。
  * 
  * @param heightMargin
  *            高度对页内边距的距离。
  * @param widthMargin
  *            宽度对页内边距的距离。
  * @param minHeight
  *            最小高度。
  * @param minWidth
  *            最小宽度。
  * 
  */
 resizeDataGrid : function(heightMargin, widthMargin, minHeight, minWidth) {
  var height = $(document.body).height() - heightMargin;
  var width = $(document.body).width() - widthMargin;
  height = height < minHeight ? minHeight : height;
  width = width < minWidth ? minWidth : width;
  $(this).datagrid('resize', {
   height : height,
   width : width
  });
 }
});

//$(function() {
// // datagrid数据表格ID
// var datagridId = 'dg';
// // 第一次加载时自动变化大小
// $('#' + datagridId).resizeDataGrid(0, 0, 0, 0);
// // 当窗口大小发生变化时，调整DataGrid的大小
// $(window).resize(function() {
//  $('#' + datagridId).resizeDataGrid(0, 0, 0, 0);
// });
//});

//$(window).resize(function(){
//$('#dg').datagrid('resize', {
//width:function(){return document.body.clientWidth;},
//height:function(){return document.body.clientHeight;},
//});
//});

//$('#dg').datagrid({ 
//width: ($(window).width()*0.99), 
//height:($(window).height()*0.98) 
//});

$(function(){
   $('#dg').datagrid({
	   iconCls:'icon-ok',
	    nowrap:false,
	    striped: true,
//	    height: 500,
	    fit: true,//自动大小 
	    collapsible:true,
	    singleSelect:true,
	    loadMsg:'数据装载中......',
	    sortName:'code',
	    sortOrder:'desc',
	    remoteSort:false,
	    frozenColumns:[[
	     {field:'ck',checkbox:true}
	    ]],
	    columns:oilLogColumns,
	    pagination:true,
	    rownumbers:true,
	    AllowPaging:true
	   });
	   
	//   设置分页控件  
		var p = $('#dg').datagrid('getPager');
		$(p).pagination({
			 onSelectPage:function(pageNumber,pageSize){  
			 	searchData(pageNumber, pageSize);
			 }  
		});
	   
	   $(p).pagination({  
	       pageSize: 20,//每页显示的记录条数，默认为10  
	       pageList: [20,30,40,60,80],//可以设置每页记录条数的列表  
	       beforePageText: '第',//页数文本框前显示的汉字  
	       afterPageText: '页    共 {pages} 页',  
	       displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
   });
	   
  });


$(document).ready(function(){
	  $("#operlog_search").click(function(){
			var operlogTradeType=$("#operlogTradeType").val();
			var operlogGasType=$("#operlogGasType").val();
			if (operlogTradeType == '' || operlogGasType == '') {
				$.messager.alert('错误','交易类型/油气类型-为必填项!');
			return;
		}
		// 3.$.ajax拼接url的异步请求
		var yz = $.ajax({
			type : 'post',
			url : 'refuelRecords/showOperatelog',
			data : {
				"operateLogBean.oilGunNum" : $("#operlogGunNum").val(),
				"operateLogBean.cardNum" : $("#operlogCardNum").val(),
				"operateLogBean.posTTC" : $("#operlogPosTTC").val(),
				"operateLogBean.stationNum" : $("#operlogStationNum").val(),
				"operateLogBean.tradeType" : $("#operlogTradeType").val(),
				"operateLogBean.gasType" : $("#operlogGasType").val(),
				"operateLogBean.payType" : $("#operlogPayType").val(),
				"operateLogBean.companyName" : $("#operlogCompanyName").val(),
				"operateLogBean.startDate" : $("#datepicker1").datetimebox('getValue'),
				"operateLogBean.endDate" : $("#datepicker2").datetimebox('getValue')
				},
			cache : false,
			dataType : 'json',
			success : function(loaddata) {
				gridData = loaddata.jsonData;
				if(gridData == null){
					$('#dg').datagrid('loadData',{total:0,rows:[]});
				}
				var data = $.parseJSON(gridData);
				$('#dg').datagrid('loadData', data);
			},
			error : function() {
			}
		});
		
	  });

	});


	var Common = {
	    //EasyUI用DataGrid用日期格式化
	    TimeFormatter: function (value, rec, index) {
	        if (value == undefined) {
	            return "";
	        }
	        /*json格式时间转js时间格式*/
	        value = value.substr(1, value.length - 2);
	        var obj = eval('(' + "{Date: new " + value + "}" + ')');
	        var dateValue = obj["Date"];
	        if (dateValue.getFullYear() < 1900) {
	            return "";
	        }
	        var val = dateValue.format("yyyy-mm-dd HH:MM");//控制格式
	        return val.substr(11, 5);
	    }

	};

	// 检索一览列
	var oilLogColumns = [[
		{field:'oilGunNum',title:'枪号',width:50, align:'center'},
        {field:'tradeTime',title:'交易时间',width:150, align:'left'},
		{field:'oilName',title:'品名',width:100, align:'left'},
		{field:'price',title:'单价',width:50,align:'left'},
		{field:'account',title:'数量',width:50,align:'left'},
		{field:'tradeAmount',title:'金额',width:50,align:'left'},
		{field:'carNum',title:'车号',width:100,align:'left'},
		{field:'gasType',title:'类型',width:80,align:'left'},
		{field:'totalAccount',title:'总量数量',width:80,align:'left'},
		{field:'cardNum',title:'卡号',width:80,align:'left'},
		{field:'cardTradeNum',title:'卡交易号',width:80,align:'left'},
		{field:'cardLeftMoney',title:'卡上余额',width:80,align:'left'},
		{field:'tradeLocation',title:'交易点',width:80,align:'left'},
		{field:'tradeNum',title:'交易号',width:80,align:'left'}
       ]];
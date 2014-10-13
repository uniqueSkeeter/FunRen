
$(function(){
   $('#dg').datagrid({
    iconCls:'icon-ok',
//    width:'auto',
//    height:'300',
    nowrap:false,
    striped: true,
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
    columns:shiftChangecolumns,
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
	  $("#shiftChange_search").click(function(){
		  	var shiftChageNum=$("#shiftChageNum").val();
			if (shiftChageNum == '') {
				$.messager.alert('错误','交接班序号-为必填项!');
			return;
		}
		// 3.$.ajax拼接url的异步请求
			searchData();
	  });

	});
	  
	function searchData(pageNumber, pageSize){
		var yz = $.ajax({
			type : 'post',
			url : 'shiftChange/showShiftChange',
			data : {
				"shiftChangeBean.shiftChageNum" : $("#shiftChageNum").val(),
				"shiftChangeBean.classNum" : $("#classNum").val(),
				"shiftChangeBean.shiftDate" : $("#datepicker1").datebox('getValue'),
				"shiftChangeBean.pageNumber" : pageNumber,
				"shiftChangeBean.pageSize" : pageSize
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
	}
//检索一览列
var shiftChangecolumns = [[
                {field:'oilGunNum',title:'枪号',width:40, align:'left'}, 
        		{field:'oilName',title:'品名',width:40, align:'left'},
        		{field:'oilPrice',title:'单价',width:40, align:'left'},
        		{field:'startOilAmount',title:'接班总量',width:60,align:'left'},
        		{field:'endOilAmount',title:'交班总量',width:60,align:'left'},
        		{field:'currentOilAccount',title:'当班总量',width:60,align:'left'},
        		{field:'cashAmount',title:'员工卡支付数量',width:100,align:'left'},
        		{field:'cashMoney',title:'员工卡支付金额',width:100,align:'left'},
        		{field:'icCard',title:'IC卡支付数量',width:100,align:'left'},
        		{field:'icConsum',title:'IC卡支付金额',width:100,align:'left'},
        		{field:'bankConsum',title:'银行卡支付数量',width:100,align:'left'},
        		{field:'bankMoney',title:'银行卡支付金额',width:100,align:'left'},
        		{field:'tinBack',title:'回灌数量',width:80,align:'left'},
        		{field:'tinBackMoney',title:'回灌金额',width:80,align:'left'}
            ]];
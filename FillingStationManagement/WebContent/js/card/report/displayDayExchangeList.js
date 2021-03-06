/**
 * this js works for displayDayExchangeList.jsp
 */
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;
$(function(){
   $('#dayExchangeListTable').datagrid({
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
    columns:dayExchangeListcolumns,
    pagination:true,
    rownumbers:true,
    AllowPaging:true
   });
// 设置分页控件  
	var dayExchangeTable = $('#dayExchangeListTable').datagrid('getPager');
	$(dayExchangeTable).pagination({
		 onSelectPage:function(pageNumber,pageSize){  
		 	searchData(pageNumber, pageSize);
		 }  
	});
  
  $(dayExchangeTable).pagination({  
      pageSize: 20,//每页显示的记录条数，默认为10  
      pageList: [20],//可以设置每页记录条数的列表  
      beforePageText: '第',//页数文本框前显示的汉字  
      afterPageText: '页    共 {pages} 页',  
      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
  }); 
 });
$(document).ready(function(){
	$('#dayExchangeList_search').click(function(){
		var startdate=$("#datepicker1").datebox('getValue');
		var enddate=$("#datepicker2").datebox('getValue');
		if(startdate=='' && enddate==''){
			$.messager.alert('错误','至少填一项!');
			return;
		}
		searchData();	
		
	});
});
function searchData(pageNumber, pageSize){
	var yz = $.ajax({
		type : 'post',
		url : server_context + '/dayExchange/showDayExchangeRecords',
		data : {
			"dayExchangeBean.startDate" : $("#datepicker1").datebox('getValue'),
			"dayExchangeBean.endDate" : $("#datepicker2").datebox('getValue'),
			"dayExchangeBean.pageNumber" : pageNumber,
			"dayExchangeBean.pageSize" : pageSize
			},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if(gridData == null){
				$('#dayExchangeListTable').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#dayExchangeListTable').datagrid('loadData', data);
		},
		error : function() {
		}
	});
}
var dayExchangeListcolumns = [[ 
            			{field:'workDate',title:'业务日期',width:120,align:'left'},
            			{field:'chargeAmount',title:'充值金额',width:100,align:'left'},
            			{field:'returnAmount',title:'退费金额',width:100,align:'left'},
            			{field:'handInAmount',title:'上缴金额',width:100,align:'left'},
            			{field:'returnForegiftAmount',title:'退押金',width:100,align:'left'},
            			{field:'receiveForegiftAmount',title:'收押金',width:100,align:'left'},
            			{field:'sendCardQuantity',title:'发卡数量',width:120,align:'left'},
            			{field:'recoverCardQuantity',title:'回收数量',width:120,align:'left'},
            			{field:'cardStorageQuantity',title:'库存数量',width:120,align:'left'},
            			{field:'userId',title:'操作员编号',width:80,align:'left'}
                       ]];
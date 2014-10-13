/**
 * this js works for displayCardList.jsp
 */

$(function(){
   $('#cardListTable').datagrid({
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
    columns:cardListcolumns,
    pagination:true,
    rownumbers:true,
    AllowPaging:true
   });
// 设置分页控件  
	var p = $('#cardListTable').datagrid('getPager');
	$(p).pagination({
		 onSelectPage:function(pageNumber,pageSize){
		 	searchData(pageNumber, pageSize);
		 }  
	});
  
  $(p).pagination({  
      pageSize: 20,//每页显示的记录条数，默认为10  
      pageList: [20],//可以设置每页记录条数的列表  
      beforePageText: '第',//页数文本框前显示的汉字  
      afterPageText: '页    共 {pages} 页',  
      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
  }); 
  /*$*/

 });
/*$(function(){
('#dg2').edatagrid({
	  columns:cardWithdrawcolumns,
	  //should be changed
	  url: 'displayCardList.jsp',
	  saveUrl: 'save_user.php',
	  updateUrl: 'update_user.php',
	  destroyUrl: 'destroy_user.php'
});
});*/
$(document).ready(function(){
	$('#cardList_search').click(function(){
		var cardtype=$("#cardType").val();
		var receipttype=$("#receiptType").val();
		var receiptstatus=$("#receiptStatus").val();
		var startdate=$("#datepicker1").datebox('getValue');
		var enddate=$("#datepicker2").datebox('getValue');
		if(cardtype=='' && receipttype=='' && receiptstatus=='' && startdate=='' && enddate==''){
			$.messager.alert('错误','至少填一项!');
			return;
		}
		searchData();	
		
	});
});
function searchData(pageNumber, pageSize){
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/cardStorage/showCardStorageRecords',
		data : {
			"cardStorageBean.cardType" : $("#cardType").val(),
			"cardStorageBean.receiptType" : $("#receiptType").val(),
			"cardStorageBean.receiptStatus" : $("#receiptStatus").val(),
			"cardStorageBean.startDate" : $("#datepicker1").datebox('getValue'),
			"cardStorageBean.endDate" : $("#datepicker2").datebox('getValue'),
			"cardStorageBean.pageNumber" : pageNumber,
			"cardStorageBean.pageSize" : pageSize
			},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if(gridData == null){
				$('#cardListTable').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#cardListTable').datagrid('loadData', data);
		},
		error : function() {
		}
	});
};
function updateTable(){
	var pageSize=$('#cardListTable').datagrid('getPager').data("pagination").options.pageSize;
	var pageNumber=$('#cardListTable').datagrid('getPager').data("pagination").options.pageNumber;
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/cardStorage/showCardStorageRecords',
		data : {
			"cardStorageBean.cardType" : $("#cardType").val(),
			"cardStorageBean.receiptType" : $("#receiptType").val(),
			"cardStorageBean.receiptStatus" : $("#receiptStatus").val(),
			"cardStorageBean.startDate" : $("#datepicker1").datebox('getValue'),
			"cardStorageBean.endDate" : $("#datepicker2").datebox('getValue'),
			"cardStorageBean.pageNumber" : pageNumber,
			"cardStorageBean.pageSize" : pageSize
			},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if(gridData == null){
				$('#cardListTable').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#cardListTable').datagrid('loadData', data);
		},
		error : function() {
		}
	});
};
var cardListcolumns = [[ 
                        {field:'receiptNum',title:'单据号',width:60, align:'left'},
                        {field:'cardType',title:'卡片类型',width:60,formatter: function(value,row,index){
                  			var key = "option[value='" + value + "']";
                  			var text = $("#cardType").find(key).text();
                  			return text;
            			},align:'left'},
            			{field:'cardSum',title:'数量',width:80,align:'left'},
            			{field:'supplier',title:'出库方',width:100,formatter: function(value,row,index){
                  			var key = "option[value='" + value + "']";
                  			var text = $("#stationList").find(key).text();
                  			return text;
            			},align:'left'},
            			{field:'supplyDate',title:'出库日期',width:80,align:'left'},
            			{field:'receiver',title:'领取方',width:100,formatter: function(value,row,index){
                  			var key = "option[value='" + value + "']";
                  			var text = $("#stationList").find(key).text();
                  			return text;
            			},align:'left'},
            			{field:'receiveDate',title:'入库日期',width:80,align:'left'},
            			{field:'receiptStatus',title:'单据状态',width:60,formatter: function(value,row,index){
                  			var key = "option[value='" + value + "']";
                  			var text = $("#receiptStatus").find(key).text();
                  			return text;
            			},align:'left'},
            			{field:'applyDate',title:'申请日期',width:120,align:'left'},
            			{field:'userId',title:'操作员',width:60,align:'left'},
            			{field:'startNo',title:'起始号',width:150,align:'left'},
            			{field:'endNo',title:'结束号',width:150,align:'left'}
                       ]];
var cardWithdrawcolumns = [[
                        {field:'no1',title:'起始段号', width:60,align:'left'},
                        {field:'no2',title:'结束段号', width:60,align:'left'},
                        {field:'cardSum',title:'数量', width:60,align:'left'},
                        {field:'note',title:'说明', width:60,align:'left'},
                        {field:'cardStatus',title:'起始段号', width:60,align:'left'}
                        ]];

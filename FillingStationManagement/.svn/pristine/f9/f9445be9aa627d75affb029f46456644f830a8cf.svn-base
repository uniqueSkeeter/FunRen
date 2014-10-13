	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
	var server_context=basePath;
	var requestUrl = basePath + '/employee/showUser';
	
$(function(){
   $('#dg').datagrid({
    title:'员工一览',
    iconCls:'icon-ok',
    width:'auto',
    height:'300',
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
    columns:employeecolumns,
    pagination:true,
    rownumbers:true,
    AllowPaging:true
   });
   
   //设置分页控件  
   var p = $('#dg').datagrid('getPager');  
   $(p).pagination({  
       pageSize: 5,//每页显示的记录条数，默认为10  
       pageList: [5,10,15,20],//可以设置每页记录条数的列表  
       beforePageText: '第',//页数文本框前显示的汉字  
       afterPageText: '页    共 {pages} 页',  
       displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
       onBeforeRefresh:function(){ 
           $(this).pagination('loading'); 
           alert('before refresh'); 
           $(this).pagination('loaded'); 
       }
   }); 
   
  });


	$(document).ready(function() {
		$("#empl_search").click(function() {
			var emplName=$("#emplName").val();
			var emplNum=$("#emplNum").val();
			var emplShiftType=$("#shiftType").val();
			var beginDate=$("#datepicker1").val();
			var endDate=$("#datepicker2").val();
			var emplShiftNum=$("#shiftNum").val();
			if (emplName == '' && emplNum == ''
				&& emplShiftType == '' && emplShiftNum == ''
				&& beginDate == '' && endDate == '') {
				$.messager.alert('My Title','至少填一项!');
				return true;
			}
			
			// 3.$.ajax拼接url的异步请求
			// 3.$.ajax拼接url的异步请求
			var yz = $.ajax({
				type : 'post',
				data : {
					"employeeBean.employeeName" : $("#emplName").val(),
					"employeeBean.employeeNum" : $("#emplNum").val(),
					"employeeBean.shiftType" : $("#shiftType").val(),
					"employeeBean.startDate" : $("#datepicker1").val(),
					"employeeBean.endDate" : $("#datepicker2").val(),
					"employeeBean.shiftNum" : $("#shiftNum").val()
					},
				cache : false,
				dataType : 'json',
				url : requestUrl,
				success : function(loaddata) {
					gridData = loaddata.jsonData;
					var data = $.parseJSON(gridData);    
					$('#dg').datagrid('loadData', data);
				},
				error : function() {
				}
			});
			
		});
	});

	// 检索一览列
	var employeecolumns = [[
	                  		{field:'employeeName',title:'员工姓名',width:80, align:'center'},
	                  		{field:'employeeNum',title:'员工号',width:80, align:'center'},
	                  		
	                  		{field:'shiftType',title:'岗位类型',width:80,formatter: function(value,row,index){
	                  			var key = "option[value='" + value + "']";
	                  			var text = $("#shiftType").find(key).text();
	                  			return text;
	            			},align:'center'},
	            			
	            			{field:'shiftStatus',title:'岗位状态',width:80,formatter: function(value,row,index){
	                  			var key = "option[value='" + value + "']";
	                  			var text = $("#shiftStatus").find(key).text();
	                  			return text;
	            			},align:'center'},
	                  		
	                  		{field:'shiftNum',title:'班次号码',width:80,align:'center'},
	                  		{field:'telephone',title:'电话',width:80,align:'center'},
	                  		{field:'stationNum',title:'站点号',width:80,align:'center'},
	                  		{field:'createData',title:'创建时间',width:100,align:'center'},
	                  		{field:'identity',title:'身份证号',width:120,align:'center'},
	                  		{field:'address',title:'联系地址',width:120,align:'center'}
	                      ]];
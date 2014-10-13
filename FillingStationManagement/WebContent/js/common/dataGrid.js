$(function() {
	$('#dg').datagrid({
		iconCls:'icon-ok',
	    width:'auto',
	    height:'auto',
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
	    columns:oilLogColumns,
	    rownumbers:true,
	    AllowPaging:true
	});
});

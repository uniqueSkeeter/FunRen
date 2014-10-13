//此JS用于单位卡维护的更改卡信息操作
//绝对路径
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
var server_context = basePath;
$(function(){
	
});
$(document).ready(function(){
	$('#changeDrivercardInfo').click(function(){
		var updateCardInfoBean=$('#viceCardTable').datagrid('getSelected');
		if (!updateCardInfoBean){
			  alert('请选择记录!');
		  }else{
			  $('#changeDriverCardIFrame')[0].src= server_context + '/updateCardInfo/loadDriver?updateCardInfoBean.id='+updateCardInfoBean.id;
			  if(updateCardInfoBean.cardStatus!='1'){
				  $.messager.alert("错误","卡状态错误，不能更改子卡信息");
				  return ;
			  }
			  var iframe = document.getElementById("changeDriverCardIFrame").contentWindow;
			  $('#changeDriverCardDialog').dialog({
	        		closed : false,
	                title : '司机信息修改',
	                shadow : true,
	                modal : true,
	                collapsible : true,
	                buttons : [{
	                	text : '保存并写卡',
	                    id : 'sBtn',
	                    handler:function() {
	                    	var rDocument = document.getElementById("changeDriverCardIFrame").contentWindow.document;
	                    	var flag=validateFieldValue(rDocument);
	                    	if(flag){
	                		$.ajax({
	                			data:$(rDocument.driverForm).serialize(),
	                			url:encodeURI(server_context+"/updateCardInfo/saveCardInfo"),type:'POST',timeout:3000,dataType:'html',
	                			success:function(data){
	                				alert("保存成功！");
	                				$('#changeDriverCardDialog').dialog('close');
	                			},
	                			error:function(){
	                				alert("保存失败，请重试！");
	                			}
	                		});
	                    }
	                    }
	                }, {
	                    text : '取消',
	                    id : 'cBtn',
	                    handler : function() {
	                        $('#changeDriverCardDialog').dialog('close');
	                    }
	                } ],
	                onBeforeClose:function(){
	                	updateTable();
	                }
	        });
		  }
	});
});

function validateFieldValue(rDocument){
	var email=rDocument.getElementById('email').value;
	var guestNum=rDocument.getElementById('guestNum').value;
	var guestType=rDocument.getElementById('guestType').value;
	var guestTel=rDocument.getElementById('guestTel').value;
	var zipCode=rDocument.getElementById('zipCode').value;
	if(!checkEmail(email) ||!checkPostcode(zipCode) || (guestType=="01" && !checkIDCard(guestNum)) ||!checkPhone(guestTel)){
		return false;
	}
	var stationInfoLimit= rDocument.getElementById('stationInfoLimit');
	for(var i=0;i<stationInfoLimit.options.length;i++)
	{
		stationInfoLimit.options[i].selected=true;
	}
	$('#alternativeStationList').hide();
	return true;
}

//重新查询
function updateTable(){
	var pageSize=$('#viceCardTable').datagrid('getPager').data("pagination").options.pageSize;
	var pageNumber=$('#viceCardTable').datagrid('getPager').data("pagination").options.pageNumber;
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/updateCardInfo/showMainCardInfo',
		data : {
			"updateCardInfoBean.mainCardNo" : $("#mainCardNo").val(),
			"updateCardInfoBean.pageNumber" : pageNumber,
			"updateCardInfoBean.pageSize" : pageSize
			},
		cache : false,
		dataType : 'json',
		success : function(loaddata) {
			gridData = loaddata.jsonData;
			if(gridData == null){
				$('#viceCardTable').datagrid('loadData',{total:0,rows:[]});
			}
			var data = $.parseJSON(gridData);    
			$('#viceCardTable').datagrid('loadData', data);
		},
		error : function() {
		}
	});
}
//此JS用于个人卡维护的查询，保存并写卡操作
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;
var server_context = basePath;
$(document).ready(function(){
	//读卡接口
	$("#cardMaintain_readonly").click(function(){
		$.messager.alert("读卡","读卡！");
	});
	$("#cardMaintain_searchfor").click(function(){
		 var cardno=document.getElementById("cardNo").value;
		 if(cardno==''){
			 $.messager.alert("错误","请读卡!");
			return false;
		 }
		 document.myForm.reset();
		 $("#cardNo").val(cardno);
		 document.myForm.submit();
	});
	
	$("#cardMaintain_clear").click(function(){
		document.myForm.reset();
	});
	
	$("#cardMaintain_saveCardInfo").click(function(){
		var flag=validateFieldValue();
		if(flag){
    		$.ajax({
    			data:$(myForm).serialize(),
    			url:encodeURI(server_context+"/updateCardInfo/saveCardInfo"),type:'POST',timeout:3000,dataType:'html',
    			success:function(data){
    				$.messager.alert("成功","保存信息成功");
    			},
    			error:function(){
    				$.messager.alert("失败","保存信息失败");
    			}
    		});
		}
	});
});

function validateFieldValue(){
	var email=document.getElementById('email').value;
	var guestNum=document.getElementById('guestNum').value;
	var guestType=document.getElementById('guestType').value;
	var guestTel=document.getElementById('guestTel').value;
	var zipCode=document.getElementById('zipCode').value;
	if(!checkEmail(email) ||!checkPostcode(zipCode) || (guestType=="01" && !checkIDCard(guestNum)) ||!checkPhone(guestTel)){
		return false;
	}
	var stationInfoLimit= document.getElementById('stationInfoLimit');
	for(var i=0;i<stationInfoLimit.options.length;i++)
	{
		stationInfoLimit.options[i].selected=true;
	}
	$('#alternativeStationList').hide();
	return true;
}


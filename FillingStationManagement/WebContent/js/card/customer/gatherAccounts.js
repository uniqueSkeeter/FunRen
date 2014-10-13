/**
 * this js works for gatherAccounts.jsp
 */
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
var server_context=basePath;

$(document).ready(function(){
	$("#account_gather").click(function() {
		$('#gatherAccountDialog').form('clear');
	  var transferAccountsBean = $('#viceCardTable').datagrid('getSelected');
	  if (!transferAccountsBean){
		  $.messager.alert('错误','请选择记录!');
	  }else{
		  if(transferAccountsBean.viceCardStatus!='1'){
			  $.messager.alert('错误','当前副卡状态非正常，不能进行圈存圈提，请重新选择!');
			  return false;
		  }
			$('#gatherAccountIFrame')[0].src= server_context + '/transferAccounts/showAccountsInfoForGather?transferAccountsBean.mainCardNo='+transferAccountsBean.mainCardNo+'&'+'transferAccountsBean.viceCardNo='+transferAccountsBean.viceCardNo;
	        	$('#gatherAccountDialog').dialog({
	        		closed : false,
	                title : '圈存圈提',
	                shadow : true,
	                modal : true,
	                collapsible : true,
	                buttons : [{
	                	text : '保存',
	                    iconCls : 'icon-save',
	                    id : 'sBtn',
	                    handler:function() {
	                    	saveInformation();	                    	
	                    }
	                }, {
	                    text : '取消',
	                    id : 'cBtn',
	                    handler : function() {
	                        $('#gatherAccountDialog').dialog('close');
	                    }
	                } ]
	        });
	  }
  });
});		
	function validateValues(rDocument){
		var gatherAmount = rDocument.getElementById('gatherAmount');
		var tradeType = rDocument.getElementById('tradeType');
		var allocateType = rDocument.getElementById('allocateType');
		if(ck(gatherAmount)){
			$.messager.alert('错误',"汇总金额不能为空！");
			return false;
		}
		if(ck(tradeType)){
			$.messager.alert('错误',"交易方式不能为空");
			return false;
		}
		if(ck(allocateType)){
			$.messager.alert('错误',"汇总方式不能为空");
			return false;
		}
		
		if(ck(tradeType)==false && tradeType.value!='4' && tradeType.value!='5'){
			$.messager.alert('错误',"交易方式只能为圈存或圈提");
			return false;
		}
		if(allocateType.value=='1' && tradeType.value=='4'){
			$.messager.alert('错误',"汇总方式为积分，无法进行圈存，请重新输入");
			return false;
		}
		if(gatherAmount.value <= 0){
			$.messager.alert('错误',"数额不能小于零，请重新输入");
			return false;
		}
		if(gatherAmount.value > 99999999){
			$.messager.alert('错误',"数额不能大于99999999，请重新输入");
			return false;
		}
		if(tradeType.value=='4'){
			if(ck(gatherAmount)==false && (gatherAmount.value - rDocument.getElementById('viceCardProvisionAccount').value)>0){
				$.messager.alert('错误',"卡内余额不足，无法进行圈存，请重新输入");
				return false;
			}
			if(rDocument.getElementById('viceCardBalance').value >= 99999999){
				$.messager.alert('错误',"卡内余额已满，无法进行圈存");
				return false;
			}
			if((parseInt(gatherAmount.value)+parseInt(rDocument.getElementById('viceCardBalance').value))>99999999){
				$.messager.alert('错误','圈存后卡内金额已满，请重新填写!');
				return false;
			}
		}
		if(tradeType.value=='5'){
			if(allocateType.value=="0"){
				if(ck(gatherAmount)==false && (gatherAmount.value - rDocument.getElementById('viceCardProvisionAccount').value)>0){
					$.messager.alert('错误',"备付账户余额不足，无法进行圈提，请重新输入");
					return false;
				}
				if(rDocument.getElementById('mainCardProvisionAccount').value >= 99999999){
					$.messager.alert('错误',"主卡备付账户余额已满，无法进行圈提");
					return false;
				}
				if((parseInt(gatherAmount.value)+parseInt(rDocument.getElementById('mainCardProvisionAccount').value))>99999999){
					$.messager.alert('错误','圈提后主卡备付账户金额已满，请重新填写!');
					return false;
				}
			}
			if(allocateType.value=="1"){
				if(ck(gatherAmount)==false && (gatherAmount.value - rDocument.getElementById('viceCardPoint').value)>0){
					$.messager.alert('错误',"积分余额不足，无法进行圈提，请重新输入");
					return false;
				}
			}
			
		}
		return true;
	}
	// 表单验证
	var ck = function (input) {
	    if (input.value == '') {
	        input.focus();
	        return true;
	    } else {
	        return false;
	    };
	};

function saveInformation(){
	var rDocument = document.getElementById("gatherAccountIFrame").contentWindow.document;
	var flag = validateValues(rDocument);
	if(flag){
		$.messager.confirm('提示', '您确认提交?提交后将不可更改', function(correct){
			if (correct){
				var result = saveGather();
				if(result[0]==0){
					if(result[1]==0){
						var docu = document.getElementById("gatherAccountIFrame").contentWindow.window;
						var mainProvisionAccount = parseFloat(rDocument.getElementById("mainCardProvisionAccount").value)+parseFloat(rDocument.getElementById("gatherAmount").value);
						var viceProvisionAccount = docu.$("#viceCardProvisionAccount").val()-docu.$("#gatherAmount").val();
						$('#printIFrame')[0].src= server_context + '/view/card/customer/printGatherAccounts.jsp?guestNo='+
						docu.$("#guestNo").val()+'&mainCardGuestName='+
						encodeURI(encodeURI(docu.$("#mainCardGuestName").val()))+'&gatherAmount='+
						docu.$("#gatherAmount").val()+'&mainCardProvisionAccount='+
						mainProvisionAccount+'&viceCardNo='+docu.$("#viceCardNo").val()+'&viceCardProvisionAccount='+
						viceProvisionAccount+'&tradeType='+docu.$("#tradeType").val()+'&allocateType='+docu.$("#allocateType").val();
						$('#printDialog').dialog({
							 closed : false,
				                title : '加油卡汇总打印',
				                shadow : true,
				                modal : true,
				                collapsible : true,
				                buttons : [{
				                	text : '返回',
				                    id : 'returnBtn',
				                    handler:function(){
				                    	updateTable();
				                    	$("#printDialog").dialog("close");
				                    }
				                }],
				                onBeforeClose:function(){
				                	updateTable();
				                }
						});
						$('#gatherAccountDialog').dialog('close');
					}
					
					if(result[1]==1){
						var docu = document.getElementById("gatherAccountIFrame").contentWindow.window;
						var moneyInCard = parseFloat(rDocument.getElementById("viceCardBalance").value)+parseFloat(rDocument.getElementById("gatherAmount").value);
						var moneyInAccount = rDocument.getElementById("viceCardProvisionAccount").value-rDocument.getElementById("gatherAmount").value;
						$('#printIFrame')[0].src= server_context + '/view/card/customer/printCreditForLoadRecords.jsp?guestNo='+
						document.getElementById("gatherAccountIFrame").contentWindow.window.$("#guestNo").val()+'&viceCardGuestName='+
						encodeURI(encodeURI(document.getElementById("gatherAccountIFrame").contentWindow.window.$("#viceCardGuestName").val()))+'&gatherAmount='+
						document.getElementById("gatherAccountIFrame").contentWindow.window.$("#gatherAmount").val()+'&viceCardProvisionAccount='+
						document.getElementById("gatherAccountIFrame").contentWindow.window.$("#viceCardProvisionAccount").val()+'&viceCardNo='+
						document.getElementById("gatherAccountIFrame").contentWindow.window.$("#viceCardNo").val()+'&viceCardBalance='+
						document.getElementById("gatherAccountIFrame").contentWindow.window.$("#viceCardBalance").val()+'&moneyInCard='+moneyInCard+'&moneyInAccount='+moneyInAccount+'&allocateType='+docu.$("#allocateType");
						$('#printDialog').dialog({
							 closed : false,
				                title : '加油卡汇总打印',
				                shadow : true,
				                modal : true,
				                collapsible : true,
				                buttons : [{
				                	text : '返回',
				                    id : 'returnBtn',
				                    handler:function(){
				                    	updateTable();
				                    	$("#printDialog").dialog("close");
				                    }
				                }],
				                onBeforeClose:function(){
				                	updateTable();
				                }
						});
						$('#gatherAccountDialog').dialog('close');
					}
				}
			}else{
				return correct;
			}
		});
		
		/*$.ajax({
			data:$(addEmplform).serialize(),
			url:encodeURI(server_context+"/cardStorage/saveCardOrder"),type:'POST',timeout:3000,dataType:'html',
			success:function(data){
				
			},
			error:function(){
				$.messager.alert('错误','请重试!');
			}
		});*/
		
		
	}
};
function updateTable(){
	var pageSize=$('#viceCardTable').datagrid('getPager').data("pagination").options.pageSize;
	var pageNumber=$('#viceCardTable').datagrid('getPager').data("pagination").options.pageNumber;
	document.getElementById("mainCardNo").disabled=false;
	var yz = $.ajax({
		type : 'post',
		url : server_context+'/transferAccounts/showViceCardsRecords',
		data : {
			"transferAccountsBean.mainCardNo" : $("#mainCardNo").val(),
			"transferAccountsBean.guestNo" : $("#guestNo").val(),
			"transferAccountsBean.pageNumber" : pageNumber,
			"transferAccountsBean.pageSize" : pageSize
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
};

function saveGather(){
	var rDocument = document.getElementById("gatherAccountIFrame").contentWindow.document;
	var addEmplform = rDocument.getElementsByTagName('form');
	var flag=[1,-1];
	if(rDocument.getElementById('tradeType').value=='5'){
		if(rDocument.getElementById('viceCardStatus').value!='1' ){
			$.messager.alert('错误','卡片处于非正常状态，无法进行圈提!');
			$('#gatherAccountDialog').dialog('close');
		}
		else{
			var yz = $.ajax({
				type : 'post',
				url : server_context+'/transferAccounts/saveGatherRecords',
				data:$(addEmplform).serialize(),
				cache : false,
				dataType : 'json',
				async:false,
				success : function(loaddata) {
					$.messager.alert('成功','保存圈提信息成功!');
					flag[0]=0;
					flag[1]=0;
				},
				error : function() {
					$.messager.alert('错误','保存失败，请重试!');
				}
			});
		}
	}
	if(rDocument.getElementById('tradeType').value=='4'){
		if(rDocument.getElementById('viceCardStatus').value!='1' ){
				$.messager.alert('错误','卡片处于非正常状态，无法进行圈存!');
				$('#gatherAccountDialog').dialog('close');
		}
		else{
			var gz = $.ajax({
				type : 'post',
				url : server_context+'/transferAccounts/saveCreditForLoadRecords',
				data:$(addEmplform).serialize(),
				cache : false,
				dataType : 'json',
				async:false,
				success : function(loaddata) {
					$.messager.alert('成功','保存圈存信息成功!');
					flag[0]=0;
					flag[1]=1;
				},
				error : function() {
					$.messager.alert('错误','保存失败，请重试!');
				}
			});
		}
	}
	return flag;
}
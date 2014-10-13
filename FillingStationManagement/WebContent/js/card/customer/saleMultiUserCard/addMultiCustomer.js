//include in addMultiCustomer.jsp
var readFlag = false;
$(document).ready(function(){
	readFlag = false;
	$("#readCard").click(function(){
		alert("读卡");
		readFlag = true;
	});
	$("#saleCard").click(function(){
		//alert("售卡");
		//alert("readFlag is "+readFlag);
		if(readFlag){
		var valideFlag = valideCardAndGuestInput();
		var customerAdd_form = document.getElementsByTagName("form");
		//alert($(customerAdd_form).serialize());
		//alert("valideFlag is "+valideFlag);
		if(valideFlag){
			//alert("验证通过");
			$.ajax({
    			data:$(customerAdd_form).serialize(),
    			url:encodeURI(server_context+"/registMultiCustomer/saveCustomer"),type:'POST',timeout:3000,dataType:'html',
    			success:function(data){
    				$('#printCardIFrame')[0].src= server_context+'/view/card/customer/saleMultiUserCard/printMultiUserMainCard.jsp'
    				+'?cardNo='+document.getElementById("cardNo").value
    				+'&deposit='+document.getElementById("deposit").value
    				+'&guestName='+encodeURI(encodeURI(document.getElementById("guestName").value))
    				+'&guestType='+encodeURI(encodeURI($("#guestType").find("option:selected").text()))
    				+'&guestNum='+document.getElementById("guestNum").value
    				+'&bankType='+encodeURI(encodeURI($("#bankType").find("option:selected").text()))
    				+'&bankAcc='+document.getElementById("bankAcc").value
    				+'&guestTel='+document.getElementById("guestTel").value;
    				$('#printCardDialog').dialog({
   					 closed : false,
   		                title : '单位卡打印',
   		                shadow : true,
   		                modal : true,
   		                collapsible : true,
   		                buttons : [{
   		                	text : '返回',
   		                    id : 'returnBtn',
   		                    handler:function(){
   		                    	$("#printCardDialog").dialog("close");
   		                    	window.location.href=basePath+"/registMultiCustomer/registMultiCustomerInit";
   		                    }
   		                }]
   				});
    			
    			},
    			error:function(){
    				$.messager.alert('错误','单位客户信息保存失败，请重试!');
    			}
		});
		}
		}
	});
	$("#reset").click(function(){
		//alert("重置");
		var customerAdd_form = document.getElementsByTagName("form"); 
		customerAdd_form.reset();
	});
	$("#returnBack").click(function(){
		window.location.href=basePath+"/registMultiCustomer/registMultiCustomerInit";
	});
});
function valideCardAndGuestInput(){
	//alert("in valideCardAndGuestInput");
	//卡号
	var cardNo = document.getElementById('cardNo').value;
	//alert('$'+cardNo+'$');
	if(cardNo == ''){
		alert('卡号为必填项!');
		return false;
	}
	//卡片类型
	var cardType = document.getElementById('cardType').value;
	//alert('$'+cardType+'$');
	if(cardType != '多用户'){
		alert('卡片类型必须为多用户!');
		return false;
	}
	//押金
	var deposit = document.getElementById('deposit').value;
	if(deposit == ''){
		alert('押金为必填项!');
		return false;
	}
	if(isNaN(deposit)){
		alert('押金必须为数字!');
		return false;
	}
	//生效日期
	var effectiveDate =$("#effectiveDate").datebox('getValue');
	if(effectiveDate == ''){
		alert('生效日期为必填项!');
		return false;
	}
	//失效日期
	var disEffectiveDate = $("#disEffectiveDate").datebox('getValue');
	if(disEffectiveDate == ''){
		alert('失效日期为必填项!');
		return false;
	}
	//印刷号
	var cardExno = document.getElementById('cardExno').value;
	if(cardExno == ''){
		alert('印刷号为必填项!');
		return false;
	}
	//单位名称
	var guestName = document.getElementById('guestName').value;
	if(guestName == ''){
		alert('单位名称为必填项!');
		return false;
	}
	//单位证件类型
	var guestType = document.getElementById('guestType').value;
	if(guestType == ''){
		alert('单位证件类型为必填项!');
		return false;
	}
	//单位证件号码
	var guestNum = document.getElementById('guestNum').value;
	if(guestNum == ''){
		alert('单位证件号码为必填项!');
		return false;
	}
	//开户银行
	var bankType = document.getElementById('bankType').value;
	if(bankType == ''){
		alert('开户银行为必填项!');
		return false;
	}
	//银行帐号
	var bankAcc = document.getElementById('bankAcc').value;
	if(bankAcc == ''){
		alert('银行帐号为必填项!');
		return false;
	}
	//税务登记号
	var taxNum = document.getElementById('taxNum').value;
	if(taxNum == ''){
		alert('税务登记号为必填项!');
		return false;
	}
	return true;
}

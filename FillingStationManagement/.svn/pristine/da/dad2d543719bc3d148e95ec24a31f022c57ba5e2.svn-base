/**
 * this js works for returnCardStorage.jsp
 */

	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
	var server_context=basePath;
	
	$(document).ready(function(){
		$("#card_return").click(function(){
			$('#returnCardIFrame')[0].src= server_context + '/view/card/card/returnCardStorage.jsp';
			$('#returnCardDialog').form('clear');
			 $('#returnCardDialog').dialog({
				 	closed : false,
	                title : '申请退卡',
	                shadow : true,
	                modal : true,
	                collapsible : true,
	                buttons : [{
	                	text : '保存',
	                    iconCls : 'icon-save',
	                    id : 'sBtn',
	                    handler:function() {
	                    	saveReturnCardInfo();
	                    }
	                }, {
	                    text : '取消',
	                    id : 'cBtn',
	                    handler : function() {
	                        $('#returnCardDialog').dialog("close");
	                    }
	                }]
				 
			 });
		});
	});
	function validateReturnCardValue(rDocument){
		var cardType = rDocument.getElementById('cardCategory');
		var cardSum = rDocument.getElementById('cardAcount');
		var receiver = rDocument.getElementById('receiver');
		var applyDate = document.getElementById("returnCardIFrame").contentWindow.window.$("#datepicker3").datebox('getValue');
		if(cardType == ''){
			$.messager.alert('错误',"卡片类型不能为空！");
			return false;
		}
		if(applyDate == ''){
			$.messager.alert('错误',"申请日期不能为空！");
			return false;
		}
		if(ck(cardSum)){
			alert("数量不能为空！");
			return false;
		}
		if(ck(receiver)){
			alert("领取方不能为空！");
			return false;
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
	function saveCardListReturn(){
		var rDocument = document.getElementById("returnCardIFrame").contentWindow.document;
		var addEmplform = rDocument.getElementsByTagName('form');
		var returnflag=false;
		$.ajax({
			data:$(addEmplform).serialize(),
			url:encodeURI(server_context+"/cardStorage/saveCardOrder"),type:'POST',timeout:3000,dataType:'html',
			async:false,
			success:function(data){
				$.messager.alert('成功','恭喜您成功保存退库申请单!');
				//updateTable();
				returnflag=true;
			},
			error:function(){
				$.messager.alert('错误','请重试!');
				$('#confirmReturnCardDialog').window('close');
			}
		});
		return returnflag;
	};	
	function saveReturnCardInfo(){
		var rDocument = document.getElementById("returnCardIFrame").contentWindow.document;
		var flag = validateReturnCardValue(rDocument);
		if(flag){
			$.messager.confirm('提示', '您确认提交?提交后将不可更改', function(correct){
    			if (correct){
    				var result = saveCardListReturn();
    				if(result){
    					rDocument.getElementById('cardListReturn-form').reset();
    					$("#returnCardDialog").dialog("close");
    					updateTable();
    				}
    			}else{
    				return correct;
    			}
    		});
			
		}
	};

	
	

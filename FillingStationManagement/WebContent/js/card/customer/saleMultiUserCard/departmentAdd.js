//include in departmentMaintain.jsp
	$(document).ready(function(){
		$("#department_add").click(function() {
			//alert("增加部门");
			var cardNo = $("#cardNo").val();
			var guestNo =$("#guestNo").val();
			var guestName = $("#guestName").val();
			if(cardNo!= ""){
				$('#addDepIFrame')[0].src= server_context + '/registMultiCustomer/depAddInit?registerCustomerBean.cardNo='+cardNo; 
			}else if(guestNo != ""){
				$('#addDepIFrame')[0].src= server_context + '/registMultiCustomer/depAddInit?registerCustomerBean.guestNo='+guestNo; 
			}else if(guestName != ""){
				$('#addDepIFrame')[0].src= server_context + '/registMultiCustomer/depAddInit?registerCustomerBean.guestName='+encodeURI(encodeURI(guestName)); 
			}
			else{
				$.messager.alert('错误','主卡号,客户编号,单位名称要有一个不为空!');
				return;
			}
        	$('#addDepDialog').form('clear');
            $('#addDepDialog').dialog({
                closed : false,
                title : '新增部门',
                shadow : true,
                modal : true,
                collapsible : true,
                buttons : [{
                	text : '保存',
                    iconCls : 'icon-save',
                    id : 'sBtn',
                    handler:function() {
                    	//alert("sss");
                    	var rDocument = document.getElementById("addDepIFrame").contentWindow.document;
                    	//alert("");
                    	var flag = validateDepInput(rDocument);
                    	//alert("");
                    	var addDepForm = rDocument.getElementsByTagName('form');
                    	//alert($(addDepForm).serialize());
                    	if(flag){
                    		//alert("验证通过");
                    		$.ajax({
                    			data:$(addDepForm).serialize(),
                    			url:encodeURI(server_context +"/registMultiCustomer/saveDepartment"),type:'POST',timeout:3000,dataType:'html',
	                			success:function(data){
	    	        				$("#addDepDialog").dialog("close");
	    	        				searchData();
	    	        			},
	    	        			error:function(){
	    	        				$.messager.alert('错误','保存失败，请重试!');
	    	        			}
	            		});
                    	}
                    }
                }, {
                    text : '取消',
                    id : 'cBtn',
                    handler : function() {
                        $('#addDepDialog').dialog('close');
                    }
                } ]
        });
	
	});
	});

	function validateDepInput(rDocument){
		//alert("进入validateDepInput");
		//客户编号
    	var guestNo = rDocument.getElementById('guestNo').value;
    	//alert(guestNo);
    	if(guestNo == ""){
    		alert("客户编号不能为空!");
    		return false;
    	}
    	//部门名字
		var depName = rDocument.getElementById('depName').value;
		//alert(depName);
		if(depName == ""){
			alert("部门名字不能为空!");
    		return false;
		}
		var tel = rDocument.getElementById('depTel').value;
		if(tel != ""){
			if(!checkPhone(tel)){
				return false;
			}
		}
		return true;
	}
		
	
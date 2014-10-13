//include in departmentMaintain.jsp
	$(document).ready(function(){
		$("#department_edit").click(function() {
			//alert("编辑部门");
			$('#addDepDialog').form('clear');
			var registerCustomerBean = $('#dg').datagrid('getSelected');
			 if (!registerCustomerBean){
				  $.messager.alert('错误','请选择记录!');
				  return;
			  }
		$('#addDepIFrame')[0].src= server_context + '/registMultiCustomer/refreshDepAdd?registerCustomerBean.id='+registerCustomerBean.id; 
            $('#addDepDialog').dialog({
                closed : false,
                title : '编辑部门',
                shadow : true,
                modal : true,
                collapsible : true,
                buttons : [{
                	text : '保存',
                    iconCls : 'icon-save',
                    id : 'sBtn',
                    handler:function() {
                    	var rDocument = document.getElementById("addDepIFrame").contentWindow.document;
                    	var flag = validateDep(rDocument);
                    	var addDepForm = rDocument.getElementsByTagName('form');
                    	//alert($(addDepForm).serialize());
                    	if(flag){
                    		//alert("验证通过");
                    		$.ajax({
                    			data:$(addDepForm).serialize(),
                    			url:encodeURI(server_context+"/registMultiCustomer/updateDepartment"),type:'POST',timeout:3000,dataType:'html',
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

	function validateDep(rDocument){
		//alert("进入validateDep");
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
		
	
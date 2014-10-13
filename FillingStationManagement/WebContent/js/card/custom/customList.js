
var gridData;

dgWidth = window.screen.width * 4 / 5;
dgHeight = window.screen.height * 5 / 11;

$(function() {
	
	// 树数据加载
	var zNodes = eval("[" + document.getElementById("tree").value + "]");
	$('#testtree').tree({ 
		data:zNodes 
	}); 
	//reloadTree('1', zNodes);
	// 设定日期选择器的相关属性
	$("#datepicker1").datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$("#datepicker2").datepicker({
		dateFormat : 'yy-mm-dd'
	});

});



//证件类型和证件号码联动
function credselect(sValue) {
	if (sValue == '') {
		$("#idcardNum").val("");
		document.getElementById("idcardNum").disabled=true;
		
	} else {
		document.getElementById("idcardNum").disabled=false;
	}
}

$(document).ready(function() {
	// 客户检索
	$("#cus_search").click(function() {
		// 用户类型
		var userType=$("#userType").val();
		// 证件类型
		var idcardType=$("#idcardType").val();
		// 证件号码
		var idcardNum=$("#idcardNum").val();
		// 状态
		var stats=$("#stats").val();
		// 开始日
		var beginDate=$("#datepicker1").val();
		// 结束日
		var endDate=$("#datepicker2").val();
		if (userType == '' && idcardType == ''
				&& idcardNum == '' && stats == ''
				&& beginDate == '' && endDate == '') {
			art.dialog({
			    title: '错误',
			    content: '请至少输入一个检索条件！',
			    icon: 'error',
			    follow: document.getElementById('btn2'),
			    ok: function(){
			        return true;
			    }
			});
			return;
		} else if (idcardType!='' && idcardNum =='') {
			art.dialog({
			    title: '错误',
			    content: '请输入证件号码！',
			    icon: 'error',
			    follow: document.getElementById('btn2'),
			    ok: function(){
			        return true;
			    }
			});
			return;
		}
		//var jsonStr = JSON.stringify( obj );
		//获取表单值，并以json的数据形式保存到params中
		var params = {
			userType:$("#userType").val(),
			idcardType:$("#idcardType").val(),
			idcardNum:$("#idcardNum").val(),
			stats:$("#stats").val(),
			beginDate:$("#datepicker1").val(),
			endDate:$("#datepicker2").val()
		}
		// 3.$.ajax拼接url的异步请求
		var yz = $.ajax({
			type : 'post',
			url : 'customSearch',
			data : params,
			cache : false,
			dataType : 'json',
			success : function(loaddata) {
				gridData = loaddata.customDatas;
				$('#dg').datagrid({
					data: gridData
					
				});
				
			},
			error : function() {
			}
		});

	});
	// 客户注册
	$("#cus_add").click(function() {
		var customadd = art.dialog.open('customAdd?process=1', {
			title : '客户注册',
			width : 800,
			height : 330,
			init : function() {

			},
			ok : function() {
				var iframe = this.iframe.contentWindow;
				if (!iframe.document.body) {
					art.dialog({
					    title: '错误',
					    content: '请稍等片刻！',
					    icon: 'error',
					    follow: document.getElementById('btn2'),
					    ok: function(){
					        return true;
					    }
					});
					return false;
				}

				var usertype = iframe.document
						.getElementsByName('fkTGuest.usertype')[0];
				var idcardType = iframe.document
						.getElementsByName('fkTGuest.idcardType')[0];
				var idcardNum = iframe.document
						.getElementsByName('fkTGuest.idcardNum')[0];
				var name = iframe.document
						.getElementsByName('fkTGuest.name')[0];
				var paymoney = iframe.document
					.getElementsByName('paymoney')[0];
				// 必须输入检查
				if (check(usertype) || check(idcardType) || check(idcardNum) || check(name)){
					
					return false;
				} else {
					var addform = iframe.document.getElementsByTagName('form');
					$.ajax({
	        			url:"customAdd?process=2",
	        			type:"post",
	        			data:$(addform).serialize(),
	        			dataType:"json",
	        			success:function(data){
	        				art.dialog({
	        				    title: '提示',
	        				    content: '客户注册成功！',
	        				    icon: 'succeed',
	        				    follow: document.getElementById('btn2'),
	        				    ok: function(){
	        				    	customadd.close();
	        				    	if (paymoney.value == "true") {
	        				    		
	        				    	}
	        				        return true;
	        				    }
	        				});
	        			},
	        			error:function(){
	        				art.dialog({
	        				    title: '错误',
	        				    content: '客户注册失败！',
	        				    icon: 'error',
	        				    follow: document.getElementById('btn2'),
	        				    ok: function(){
	        				        return true;
	        				    }
	        				});
	        			}
					});
				}
				return false;
			},
			cancel : true
		});
	});
	$("#cus_modify").click(function() {
		var row = $('#dg').datagrid('getSelected');
		if (!row){
			art.dialog({
			    title: '错误',
			    content: '请选择记录！',
			    icon: 'error',
			    follow: document.getElementById('btn2'),
			    ok: function(){
			        return true;
			    }
			});
		}
		var customadd = art.dialog.open('customAdd?process=3&customId=' + row.id, {
			title : '客户编辑',
			width : 800,
			height : 330,
			init : function() {

			},
			ok : function() {
				var iframe = this.iframe.contentWindow;
				if (!iframe.document.body) {
					art.dialog({
					    title: '错误',
					    content: '请稍等片刻！',
					    icon: 'error',
					    follow: document.getElementById('btn2'),
					    ok: function(){
					        return true;
					    }
					});
					return false;
				}

				var usertype = iframe.document
						.getElementsByName('fkTGuest.usertype')[0];
				var idcardType = iframe.document
						.getElementsByName('fkTGuest.idcardType')[0];
				var idcardNum = iframe.document
						.getElementsByName('fkTGuest.idcardNum')[0];
				var name = iframe.document
						.getElementsByName('fkTGuest.name')[0];

				// 必须输入检查
				if (check(usertype) || check(idcardType) || check(idcardNum) || check(name)){
					
					return false;
				} else {
					var addform = iframe.document.getElementsByTagName('form');
					$.ajax({
	        			url:'customAdd?process=4&customId=' + row.id,
	        			type:"post",
	        			data:$(addform).serialize(),
	        			dataType:"json",
	        			success:function(data){
	        				art.dialog({
	        				    title: '提示',
	        				    content: '客户更新成功！',
	        				    icon: 'succeed',
	        				    follow: document.getElementById('btn2'),
	        				    ok: function(){
	        				    	customadd.close();
	        				        return true;
	        				    }
	        				});
	        			},
	        			error:function(){
	        				art.dialog({
	        				    title: '错误',
	        				    content: '客户更新失败！',
	        				    icon: 'error',
	        				    follow: document.getElementById('btn2'),
	        				    ok: function(){
	        				        return true;
	        				    }
	        				});
	        			}
					});
				}
				return false;
			},
			cancel : true
		});
	});
	
	$("#cus_pay").click(function() {
		var row = $('#dg').datagrid('getSelected');
		if (!row){
			art.dialog({
			    title: '错误',
			    content: '请选择记录！',
			    icon: 'error',
			    follow: document.getElementById('btn2'),
			    ok: function(){
			        return true;
			    }
			});
		}
		var custompay = art.dialog.open('customPay?process=1&customId=' + row.id, {
			title : '客户交费',
			width : 800,
			height : 230,
			init : function() {

			},
			ok : function() {
				var iframe = this.iframe.contentWindow;
				if (!iframe.document.body) {
					art.dialog({
					    title: '错误',
					    content: '请稍等片刻！',
					    icon: 'error',
					    follow: document.getElementById('btn2'),
					    ok: function(){
					        return true;
					    }
					});
					return false;
				}
				var money = iframe.document
						.getElementsByName('fkTGuest.paymoney')[0];
				// 必须输入检查
				if (check(money)){
					return false;
				} else {
					var addform = iframe.document.getElementsByTagName('form');
					$.ajax({
	        			url:'customPay?process=2&customId=' + row.id + '&money=' + money,
	        			type:"post",
	        			data:$(addform).serialize(),
	        			dataType:"json",
	        			success:function(data){
	        				art.dialog({
	        				    title: '提示',
	        				    content: '客户交费成功！',
	        				    icon: 'succeed',
	        				    follow: document.getElementById('btn2'),
	        				    ok: function(){
	        				    	custompay.close();
	        				        return true;
	        				    }
	        				});
	        			},
	        			error:function(){
	        				art.dialog({
	        				    title: '错误',
	        				    content: '客户交费失败！',
	        				    icon: 'error',
	        				    follow: document.getElementById('btn2'),
	        				    ok: function(){
	        				        return true;
	        				    }
	        				});
	        			}
					});
				}
				return false;
			},
			cancel : true
		});
	});
});
//表单验证
var check = function (input) {
    if (input.value == '') {
        inputError(input);
        input.focus();
        return true;
    } else {
        return false;
    };
};

// 输入错误提示
var inputError = function (input) {
    clearTimeout(inputError.timer);
    var num = 0;
    var fn = function () {
        inputError.timer = setTimeout(function () {
            input.className = input.className == '' ? 'form-error' : '';
            if (num == 5) {
                input.className = '';
            } else {
                fn(num ++);
            };
        }, 150);
    };
    fn();
};
// 检索一览列
var customcolumns = [[
          		{field:'guestno',title:'客户编号',width:80,align:'center'},
          		{field:'guestname',title:'客户名称',width:80,align:'center'},
          		{field:'usertype',title:'用户类型',width:60,formatter: function(value,row,index){
          			var key = "option[value='" + value + "']";
          			var text = $("#userType").find(key).text();
          			return text;
    			},align:'center'},
          		{field:'idcardType',title:'证件类型',width:60,formatter: function(value,row,index){
          			var key = "option[value='" + value + "']";
          			var text = $("#idcardType").find(key).text();
          			return text;
    			},align:'center'},
          		{field:'idcardNum',title:'证件编号',width:120,halign:'center',align:'left'},
          		{field:'name',title:'姓名',width:60,align:'center'},
          		{field:'tel',title:'电话',width:80,align:'center'},
          		{field:'add',title:'地址',width:100,align:'left',halign:'center'},
          		{field:'bal',title:'账户金额',width:100,align:'left',halign:'center'},
          		{field:'createDate',title:'创建时间',width:120,align:'center'},
          		{field:'stats',title:'状态',width:60,formatter: function(value,row,index){
          			var key = "option[value='" + value + "']";
          			var text = $("#stats").find(key).text();
          			return text;
    			}, align:'center'}
              ]];


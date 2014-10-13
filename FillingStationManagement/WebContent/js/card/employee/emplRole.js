dgWidth = window.screen.width * 4 / 5;
dgHeight = window.screen.height * 5 / 11;

$(document).ready(function(){
	$('#empl_permission').live('click',function(){
		var employeeBean = $('#dg').datagrid('getSelected');
		if (!employeeBean){
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
		var roleDialog = art.dialog.open("employee/transferData?employeeBean.employeeName=" + employeeBean.employeeName
				+ "&employeeBean.id=" + employeeBean.id
				+ "&employeeBean.employeeNum=" + employeeBean.employeeNum
				+ "&employeeBean.shiftType=" + employeeBean.shiftType, {
        id : "emplPermi",
        lock : true,
        drag : true,
        title : '员工权限分配',
		width : 400,
		height : 200,
        background: 'gray', // 背景色
        opacity: 0.31, // 透明度
        
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
			
			var shiftType = iframe.document.getElementById('shiftType');
			alert(shiftType.value);
			if (check(shiftType)){
				return false;
			} else {
				var addform = iframe.document.getElementsByTagName('form');
				$.ajax({
        			url:"updateUser?employeeBean.id="+employeeBean.id,
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
        				    	roleDialog.close();
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
    }, false);
});

// 表单验证
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
	
});	
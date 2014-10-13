
$(document).ready(function(){
	$("#saveCurrentShift").click(function(){
		saveCurrentShiftConfirm();
	});
	
});

function saveCurrentShiftConfirm(){
	$.messager.confirm('提示', '您确认进行班结?提交后将不可更改', function(correct){
		if (correct){
			var result = saveCurrentShiftAction();
			if(result){
				alert("班结保存成功,自动开始下一班");
				refreshCurrentShiftChangeData();
			}
		}else{
			return correct;
		}
	});
	
}

function saveCurrentShiftAction(){
	var flag = false;
	$.ajax({
		data : {
			"classChangeBean.classNo" : $("#classNo").text(),
			"classChangeBean.id" : $("#shiftId").text()
			},
		async: false,
		url:encodeURI(server_context+"/shiftChangeManage/shiftChangeManage"),type:'POST',timeout:5000,dataType:'html',
		success:function(result){
			flag = true;
		},
		error:function(){
			$.messager.alert("失败","班结保存失败，请联系管理员", "error");
		}
	});
	return flag;
}

function refreshCurrentShiftChangeData(){
	document.shiftChangeForm.submit();
}

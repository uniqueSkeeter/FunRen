$(function(){
		//移到左边
		$('#addStationInforButton').click(function() {
			$('#alternativeStationList').show();
			var length1=document.getElementById('stationInfoLimit').options.length;
			var stationInfoLimit=document.getElementById('stationInfoLimit');
			var alternativeStationList=document.getElementById('alternativeStationList');
			var length2=0;
			for(var i=0;i<alternativeStationList.options.length;i++)
			{
				if(alternativeStationList.options[i].selected==true)
					length2++;
			}
			if(length1+length2>10)
				alert("限制区站不能超过10个！！");
			else{
			$('#alternativeStationList option:selected').appendTo('#stationInfoLimit');
			}
			for(var i=0;i<alternativeStationList.options.length;i++)
				for(var j=0;j<stationInfoLimit.options.length;j++){
					if(alternativeStationList.options[i].value==stationInfoLimit.options[j].value){
						alternativeStationList.remove(i);
					}
				}
		});
		//移到右边
		$('#removeStationInforButton').click(function() {
			$('#stationInfoLimit option:selected').appendTo('#alternativeStationList');
		});
		//双击选项
		$('#alternativeStationList').dblclick(function(){ //绑定双击事件
		//获取全部的选项,删除并追加给对方
			var length1=document.getElementById('stationInfoLimit').options.length;
			var alternativeStationList=document.getElementById('alternativeStationList');
			var length2=0;
			for(var i=0;i<alternativeStationList.options.length;i++)
			{
				if(alternativeStationList.options[i].selected==true)
					length2++;
			}
			if(length1+length2>10)
				alert("限制区站不能超过10个！！");
			else
				$("option:selected",this).appendTo('#stationInfoLimit'); //追加给对方
		});
		//双击选项
		$('#stationInfoLimit').dblclick(function(){
			$("option:selected",this).appendTo('#alternativeStationList');
		});
		//密码标识设为启用,则密码框可输入
		$('#passEnable').click(function(){
			document.getElementById("cardPass").disabled=false;
		});
		//密码标识设为停用,则密码框不可输入
		$('#passDisenable').click(function(){
			document.getElementById("cardPass").disabled=true;
		});
		//限车号标识设为启用,则限车号可输入
		$('#carNoEnable').click(function(){
			document.getElementById("carNoConstr").disabled=false;
		});
		//限车号标识设为停用,则限车号不可输入
		$('#carNoDisenable').click(function(){
			document.getElementById("carNoConstr").disabled=true;
		});
		//限站标识设为启用,则限站信息可输入
		$('#stationEnable').click(function(){
			document.getElementById("stationInfoLimit").disabled=false;
		});
		//限站标识设为停用,则限站信息不可输入
		$('#stationDisenable').click(function(){
			document.getElementById("stationInfoLimit").disabled=true;
		});
	});
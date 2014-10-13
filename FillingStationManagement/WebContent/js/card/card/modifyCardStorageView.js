/**
 * 
 */
$(function(){
	$(function(){
		var lastIndex;
		$('#tt').datagrid({
			toolbar:[{
				text:'添加一行',
				iconCls:'icon-add',
				handler:function(){
					if($('#receiptStatus').val()=='2'){
						$.messager.alert('错误','单据状态为已入库，无法编辑！');
						return false;
					}
					else if($('#receiptStatus').val()=='3' && $('#receiver').val() == $('#stationNum').val()){
						$.messager.alert('错误','单据状态为已出库，您作为领取方无法编辑！');
						return false;
					}
					else{
						$('#tt').datagrid('endEdit', lastIndex);
						var totalLen = $('#tt').datagrid('getRows').length;
						if(totalLen>0){
							var rows =  $('#tt').datagrid('getRows');
							if(rows[totalLen-1].startNo=='' || rows[totalLen-1].endNo==''){
								$.messager.alert('错误','起始号和结束号必须填写！');
								return false;
							}
							if(rows[totalLen-1].startNo > rows[totalLen-1].endNo){
								$.messager.alert('错误','起始号必须小于结束号！');
								return false;
							}
							else{
								var staStr = rows[totalLen-1].startNo.substring(11,20);
								var count1=0;
								while(count1<9 ){
									if(staStr.charAt(count1)=='0'){
										count1++;
									}
									else{
										break;
									}
								}
								var edStr = rows[totalLen-1].endNo.substring(11,20);
								var count2=0;
								while(count2<9 ){
									if(edStr.charAt(count2)=='0'){
										count2++;
									}
									else{
										break;
									}
								}
								var staNum = parseInt(staStr.substring(count1));
								var edNum = parseInt(edStr.substring(count2));
								var cardAmount = parseInt(edNum-staNum)+ 1;
								$('#tt').datagrid('updateRow',{index:totalLen-1,row:{startNo:rows[totalLen-1].startNo,endNo:rows[totalLen-1].endNo,cardSum:cardAmount,note:rows[totalLen-1].note}});
							}
						}
						$('#tt').datagrid('appendRow',{
							startNo:'',
							endNo:'',
							cardSum:'',
							note:''
						});
						lastIndex = $('#tt').datagrid('getRows').length-1;
						$('#tt').datagrid('selectRow', lastIndex);
						$('#tt').datagrid('beginEdit', lastIndex);
					}
					
				}
			},'-',{
				text:'删除一行',
				iconCls:'icon-remove',
				handler:function(){
					var row = $('#tt').datagrid('getSelected');
					if (row){
						var index = $('#tt').datagrid('getRowIndex', row);
						$('#tt').datagrid('deleteRow', index);
					}
				}
			}],
			onBeforeLoad:function(){
				$(this).datagrid('rejectChanges');
			},
			onClickRow:function(rowIndex){
				if (lastIndex != rowIndex){
					$('#tt').datagrid('endEdit', lastIndex);
					$('#tt').datagrid('beginEdit', rowIndex);
				}
				lastIndex = rowIndex;
			}
		});
	});
});

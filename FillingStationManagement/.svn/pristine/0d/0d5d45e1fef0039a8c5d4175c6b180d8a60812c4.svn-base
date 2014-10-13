var HKEY_Root,HKEY_Path,HKEY_Key; 
HKEY_Root="HKEY_CURRENT_USER"; 
HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\"; 
//设置网页打印的页眉页脚为空 
function PageSetup_Null() 
{ 
	
try 
{ 
var Wsh=new ActiveXObject("WScript.Shell"); 
HKEY_Key="header"; 
Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,""); 
HKEY_Key="footer"; 
Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,""); 
} 
catch(e) 
{
	alert("active对象创建失败,打开你的ie浏览器internet选项—— 安全—— 自定义级别—— 把安全级别调为低");
} 

} 

//设置网页打印的页眉页脚为默认值 
function PageSetup_Default() 
{ 
try 
{ 
var Wsh=new ActiveXObject("WScript.Shell"); 
HKEY_Key="header"; 
Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"&w&b页码,&p/&P"); 
HKEY_Key="footer"; 
Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"&u&b&d"); 
} 
catch(e) 
{
	alert("active对象创建失败,打开你的ie浏览器internet选项—— 安全—— 自定义级别—— 把安全级别调为低");
} 

} 
PageSetup_Null(); 

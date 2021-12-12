<head>
<meta http-equiv = "content-Type" content = "text/html" charset = "utf-8">
</head> 
<?php
$connect = mysql_connect("127.0.0.1", "root", "apmsetup"); 
mysql_selectdb("gym"); 
mysql_query("set names UTF8");


$Cname=$_REQUEST['Cname'];
$name=$_REQUEST['name'];
$t=$_REQUEST['t'];
$year=$_REQUEST['year'];
$month=$_REQUEST['month'];
$day=$_REQUEST['day'];
$time=$_REQUEST['time'];	


	 
$result=  mysql_result(mysql_query("select count(name) from reservation where yesno=0 and ready=2  and year='$year' and Cname='$Cname' and month='$month' and day='$day' and time='$time';"),0);
	
 
$xmlcode = "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>\n";
$xmlcode .= "<result>$result</result>\n";
 
$dir = "C:/APM_Setup/htdocs"; 
$filename = $dir."/ok_before_check.xml";
 
file_put_contents($filename, $xmlcode); 
?>


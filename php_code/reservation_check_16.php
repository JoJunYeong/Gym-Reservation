<head>
<meta http-equiv = "content-Type" content = "text/html" charset = "utf-8">
</head> 
<?php
$connect = mysql_connect("127.0.0.1", "root", "apmsetup");
mysql_selectdb("gym"); 
mysql_query("set names UTF8");


$Cname=$_REQUEST['Cname'];
$month=$_REQUEST['month'];
$day=$_REQUEST['day'];


$result=  mysql_result(mysql_query("select count(Cname) from reservation where month='$month' and day='$day' and Cname='$Cname' and time='16:00~17:00' and yesno=0  ;"),0);

 

$xmlcode = "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>\n"; 
$xmlcode .= "<result>$result</result>\n";


$dir = "C:/APM_Setup/htdocs"; 
$filename = $dir."/reservation_check_16.xml";

file_put_contents($filename, $xmlcode); 
?>


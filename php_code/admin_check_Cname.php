﻿<head>
<meta http-equiv = "content-Type" content = "text/html" charset = "utf-8">
</head> 
<?php
$connect = mysql_connect("127.0.0.1", "root", "apmsetup");
mysql_selectdb("gym"); 
mysql_query("set names UTF8");

$Cname=$_REQUEST['Cname'];
$name=$_REQUEST['name'];
$ID=$_REQUEST['ID'];
$Password=$_REQUEST['Password'];



$result=  mysql_result(mysql_query("select ACname from admin where id='$ID' and password='$Password';"),0);

 

$xmlcode = "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>\n"; 
$xmlcode .= "<result>$result</result>\n";


$dir = "C:/APM_Setup/htdocs"; 
$filename = $dir."/admin_check_Cname.xml";

file_put_contents($filename, $xmlcode); 
?>


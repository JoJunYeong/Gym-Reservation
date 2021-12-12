<head>
<meta http-equiv = "content-Type" content = "text/html" charset = "utf-8">
</head> 
<?php
$connect = mysql_connect("127.0.0.1", "root", "apmsetup");
mysql_selectdb("gym"); 
mysql_query("set names UTF8");

$name=$_REQUEST['name'];
$Cname=$_REQUEST['Cname'];
$ID=$_REQUEST['ID'];
$Password=$_REQUEST['Password'];



$qry = "insert into admin values('$name','$Cname','$ID','$Password');";
$result = mysql_query($qry);
 
 

$xmlcode = "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>\n"; 
$xmlcode .= "<result>$result</result>\n";


$dir = "C:/APM_Setup/htdocs"; 
$filename = $dir."/admin_create.xml";

file_put_contents($filename, $xmlcode); 
?>


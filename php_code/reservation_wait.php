<head>
<meta http-equiv = "content-Type" content = "text/html" charset = "utf-8">
</head> <!-- �좎럩裕꾢뜝占썹춯�묒삕占쏙옙DB�좎룞�셵tf-8_unicode_ci�β댙�숂춯�얠뒧獄�뼲�숋옙怨삵룖�좎럥梨뤄옙占썲뜝�숈삕�좎럡�들뇡占썲뜝�덉뒩占쏙옙-->
<?php
$connect = mysql_connect("127.0.0.1", "root", "apmsetup"); //DB�띠룊�쇿뜝�덈쐞占쏙옙�낅슣�섓옙占썲뜝�덈뼬�⊥띿삕�좎룞�숃キ占쏀맋�뺢퀗�т빳占썹춯�딅궚占쏙옙�좎럥理먲옙�숈삕占쎈∥裕��롪퍒�뷂옙議용Ь�좎룞�숋옙占쏙옙�쇿뜝�밸쇀占쏙옙�꾤뛾�됱삕�낅슣�섓옙�섎ご�좎룞�숋옙�살┣ �좎룞��
mysql_selectdb("gym"); //DB �좎럩伊싨틦占�mysql_query("set names UTF8"); //�좎럥��떋占썲뜝�덌옙�됵옙�좎럩裕꾢뜝占퐑tf8)�좎룞�숂춯�묒삕占쎌빢�숋옙�얄뵛 �좎럡�들뇡占썽뇦猿볦삕
mysql_query("set names UTF8");

	$name=$_REQUEST['name'];
	$age=$_REQUEST['age'];
	$perpose=$_REQUEST['perpose'];
	$phone=$_REQUEST['phone'];
	$year=$_REQUEST['year'];
	$month=$_REQUEST['month'];
	$day=$_REQUEST['day'];
	$time=$_REQUEST['time'];
	$Cname=$_REQUEST['Cname'];


	$qry = "insert into reservation values('$year','$month','$day','$time','$Cname','$name', '$age', '$perpose','$phone',1,1,now());";
	$result = mysql_query($qry);
 


$xmlcode = "<?xml version = \"1.0\" encoding = \"UTF-8\" ?>\n"; //xml占쎈슣�わ옙占썹빊�뺤젾占쏙옙�꾨뗀諭�
$xmlcode .= "<result>$result</result>\n"; //DB insert揶쏉옙占쎄퉫�э옙怨몄몵嚥∽옙占쎈Ŧ�쀯쭪占쏙옙�占썹몴占쏙옙類ㅼ뵥占쎌꼵由�占쎄쑵鍮�result揶쏅���xml嚥∽옙�곗뮆�곤옙�쀪땀
 
$dir = "C:/APM_Setup/htdocs"; //insertresult.xml 占쎈슣�わ옙占쏙옙占쎌삢占쏙옙野껋럥以�
$filename = $dir."/insertresult2.xml";
 
file_put_contents($filename, $xmlcode); //xmlcode占쏙옙占쎈똻�쒙옙占퐔ml占쎈슣�ゆ에占썹빊�뺤젾
?>
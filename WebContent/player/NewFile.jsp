<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>RIMI</title>
<script LANGUAGE=Javascript>
	
</script>
</head>
<body>

	<div class="close_light_bg" id="close_light_bg"></div>
	<div class="video" id="CuPlayer">
		<b><img src="images/loading.gif" /> 播放器加载中...<a href="http://www.cuplayer.com/cuplayer" target="_blank">点此升级&gt;&gt;</a></b>
	</div>

</body>
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript">
	var so = new SWFObject("player.swf", "myCuPlayer", "900", "600", "9",
			"#000000");
	so.addParam("allowfullscreen", "true");
	so.addParam("allowscriptaccess", "always");
	so.addParam("wmode", "opaque");
	so.addParam("quality", "high");
	so.addParam("salign", "lt");

	so.addVariable("JcScpFile", "CuSunV4set.xml");//播放器设置文件

	so.addVariable("JcScpAutoPlay", "no"); //是否自动播放
	so.addVariable("JcScpVideoPath", "../videos/2222.flv"); //视频文件地址
	so.addVariable("JcScpImg", "../image/1.jpg");//视频缩略图

	so.write("CuPlayer");
</script>
<script language=javascript src="js/jquery-1.4.2.min.js" type=text/javascript></script>
<script language=javascript src="js/action.js" type=text/javascript></script>
</html>

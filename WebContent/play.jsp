<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RIMI</title>
<script LANGUAGE=Javascript>
<!--
function getLight(pars){if(pars=="open"){close_light(this)}else{close_light(this)}};function thisMovie(movieName){if(navigator.appName.indexOf("Microsoft")!=-1){return window[movieName]}else{return document[movieName]}}
//-->
</script> 

<style type="text/css">
<!--
.video { OVERFLOW: hidden; WIDTH: 100%; POSITION: relative}
.close_light_bg {DISPLAY: none; BACKGROUND: #000; FILTER: alpha(opacity = 95); LEFT: 0px; WIDTH: 100%; POSITION: absolute; TOP: 0px; HEIGHT: 100%; opacity: .95}

body { padding:10px;}
div.help { line-height:32px; font-size:14px;}
-->
</style>
</head>

<body>
<div class="close_light_bg" id="close_light_bg"></div>
<!--极酷阳光播放器/代码开始-->
<script type="text/javascript" src="player/js/swfobject.js"></script>
<div class="video" id="CuPlayer"><b><img src="player/images/loading.gif"  /> 网页视频播放器加载中，请稍后...<a href="http://www.cuplayer.com/cuplayer" target="_blank">点此升级&gt;&gt;</a></b></div>
<script type="text/javascript">
var so = new SWFObject("player/player.swf","myCuPlayer","900","600","9","#000000");
so.addParam("allowfullscreen","true");
so.addParam("allowscriptaccess","always");
so.addParam("wmode","opaque");
so.addParam("quality","high");
so.addParam("salign","lt");
//播放器设置文件-----------------------------
so.addVariable("JcScpFile","player/CuSunV4set.xml");
//视频文件及略缩图--------------------------
//so.addVariable("JcScpServer","rtmp://www.yoursite.com/vod");//流媒体服务器
so.addVariable("JcScpAutoPlay","no"); //是否自动播放
so.addVariable("JcScpVideoPath","<%=request.getParameter("url")%>"); //视频文件地址
so.addVariable("JcScpImg","<%=request.getParameter("imgurl")%>");//视频缩略图
//-----------------------------------------
so.write("CuPlayer");
</script>
<script language=javascript src="player/js/jquery-1.4.2.min.js" type=text/javascript></script> 
<script language=javascript src="player/js/action.js" type=text/javascript></script>
<!--极酷阳光播放器/代码结束-->
<a href="videos/2222.flv">aaa</a>
<a href="videos/2222.flv"><%=request.getParameter("url")%>")</a>

<!-- help/End -->
</body>
</html>

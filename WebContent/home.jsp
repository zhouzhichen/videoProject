<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>layout 后台大布局 - Layui</title>
<link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">RIMI视频资料管理</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item"><a href="upload.jsp" target="main">上传视频</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          用户名
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退出系统</a></li>
    </ul>
 </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
       
        <c:forEach  var="m"  items="${majorInfo }">
        	 <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">${m.major }</a>
          <dl class="layui-nav-child">
          	<c:forEach var="u" items="${ userInfo }">
          		<c:if test="${m.major == u.major }">
	          		 <dd><a href="VedioServlet?method=flower&case=${u.id }" target="main">${ u.name }</a></dd>
          		</c:if>
          	</c:forEach>
          </dl>
       	 </li>
        </c:forEach>
        
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <iframe  name="main" src="main.jsp" width="100%"  height="99%"  frameborder="1">

    </iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © rimiedu.com 
  </div>
</div>
<script src="layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>
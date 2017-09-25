<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<progress max="100" value="0" id="pro"> </progress>
	<p id="p">0%</p>
	<form action="UploadServlet" method="post"
		enctype="multipart/form-data">
		选择视频:<input type="file" name="sk1"><br>
		<!-- 这里的file必须要有name，否则会出现list为null -->
		视频名称:<input type="text" name="sk2"><br>
		视频信息：<input type="text" name="sk4"><br>
		选择图片:<input type="file" name="sk3"><br>
		
		<input type="submit" id="sub">
	</form>
</body>
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
/*

//用js实现原生异步
	//给上面表单的submit一个点击事件来触发js，实现异步
	
	document.getElementById("sub").onclick = function getXhr() {
		//定时器。时间单位为毫秒
		setInterval(() => {
		
			var xhr = null;
			if (window.XMLHttpRequest) {
				xhr = new XMLHttpRequest();

			} else {
				xhr = new ActiveXObject("Microsoft XMLHttp");
			}
		xhr.open("post", "GetprogressServlet");
		//设置请求头信息
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send();
		//状态码为4表示请求已完成，响应内容已就绪
		//状态码200表示请求资源没有被修改，可以使用浏览器缓存
		//监听服务器响应状态及响应数据
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				//服务器返回的是json对象，使用JSON.parse()方法格式化为js对象。
				var data = xhr.responseText;//JSON.parse(xhr.responseText)
				document.getElementById("pro").value=data;
				/* console.log(data); */
/* 				document.getElementById("p").innerHTML=data+"%";
			}
			
		}
		}, 100);
			

	}
*/ 
	//用jQuery实现异步
	$("#sub").bind("click",function(){//这里可以用bind(绑定事件)方法，绑定点击事件
		var obtainProgress=setInterval(()=> {
			$.ajax({
				type:"post",  //提交方法
				url:"GetprogressServlet",  //发送页面
				/* data:"",//用来传参 */
				success:function(result){
					console.log(result);
					$("#pro").val(result);//相当于js里面的value
					$("#p").text(result);//相当于js里面的innerHTML
					if(result>=100){
						clearInterval(obtainProgress);//清空计时器，以免持续触发
					}
				}
			
			});
		},500);
	} );
	
		
</script>
</html>
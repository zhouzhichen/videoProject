<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		

		<table>
			<tr>
				<c:forEach var="li"  items="${list }" varStatus="sta">
					<c:if test="${sta.index % 4 == 0}">
						</tr>
						<tr height="230px">
					</c:if>
					<td>
					<table border="0px" cellpadding="0" cellspacing="0" style="margin-right: 10px">
						<tr>
							<td><a href="play.jsp?url=${li.vedio_url }&imgurl=${li.vedio_img_url }" ><img alt="图片" src="${li.vedio_img_url }" title="${li.vedio_msg }"  width="250px" height="150px"></a></td>
						</tr>
						<tr align="center">
							<td>
								<span>视频名称：${li.vedio_name}</span><br>
								<span>上传时间：${li.vedio_upload_time }</span>
							</td>
						</tr>
					</table>					
					</td>
				</c:forEach>			
			</tr>		
		</table>
</body>
</html>
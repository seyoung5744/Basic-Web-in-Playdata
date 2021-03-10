<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>hello 가입</h3>
<form action="${pageContext.request.contextPath }/hello" method="post">
id: <input type="text" name="id"><br>
name: <input type="text" name="name"><br>
<input type="submit" value="join"><br>
</form> 
</body>
</html>
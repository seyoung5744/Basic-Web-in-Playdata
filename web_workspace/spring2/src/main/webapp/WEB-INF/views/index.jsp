<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>spring index</h3>
<h3><a href="${pageContext.request.contextPath }/board/write">인사 메시지 쓰기</a></h3>
${mv.email }/${mv.pwd }/${mv.msg }
</body>
</html>
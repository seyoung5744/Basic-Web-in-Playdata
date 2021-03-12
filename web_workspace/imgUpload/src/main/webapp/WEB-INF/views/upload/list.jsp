<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>이미지 목록</h3>
<c:forEach var="img" items="${imgs }">
<img src="/upload/read_img?fname=${img }" style="width:300px;height:300px">
<br>
</c:forEach>
</body>
</html>
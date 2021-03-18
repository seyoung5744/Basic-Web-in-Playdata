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
<h3>자료실</h3>
<a href="/down/upload">자료등록</a><br>
<table border="1">
<tr>
<th>글번호</th><th>제목</th><th>다운수</th>
</tr>
<c:forEach var="df" items="${list }">
<tr>
<td>${df.num }</td>
<td><a href="/down/read?num=${df.num }">${df.title }</a></td>
<td>${df.cnt }</td>
</tr>
</c:forEach>
</table>
</body>
</html>
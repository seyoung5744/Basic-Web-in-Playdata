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
<h3>방명록</h3>
<a href="/guestbook/write">글작성</a><br>
<table border="1">
<tr><th>글번호</th><th>작성자</th><th>글내용</th></tr>
<c:forEach var="gb" items="${list }">
<tr>
<td>${gb.num }</td><td>${gb.writer }</td><td>${gb.content }</td>
</tr>
</c:forEach>
</table>
</body>
</html>
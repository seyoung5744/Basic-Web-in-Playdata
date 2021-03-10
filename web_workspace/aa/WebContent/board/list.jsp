<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>글목록</h3>
<a href="${pageContext.request.contextPath }/board/Write">글작성</a><br>
<c:if test="${empty list}">
<h3>등록된 글이 없다</h3>
</c:if>
<c:if test="${not empty list}">
<table border="1">
<tr>
<th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th>
</tr>
<c:forEach var="b" items="${list }">
<tr>
<td>${b.num }</td>
<td><a href="${pageContext.request.contextPath }/board/Read?num=${b.num }">${b.title }</a></td>
<td>${b.writer }</td>
<td>${b.w_date }</td>
</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>
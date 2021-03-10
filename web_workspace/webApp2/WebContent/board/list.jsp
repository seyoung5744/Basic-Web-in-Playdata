<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function search(type){
	var key = "writer";
	var val = "";
	if(type==2){
		key="title";
		val = f.title.value;
	}else{
		val = f.writer.value;
	}
	var url = "${pageContext.request.contextPath }/board/Search"
	url += "?" + key + "=" + val;
	url += "&type=" + type;
	location.href = url;	
}
</script>
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
<c:forEach var="b" items="${list}">
<tr>
<td>${b.num }</td>
<td><a href="${pageContext.request.contextPath }/board/Read?num=${b.num }">${b.title }</a></td>
<td>${b.writer }</td>
<td>${b.w_date }</td>
</tr>
</c:forEach>
</table>
</c:if>
<form action="${pageContext.request.contextPath }/board/Search" method="post" name="f">
작성자로 검색: 작성자입력<input type="text" name="writer"><input type="button" value="검색" onclick="search(1)"><br>
제목으로 검색: 검색단어입력<input type="text" name="title"><input type="button" value="검색" onclick="search(2)"><br>
</form>
</body>
</html>
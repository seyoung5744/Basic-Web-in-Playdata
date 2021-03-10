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
<h3>이미지 리스트</h3>
<a href="${pageContext.request.contextPath }/img/Write" >이미지 등록</a>
<c:forEach var="ib" items="${list}">
<table border="1">
<tr>
<th>글번호</th><td><input type="text" name="num" value="${ib.num }" readonly></td>
</tr>
<tr>
<th>작성자</th><td><input type="text" name="num" value="${ib.writer }" readonly></td>
</tr>
<tr>
<th>제목</th><td><input type="text" name="num" value="${ib.title }" readonly></td>
</tr>
<tr>
<th>이미지</th><td><img src="${ib.path }" style="width:300;height:300"></td>
</tr>
<tr>
<th>내용</th><td><textarea rows="5" cols="45" name="content" readonly>${ib.content } </textarea></td>
</tr>
</table>
</c:forEach>
</body>
</html>
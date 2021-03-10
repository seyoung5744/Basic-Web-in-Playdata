<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>글작성</h3>
<a href="${pageContext.request.contextPath }/board/List">글목록</a><br>
<form action="${pageContext.request.contextPath }/board/Write" method="post">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.id }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title"></td></tr>
<tr><th>내용</th><td><textarea name="content" rows="15" cols="45"></textarea></tr>
<tr><td colspan="2"><input type="submit" value="저장"></td></tr>
</table>
</form>
</body>
</html>
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
<form action="/guestbook/write" method="post">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer"></td></tr>
<tr><th>글 비밀번호</th><td><input type="password" name="pwd"></td></tr>
<tr><th>내용</th><td><textarea rows="10" cols="45" name="content"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="save"></td></tr>
</table>
</form>
</body>
</html>
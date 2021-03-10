<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/board/write" method="post">
<table style="border:2px solid black">
<tr><th>email</th><td><input type="text" name="email"></td></tr>
<tr><th>pwd</th><td><input type="password" name="pwd"></td></tr>
<tr><th>message</th><td><textarea rows="10" cols="45" name="msg"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="save"></td></tr>
</table>
</form>
</body>
</html>
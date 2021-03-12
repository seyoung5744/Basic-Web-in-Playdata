<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>자료 업로드</h3>
<form action="/down/upload" method="post" enctype="multipart/form-data">
title:<input type="text" name="title"><br>
writer:<input type="text" name="writer"><br>
content:<input type="text" name="content"><br>
글 pwd:<input type="text" name="pwd"><br>
file:<input type="file" name="file"><br>
<input type="submit" value="upload">
</form>
</body>
</html>
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
<form action="/upload/upload" method="post" enctype="multipart/form-data">
title: <input type="text" name="title"><br>
file: <input type="file" name="file"><br>
<input type="submit" value="upload">
</form>
</body>
</html>
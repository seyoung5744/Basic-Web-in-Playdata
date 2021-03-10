<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>작성 페이지</h3>
<form action="${pageContext.request.contextPath }/img/Write" method="post" enctype="multipart/form-data">
<table boader="1">
<tr>
<th>작성자</th><td><input type="text" name="writer" value="${sessionScope.id }"></td>
</tr>
<tr>
<th>제목</th><td><input type="text" name="title"></td>
</tr>
<tr>
<th>내용</th><td><textarea rows="5" cols="45" name="content"></textarea></td>
</tr>
<tr>
<th>사진선택</th><td><input type="file" name="file"></td>
</tr>
<tr>
<tr><td colspan="2"><input type="submit"  value="작성"></td></tr>
</tr>
</table>
</form>
</body>
</html>
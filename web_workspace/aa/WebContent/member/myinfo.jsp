<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function a(){
	//페이지 이동
	location.href="${pageContext.request.contextPath }/member/success.jsp";
}
</script>
</head>
<body>
<h3>내 정보 보기 / 수정</h3>
<form action="${pageContext.request.contextPath }/member/MyInfo" method="post">
<table border="1">
<tr>
<th>id</th><td><input type="text" value="${m.id }" name="id" readonly></td>
</tr>
<tr>
<th>pwd</th><td><input type="text" value="${m.pwd }" name="pwd"></td>
</tr>
<tr>
<th>name</th><td><input type="text" value="${m.name }" readonly></td>
</tr>
<tr>
<th>email</th><td><input type="text" value="${m.email }" readonly></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="정보수정">
<input type="button" value="확인" onclick="a()">
</td>
</tr>
</table>
</form>
</body>
</html>
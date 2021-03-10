<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	if(f.id.value==''){
		alert('id는 필수');
		return;
	}
	if(f.pwd.value==''){
		alert('pwd는 필수');
		return;
	}
	if(f.name.value==''){
		alert('name는 필수');
		return;
	}
	if(f.email.value==''){
		alert('email는 필수');
		return;
	}
	
	if(f.flag.value!='true'){
		alert('id 중복체크 필수');
		return;
	}
	
	f.submit();//전송버튼 클릭과 동일
}
function idCheck(){
	//새창 여는 함수. p1:새창에띄울소스경로, p2:새창이름. p3:창설정(크기, 위치...)
	win = window.open("${pageContext.request.contextPath }/member/idcheck.jsp","win","width=500,height=300,top=100,left=100");
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/member/Join" method="post" name='f'>
<input type="hidden" name="flag" value="false">
<table style="border:2px solid black">
<tr>
<th>id</th><td><input type="text" name="id"><input type="button" value="id중복체크" onclick="idCheck()"></td>
</tr>
<tr>
<th>pwd</th><td><input type="password" name="pwd"></td>
</tr>
<tr>
<th>name</th><td><input type="text" name="name"></td>
</tr>
<tr>
<th>email</th><td><input type="text" name="email"></td>
</tr>
<tr>
<td colspan="2">
<input type="button" value="가입" onclick="check()">
<input type="reset" value="취소">
</td>
</tr>
</table>
</form>
</body>
</html>
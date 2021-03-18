<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function down(){
	location.href="/down/down?num=${df.num}";
}
function del(){
	var pwd = prompt("글 비밀번호를 입력하라");
	if(pwd=='${df.pwd}'){
		location.href="/down/del?num=${df.num}";
	}else{
		alert('글 비밀번호가 일치하지 않음')
	}
}
</script>
</head>
<body>
<h3>상세 페이지</h3>
<a href="/down/list">목록으로 돌아가기</a><br>
<table border="1">
<tr>
<th>글번호</th><td>${df.num }<input type="button" value="삭제" onclick="del()"></td>
</tr>
<tr>
<th>제목</th><td>${df.title }</td>
</tr>
<tr>
<th>올린이</th><td>${df.writer }</td>
</tr>
<tr>
<th>파일명</th><td>${df.path }<input type="button" value="다운로드" onclick="down()"></td>
</tr>
<tr>
<th>다운수</th><td>${df.cnt }</td>
</tr>
<tr>
<th>설명</th><td>${df.content }</td>
</tr>
</table>
</body>
</html>
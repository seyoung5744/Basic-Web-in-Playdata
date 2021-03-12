<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
//window.onload: 페이지가 시작될때 이벤트 핸들러 등록 속성
window.onload=function(){//익명함수
	var html = '';
	if('${flag}'=='true'){
		html = '사용가능한 아이디';
		html += '<input type=button value="선택" onclick=a()>';
	}else if('${flag}'=='false'){
		html = '중복된 아이디';
	}else{
		//window.opener: 이창을 연 당사자
		id = window.opener.document.f.id.value;
		ff.id.value = id;
	}
	
	if(html!=''){
		var resDiv = document.getElementById('res');
		resDiv.innerHTML = html;
	}
}

function a(){
	window.opener.document.f.id.value = '${id }';
	window.opener.document.f.flag.value = 'true';
	window.close();
}
</script>
</head>
<body>
<h3>id 중복체크</h3>
<form action="/helloWeb/member/IdCheck" method="post" name="ff">
id:<input type="text" name="id" value="${id }"><input type="submit" value="중복체크">
</form><br>
<div id="res"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>   
<script type="text/javascript">
	$(document).ready(functnion() {
		// 클래스가 edit인 요소 클릭하면 실행하는 함수 등록
		$(".edit").click(function(){
			var num = $(this).attr("num"); // $(this) : 클릭이 발생한 현재 객체. attr(속성이름) : 속성값 반환
			var pwd = $(this).attr("pwd");
			var pwd2 = prompt("글 비밀번호를 입력하시오");
			if(pwd==pwd2){
				var msg = prompt("새 메시지를 입력하시오");
				location.href = "${pageContext.request.contextPath}/msg/edit?num"+num+"&mag="+msg;
			}else{
				alert("글 비밀번호가 맞지 않습니다.");
			}
		})
		
		// 클래스가 del인 요소 클릭하면 실행하는 함수 등록
		$(".del").click(function(){
			
		})
	})
</script>
</head>
<body>
<h3>msg 목록</h3>
<a href="${pageContext.request.contextPath }/msg/write">메시지 작성</a>
<table border="1">
<tr><th>글번호</th><th>글내용</th><th>작성자</th><th>수정/삭제</th></tr>
<c:forEach var="msg" items="${list }">
<tr>
<td>${msg.num }</td><td>${msg.msg }</td><td>${msg.email }</td>
<td>
<input type="button" value="수정" id="edit" num="${msg.num }" pwd="${msg.pwe }">
<input type="button" value="삭제" id="del" num="${msg.num }" pwd="${msg.pwe }">
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
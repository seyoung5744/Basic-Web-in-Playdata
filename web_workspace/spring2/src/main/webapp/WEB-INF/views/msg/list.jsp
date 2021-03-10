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
		// Ŭ������ edit�� ��� Ŭ���ϸ� �����ϴ� �Լ� ���
		$(".edit").click(function(){
			var num = $(this).attr("num"); // $(this) : Ŭ���� �߻��� ���� ��ü. attr(�Ӽ��̸�) : �Ӽ��� ��ȯ
			var pwd = $(this).attr("pwd");
			var pwd2 = prompt("�� ��й�ȣ�� �Է��Ͻÿ�");
			if(pwd==pwd2){
				var msg = prompt("�� �޽����� �Է��Ͻÿ�");
				location.href = "${pageContext.request.contextPath}/msg/edit?num"+num+"&mag="+msg;
			}else{
				alert("�� ��й�ȣ�� ���� �ʽ��ϴ�.");
			}
		})
		
		// Ŭ������ del�� ��� Ŭ���ϸ� �����ϴ� �Լ� ���
		$(".del").click(function(){
			
		})
	})
</script>
</head>
<body>
<h3>msg ���</h3>
<a href="${pageContext.request.contextPath }/msg/write">�޽��� �ۼ�</a>
<table border="1">
<tr><th>�۹�ȣ</th><th>�۳���</th><th>�ۼ���</th><th>����/����</th></tr>
<c:forEach var="msg" items="${list }">
<tr>
<td>${msg.num }</td><td>${msg.msg }</td><td>${msg.email }</td>
<td>
<input type="button" value="����" id="edit" num="${msg.num }" pwd="${msg.pwe }">
<input type="button" value="����" id="del" num="${msg.num }" pwd="${msg.pwe }">
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
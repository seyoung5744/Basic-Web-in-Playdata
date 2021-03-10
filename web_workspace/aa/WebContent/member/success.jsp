<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>${sessionScope.id }님 로그인 성공</h3>
<h3><a href="${pageContext.request.contextPath }/member/List">모든 회원 목록 보기</a></h3>
<h3><a href="${pageContext.request.contextPath }/member/MyInfo">내정보보기</a></h3>
<h3><a href="${pageContext.request.contextPath }/member/Out">탈퇴</a></h3>
<h3><a href="${pageContext.request.contextPath }/member/Logout">로그아웃</a></h3>
<h3><a href="${pageContext.request.contextPath }/board/List">게시판</a></h3>
</body>
</html>
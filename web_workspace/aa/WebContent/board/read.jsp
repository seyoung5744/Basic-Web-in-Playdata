<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function del(){
	location.href="${pageContext.request.contextPath}/board/Del?num=${b.num}";
}
</script>
</head>
<body>
<c:if test="${sessionScope.id == b.writer }">
<c:set var="str">readonly</c:set>
</c:if>
<h3>글 상세 페이지</h3>
<a href="${pageContext.request.contextPath }/board/List">글목록</a><br>
<form action="${pageContext.request.contextPath }/board/Edit" method="post">
<table border="1">
<tr><th>글번호</th><td><input type="text" name="num" value="${b.num }" readonly></td></tr>
<tr><th>제목</th><td><input type="text" name="title" value="${b.title }" ${str }></td></tr>
<tr><th>작성자</th><td><input type="text" value="${b.writer }" readonly></td></tr>
<tr><th>작성일</th><td><input type="text" value="${b.w_date }" readonly></td></tr>
<tr><th>내용</th><td><textarea name="content" rows="15" cols="45" ${str }>${b.content }</textarea></tr>
<c:if test="${sessionScope.id == b.writer }">
<tr><td colspan="2"><input type="submit" value="수정">
<input type="button" value="삭제" onclick="del()"></td></tr>
</c:if>
</table>
</form>
</body>
</html>
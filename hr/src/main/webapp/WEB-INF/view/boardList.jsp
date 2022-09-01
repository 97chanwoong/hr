<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- menu.jsp include(forward) -->
	<div>
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
	<!-- end menu.jsp include -->
		<hr>
	<div>
		<a href="${pageContext.request.contextPath}/addBoard">add board</a>
	</div>
	<table border="1">
		<tr>
			<th>boardNo</th>
			<th>boardTitle</th>
			<th>boardContent</th>
			<th>boardDate</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="b" items="${boardList}">
			<tr>
				<td>${b.boardNo}</td>
				<td>${b.boardTitle}</td>
				<td>${b.boardContent}</td>
				<td>${b.boardDate}</td>
				<th><a href="${pageContext.request.contextPath}/modifyBoard?boardNo=${b.boardNo}">수정</a></th>
				<th><a href="${pageContext.request.contextPath}/removeBoard?boardNo=${b.boardNo}">삭제</a></th>
			</tr>
		</c:forEach>
	</table>
		<hr>
	<!-- footer.jsp include(forward) -->
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
</body>
</html>
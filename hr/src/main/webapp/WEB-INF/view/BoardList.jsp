<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- menu.jsp include(forward동일한 기술)  -->
	<div>
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
		<!--  jsp:include -->
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/addLocation">add Location</a>
	</div>
	<table border="1">
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="l" items="${locationList}">
				<tr>
					<td>${}</td>
					<td>${}</td>
					<td>${}</td>
					<td>${}</td>
					<td>${}</td>
					<td>${}</td>
					<td>${}</td>
					<td>${}</td>
					<td>${}</td>
					<td><a href="${pageContext.request.contextPath}/modifyLocation?locationId=${}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/removeLocation?locationId=${}">삭제</a></td>
				</tr>
		</c:forEach>
	</table>
	<!-- footer include -->
	<hr>
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
		<!--  jsp:include -->
	</div>
</body>
</html>

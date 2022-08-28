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
		<a href="${pageContext.request.contextPath}/addRegion">add region</a>
	</div>
	<table border="1">
		<tr>
			<th>regionId</th>
			<th>regionName</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="r" items="${list}">
			<tr>
				<td>${r.regionId}</td>
				<td>${r.regionName}</td>
				<td><a href="${pageContext.request.contextPath}/modifyRegion?regionId=${r.regionId}">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/removeRegion?regionId=${r.regionId}">삭제</a></td>
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

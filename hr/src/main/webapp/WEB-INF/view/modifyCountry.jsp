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
	<form method="post"
		action="${pageContext.request.contextPath}/modifyCountry">
		<h1>Country 수정</h1>
		<label for="regionId">regionId</label> <select name="regionId">
			<c:forEach var="list" items="${regionList}">
				<option value="${list.regionId}">${list.regionName}</option>
			</c:forEach>
		</select>
		<div>
			countryId: <input type="text" name="countryId" readonly="readonly"
				value="${country.countryId}">
		</div>
		<div>
			countryName: <input type="text" name="countryName"
				value="${country.countryName}">
		</div>
		<div>
			<button type="submit">수정</button>
		</div>
	</form>
	<!-- footer include -->
	<hr>
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
		<!--  jsp:include -->
	</div>
</body>
</html>
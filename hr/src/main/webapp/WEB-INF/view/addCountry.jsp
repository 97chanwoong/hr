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
		action="${pageContext.request.contextPath}/addCountry">
		<h1>Country 추가</h1>
		<label for="regionId">regionId</label> 
		<select name="regionId">
			<option value="default">---선택해주세요---</option>
			<c:forEach var="list" items="${regionList}">
				<option value="${list.regionId}">${list.regionName}</option>
			</c:forEach>
		</select> 
		<div>
			countryId: <input type="text" name="countryId">
		</div>
		<div>
			countryName: <input type="text" name="countryName">
		</div>
		<div>
			<button type="submit">제출</button>
		</div>
	</form>
	<hr>
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
		<!--  jsp:include -->
	</div>
</body>
</html>
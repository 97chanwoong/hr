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
		action="${pageContext.request.contextPath}/addRegion">
	<h1>추가</h1>
		<div>
			regionId: <input type="text" name="regionId">
		</div>
		<div>
			regionName: <input type="text" name="regionName">
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
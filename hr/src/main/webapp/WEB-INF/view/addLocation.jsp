<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#regionId').change(function(){
		// alert('regionId change');
		// ajax호출 -> 값 -> countryId select append
		if($('#regionId').val() == ''){
			alert('Region을 선택하세요');
		} else {
			$('#countryId').empty();
			$('#countryId').append('<option value="">::: Country 선택 :::</option>');
			
			$.ajax({
				url : '/rest/getCountryList',
				type : 'get',
				data : {regionId : $('#regionId').val()},
				success : function(json){
					// let arr = [];
					$(json).each(function(index, item){
						// arr.push(item);
						$('#countryId').append('<option value="'+ item.countryId +'">'+ item.countryName +'</option>');
					});
					// console.log(arr);
				}
			});
		}
	});
});
</script>
</head>
<body>
	<!-- menu.jsp include(forward동일한 기술)  -->
	<div>
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
		<!--  jsp:include -->
	</div>
	<form method="post"
		action="${pageContext.request.contextPath}/addLocation">
		<h1>Location 추가</h1>
		<label for="regionId">regionId : </label> 
		<select id="regionId">
			<option value="regionId">:::Region 선택:::</option>
			<c:forEach var="r" items="${regionList}">
				<option value="${r.regionId}">${r.regionName}</option>
			</c:forEach>
		</select> 
		<br>
		<label for="countryId">countryId : </label>
		<select name="countryId" id="countryId">
		</select>  
		<br>
		<label for="locationId">locationId : </label> 
			<input type="text" name="locationId">
		<br>	
		<label for="streetAddress">streetAddress : </label> 	
			<input type="text" name="streetAddress">
		<br>	
		<label for="postalCode">postalCode : </label> 	
			<input type="text" name="postalCode">
		<br>
		<label for="city">city : </label> 		
			<input type="text" name="city">
		<br>
		<label for="stateProvince">stateProvince : </label> 		
			<input type="text" name="stateProvince">
		<br>
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
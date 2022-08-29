<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#removeFile').click(function(){
			$('#fileSection').empty();
		});
		
		$('#addFile').click(function(){
			// 디버깅 alert('addFile');
			let isFileEmpty = false; // 파일이 없으면
			let html = '<div><input type="file" name="multiList" class="multiList"></div>';
			
			$('.multiList').each(function(index, item){
				// $(this) --> item 그렇다면 매개변수(index, item) 생략 가능
				if($(item).val() == ''){
					isFileEmpty = true;
				}
			});
			if(!isFileEmpty){
				$('#fileSection').append(html);
			}
		});
		
		$('#addBtn').click(function(){
			let isFileEmpty = false; // 파일이 없으면
			
			$('.multiList').each(function(index, item){
				// $(this) --> item 그렇다면 매개변수(index, item) 생략 가능
				if($(item).val() == ''){
					isFileEmpty = true;
				}
			});
			
			if($('#boardTitle').val() == ''){
				alert('boardTitle을 기입해주세요');
			} else if ($('#boardContent').val() == ''){
			} else if(isFileEmpty){
				alert('file을 입력해주세요');
			} else {
				$('#addform').submit();
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
	<form enctype="multipart/form-data" method="post" action="${pagetContext.request.contextPath}/addBoard" id="addform">
		<!-- 보드내용들 -->
		<div>
			boardTitle
			<input type="text" name="board.boardTitle" id="boardTitle">
		</div>
		<div>
			boardContent
			<input type="text" name="board.boardContent" id="boardContent">
		</div>
		
		<button type="button" id="addFile">파일추가</button> <!-- input type="type" -->
		<button type="button" id="removeFile">파일삭제</button>
		<div id="fileSection">
		</div>
		<button type="button" id="addBtn">addBoard</button>
	</form>
	<hr>
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
		<!--  jsp:include -->
	</div>
</body>
</html>
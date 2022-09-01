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
		
		$('#modifyBtn').click(function(){
			let isFileEmpty = false; // 파일이 없으면
			
			$('.multiList').each(function(index, item){
				// $(this) --> item 그렇다면 매개변수(index, item) 생략 가능
				if($(item).val() == ''){
					isFileEmpty = true;
				}
			});
			
			if($('#boardTitle').val() == ''){
				alert('boardTitle을 기입해주세요');
			} else if(isFileEmpty){
				alert('file을 입력해주세요');
			} else {
				$('#form').submit();
			}
		});
	});
</script>
</head>
<body>
	<!-- menu.jsp include(forward) -->
	<div>
		<c:import url="/WEB-INF/view/inc/menu.jsp"></c:import>
	</div>
	<!-- end menu.jsp include -->
		<hr>
	<form action="${pageContext.request.contextPath}/modifyBoard" method="post" enctype="multipart/form-data" id="form">
		<table border="1">
				<tr>
					<th>boardNo</th>
					<td>
						<input type="text" name="board.boardNo" value="${board.boardNo}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>boardTitle</th>
					<td>
						<input type="text" name="board.boardTitle" id="boardTitle" value="${board.boardTitle}">
					</td>
				</tr>
				<tr>
					<th>boardContent</th>
					<td>
						<textarea name="board.boardContent">${board.boardContent}</textarea>
					</td>
				</tr>
				<tr>
					<th>boardDate</th>
					<td>
						<input type="text" name="board.boardDate" value="${board.boardDate}" readonly="readonly">
					</td>
				</tr>
		</table>
		<div>
			<button type="button" id="addFile">파일추가</button> <!-- input type="type" -->
			<button type="button" id="removeFile">파일삭제</button>
			<div id="fileSection">
			</div>
			<button type="button" id="modifyBtn">modifyBoard</button>
		</div>
	</form>
		<hr>
	<!-- footer.jsp include(forward) -->
	<div>
		<c:import url="/WEB-INF/view/inc/footer.jsp"></c:import>
	</div>
</body>
</html>
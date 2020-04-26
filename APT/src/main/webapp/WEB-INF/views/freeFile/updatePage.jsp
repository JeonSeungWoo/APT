<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<form id="form" method="get"enctype="multipart/form-data">
		<input type="hidden" name="ffno" id="ffno" value="${vo.ffno}">
		<input type="hidden" id="listSize" value="${listSize}">
		          <input type="hidden" name="userid" id="userid" value="${login.userid}">
		<table border="1">
			<tr>
				<th>제목</th>
				<th>내용</th>
			</tr>
			
			<tr>
				<td><input type="text" name="title" id="title" value="${read.title }"></td>
				<td><input type="text" name="content" id="content" value="${read.content }"></td>
			</tr>

		</table>
		<ul>
			<c:forEach items="${list}" var="list" >
				<li>
				<input type="hidden" class="filename" value="${list.filename}">
				<img class="img" alt="${list.filename}" src="/freeUpload/file?ffno=${vo.ffno}&filename=${list.filename}">
				<button type="button" class="deleteImg" value="${vo.ffno}" data-value="${list.filename}">X</button>
				</li>
			</c:forEach>
		</ul>

		<div id="divForm">
			<input type="file" id="file" class="file" name="file">
		</div>


	    
        <button type="button" id="updateBtn">수정</button>
		<button type="button" id="addBtn">파일 추가</button>
		<button type="button" id="removeBtn">제거</button>
		<button type="submit" id="insertBtn">파일 등록</button>

	</form>





	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
	/* 		$(".img").on("click", function() {
				var src = $(this).attr("src");
                window.location.href = src;
			}); */
		
			var form = $("#form");
			var numCheck = 0;
             
			
			$(".deleteImg").on("click",function(){	
				var ffno =$(this).attr("value");
				var filename = $(this).attr("data-value");
				var filenameEnc = encodeURI(filename);
				form.attr("action","/freeUpload/fileDelete?ffno="+ffno+"&filename="+filenameEnc).attr("method","post").submit(); 	

			});
			$("#updateBtn").on("click", function() {
				form.attr("action", "/freeFile/update");
				form.attr("method", "POST");
				form.submit();
			});
			
			$("#insertBtn").on("click", function() {
				//이미지의 값 중 빈값이 있으면 등록 되지 않도록 구현한다.
				var fileVal = $('[name="file"]').val();
				if (fileVal == "" || fileVal == null) {
					alert("파일을 1개 이상 등록해 주세요.");
				} else {
					form.attr("action", "/freeUpload/insertFile");
					form.attr("method", "POST");
					form.submit();
				}

			});

			$("#addBtn").on("click",function() {
				numCheck = numCheck + 1;
				var txt = '<input type="file" id="file" class="file'+numCheck+'" name="file"> '
				$("#divForm").append(txt);
			});

			$("#removeBtn").on("click", function() {
				/*전체 제거  */
				/* $("#divForm *").remove(); */
				$(".file" + numCheck).remove();
				numCheck = numCheck - 1;
			});
		
		
		});
	</script>

</body>
</html>
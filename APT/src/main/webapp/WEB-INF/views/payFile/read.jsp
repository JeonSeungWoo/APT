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
		<input type="hidden" name="pfno" id="pfno" value="${vo.pfno}">
		<input type="hidden" id="listSize" value="${listSize}">
		
		<ul>
			<c:forEach items="${list}" var="list" >
				<li>
				<input type="hidden" class="filename" value="${list.filename}">
				<img class="img" alt="${list.filename}" src="/payUpload/file?pfno=${vo.pfno}&filename=${list.filename}">
				<button type="button" class="deleteImg" value="${vo.pfno}" data-value="${list.filename}">X</button>
				</li>
			</c:forEach>
		</ul>

		<div id="divForm">
			<input type="file" id="file" class="file" name="file">
		</div>


	     <button type="button" id="payBtn">결제</button>

         
		<button type="button" id="addBtn">추가</button>
		<button type="button" id="removeBtn">제거</button>
		<button type="submit" id="insertBtn">등록</button>

	</form>





	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".img").on("click", function() {
				var src = $(this).attr("src");
                window.location.href = src;
			});
			
			$("#payBtn").on("click", function() {
				var pfno = $("#pfno").val();
				var filename = $(".filename").val();
				var filenameEnc = encodeURI(filename);
                location.href = "/payUpload/file?pfno="+ pfno+"&filename="+filenameEnc;
			});
		
			var form = $("#form");
			var numCheck = 0;
             
			
			$(".deleteImg").on("click",function(){	
				var pfno =$(this).attr("value");
				var filename = $(this).attr("data-value");
					form.attr("action","/payUpload/fileDelete?pfno="+pfno+"&filename="+filename).attr("method","post").submit(); 	

			});
			
			$("#insertBtn").on("click", function() {
				//이미지의 값 중 빈값이 있으면 등록 되지 않도록 구현한다.
				var fileVal = $('[name="file"]').val();
				if (fileVal == "" || fileVal == null) {
					alert("이미지를 1개 이상 등록해 주세요.");
				} else {
					form.attr("action", "/payUpload/insertFile");
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
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
		<input type="hidden" id="page" value="${param.page}">
		<table border="1">
			<tr>
				<th>제목</th>
				<th>내용</th>
			</tr>
			
			<tr>
				<td><input type="text" name="title" id="title" value="${read.title }" readonly="readonly"></td>
				<td><input type="text" name="content" id="content" value="${read.content }" readonly="readonly"></td>
				
			</tr>

		</table>
		<ul>
			<c:forEach items="${list}" var="list" >
				<li>
				<input type="hidden" class="filename" value="${list.filename}">
				<h5>${list.filename} </h5>
				</li>
			</c:forEach>
		</ul>



	     <button type="button" id="payBtn">결제</button>
         <button type="button" id="homeBtn">홈으로</button>
         <c:if test="${login.auth eq 1}">
         <button type="button" id="updateBtn">수정</button>
         <button type="button" id="deleteBtn">삭제</button>
         </c:if>
	</form>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var form = $("#form");
			
			$("#payBtn").on("click", function() {
				var ffno = $("#ffno").val();
				var filename = $(".filename").val();
				var filenameEnc = encodeURI(filename);
                location.href = "/freeUpload/file?ffno="+ ffno+"&filename="+filenameEnc;
			});

			$("#homeBtn").on("click", function() {
                location.href = "/";
			});
			
			$("#deleteBtn").on("click", function() {
				form.attr("action", "delete");
				form.attr("method", "POST");
				form.submit();
			});
			
			$("#updateBtn").on("click", function() {
				var ffno = $("#ffno").val();
                location.href = "/freeFile/updatePage?ffno="+ffno;
			});
		
		
		});
	</script>

</body>
</html>
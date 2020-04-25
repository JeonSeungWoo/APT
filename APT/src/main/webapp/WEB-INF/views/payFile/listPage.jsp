<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<style>

/*paging Img  */
.pagingNum{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  padding:5px;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
.pagingNum:hover{
  background:#fff;
  color:#1AAB8A;
}
.pagingNum:before,.pagingNum:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
.pagingNum:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
.pagingNum:hover:before,.pagingNum:hover:after{
  width:100%;
  transition:800ms ease all;
}



</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<!--검색 STA  -->

<div align="center">
		<form action="listPage" method="get" id="form">
			<input id="pageHidden" type="hidden" name="page" value="${param.page}"> 
				<select id="sType" name="sType">
				<option value="null" ${param.sType == "null" ? "selected" : ""}>--</option>
				<option value="title" ${param.sType == "title" ? "selected" : ""}>제목</option>
				<option value="content" ${param.sType == "content" ? "selected" : ""}>내용</option>
			</select>
             <input type="text" name="keyword" id="keyword" value="${param.keyword}">
             <button id="sBtn">검색 </button>
		</form>
</div>
<!--검색 End  -->
<form id="form2">
<table border="1">
<tr>
<th>번호</th>
<th>제목</th>
<th>내용</th>
<th>금액</th>
</tr>
 <c:forEach items="${list}" var="list">
 <tr>
<td><a href="/payFile/read?page=${param.page}&pfno=${list.pfno}">${list.pfno}</a></td>
<td>${list.title}</td>
<td>${list.content}</td>
<td>${list.pay}</td>
</tr>
  </c:forEach>
</table>
<c:if test="${login.auth eq 1}">
<button type="button" id="insertBtn" >등록</button>
</c:if>      

 </form>
<p class="paging">
		<c:if test="${Paging.prev}">
			<a  class="page_btn btn_prev" href="listPage?page=${(Paging.startPage - 1)}">이전</a>
		</c:if>

		<c:forEach begin="${Paging.startPage}" end="${Paging.endPage}"   var="idx">
           
           <c:out value="${Paging.page == idx ? '':''}"/>
           <a  class="pagingNum" href="listPage?page=${idx}">${idx}</a>
          			
		</c:forEach>

		<c:if test="${Paging.next && Paging.endPage > 0}">
			<a class="page_btn btn_next" href="listPage?page=${Paging.endPage +1}">다음</a>
		</c:if>

</p>


</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	
	$("#sBtn").on("click",function(event){
		event.preventDefault();
		$("#pageHidden").val(1);
		$("#form").submit();
	});
	
	 
	$("#insertBtn").on("click",function(){
		$("#form2").attr("action","insertPage").attr("method","get").submit();
	});

	
});


</script>



</html>







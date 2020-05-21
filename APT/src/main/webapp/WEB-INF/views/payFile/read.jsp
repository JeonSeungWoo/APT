<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/sub.css" />
  </head>
  <body>
    <div class="wrap">
      <%@ include file="/resources/include/header.jsp" %>
      <div class="contents">
      
	  <form id="form" method="get" enctype="multipart/form-data">
		<input type="hidden" name="pfno" id="pfno" value="${vo.pfno}">
		<input type="hidden" id="page" value="${param.page}"> 
        <div class="contents_inner">
          <div class="conWrap proud_list">
            <div class="subPage_title">
              <h2>안건정리</h2>
            </div>
            <div class="viewWrap bdt2s333">
              <h4>
                ${read.title}<span class="docDate">${read.regdate}</span>
              </h4>
              <table class="viewTable6" summary="글보기">
                <colgroup>
                  <col width="26%" />
                  <col width="*" />
                </colgroup>
                <tbody>
                  <tr>
                    <td colspan="2" class="viewCon">
                      <div class="inner_view">${read.content}</div>
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">가격</th>
                    <td>${read.pay}원</td>
                  </tr>
                  <tr>
                    <th scope="row">첨부파일</th>
                    <c:forEach items="${list}" var="list" >
                    <td>
                    <input type="hidden" class="filename" value="${list.filename}">
                       ${list.filename}
                    </td>
                    </c:forEach>
                  </tr>
                </tbody>
              </table>
              <div class="bottom_buttons">
              <button type="button" id="payBtn" class="blackBtn">결제</button>
              <c:if test="${login.auth eq 1}">
                <button type="button" id="updateBtn" class="blackBtn">수정</button>
                <button  type="button" id="deleteBtn" class="pointBtn">삭제</button>
              </c:if>
                <button type="button" id="homeBtn" class="blackBtn">목록</button>
              </div>
            </div>
          </div>
          <!-- contents e -->
        </div>
        </form>
      </div>
       <%@ include file="/resources/include/footer.jsp" %>
    </div>
    
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var form = $("#form");
			/* $(".img").on("click", function() {
				var src = $(this).attr("src");
                window.location.href = src;
			}); */
			
			$("#payBtn").on("click", function() {
				var pfno = $("#pfno").val();
                location.href = "/payUpload/file?pfno="+ pfno;
			});

			$("#homeBtn").on("click", function() {
                location.href = "/payFile/listPage?page=" + $("#page").val();
			});
			
			$("#deleteBtn").on("click", function() {
				form.attr("action", "delete");
				form.attr("method", "POST");
				form.submit();
			});
			
			$("#updateBtn").on("click", function() {
				var page = $("#page").val();
				var pfno = $("#pfno").val();
                location.href = "/payFile/updatePage?page="+page+"" + "&pfno="+pfno;
			});
		
		
		});
	</script>
    
  </body>
</html>

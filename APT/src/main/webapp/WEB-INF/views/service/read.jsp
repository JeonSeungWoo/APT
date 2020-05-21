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
      <form id="form" method="POST">
        <input type="hidden" name="sno" id="sno" value="${vo.sno}">
		<input type="hidden" name="page" id="page" value="${param.page}"> 
        <div class="contents_inner">
          <div class="conWrap proud_list">
            <div class="subPage_title">
              <h2>고객센터</h2>
            </div>
            <div class="viewWrap bdt2s333">
               <h4>
                ${vo.title}<span class="docDate">${vo.regdate}</span>
              </h4>
            <table class="viewTable6" summary="글보기">
              <colgroup>
                <col width="10%" />
                <col width="*" />
              </colgroup>
              <tbody>
                <tr>
                  <td colspan="2" class="viewCon">
                    <div class="inner_view">
                      ${vo.content}
                    </div>
                  </td>
                </tr>
               <tr>
               </tr>
               <!--조건  -->
                <tr> 
                  <th scope="row">답변</th>
                  <td>
                     <c:choose>
                       <c:when test="${login.auth eq 1}">
                          <textarea name="answer"  id="answer" placeholder="답변을 입력해주세요.">${vo.answer}</textarea>                   
                       </c:when>
                       <c:otherwise>
                             <div class="inner_view">
                                 ${vo.answer}
                              </div>                                 
                       </c:otherwise>
                      </c:choose>
                    
                  </td>
                </tr>
              </tbody>
            </table>
            </div>
          </div>
          
          <div class="bottom_buttons">
            <c:if test="${login.userid eq vo.writer || login.auth eq 1}">
                <button type="button" id="updateBtn" class="blackBtn">수정</button>
                <button  type="button" id="deleteBtn" class="pointBtn">삭제</button>
              </c:if>
              <button type="button" id="homeBtn" class="blackBtn">목록</button>
               
               <c:if test="${login.auth eq 1}">
                 <button class="blackBtn" id="answerBtn">답변</button>
             </c:if>
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

			$("#homeBtn").on("click", function() {
                location.href = "/service/listPage?page=" + $("#page").val();
			});
			
			$("#deleteBtn").on("click", function() {
				form.attr("action", "delete");
				form.attr("method", "POST");
				form.submit();
			});
			
			$("#updateBtn").on("click", function() {
				var page = $("#page").val();
				var sno = $("#sno").val();
                location.href = "/service/updatePage?page="+page+""+"&sno="+sno;
			});
			

			$("#answerBtn").on("click", function() {
				form.attr("action", "answerUpdate");
				form.attr("method", "POST");
				form.submit();
			});
		
		
		});
	</script>
    
  </body>
</html>

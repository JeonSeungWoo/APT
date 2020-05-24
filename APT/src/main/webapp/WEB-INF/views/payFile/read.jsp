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
		<!--PG INPUT  -->
		<input type="hidden" name="pay" id="pay" value="${read.pay}">
	    <input type="hidden" name="name" id="name" value="${login.name}">
	    <input type="hidden" name="phone" id="phone" value="${login.phone}">
	    
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
              <c:if test="${login.userid ne null}">
              <button type="button" id="payBtn" class="blackBtn">결제</button>
              </c:if>
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
    
    <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {


		      $(document).bind('keydown',function(e){
		          if ( e.keyCode == 123 /* F12 */) {
		              e.preventDefault();
		              e.returnValue = false;
		          }
		      });
		      document.onmousedown=disableclick;
		      status="여기서는 마우스 우클릭이 안됩니다.";
		      
		      function disableclick(event){
		          if (event.button==2) {
		              alert(status);
		              return false;
		          }

		      }
			
			var IMP = window.IMP;
			IMP.init('imp23596754');
			var form = $("#form");
			
			/*BUTTON ST  */
			$("#payBtn").on("click", function() {
				var pfno = $("#pfno").val();
				var pay = $("#pay").val();
				var name = $("#name").val();
				var phone = $("#phone").val();
				var msg = "";
				//PG ST
				IMP.request_pay({
					amount : pay,
					buyer_name : name,
					name : '결제테스트',
					buyer_email : ''
				}, function(response) {
					//결제 후 호출되는 callback함수
					if ( response.success ) { //결제 성공
						console.log(response);
						msg = '결제가 완료되었습니다.';
						msg += '결제 금액 : ' + response.paid_amount +'원';
					    
					    //성공하면 파일 다운로드 
						location.href = "/payUpload/file?pfno="+ pfno+"&pay="+pay;
					} else {
						msg = '결제에 실패하였습니다.';
						msg += '에러내용 : ' + response.error_msg ; 
					}
                     alert(msg);
					
				});
				//PG END
			
			});
			/*BUTTON END  */
			
			
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

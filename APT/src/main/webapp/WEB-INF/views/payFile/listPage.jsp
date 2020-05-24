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
     <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
      rel="stylesheet"/>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/sub.css" />
  </head>
  <body>
    <div class="wrap">
    <%@ include file="/resources/include/header.jsp" %>
      <div class="contents">
        <div class="contents_inner">
          <div class="conWrap proud_list">
            <div class="subPage_title">
              <h2>안건정리</h2>
            </div>
           <div class="apt_searchBox sub_searchBox bdt2s333">
              <div class="srch_title">
                <span class="pointC1">안건정리</span> 검색하기
              </div>
              
              <form action="listPage" method="get" id="form">
              <input id="pageHidden" type="hidden" name="page" value="${param.page}"> 
	          <input type="hidden" name="name" id="name" value="${login.name}">
	          <input type="hidden" name="phone" id="phone" value="${login.phone}">
                <div class="srch_val">

                  <input type="text"
                    name="keyword"
                    id="keyword"
                    class="mr10 srch_input"
                    placeholder="검색어 입력"
                    value="${param.keyword}" />
                  <a href="#none" class="btnS searchBtn"> 검색하기</a>
                </div>
              </form>
            </div>
            <table
              class="listTable1 bdt2s333 mt20"
              summary="번호,지역,제목,작성자,등록일,공감별점"
            >
              <colgroup>
                <col width="5%" />
                <col width="5%" />
                <col width="*" />
                <col width="10%" />
                <col width="10%" />
              </colgroup>
              <tbody>
                <tr>
                <th scope="col">
                   <input type="checkbox" name="checkAll" id="checkAll" onclick="checkAll();"/>
               </th>
                  <th scope="col">번호</th>
                  <th scope="col">제목</th>
                  <th scope="col">가격</th>
                  <th scope="col">등록일</th>
                </tr>
                
                <c:forEach items="${list}" var="list">
                <tr>
                 <td>
                 <span class="tdNum">
                 <input type="checkbox" name="checkRow" class="checkRow" value="${list.pfno}" attr-date="${list.pay}" />
                 </span></td>
                  <td><span class="tdNum">${list.pfno}</span></td>
                  <td class="listSubject">
                    <a href="/payFile/read?page=${param.page}&pfno=${list.pfno}" class="tableSubject">
                     ${list.title}
                    </a>
                  </td>
                  <td class="price">${list.pay}원</td>
                  <td><span class="tdDate">${list.regdate}</span></td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          
          <div class="pagingBoxWrap">
            <ul class="pagingBox">
            
            <c:if test="${Paging.prev}"> 
              <li class="angleBtn abL">
                <a href="listPage?page=${(Paging.startPage - 1)}"><i class="fa fa-angle-left" alt="이전페이지">
                    <span class="blind">이전페이지</span>
                </i></a>
              </li>
            </c:if>
              
            <c:forEach begin="${Paging.startPage}" end="${Paging.endPage}"   var="idx">
              <c:choose>
                <c:when test="${param.page eq idx}">
                   <li class="numBtn actOn">
                    <a  class="pagingNum" href="listPage?page=${idx}">${idx}</a>
                   </li>
                </c:when>
                 <c:otherwise>
                    <li class="numBtn">
                     <a  class="pagingNum" href="listPage?page=${idx}">${idx}</a>
                    </li>
                 </c:otherwise>
              </c:choose>
          	</c:forEach>
            
            <c:if test="${Paging.next && Paging.endPage > 0}">
            <li class="angleBtn abR">
                <a href="listPage?page=${Paging.endPage +1}"><i class="fa fa-angle-right" alt="다음페이지">
                <span class="blind">다음페이지</span></i>
                </a>
              </li>
            </c:if>
              
              
            </ul>
          </div>
          
          <div class="bottom_buttons">
           <c:if test="${login.userid ne null}">
          <button type="button" id="payBtn" class="blackBtn">결제</button>
           </c:if>
            <c:if test="${login.auth eq 1}">
            <a href="/payFile/insertPage" id="insertBtn" class="blackBtn">등록</a>
            </c:if>
          </div>
          
          <!-- contents e -->
        </div>
      </div>
        <%@ include file="/resources/include/footer.jsp" %>
    
   
    </div>
  </body>
      <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){

		$(".searchBtn").on("click",function(event){
			event.preventDefault();
			$("#pageHidden").val(1);
			$("#form").submit();
		});
		
	    var IMP = window.IMP;
		IMP.init('imp23596754');
		var form = $("#form");
		
      function sleep(delay) {
	        var start = new Date().getTime();
			while (new Date().getTime() < start + delay);
	  }

      
 
		/*BUTTON ST  */
		$("#payBtn").on("click", function() {
			
			//pfno의 값을
			var chked_val = "";
			var pay = 0;
	         $(":checkbox[name='checkRow']:checked").each(function(pi,po){
	              chked_val += ","+po.value; 
	              pay += parseInt(po.getAttribute('attr-date'));
                  console.log(pi);
	         }); 
	        chked_val = chked_val.substring(1); // 1st (,) removed
            console.log(chked_val);
            
            if(chked_val == ''){
                alert('한개이상 눌러주세요.');
            }else{
				var name = $("#name").val();
				var phone = $("#phone").val();
				
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
						 var chkedArray = chked_val.split(',');
		                  for(var i=0; i<chkedArray.length; i++) {
		                	  sleep(2000); 
		                      location.href = "/payUpload/file?pfno="+ chkedArray[i]; 
		                  }
		                  
					} else {
						msg = '결제에 실패하였습니다.';
						msg += '에러내용 : ' + response.error_msg ; 
					}
                     alert(msg);
					
				});
				//PG END
            	 
            } 
          
		});
		/*BUTTON END  */
		

		


	//allCHek
	  var selectAll = document.querySelector("#checkAll");
      selectAll.addEventListener('click', function(){
          var objs = document.querySelectorAll(".checkRow");
          for (var i = 0; i < objs.length; i++) {
            objs[i].checked = selectAll.checked;
          };
      }, false);
       
      var objs = document.querySelectorAll(".checkRow");
      for(var i=0; i<objs.length ; i++){
        objs[i].addEventListener('click', function(){
          var selectAll = document.querySelector("#checkAll");
          for (var j = 0; j < objs.length; j++) {
            if (objs[j].checked === false) {
              selectAll.checked = false;
              return;
            };
          };
          selectAll.checked = true;                                   
      }, false);
      } 

      //결제
      

	
});


</script>
  
</html>

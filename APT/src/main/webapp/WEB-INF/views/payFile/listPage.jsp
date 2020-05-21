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
                <div class="srch_val">
                  <label for="what" class="blind">검색어 입력</label>
                  <select id="sType" name="sType" class="srch_sel">
                  <option value="null" ${param.sType == "null" ? "selected" : ""}>--</option>
                  <option value="title" ${param.sType == "title" ? "selected" : ""}>제목</option>
				  <option value="content" ${param.sType == "content" ? "selected" : ""}>내용</option>
                  </select>
                  <input
                    type="text"
                    name="what"
                    id="what"
                    class="mr10 srch_input"
                    placeholder="검색어 입력"
                    value=""
                  />
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
                <col width="*" />
                <col width="8%" />
                <col width="10%" />
                <col width="10%" />
              </colgroup>
              <tbody>
                <tr>
                  <th scope="col">번호</th>
                  <th scope="col">제목</th>
                  <th scope="col">가격</th>
                  <th scope="col">첨부파일</th>
                  <th scope="col">등록일</th>
                </tr>
                
                <c:forEach items="${list}" var="list">
                <tr>
                  <td><span class="tdNum">${list.pfno}</span></td>
                  <td class="listSubject">
                    <a href="/payFile/read?page=${param.page}&pfno=${list.pfno}" class="tableSubject">
                     ${list.title}
                    </a>
                  </td>
                  <td class="price">${list.pay}원</td>
                  <td>
                    <a href="?mode=download&amp;bkey=3600&amp;num=0"
                      ><span class="fs09e clr88">받기</span></a
                    >
                  </td>
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
            <a href="/payFile/insertPage" id="insertBtn" class="blackBtn">등록</a>
          </div>
          <!-- contents e -->
        </div>
      </div>
        <%@ include file="/resources/include/footer.jsp" %>
    
   
    </div>
  </body>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	
	$("#sBtn").on("click",function(event){
		event.preventDefault();
		$("#pageHidden").val(1);
		$("#form").submit();
	});
    

});


</script>
  
</html>

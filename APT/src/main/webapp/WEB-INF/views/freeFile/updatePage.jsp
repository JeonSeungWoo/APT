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
      <form id="form" method="post" enctype="multipart/form-data">
       <input type="hidden" name="ffno" id="ffno" value="${vo.ffno}">
       <input type="hidden" name="page" id="page" value="${param.page}">
	   <input type="hidden" id="listSize" value="${listSize}">
	   <input type="hidden" name="userid" id="userid" value="${login.userid}">
        <div class="contents_inner">
          <div class="conWrap proud_list">
            <div class="subPage_title">
              <h2>일반자료</h2>
            </div>
            <div class="viewWrap bdt2s333">
              <h4>
                <input type="text" name="title" id="title" value="${read.title}" placeholder="제목" />
              </h4>
              <table class="viewTable6" summary="글보기">
                <colgroup>
                  <col width="26%" />
                  <col width="*" />
                </colgroup>
                <tbody>
                  <tr>
                    <td colspan="2" class="viewCon">
                      <div class="inner_view">
                        <textarea name="content" id="content"  
                          placeholder="내용을 입력해주세요." >${read.content}</textarea>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">현재 첨부파일</th>
                    <td>
                    <c:forEach items="${list}" var="list" >
                     <input type="hidden"  id="filename" class="filename" value="${list.filename}">
				      ${list.filename}
				      <button type="button" class="deleteImg blackBtn" value="${vo.ffno}" data-value="${list.filename}">기존파일 삭제</button>
                   </c:forEach>
                    </td>
                    
                  </tr>
                   <tr>
                    <th scope="row">첨부파일</th>
                    <td>
                    <input type="file" id="file" class="file" name="file">
                    </td>
                   
                  </tr>
                </tbody>
              </table>
              <div class="bottom_buttons">
                <button type="button" class="blackBtn" id="updateBtn">수정</button>
		        <button type="submit" class="blackBtn" id="insertBtn">파일 등록</button>
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
				var listSize = $("#listSize").val();
				
				if (fileVal == "" || fileVal == null) {
					alert("파일을 1개 이상 등록해 주세요.");
					return false;
				}else if(listSize >= 1){
					alert("기존 파일을 삭제해 주세요.");
					return false;
				}else {
					form.attr("action", "/freeUpload/insertFile");
					form.attr("method", "POST");
					form.submit();
				}

			});
		
		});
	</script>
  </body>
</html>
	
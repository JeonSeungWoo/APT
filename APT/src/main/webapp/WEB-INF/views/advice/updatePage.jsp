<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
       <input type="hidden" name="lno" id="lno" value="${vo.lno}">
       <input type="hidden" name="page" id="page" value="${param.page}">
        <div class="contents_inner">
          <div class="conWrap proud_list">
            <div class="subPage_title">
              <h2>일반자료</h2>
            </div>
            <div class="viewWrap bdt2s333">
              <h4>
                <input type="text" name="title" id="title" placeholder="제목" value="${vo.title}" />
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
                        <textarea name="content" id="content"placeholder="내용을 입력해주세요.">${vo.content}</textarea>
                      </div>
                    </td>
                  </tr>
                  
                </tbody>
              </table>
               
              <div class="bottom_buttons">
               <button type="button" class="blackBtn" id="updateBtn">수정</button>
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
		var form = $("#form");
		$("#updateBtn").on("click", function() {
			
			var title = $('#title').val();
			var content = $('#content').val();
			if(title == "" || content == ""){
				alert("데이터를 입력해 주세요.");
				return false;
			} else {
				form.attr("action", "update");
				form.attr("method", "POST");
				form.submit();
			}
		});

		
	</script>
  </body>
</html>
	
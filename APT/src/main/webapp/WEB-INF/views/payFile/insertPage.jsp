<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
        <input type="hidden" name="userid" id="userid" value="${login.userid}">
        <div class="contents_inner">
          <div class="conWrap proud_list">
            <div class="subPage_title">
              <h2>안건정리</h2>
            </div>
            <div class="viewWrap bdt2s333">
              <h4>
                <input type="text" name="title" id="title" placeholder="제목" />
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
                        <textarea
                          name="content" id="content"
                          placeholder="내용을 입력해주세요."
                        ></textarea>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">가격</th>
                    <td><input type="number"  name="pay" id="pay"/> 원</td>
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
                <button class="blackBtn" id="insertBtn">등록</button>
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
		$("#insertBtn").on("click", function() {
			//이미지의 값 중 빈값이 있으면 등록 되지 않도록 구현한다.
			var fileVal = $('[name="file"]').val();
			var title = $('#title').val();
			var content = $('#content').val();
			var pay = $('#pay').val();

			if(title == "" || content == ""  || pay == ""){
				alert("데이터를 입력해 주세요.");
			}else if(fileVal == "" || fileVal == null) {
				alert("파일을  등록해 주세요.");
			} else {
				form.attr("action", "insert");
				form.attr("method", "POST");
				form.submit();
			}

		});

		
	</script>
  </body>
</html>
	
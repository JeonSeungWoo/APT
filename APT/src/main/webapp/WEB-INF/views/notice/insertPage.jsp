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
      <script  type="text/javascript"  src="/resources/dist/js/service/HuskyEZCreator.js" charset="utf-8" ></script>
  </head>
  <body>
    <div class="wrap">
     <%@ include file="/resources/include/header.jsp" %>
      <div class="contents">
      <form id="form" method="post">
        <div class="contents_inner">
          <div class="conWrap proud_list">
            <div class="subPage_title">
              <h2>공지사항</h2>
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
                            name="content"
                            id="ir1"
                            rows="10"
                            cols="100"
                            style="width: 1000px; height: 500px;display: none; "
                          ></textarea>
                      </div>
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
			
			var title = $('#title').val();
			var content = $('#content').val();
			if(title == "" || content == ""){
				alert("데이터를 입력해 주세요.");
				return false;
			} else {
				form.attr("action", "insert");
				form.attr("method", "POST");
				form.submit();
			}

		});

		  var oEditors = [];

	      var sLang = "ko_KR"; // 언어 (ko_KR/ en_US/ ja_JP/ zh_CN/ zh_TW), default = ko_KR

	      // 추가 글꼴 목록
	      //var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

	      nhn.husky.EZCreator.createInIFrame({
	        oAppRef: oEditors,
	        elPlaceHolder: "ir1",
	        sSkinURI: "/resources/dist/SmartEditor2Skin.html",
	        htParams: {
	          bUseToolbar: true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	          bUseVerticalResizer: true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	          bUseModeChanger: true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	          //bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
	          //aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
	          fOnBeforeUnload: function () {
	            //alert("완료!");
	          },
	          I18N_LOCALE: sLang,
	        }, //boolean
	        fOnAppLoad: function () {
	          //예제 코드
	          //oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
	        },
	        fCreator: "createSEditor2",
	      });

	      
	      function setDefaultFont() {
	        var sDefaultFont = "궁서";
	        var nFontSize = 24;
	        oEditors.getById["ir1"].setDefaultFont(sDefaultFont, nFontSize);
	      }
		
	</script>
  </body>
</html>
	
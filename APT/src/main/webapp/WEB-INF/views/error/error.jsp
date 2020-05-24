<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=\, initial-scale=1.0" />
    <title></title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/error.css" />
  </head>
  <body>
    <div class="wrap">
      <%@ include file="/resources/include/header.jsp" %>
      <div class="contents">
        <div class="error_wrap">
          <div class="error_icon"></div>
          <p class="error_message">Error :(</p>
          <p>
            일시적인 오류가 발생했습니다.<br />
            잠시 후 다시 실행해 주세요.
          </p>
        </div>
      </div>
        <%@ include file="/resources/include/footer.jsp" %>
    </div>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script
      src="https://code.jquery.com/jquery-1.12.4.min.js"
      integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
      crossorigin="anonymous"    ></script>

  </body>
</html>

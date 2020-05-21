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
    <link rel="stylesheet" href="/resources/css/agreement.css" />
  </head>
  <body>
    <div class="wrap">
          <%@ include file="/resources/include/header.jsp" %>
      
      <div class="contents">
        <div class="agreement_box">
          <h2 class="agreement_title">개인정보처리방침</h2>
          <div class="agreement_cont">
            개인정보 블라블라 블라 블라 블라블라 블라 블라블라 블라 블라
            블라블라 블블라블라 블라 블라 블라블라 블블라블라 블라 블라 블라블라
            블블라블라 블라 블라 블라블라 블블라블라 블라 블라 블라블라
            블블라블라 블라 블라 블라블라 블블라블라 블라 블라 블라블라
            블블라블라 블라 블라 블라블라 블 <br /><br />
            주식회사 카카오(이하"회사")는 이용자의 ‘동의를 기반으로 개인정보를
            수집·이용 및 제공’하고 있으며, ‘이용자의 권리 (개인정보
            자기결정권)를 적극적으로 보장’합니다.<br />
            회사는 정보통신서비스제공자가 준수하여야 하는 대한민국의 관계 법령
            및 개인정보보호 규정, 가이드라인을 준수하고 있습니다.<br /><br /><br />
            “개인정보처리방침”이란 이용자의 소중한 개인정보를 보호함으로써
            이용자가 안심하고 서비스를 이용할 수 있도록 회사가 준수해야 할
            지침을 의미합니다. 본 개인정보처리방침은 회사가 제공하는 카카오계정
            기반의 서비스(이하 ‘서비스'라 함)에 적용됩니다. 블라<br />서비스
            제공을 위한 필요 최소한의 개인정보를 수집하고 있습니다.<br />
            회원 가입 시 또는 서비스 이용 과정에서 홈페이지 또는 개별
            어플리케이션이나 프로그램 등을 통해 아래와 같은 서비스 제공을 위해
            필요한 최소한의 개인정보를 수집하고 있습니다.<br /><br />
            “개인정보처리방침”이란 이용자의 소중한 개인정보를 보호함으로써
            이용자가 안심하고 서비스를 이용할 수 있도록 회사가 준수해야 할
            지침을 의미합니다. 본 개인정보처리방침은 회사가 제공하는 카카오계정
            기반의 서비스(이하 ‘서비스'라 함)에 적용됩니다. 블라<br />서비스
            제공을 위한 필요 최소한의 개인정보를 수집하고 있습니다.<br />
            회원 가입 시 또는 서비스 이용 과정에서 홈페이지 또는 개별
            어플리케이션이나 프로그램 등을 통해 아래와 같은 서비스 제공을 위해
            필요한 최소한의 개인정보를 수집하고 있습니다. 필요한 최소한의
            개인정보를 수집하고 있습니다.<br /><br />
            “개인정보처리방침”이란 이용자의 소중한 개인정보를 보호함으로써
            이용자가 안심하고 서비스를 이용할 수 있도록 회사가 준수해야 할
            지침을 의미합니다. 본 개인정보처리방침은 회사가 제공하는 카카오계정
            기반의 서비스(이하 ‘서비스'라 함)에 적용됩니다. 블라<br />서비스
            제공을 위한 필요 최소한의 개인정보를 수집하고 있습니다.<br />
            회원 가입 시 또는 서비스 이용 과정에서 홈페이지 또는 개별
            어플리케이션이나 프로그램 등을 통해 아래와 같은 서비스 제공을 위해
            필요한 최소한의 개인정보를 수집하고 있습니다.
          </div>
        </div>
      </div>
       <%@ include file="/resources/include/footer.jsp" %>
    </div>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script
      src="https://code.jquery.com/jquery-1.12.4.min.js"
      integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
      crossorigin="anonymous"
    ></script>
    <script>
      (function () {
        // dom
        var el = {};
        el.name = $("#name");
        el.id = $("#id");
        el.password = $("#password");
        el.password_check = $("#password_check");
        el.tel = $("#tel");
        el.apartment = $("#apartment");

        el.address_detail = $("#address_detail");
        el.roadnameCode = $("#roadnameCode");
        el.address = $("#address");

        el.agreement = $("#agreement");

        // 값에 맞는 정규표현식 넣어주기
        var joinRegex = {};
        joinRegex.tel = /^\d{2,3}-\d{3,4}-\d{4}$/;

        var btn = {};
        btn.find_address = $(".find_address");
        btn.join_btn = $(".join_btn");

        // event
        function findAddressEvent(e) {
          e.preventDefault();
          new daum.Postcode({
            oncomplete: function (data) {
              console.log(data);

              var addr = "";
              var extraAddr = "";

              if (data.userSelectedType === "R") {
                addr = data.roadAddress;
              } else {
                addr = data.jibunAddress;
              }

              if (data.userSelectedType === "R") {
                if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                  extraAddr += data.bname;
                }
                if (data.buildingName !== "" && data.apartment === "Y") {
                  extraAddr +=
                    extraAddr !== ""
                      ? ", " + data.buildingName
                      : data.buildingName;
                }
                if (extraAddr !== "") {
                  extraAddr = " (" + extraAddr + ")";
                }
                el.address_detail.val(extraAddr);
              } else {
                el.address_detail.val("");
              }
              el.roadnameCode.val(data.zonecode).attr("disabled", true);
              el.address.val(addr).attr("disabled", true);
              el.address_detail.focus();
            },
          }).open();
        }

        function checkPassword(e) {
          var $self = $(this),
            ERROR_CLASS = "error";

          $self[$self.val() !== el.password.val() ? "addClass" : "removeClass"](
            ERROR_CLASS
          );
        }

        function checkEmptyValue(e) {
          e.preventDefault();
          var check = true,
            ERROR_CLASS = "error";

          function error(el, message) {
            alert(el.attr("placeholder") + message);
            el.addClass(ERROR_CLASS);
            el.focus();
          }

          for (let [key, value] of Object.entries(el)) {
            if (value.attr("type") === "checkbox") {
              if (!value.is(":checked")) {
                alert("개인정보 취급방침에 동의 해주세요.");
              }
            } else if (!value.val()) {
              error(value, "을(를) 입력해주세요.");
              return;
            } else if (joinRegex[key] && !joinRegex[key].test(value.val())) {
              error(value, "의 값을 확인해주세요.");
              return;
            } else {
              value.removeClass(ERROR_CLASS);
            }
          }
        }

        // event 연결
        btn.find_address.click(findAddressEvent);
        el.password_check.change(checkPassword);
        btn.join_btn.click(checkEmptyValue);
      })();
    </script>
  </body>
</html>

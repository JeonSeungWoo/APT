<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=\, initial-scale=1.0" />
    <title></title>
    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/login.css" />
  </head>
  <body>
    <div class="wrap">
        <%@ include file="/resources/include/header.jsp" %>
      
      <div class="contents">
        <div class="login_box">
          <h2 class="login_title">Login</h2>
          <form action="/member/loginProcess" id="form" method="post">
            <label for="id">Id</label>
            <input type="text" id="id"  name="userid" class="login_input" placeholder="Id" />
            <label for="password">Password</label>
            <input
              type="password"
              id="password"
              name="pw"
              class="login_input"
              placeholder="Password"
            />
            <button type="submit" class="login_btn">로그인</button>
          </form>
          <form action="" class="">
            <div class="sns_wrap">
              <button class="sns_login naver">네이버 로그인</button>
             <!--  <button class="sns_login kakao">카카오 로그인</button> -->
              <a  class="sns_login kakao" href="https://kauth.kakao.com/oauth/authorize?client_id=5b54b4a4b3c9b9a2ea0468e03a467785&redirect_uri=http://localhost/member/kakaoLogin&response_type=code">카카오 로그인 </a>
            </div>
          </form>
          <p class="login_txt">
            아직도 회원가입을 안하셨나요? <a href="/member/signUpForm">회원가입 하기</a>
          </p>
        </div>
      </div>
      
       <%@ include file="/resources/include/footer.jsp" %>
      
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function(){
    	   //회원가입 페이지로.
	        document.getElementById('login_btn').onclick = function() { 
			location.href = "/member/signUpForm";
	       }
        });
    </script>
  
  </body>
  
  
</html>

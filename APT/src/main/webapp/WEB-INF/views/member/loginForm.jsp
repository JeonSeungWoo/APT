<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

  <style>
    #login {
      width: 300px;
      margin: auto;
      position: relative;
      top: 100px;
    }
  
    .inputDiv{
      width: 310px;
      height: 40px;
    }
    .inputTag,
    .inputBox {
      height: 40px;
      float: left;
      border: 1px solid #bbbbbb;
      display: flex;
      justify-content: center;
      align-items: center;
    }
   .inputTag {
      width: 40px;
      border-right: none;
      background: rgb(248, 252, 250);
    }
    input {
      border: none;
      width: 260px;
      height: 38px;
      font-size: 16px;
      padding-left: 5px;
    }
    .buttonDiv{
      padding-bottom: 10px;
      padding-top: 10px;
      margin-bottom: 10px;
      margin-top: 10px;
    }
    
    .btn1{
    padding: 10px;
    width: 306PX;
    border-radius: 10px;
    margin-bottom: 5px;
    color: white;
    background: black;
    }
    
    
    
  
  </style>
</head>

<body>
<form action="/member/loginProcess" id="form" method="post">
  <div id="login">
  
      <div class="inputDiv">
        <div class="inputTag">
          <span><img src="/resources/img/loginImg/user.png" width="30" align="center"></span>
        </div>
        <div class="inputBox">
          <input type="text"  name="userid" placeholder="아이디" >
        </div>
      </div>

       <div class="inputDiv">
           <div class="inputTag"> 
           <span><img src="/resources/img/loginImg/userPw.png" width="30" align="center"></span> 
           </div>
           <div class="inputBox"> <input type="password" name="pw" placeholder="비밀번호" > </div>
       </div>
       
       <div class="buttonDiv">
         <button type="submit" class="btn1" id="loginBtn">로그인</button>
         <button type="button" class="btn1" id="signUpBtn">회원가입</button>
       </div>
       
  </div>
</form>  
</body>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function(){
	//회원가입 페이지로.
	
	 document.getElementById('signUpBtn').onclick = function() { 
			location.href = "/member/signUpForm";
	  }
	
});
</script>

</html>
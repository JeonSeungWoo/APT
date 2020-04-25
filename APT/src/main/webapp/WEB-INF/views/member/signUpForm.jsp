<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<body>
	<form id="form">
		<div>
		<input type="text" placeholder="아이디"  name="userid" id="userid"style="width: 240px">
			<button type="button" id="checkId">Id체크</button>
		<span id="idCk"></span>
		</div>
		
		<div>		
		<input type="password" placeholder="페스워드" name="pw" id="pw" >
		</div>		
		
		<div>		
		<input type="text" placeholder="이름" name="name" id="name" >
		</div>		
		
		<div>		
		<input type="text" placeholder="e메일" name="email" id="email" >
		</div>		
		
		<div>		
		<input type="text" placeholder="핸드폰" name="phone" id="phone" >
		</div>		
		
	</form>		
	
		<div class="pw_buttonbox">
			<div class="pw_button xyCenter">
				<button type="submit" id="insertBtn" class="change">회원가입</button>
				<button type="submit" id="cancelBtn" class="cancel">취소</button>
			</div>
		</div>
			

	<!-- JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script>
        $(document).ready(function() {
            var form =$("#form");
            
        	var checkedId = false;
			//회원가입 시작
			$("#insertBtn").on("click",function(){
				 
			     var userid  = $("#userid").val(); 
				 var pw  = $("#pw").val(); 
				 var name  = $("#name").val(); 
				 var email  = $("#email").val(); 
				 var phone  = $("#phone").val();
				 
				//유효성 검사 
				if(name == "" || userid == ""  || pw == "" || email == "" || phone == ""){
					alert("데이터를 입력해주세요");
			    }else if(pw.length < 6 ||pw.length > 16){
        	       alert("비밀번호를 6~16자까지 입력해주세요.")
                    $("#pw").focus();
                    $("#pw").select();
                    return false;
			    }else{
			    	//아이디 체크 검사
			    	if(checkedId == true){
			    		alert("회원가입 되었습니다.");
			    		form.attr("action","loginCreate").attr("method","POST").submit();
			    		return true;
			    	}else{
			    		alert("아이디를 체크를 확인해 주세요!!!!");
			    		return false;
			    	}
			    }
			});
			//회원가입 끝
			
	
	//idCheck 시작		
	 //id check 
	 $("#checkId").on("click",function(){
		var userid  = $("#userid").val(); 
		$.ajax({
			type : "POST",
			url : "/member/checkId",
			data : {"userid" :  userid},
			
			success : function(data){
				if($.trim(data) == 0){
					$("#idCk").html('<b style ="font-size:18xp; color:blue">사용가능</b>');
					checkedId = true;
				}else{
					$("#idCk").html('<b style ="font-size:18xp; color:red">사용불가</b>');
					checkedId = false;
				}
			}
		});
		 return false;
		 
	 });
	//idCheck 끝
	
	$("#cancelBtn").on("click",function(){
		location.href = "/member/loginForm";
	});
			
			
        });    
    </script>
</body>
</html>
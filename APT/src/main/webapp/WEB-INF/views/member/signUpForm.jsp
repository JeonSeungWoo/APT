<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=\, initial-scale=1.0" />
<title></title>
<link rel="stylesheet" href="/resources/css/common.css" />
<link rel="stylesheet" href="/resources/css/join.css" />
</head>
<body>
	<div class="wrap">
		<%@ include file="/resources/include/header.jsp"%>
		<div class="contents">
			<div class="join_box">
				<h2 class="join_title">Join</h2>

				<form id="form" method="get">
					<table class="join_table">
						<colgroup>
							<col style="width: 80px;" />
							<col style="width: 160px;" />
							<col style="width: 113px;" />
							<col style="width: 120px;" />
							<col style="width: 160px;" />
							<col style="width: 113px;" />
						</colgroup>
						<tbody>
							<tr>
								<th><label for="name">성명</label></th>
								<td colspan="2"><input type="text" id="name" name="name"
									placeholder="성명" /></td>
							</tr>
							<tr>
								<th><label for="id">아이디</label></th>
								<td colspan="2"><input type="text" id="id" name="userid"
									placeholder="아이디" /></td>
								<td><button class="check_id">중복확인</button></td>
								<td><span id="idCk"></span></td>
							</tr>
							<tr>
								<th><label for="pw">비밀번호</label></th>
								<td colspan="2"><input type="password" id="password"
									name="pw" placeholder="비밀번호" /></td>
								<th><label for="pw">비밀번호 확인</label></th>
								<td colspan="2"><input type="password" id="password_check"
									placeholder="비밀번호 확인" /></td>
							</tr>
							<tr>
								<th><label for="tel">전화번호</label></th>
								<td colspan="2"><input type="text" id="tel" name="phone"
									placeholder="전화번호" /></td>
								<td colspan="2"><span style="color: red;">핸드폰 번호는
										중간에 -를 붙여주세요. ex)010-xxxx-xxxx</span></td>
							</tr>
							<tr>
								<th><label for="apartment">아파트명</label></th>
								<td colspan="2"><input type="text" id="apartment"
									name="apartment" placeholder="아파트명" /></td>
							</tr>
							<tr>
								<th><label for="roadnameCode">주소</label></th>
								<td colspan="2">
								<input type="text" id="roadnameCode" name="roadnameCode" placeholder="우편번호" />
								</td>
								<td>
									<button type="button" class="find_address">우편번호 검색</button>
								</td>
							</tr>
							<tr>
								<td></td>

								<td colspan="2">
								<input type="text" id="address" name="address" placeholder="주소" /></td>
								<td colspan="4">
								<input type="text" id="address_detail" name="address_detail" placeholder="상세 주소" />
								</td>
							</tr>
						</tbody>
					</table>
					<p class="agreement">
						<label><input type="checkbox"
							id="agreement" />개인정보 약관에 대해 동의 합니다.</label> <a href="/agreement">약관보기</a>
					</p>
					<p class="noti">회원가입 시 정확한 정보를 입력하지 않는 경우 불이익이 생길 수 있습니다.</p>
					<button type="button" class="join_btn">회원 가입</button>
				</form>
			</div>
		</div>
		<%@ include file="/resources/include/footer.jsp"%>
	</div>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
		integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
		crossorigin="anonymous"></script>
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
          
        var btn = {};
        btn.find_address = $(".find_address");
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
              el.roadnameCode.val(data.zonecode);
              /* .attr("disabled", true); */
              el.address.val(addr);
              el.address_detail.focus();
            },
          }).open();
        }
        // event 연결
        btn.find_address.click(findAddressEvent);
      })();

    var form =$("#form");
      
  	var checkedId = false;
		//회원가입 시작
		$(".join_btn").on("click",function(){
			 
		     var userid  = $("#id").val(); 
			 var pw  = $("#password").val(); 
			 var password_check  = $("#password_check").val(); 
			 var name  = $("#name").val(); 
			 var tel  = $("#tel").val();
             var apartment = $("#apartment").val();

	      
	         var roadnameCode = $("#roadnameCode").val();
	         var address = $("#address").val();
	         var address_detail = $("#address_detail").val();


	         var tel_check = /^\d{2,3}-\d{3,4}-\d{4}$/;
	         
			//유효성 검사 
			if(name == "" || userid == ""  || pw == "" || password_check == "" || tel == ""
				|| apartment == "" || roadnameCode == "" || address == "" || address_detail == ""){
				alert("데이터를 입력해주세요");
				return false;
		    }else if(pw != password_check){
		    	alert("비밀번호가 서로 맞지 않습니다.");
              return false;
		    }else if(!$("input:checkbox[id='agreement']").is(":checked")){
		    	alert("개인정보 취급방침에 동의 해주세요.");
		     return false;
			 }else if(!tel_check.test(tel)){
				alert("핸드폰 번호가 이상합니다.");
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
$(".check_id").on("click",function(){
	var userid  = $("#id").val(); 
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
      
    </script>
</body>
</html>


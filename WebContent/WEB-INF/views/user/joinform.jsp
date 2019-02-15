<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
	$(function(){
		
		
		
		$("#join-form").submit(function(){
						
			//1.이름체크
			if($("#name").val() == ""){
				alert("이름을입력하세요");
				$("#name").focus();
				return false;
			}

			//2-1.이메일체크
			if($("#email").val() == ""){
				alert("이메일을입력하세요");
				$("#email").focus();
				return false;
			}
			//2-2 이메일 중복체크
			if($("#img-checkemail").is(":visible") == false){
				alert("이메일 중복체크를 해야합니다.");
				return false;
			}
			
			//3. 비밀번호 확인
			if($("input[type='password']").val() == ""){
				alert("비밀번호를 입력하세요");
				$("input[type='password']").focus();
				return false;
			}
			
			//4. 약관동의
			if( $("#agree-prov").is(":checked")== false){
				alert("약관동의를 체크해야 회원가입이 됩니다.");
				return false;
			}

			return true;
			
		});
		
		$("#email").keypress(function(){
			$("#btn-checkemail").show();
			$("#img-checkemail").hide();
		});
		
		$("#btn-checkemail").click(function(){
			var email =$("#email").val();
			if(email == ""){
				return;
			}
			
			$.ajax({
				url:"${pageContext.servletContext.contextPath }/api/user?a=ajax-checkemail&email=" + email,
				type:"get",
				dataType:"json",
				//data:"",
				success: function(response){
					if(response.exist == true){
						alert("이미 존재하는 이메일입니다. 다른 이메일을 사용해주세요");
						$("#email").val("").focus();
						return;
					}
					
					//사용가능한 이메일 
					$("#btn-checkemail").hide();
					$("#img-checkemail").show();
					
				},
				error:function(xhr, status, e){
					console.error(status+":"+e);
				}
			});
			
		});

	});
</script>
</head>
<body>
	<div id="container">
	
		<div id="header">
			<c:import url="/WEB-INF/views/includes/header.jsp"/>
		</div>
		
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post" action="${pageContext.servletContext.contextPath }/user">
					<input type="hidden" name="a" value="join"/>
					
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					<input id="btn-checkemail" type="button" value="이메일체크">
					<img id="img-checkemail"  style="width:20px; display:none" src="${pageContext.servletContext.contextPath }/assets/images/check.png"/>
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form>
			</div>
		</div>
		
		<div id="navigation">
			<c:import url="/WEB-INF/views/includes/navigation.jsp">
			</c:import>
		</div>
		
		<div id="footer">
			<c:import url="/WEB-INF/views/includes/footer.jsp"/>	
		</div>
		
	</div>
</body>
</html>
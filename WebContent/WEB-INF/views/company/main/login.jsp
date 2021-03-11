<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<style>

</style>
</head>
<body>
	
	<!-- 로그인 시작 -->

	<form method="POST" action="/yaneodo/company/main/loginok.do" id="form1">
		<div id="bLogin">
			<div id="subbox">
				<div id="title">관리자 계정 로그인</div>
				<div class="glyphicon glyphicon-remove" id="bLoginClose"
					style="color: gray; float: left;"></div>
				<div style="clear: both;"></div>
			</div>

			<div id="box">
				<div class="subbox">
					<input type="text" id="email" name="email"
						placeholder="회사 이메일(로그인 아이디로 사용됩니다.)" required>
				</div>

				<div class="subbox">
					<input type="password" id="password" name="password"
						placeholder="비밀번호" required>
				</div>


				<div>
					<input type="submit" class="subbox" id="bLoginBtn2" value="로그인">
				</div>
				<div id="subTitle">
					계정이 없으신가요? <a id="toBjoin"
						style="text-decoration: none; cursor: pointer;">관리자 계정 만들기</a>
				</div>
			</div>
			
			     
			     
			<!-- 			  
			<button type="button" onclick="test('sein22@gmail.com', 'sein123456');">승인X</button>
			<button type="button" onclick="test('muscle9897@naver.com', 'proteinbest9897');">승인O</button>
			-->

			
		</div>
	</form>


	<!-- 로그인 끝 -->

	<script>
	
	/* 
		function test(email, password) {
			$("#email").val(email);
			$("#password").val(password);
			$("#form1").submit();
		}	
	 */
	
	</script>
</body>
</html>
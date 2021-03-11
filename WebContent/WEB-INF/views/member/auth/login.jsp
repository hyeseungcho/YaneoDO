<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<style>
</style>
</head>
<body>

	<!-- 로그인 시작 -->
	
	<c:if test="${empty email}">
	<!-- 아이디 입력 -->
	<form method="POST" action="/yaneodo/member/login.do" id="form1">
		<div id="clogin">
			<div class="logo">
				yaneoDO
				<div class="glyphicon glyphicon-remove" id="emailClose"
					style="color: gray; float: left;"></div>
				<div style="clear: both;"></div>
			</div>
			<div id="title">
				직장인을 위한<br>커리어 플랫폼, 야너도!
			</div>
			
			<div class="subtitle">이메일</div>
				<div class="inputbox">
					<input type="text" id="email" name="email" placeholder="이메일을 입력해주세요." required>
			</div>
			
			<div class="subtitle">비밀번호</div>
				<div class="inputbox">
					<input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요." required>
			</div>
			
			
			<div>
				<input type="submit" id="btn1" value="로그인">
			</div>			
		</div>
	</form>
	</c:if>

	<!-- 비밀번호 입력 -->
	
<%-- 	<c:if test="${not empty email}">
	<form method="POST" action="/yaneodo/member/loginok.do" enctype="multipart/form-data" id="form2">
		<div id="cpassword">
			<div class="logo">
				yaneoDO
				<div class="glyphicon glyphicon-remove" id="cpasswordClose"
					style="color: gray; float: left;"></div>
				<div style="clear: both;"></div>
			</div>
			<div class="subtitle">비밀번호</div>
			<div class="inputbox">
				<input type="password" id="password" name="password"
					placeholder="비밀번호를 입력해주세요." required>
			</div>
			<div>
				<input type="submit" id="btn2" value="로그인">
			</div>
		</div>
	</form>
	</c:if> --%>
	
	
	<!-- 로그인 끝 -->


	<script>

    /* 로그인 창, 검색창 숨기기 */
    $(document).ready(function() {
        $("#clogin").hide();
        $("#cpassword").hide();
        $("#searchBox1").hide();
    });

    $("#emailClose").click(function() {
        $("#clogin").hide();
        $("#container").css("opacity", "1");
    });

    $("#cpasswordClose").click(function() {
        $("#clogin").hide();
        $("#container").css("opacity", "1");
    });
    
    
	</script>
</body>
</html>
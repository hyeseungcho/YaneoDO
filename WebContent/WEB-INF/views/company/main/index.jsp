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
<%@include file="/WEB-INF/views/company/main/login.jsp"%>
<%@include file="/WEB-INF/views/company/main/join.jsp"%>

<link rel="stylesheet" href="/yaneodo/css/company/main/main.css">
<link rel="stylesheet" href="/yaneodo/css/company/main/header.css">
<link rel="stylesheet" href="/yaneodo/css/company/main/footer.css">


<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/regHeader.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="contents">
		<div class="section" id="section1">
			<p>
				<span>사람</span>과 <span>일자리</span>를 가장<br> 인간적이고 효율적으로<br>
				<span>연결</span>합니다
			</p>
		</div>
		
		<div class="section" id="section2">
			<div class="section" id="subsection">
				<h1>야너도 서비스</h1>
				<ul id="service">
					<li>
						<h2>추천 채용</h2>
						<div>채용 확정 전까지 아무런 비용 부담없이, 200만 명의 추천인들로부터 최적의 인재를 추천 받으세요</div>
					</li>
					<li>
						<h2>매치업</h2>
						<div>300,000+명의 엄선된 경력자들 중에 맘에 드는 후보자에게 직접 면접을 제안하세요</div>
					</li>
					<li>
						<h2>네트워크 광고</h2>
						<div>한번의 신청으로 최대 500만명의 적극적, 잠재적 구직자들에게 채용정보를 알리세요</div>
					</li>
				</ul>
			</div>
		</div>

		<div class="section" id="section4">
			<h1>
				이제 야나도를 통해<br>최적의 후보자를<br>만나세요
			</h1>
			<ul id="service">
				<li><input type="button" class="btn btn-default btn-lg"
					value="서비스 문의" style="outline: none;">
					<div></div></li>
				<li><input type="button" class="btn btn-default btn-lg"
					value="시작하기" style="outline: none;">
					<div></div></li>
			</ul>
		</div>

	</div>


	<!-- ########## 푸터 시작 -->
	<%@include file="/WEB-INF/views/company/inc/regFooter.jsp"%>
	<!-- ########## 푸터 끝 -->




	<script>
		
	    $(document).ready(function() {
	        $("#bLogin").hide();
	        $("#bJoin").hide();
	    });
	
	    $("#bLoginBtn").click(function() {
	        $("#bLogin").show();
	        $("#container").css("opacity", ".8");
	    });
	
	    $("#bJoinBtn").click(function() {
	        $("#bJoin").show();
	        $("#container").css("opacity", ".8");
	    });
	
	    $("#bLoginClose").click(function() {
	        $("#bLogin").hide();
	        $("#container").css("opacity", "1");
	    });
	
	    $("#bJoinClose").click(function() {
	        $("#bJoin").hide();
	        $("#container").css("opacity", "1");
	    });
	
	
	    $("#toBjoin").click(function() {
	        $("#bLogin").hide();
	        $("#bJoin").show();
	    });
	
	    $("#toBlogin").click(function() {
	        $("#bJoin").hide();
	        $("#bLogin").show();
	    });
    
	</script>
</body>
</html>
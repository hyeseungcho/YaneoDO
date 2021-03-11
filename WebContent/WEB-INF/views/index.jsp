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
<%@include file="/WEB-INF/views/member/auth/login.jsp"%>
<%@include file="/WEB-INF/views/main/search.jsp"%>

<link rel="stylesheet" href="/yaneodo/css/main/main.css">
<link rel="stylesheet" href="/yaneodo/css/main/search.css">
<!-- <link rel="stylesheet" href="/yaneodo/css/member/member-main.css"> -->
<link rel="stylesheet" href="/yaneodo/css/member/header.css">
<link rel="stylesheet" href="/yaneodo/css/member/footer.css">
<link rel="stylesheet" href="/yaneodo/css/member/login.css">


<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script>

	$(document).ready(function(){
	    $('.slider').bxSlider();
	});

</script>

<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="slider">
		<ul class="bxslider">
			<li><img src="/yaneodo/images/mainSlider/random1.jpg" class="images"></li>
			<li><img src="/yaneodo/images/mainSlider/random2.jpg" class="images"></li>
			<li><img src="/yaneodo/images/mainSlider/random3.jpg" class="images"></li>
		</ul>
	</div>

	<div id="section">
		<div id="recommend">
			<div class="title">추천 공고</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="companyPic">
				</div>
				<div class="desc">SCM 매니저</div>
				<div class="desc sm">깃컴퍼니</div>
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="companyPic">
				</div>
				<div class="desc">SCM 매니저</div>
				<div class="desc sm">깃컴퍼니</div>
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="companyPic">
				</div>
				<div class="desc">SCM 매니저</div>
				<div class="desc sm">깃컴퍼니</div>
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="companyPic">
				</div>
				<div class="desc">SCM 매니저</div>
				<div class="desc sm">깃컴퍼니</div>
			</div>
			<div style="clear: both;"></div>
		</div>

		<div id="new">
			<div class="title">신규 채용 회사</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="companyPic">
				</div>
				<div class="desc">SCM 매니저</div>
				<div class="desc sm">깃컴퍼니</div>
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="companyPic">
				</div>
				<div class="desc">SCM 매니저</div>
				<div class="desc sm">깃컴퍼니</div>
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="companyPic">
				</div>
				<div class="desc">SCM 매니저</div>
				<div class="desc sm">깃컴퍼니</div>
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="companyPic">
				</div>
				<div class="desc">SCM 매니저</div>
				<div class="desc sm">깃컴퍼니</div>
			</div>
			<div style="clear: both;"></div>
		</div>

		<div id="theme">
			<div class="title">
				테마별 채용
				<div class="arrowsSm">
					<span class="glyphicon glyphicon-menu-left"></span> <span
						class="glyphicon glyphicon-menu-right"></span>
				</div>
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="themePic">
				</div>
				<div class="desc">포스트 코로나 시대에도 유망할 언택트 기업</div>
				<div class="desc sm">포스트 코로나 시대, 비대면 서비스를 제공하는 기업을 소개합니다.</div>
			</div>
			<div class="details">
				<div>
					<img src="/yaneodo/images/company/snow.jpg" class="themePic">
				</div>
				<div class="desc">포스트 코로나 시대에도 유망할 언택트 기업</div>
				<div class="desc sm">포스트 코로나 시대, 비대면 서비스를 제공하는 기업을 소개합니다.</div>
			</div>
			<div style="clear: both;"></div>
		</div>
	</div>





	<!-- ########## 푸터 시작 -->
	<%@include file="/WEB-INF/views/member/inc/footer.jsp"%>
	<!-- ########## 푸터 끝 -->


	<script>

		/* 슬라이더 */
        $(document).ready(function () {

            $('.bxslider').bxSlider({ // 클래스명 주의!
                auto: true, // 자동으로 애니메이션 시작
                speed: 1000,  // 애니메이션 속도
                pause: 2000,  // 애니메이션 유지 시간 (1000은 1초)
                mode: 'horizontal', // 슬라이드 모드 ('fade', 'horizontal', 'vertical' 이 있음)
                // autoControls: true, // 시작 및 중지버튼 보여짐
                // pager: true, // 페이지 표시 보여짐
                // captions: true, // 이미지 위에 텍스트를 넣을 수 있음
            });

        });

		
        //이메일으로 시작
        $("#btn1").click(function() {
            // 비밀번호 입력창 바로 보여주지 않고, 일치하는 이메일 있으면 비밀번호 입력창
            //일치하는 이메일 없으면 회원가입 페이지로 이동
            //location.href="register.html"
            // $("#clogin").hide();
            // $("#cpassword").show();
        });

        /* 로그인 */
        $("#btn2").click(function() {
            location.href="main.html";
        });

        $("#cpasswordClose").click(function() {
            $("#cpassword").hide();
        });

        $("#bSearchClose").click(function() {
            $("#searchBox1").hide();
            $("#headerContainer").show();
        });

		/* 검색창 */
        $(function(){
            $(document).mousedown(function( e ){
                if( $("#searchBox1").is(":visible") ) {
                    $("#searchBox1").each(function(){
                        var l_position = $(this).offset();
                        l_position.right = parseInt(l_position.left) + ($(this).width());
                        l_position.bottom = parseInt(l_position.top) + parseInt($(this).height());

                        if( ( l_position.left <= e.pageX && e.pageX <= l_position.right )
                            && ( l_position.top <= e.pageY && e.pageY <= l_position.bottom ) ) {
                        } else {
                            $(this).hide();
                        }
                    });

                $("#container").css("opacity", "1");
                
                }
            });
            
            $("#search").click(function(){
                if( !$("#searchBox1").is(":visible") ) {
                    $("#searchBox1").show();

                    $("#container").css("opacity", ".7");
                }
            });
        });
	    
	    
	</script>
</body>
</html>
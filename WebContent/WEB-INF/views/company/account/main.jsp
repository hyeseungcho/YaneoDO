<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/account/account.css">
<link rel="stylesheet" href="/yaneodo/css/company/account/main.css">
<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	   <%@include file="/WEB-INF/views/company/inc/header.jsp" %>
	<!-- ########## 상단 헤더 끝 -->
		
	 <div id="container">


        <!-- section-header -->
        <div class="section-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-10">
                        <div class="section-title" onclick="location.href='/project/views/account/main.html';"><h1>계정관리</h1></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- section-header end -->
       <!-- sidemenu -->
       <div id="side-menu">
        <div class="side-menu-profile">
            <div class="profile-name"><span>홍길동</span></div>
            <div class="profile-info"><span>test@test.com</span></div>
            <div class="profile-info"><span>010-1234-5678</span></div>
            <div class="profile-btn"><input type="button" class="btn btn-default" value="기본정보 수정"></div>
        </div>
        <div class="side-menu-info container">
            <div class="row">
                <div class="col-md-9">
                    좋아요
                </div>
                <div class="col-md-3">
                    0
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    지원자
                </div>
                <div class="col-md-3">
                    0
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    최종합격자
                </div>
                <div class="col-md-3">
                    0
                </div>
            </div>

        </div>
        <div class="side-menu-info-link container">
            <div class="row">
                <div class="col-md-9">
                    <a href="#">받은알림</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9 submenu">
                    <a href="#">좋아요</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9 submenu">
                    <a href="#">면접제안 수락</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9 submenu">
                    <a href="#">새로운 지원자</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9">
                    통계(시간되면)
                </div>
            </div>
            <div class="row">
                <div class="col-md-9 submenu">
                    <a href="#">통계</a>
                </div>
            </div>

        </div>
    </div>
    <!-- sidemenu 끝 -->

        <!-- content -->
        <div id="content">
            <div class="content-header">기본정보 수정</div> 
            <div class="content-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">이름</div>
                        <div class="col-md-8"><input type="text" class="form-control"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">연락처</div>
                        <div class="col-md-8"><input type="text" class="form-control"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-3 btnedit">
                            <input type="button" class="btn btn-primary" value="수정하기">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="clear: both;"></div>
        <!-- content 끝 -->
	
	</div>
	<!-- ########## 하단 푸터 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 하단 푸터 끝 -->
	
	<script>

	</script>
</body>
</html>
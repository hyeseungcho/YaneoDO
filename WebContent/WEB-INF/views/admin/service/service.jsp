<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>
    <link rel="stylesheet" href="/yaneodo/css/admin/admin-service.css?ver=1.1">

    
</head>
<body>
	<!-- header -->
	<div id="header">
	
		<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	
	</div>
	<div style="clear:both;"></div>
    
    <div>
    	<section>
            <div class="back-img">
                <div id="search">
                    <input type="search" name="search" id="search" placeholder="검색창 예)">
                    <input type="submit" name="commit" value="검색">
                </div>
            </div>
        </section>
        <section id="pageAll" style="background-color: transparent; height: 800px;">
            <section>
                <div class="col-sm-12 col sx-12 col-md-12" id="question">
                    <ul class="category-list navigator text-center" id="with-id">
                        <li id="customerMember" class="col-sm-6" style="border-radius:5px;">
                            <a href="#" class="main-cat-li">
                                <span class="category-icon"></span>
                                <h3 class="mainct-inner">개인회원</h3>
                                <p> 개인회원을 위한 이용 안내입니다.</p>
                            </a>
                        </li>   
                        <li id="businessMember" class="col-sm-6" style="border-radius:5px;">
                            <a href="#" class="main-cat-li">
                                <span class="category-icon"></span>
                                <h3 class="mainct-inner">기업회원</h3>
                                <p>  기업회원을 위한 이용 안내입니다.</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </section>
            <section>
                <div class="container">
                    <div class="col-sm-6">
                        <section class="article">
                            <h3>개인 회원 자주 묻는 질문</h3>
                            <ul class="article-list">
                                <li>
                                    <a href="#">아이디를 변경하고 싶어요.</a>
                                </li>
                                <li>
                                    <a href="#">계정 비밀번호를 잃어버렸어요.</a>
                                </li>
                                <li>
                                    <a href="#">개인회원 탈퇴는 어떻게 하나요?.</a>
                                </li>
                            </ul>
                        </section>
                    </div>
                    <div class="col-sm-6">
                        <section class="article">
                            <h3>기업 회원 자주 묻는 질문</h3>
                            <ul class="article-list">
                                <li>
                                    <a href="#">기업 서비스 가입, 이용 절차가 궁금합니다.</a>
                                </li>
                                <li>
                                    <a href="#">매치업 기업 서비스를 이용하고 싶어요.</a>
                                </li>
                                <li>
                                    <a href="#">등록된 기업회원 회사 정보는 어디에 노출되나요?</a>
                                </li>
                            </ul>
                        </section>
                    </div>
                </div>
            </section>
        </section>
    </div>
    
    <!-- footer -->
	<div id="footer">
	
		<%@include file="/WEB-INF/views/admin/form/footer.jsp" %>
	
	</div>
	
</body>
</html>
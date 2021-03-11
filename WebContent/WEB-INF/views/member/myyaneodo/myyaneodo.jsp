<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<!-- 적용CSS -->
<link rel="stylesheet" href="/yaneodo/css/member/member-main.css">
<link rel="stylesheet" href="/yaneodo/css/member/member-menu.css">
<style>

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	
	
	  <section class="container"> 
            
<%@include file="/WEB-INF/views/member/inc/mymenu.jsp" %>
           

            <div id="right">
             
                <div id="status" class="table">
                    <div class="title2">지원현황</div>
                    <ul>
                    <li><a class="count" href="/yaneodo/member/status/applied_status.do?status=지원 완료">${cntComplete}<div class="state">지원 완료</div></a></li>
                    <li><a class="count" href="/yaneodo/member/status/applied_status.do?status=서류 통과">${cntResumePass}<div class="state">서류 통과</div></a></li>
                    <li><a class="count" href="/yaneodo/member/status/applied_status.do?status=최종 합격">${cntPass}<div class="state">최종 합격</div></a></li>
                    <li><a class="count" href="/yaneodo/member/status/applied_status.do?status=불합격">${cntFail}<div class="state">불합격</div></a></li>

                    </ul>
                </div>
            </div>
            <div id="rightDown">
                <div id="recoPosition"  class="table">
                    <div class="title2">추천포지션</div>
               <div class="recoList">
                <div class="details">
                    <div><img src="/yaneodo/images/company/company.png" class="companyPic"></div>
                    <div class="desc">프론트엔드 개발자</div>
                    <div class="desc sm">(주)한동디벨로프</div>
                </div>
                <div class="details">
                    <div><img src="/yaneodo/images/company/company01.png" class="companyPic"></div>
                    <div class="desc">프론트엔드 개발자</div>
                    <div class="desc sm">메가존클라우드(주)</div>
                </div>
                <div class="details">
                    <div><img src="/yaneodo/images/company/company02.png" class="companyPic"></div>
                    <div class="desc">프론트엔드 엔지니어</div>
                    <div class="desc sm">엔에이치엔(주)</div>
                </div>
                <div class="details">
                    <div><img src="/yaneodo/images/company/company03.png" class="companyPic"></div>
                    <div class="desc">프론트엔드 개발자</div>
                    <div class="desc sm">(주)바바리퍼블리카</div>
                </div>
                <div style="clear: both;"></div>
        	</div>
                </div>
            </div>
            <div style="clear: both;"></div>
         </div>
        </section>
	
	<scirpt>
		
	</scirpt>
</body>
</html>
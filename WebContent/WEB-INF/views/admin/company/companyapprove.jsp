<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

    <link rel="stylesheet" href="/yaneodo/css/admin/admin-company.css?ver=1.1">
    
</head>
<body>
	<!-- header -->
	<div id="header">
	
		<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	
	</div>
	<div style="clear:both;"></div>
    
    <div id="pageAll" style="height: 1300px;">
    
    	<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>

        <section id="contents">
            <div id="subtitle">기업 정보</div>
            <div id="business">
            	<form method="POST" action="/yaneodo/admin/company/companyapproveok.do">
                <div><img src="/yaneodo/images/admin/company.png" alt="회사" style="display: block; margin: 10px 10px; margin-right: 30px; width: 400px; height: 250px; float: left;"></div>
                <div class="state">기&nbsp업&nbsp명&nbsp&nbsp&nbsp&nbsp <span>${companydto.companyName}</span></div>
                <div class="state">주&nbsp&nbsp&nbsp&nbsp&nbsp소&nbsp&nbsp&nbsp&nbsp <span>${companydto.address}</span></div>
                <div class="state">직&nbsp원&nbsp수&nbsp&nbsp&nbsp&nbsp <span>${companydto.employeeNum}</span></div>
                <div class="state">매&nbsp출&nbsp액&nbsp&nbsp&nbsp&nbsp <span><fmt:formatNumber type="number" maxFractionDigits="3" value="${companydto.sales}" /></span></div>
                <div class="state">이&nbsp메&nbsp일&nbsp&nbsp&nbsp&nbsp <span>${companydto.companyEmail}</span></div>
                <div class="state">사업자 등록번호&nbsp&nbsp&nbsp&nbsp <span>${companydto.regNum}</span></div>
                <br>
                <div class="business-info">담당자</div>
                <div class="state">담당자 이름</div>
                <div class="business-state">${companydto.managerName}</div>
                <br>
                <div class="state">담당자 번호</div>
                <div class="business-state">${companydto.managerPhone}</div>
                <br>
                <div class="state">담당자 이메일</div>
                <div class="business-state">${companydto.managerEmail}</div>
                <br>
                <div class="business-info">회사소개</div>
                <div class="state">웹주소</div>
                <div class="business-state"><a href="${companydto.webAddress}">${companydto.webAddress}</a></div>
                <br>
                <div class="state">설립년도</div>
                <div class="business-state">${companydto.establishment}</div>
                <br>
                <div class="state">산업군</div>
                <div class="business-state">${companydto.industry}</div>
                <br>
                <div class="state">회사/서비스소개</div>
                <div class="business-state">${companydto.introduction}</div>
                 
            </div>
            <div>
                <input type="button" value="목록" class="btn btn-default" onclick="location.href='/yaneodo/admin/company/companyapprovelist.do?&page=${page}'">
                <input type="submit" value="승인" class="btn btn-primary"> 
                
                <input type="hidden" name="companyseq" value="${companydto.companySeq}">
                <input type="hidden" name="page" value="${page}">
            </div>
            </form>
        </section>
    </div>
    
    <!-- footer -->
	<div id="footer">
	
		<%@include file="/WEB-INF/views/admin/form/footer.jsp" %>
	
	</div>
</body>
</html>
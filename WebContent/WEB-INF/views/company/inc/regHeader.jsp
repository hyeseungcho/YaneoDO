<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="cheaderContainer">
	<nav id="rightmenu">
		<div id="logo">yaneoDO</div>
		<ul>
			<!-- 기업관리자 로그인 전 -->
			<c:if test="${empty cmemail}">
				<li><a class="bmenuLink" id="bLoginBtn">채용담당자 로그인</a></li>
				<li><a class="bmenuLink" id="bJoinBtn">관리자 가입</a></li>
			</c:if>

			<!-- 기업관리자 로그인 후 -->
			<c:if test="${not empty cmemail}">
				<li><a href="/yaneodo/company/main/logout.do"class="bmenuLink" id="bLogoutBtn">로그아웃</a></li>
				
				<!-- 로그인 & 기업 미등록 -->
				<c:if test="${cmstate == null}">
				<li><a href="/yaneodo/company/main/register.do" class="bmenuLink" id="regCompany">기업등록</a></li>
				</c:if>
				
				<!-- 로그인 & 기업 등록 & 미승인 -->
				<c:if test="${cmstate == '0'}">
				<li><a href="/yaneodo/company/main/registered.do?seq=${cmseq}" class="bmenuLink" id="regCompany">기업등록</a></li>
				</c:if>

			</c:if>
	
	
			<!-- 공통 -->
			<li><a href="/yaneodo/index.do" class="bmenuLink" id="home">야너도 홈</a></li>
			<div style="clear: both;"></div>
			
		</ul>
	</nav>
</div>
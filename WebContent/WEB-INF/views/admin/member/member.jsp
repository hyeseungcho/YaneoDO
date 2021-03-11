<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

    <link rel="stylesheet" href="/yaneodo/css/admin/admin-member.css">

</head>
<body>
	<!-- header -->
	<div id="header">
	
		<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	
	</div>
	<div style="clear:both;"></div>
    
    <div id="pageAll" style="height: 1500px;">
    
    	<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>

        <section id="contents" style="height: 1500px;">
            <div id="subtitle">회원 정보</div>
            <div id="member">
            	<c:if test="${memberdto.photo eq 'null'}">
                	<div><img src="/yaneodo/images/admin/user.png" alt="기본" style="width: 80px; height: 80px;"></div>
                </c:if>
                <c:if test="${memberdto.photo ne 'null'}">
                	<div><img src="/yaneodo/images/admin/${dto.photo}" alt="${dto.photo}"></div>
                </c:if>
                
                <div id="member-name">${memberdto.name}</div>

                <br><br>

                <div class="member-info">개인 정보</div>
                <br>
                <div class="state">이메일</div>
                <div class="member-state">${memberdto.email}</div>
                <br>
                <div class="state">닉네임</div>
                <div class="member-state">${memberdto.nickname}</div>
                <br>
                <div class="state">연락처</div>
                <div class="member-state">${memberdto.phone}</div>
                <br>
                <div class="state">생년월일</div>
                <div class="member-state">${memberdto.birth}</div>

                <br><br>

                <div class="member-info">활동 정보</div>
                <br>
                <div class="state">가입날짜</div>
                <div class="member-state">${memberdto.joinDate}</div>
                <br>
                <div class="state">마지막 로그인</div>
                <div class="member-state">${memberdto.lastJoin}</div>
                <br>
                <div class="state">작성</div>
                <div class="member-count">좋아요 <span>${memberdto.likeCnt} 개</span> </div>
                <div class="member-count">북마크 <span>${memberdto.bookMarkCnt} 개</span> </div>
                <div class="member-count">게시물 <span><c:out value="${memberdto.boardCnt + memberdto.qnaCnt}" /> 개 (자유게시판 : ${memberdto.boardCnt} 개 + Q&A게시판 : ${memberdto.qnaCnt} 개)</span> </div>
                <div class="member-count">댓  글 <span><c:out value="${memberdto.boardCommentCnt + memberdto.qnaCommentCnt}" /> 개 (자유게시판 : ${memberdto.boardCommentCnt} 개 + Q&A게시판 : ${memberdto.qnaCommentCnt} 개)</span> </div>

                <br><br>
				
				<c:forEach items="${resumeList}" var="resumedto">
                <div class="member-info">자기소개 & 이력서</div>
                <div id="member-introduce">${resumedto.introduce}</div>
                <div style="margin-bottom: 20px;"><a href="http://naver.com">${resumedto.orgfilename}</a></div>
                </c:forEach>
            </div>
            <div>
                <input type="button" value="목록" class="btn btn-default" onclick="location.href='/yaneodo/admin/member/memberlist.do?page=${page}'">
            </div>
        </section>
    </div>
    
    <!-- footer -->
	<div id="footer">
	
		<%@include file="/WEB-INF/views/admin/form/footer.jsp" %>
	
	</div>
</body>
</html>
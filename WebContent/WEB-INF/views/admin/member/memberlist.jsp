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

    <div id="pageAll" style="height: 1200px;">
	    
    	<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>

        <section id="contents" style="height: 1200px;">
            <div id="memberManager">
                <div id="subtitle">회원 목록</div>
                <div id="select">
                    <select name="order" id="order" style="width: 120px; height: 30px; font-size: 1.0em;">
                        <option value="이름순">이름순</option>
                        <option value="가입일순">가입일순</option>
                    </select>
                </div>
            </div>
            <div>
                <table id="memberList">
                    <thead>
                        <tr>
                            <th>프로필 사진</th>
                            <th>이름</th>
                            <th>닉네임</th>
                            <th>이메일</th>
                            <th>연락처</th>
                            <th>가입날짜</th>
                            <th>마지막접속</th>
                        </tr>
                    </thead>
                    <tbody>
           	
                    	<c:if test="${list.size() == 0}">
                    	<tr>
                    		<td colspan="7" style="text-align:center;">회원이 없습니다.</td>
                    	</tr>
                    	</c:if>
                    
                    	<c:forEach items="${list}" var="dto">
                        <tr onclick="location.href='/yaneodo/admin/member/member.do?customerseq=${dto.customerSeq}&page=${nowPage}'">
                        	<c:if test="${dto.photo eq null}">
                            	<td class="profile"><img src="/yaneodo/images/admin/user.png" alt="기본" style="width: 80px; height: 80px;"></td>
                            </c:if>
                            <c:if test="${dto.photo ne null}">
                            	<td class="profile"><img src="/yaneodo/images/admin/${dto.photo}" alt="${dto.photo}" style="width: 80px; height: 80px;"></td>
                            </c:if>
                            <td class="name">${dto.name}</td>
                            <td class="nick">${dto.nickname}</td>
                            <td class="email">${dto.email}</td>
                            <td class="phone">${dto.phone}</td>
                            <td class="joindate">${dto.joinDate}</td>
                            <td class="lastdate">${dto.lastJoin}</td>
                        </tr>
						</c:forEach>
						
                    </tbody>
                </table>
            </div>

            <div style="clear: both;"></div>

            <nav class="pagebar" style="text-align: center;">
                <ul class="pagination">
                    ${pagebar}
                </ul>
            </nav>
        </section>
    </div>
    
    <!-- footer -->
	<div id="footer">
	
		<%@include file="/WEB-INF/views/admin/form/footer.jsp" %>
	
	</div>
	
</body>
</html>






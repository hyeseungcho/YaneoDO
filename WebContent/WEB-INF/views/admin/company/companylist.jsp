<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

    <link rel="stylesheet" href="/yaneodo/css/admin/admin-company.css">

</head>
<body>
	<!-- header -->
	<div id="header">
	
		<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	
	</div>
	<div style="clear:both;"></div>

    <div id="pageAll" style="height: 1700px;">
    
    	<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>

        <section id="contents">
            <div id="businessManager">
                <div id="subtitle">기업회원 목록</div>
            </div>
            <div>
                <table id="businessList">
                    <thead>
                        <tr>
                            <th>기업사진</th>
                            <th>기업명</th>
                            <th>사업자등록번호</th>
                            <th>기업메일</th>
                            <th>기업주소</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:if test="${list.size() == 1}">
                    	<tr>
                    		<td colspan="5" style="text-align:center;">회원이 없습니다.</td>
                    	</tr>
                    	</c:if>
                    
                    	<c:forEach items="${list}" var="dto">
                    	<c:if test="${dto.state == 1}">
                        <tr onclick="location.href='/yaneodo/admin/company/company.do?companyseq=${dto.companySeq}&page=${nowPage}'">
                        	<c:if test="${empty dto.companyPhoto}">
                            	<td class="profile"><img src="/yaneodo/images/admin/company.png" alt="기본" style="width: 200px;"></td>
                            </c:if>
                            <c:if test="${!empty dto.companyPhoto}">
                            	<td class="profile"><img src="/yaneodo/images/admin/${dto.companyPhoto}" alt="${dto.companyPhoto}" style="width: 200px;"></td>
                            </c:if>
                            <td class="business-name">${dto.companyName}</td>
                            <td class="business-tel">${dto.regNum}</td>
                            <td class="business-email">${dto.companyEmail}</td>
                            <td class="business-address">${dto.address}</td>
                        </tr>
                        </c:if>
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
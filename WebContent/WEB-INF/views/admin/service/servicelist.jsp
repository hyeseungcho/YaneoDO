<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

    <link rel="stylesheet" href="/yaneodo/css/admin/admin-service.css">

</head>
<body>
	<!-- header -->
	<div id="header">
	
		<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	
	</div>
	<div style="clear:both;"></div>

    <div id="pageAll">
    
    	<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>

        <section id="contents">
            <div id="questionManager">
                <div id="subtitle">고객센터 질문</div>
            </div>
            <div>
                <table id="questionList">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>이메일</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="number">1</td>
                            <td class="title">고객센터 운영시간이 어떻게 되나요??</td>
                            <td class="email">abcd4501@naver.com</td>
                            <td class="date">02.08</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </section>
        <div style="clear: both;"></div>
        
    </div>
</body>
</html>
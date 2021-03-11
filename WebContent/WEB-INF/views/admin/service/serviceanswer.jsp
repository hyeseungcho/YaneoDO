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
                <div id="subtitle">고객센터 답변</div>
            </div>
            <div class="questionService">
                <table id="question-query">
                    <thead>
                        <tr>
                            <th>
                                <span class="seq">1.</span>
                                <span class="subject">제목</span>
                                <span class="regdate">날짜</span>
                            </th>
                        </tr>
                        <tr>
                            <th colspan="3">
                                <span class="email">abcd4501@naver.com</span>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="content">
                                내용
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div id="answerManager">
                <div id="subtitle">답변하기</div>
            </div>
            <div class="answerService">
                <div class="receiver-email">받는 사람 : abcd4501@naver.com</div>
                <textarea name="answertext" id="answertext" cols="110" rows="10"></textarea>
            </div>
            <div class="input">
                <input type="button" name="submit" id="submit" value="전송" class="btn btn-default">
                <input type="button" name="cancel" id="cancel" value="취소" class="btn btn-default">    
            </div>
        </section>
        <div style="clear: both;"></div>
        
    </div>
</body>
</html>
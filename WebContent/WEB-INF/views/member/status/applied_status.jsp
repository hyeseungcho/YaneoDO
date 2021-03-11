<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   <div class="container">
        <div class="title">지원 현황</div>
        <div class="content">
            <!-- 메뉴 -->
            <div class="aside-nav-group">
                <div class="aside-nav-header">지원</div>
                <div id="applied" class="aside-nav-item-selected">지원한 포지션</div>
                
                <div id="writing" class="aside-nav-item" ><span id="state">작성중</span><div class="aside-nav-label">${cntWriting}</div></div>
            </div>

			
            <div id="appliedPosition" class="appliedPosition">
                <div id="status-items" class="status-items">
                    <a id="all" class="status-link" > <dl><dt>${cntAll}</dt><dd id="allK">전체</dd></dl></a>
                    <a id="complete" class="status-link" > <dl><dt>${cntComplete}</dt><dd id="completeK">지원 완료</dd></dl></a>
                    <a id="resumePass" class="status-link" > <dl><dt>${cntResumePass}</dt><dd id="resumePassK">서류 통과</dd></dl></a>
                    <a id="pass" class="status-link" > <dl><dt>${cntPass}</dt><dd id="passK">최종 합격</dd></dl></a>
                    <a id="fail" class="status-link" > <dl><dt>${cntFail}</dt><dd id="failK">불합격</dd></dl></a>
                </div>
			<form method="GET" action="/yaneodo/member/status/applied_status.do">
                <div class="status-company">
                    <div class="status-check">
                    	<c:if test="${not empty list.size()}">
                        <span>총 ${list.size()}건</span>
                        </c:if> 
						<c:if test="${empty list.size()}">
                        <span>총 0건</span>
                        </c:if> 
                        <div id="status-search">
                        <span class="glyphicon glyphicon-search"></span><input type="text" placeholder="회사/지원자명 검색">
                        </div>
                        <div style="clear: both;"></div>
                    </div>
                 
                    <table id="statusTable" class="table table-striped ">
                        <tr>
                            <th>지원 회사</th>
                            <th>지원 포지션</th>
                            <th>작성일</th>
                            <th>진행상태</th>
                        </tr>
                        
                         <c:forEach items="${list}" var="dto"> 
                        <tr class="tableSel">
                            <td>${dto.cname}</td>
                            <td>${dto.job}</td>
                            <td>${dto.applyDate}</td>
                            <td>${dto.applyStatus}</td>
                        </tr>
				 		</c:forEach>
				 		<c:if test="${empty list}">
                        <tr>
                            <td colspan="5" style="text-align: center; padding-top: 60px; color:#ccc;"> 요청하신 검색자료가 없습니다.</td>
                        </tr>
                        </c:if>
                        
                        
       				</table>
       				
                </div>
                 </form>
                 
                <nav id="pagebar" class="pagebar">
                    <ul class="pagination">
                        ${pagebar}
                    </ul>
                </nav>
                
<%--                  <nav id="pagebar2" class="pagebar">
                    <ul class="pagination">
                        ${pagebar}
                    </ul>
                </nav> --%>
            </div>
        
        </div>
    </div>    
<script>

	$("#all").click(function(){
   	location.href="/yaneodo/member/status/applied_status.do?";
	});


	$("#complete").click(function(){
	   	location.href="/yaneodo/member/status/applied_status.do?status=" + $("#completeK").text();
	});

	$("#resumePass").click(function(){
	   	location.href="/yaneodo/member/status/applied_status.do?status=" + $("#resumePassK").text();
	});

	$("#pass").click(function(){
	   	location.href="/yaneodo/member/status/applied_status.do?status=" + $("#passK").text();
	});

	$("#fail").click(function(){
	   	location.href="/yaneodo/member/status/applied_status.do?status=" + $("#failK").text();
	});

   $("#writing").click(function(){
	   	location.href="/yaneodo/member/status/applied_status.do?status=" + $("#state").text();

	   });
    
   $("#applied").click(function(){
	   location.href="/yaneodo/member/status/applied_status.do";

   });
   
   <c:if test="${status == '작성중'}">
   $("#status-items").css("display","none");
   $("#writing").addClass("aside-nav-item-selected");
   $("#writing").removeClass("aside-nav-item");
   $("#applied").removeClass("aside-nav-item-selected");
   $("#applied").addClass("aside-nav-item");

   </c:if>
/*    <c:if test="${status == null}">
   $("#pagebar").css("display","block");
   $("#pagebar2").css("display","none");
   </c:if>
   
   <c:if test="${status != null}">
   $("#pagebar").css("display","none");
   $("#pagebar2").css("display","block");
   </c:if> */
   
   <c:if test="${status != '작성중'}">
   $("#status-items").css("display","block");
   $("#writing").addClass("aside-nav-item");
   $("#writing").removeClass("aside-nav-item-selected");
   $("#applied").removeClass("aside-nav-item");
   $("#applied").addClass("aside-nav-item-selected");
 	$("#status-items").css("color","#86939E");
   	$("#status-items").css("cursor","pointer");
 	$("#all").css("color","black");
   	
   </c:if>
   <c:if test="${status == '지원 완료'}">
  	$("#all").css("color","#86939E");
   	$("#status-items").css("color","#86939E");
   	$("#complete").css("color","black");
   </c:if>
   <c:if test="${status == '서류 통과'}">
 	$("#all").css("color","#86939E");
  	$("#status-items").css("color","#86939E");
   	$("#resumePass").css("color","black");
   </c:if>
   <c:if test="${status == '최종 합격'}">
 	$("#all").css("color","#86939E");
  	$("#status-items").css("color","#86939E");
   	$("#pass").css("color","black");
   </c:if>
   <c:if test="${status == '불합격'}">
 	$("#all").css("color","#86939E");
  	$("#status-items").css("color","#86939E");
   	$("#fail").css("color","black");
   </c:if>
     

</script>
</body>
</html>
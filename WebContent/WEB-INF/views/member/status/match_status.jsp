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

    <div class="title">제안받기 현황</div>
    <div class="content">
        <div class="aside-nav-group" style="border-bottom: 0px;">
            
            <div class="aside-nav-header">나를 원하는 회사</div>

            <div id="want" class="aside-nav-item-selected">원해요<div class="aside-nav-label">${wantcount}</div></div>
            <div id="read" class="aside-nav-item">프로필 열람<div class="aside-nav-label">${readcount}</div></div>
            <div id="match" class="aside-nav-item">받은 제안<div class="aside-nav-label">${matchcount}</div></div>

        </div>
        
		<!-- 원해요 목록 -->
        <div id="wantlist" class="appliedPosition">

            <div class="status-company">
                <div class="status-check">
                	<c:if test="${not empty wantlist.size()}">
                       <span>총 ${wantlist.size()}건</span>
                      </c:if> 
					<c:if test="${empty wantlist.size()}">
                       <span>총 0건</span>
                       </c:if> 
                    <div id="status-search">
                    <span class="glyphicon glyphicon-search"></span><input type="text" placeholder="회사/지원자명 검색">
                    </div>
                    <div style="clear: both;"></div>
                </div>
                <table id="statusTable" class="table table-striped ">
                    <tr>
                        <th>회사명</th>
                        <th>지역</th>
                        <th>일자</th>
                    </tr>
                    <c:forEach items="${wantlist}" var="dto">
                    <tr class="tableSel">
                        <td>${dto.cname}</td>
                        <td>${dto.region}</td>
                        <td>${dto.dibDate}</td>
                    </tr>
					</c:forEach>
				 	<c:if test="${empty wantlist}">
                        <tr>
                            <td colspan="5" style="text-align: center; padding-top: 60px; color:#ccc;"> 요청하신 검색자료가 없습니다.</td>
                        </tr>
                     </c:if>
				</table>
            </div>
           	<nav class="pagebar">
                   <ul class="pagination">
                        ${pagebar}
                    </ul>
                </nav>
        </div>
        <!-- 이력서 열람 목록 -->
         <div id="readlist" class="appliedPosition" style="display:none;">

            <div class="status-company">
                <div class="status-check">
                	<c:if test="${not empty readlist.size()}">
                       <span>총 ${readlist.size()}건</span>
                      </c:if> 
					<c:if test="${empty readlist.size()}">
                       <span>총 0건</span>
                       </c:if> 
                    <div id="status-search">
                    <span class="glyphicon glyphicon-search"></span><input type="text" placeholder="회사/지원자명 검색">
                    </div>
                    <div style="clear: both;"></div>
                </div>
                <table id="statusTable" class="table table-striped ">
                    <tr>
                        <th>회사명</th>
                        <th>지역</th>
                        <th>열람일자</th>
                    </tr>
            	        <c:forEach items="${readlist}" var="dto2">
                    <tr class="tableSel">
                        <td>${dto2.cname}</td>
                        <td>${dto2.region}</td>
                        <td>${dto2.readDate}</td>
                    </tr>
					</c:forEach>
				 	<c:if test="${empty readlist}">
                        <tr>
                            <td colspan="5" style="text-align: center; padding-top: 60px; color:#ccc;"> 요청하신 검색자료가 없습니다.</td>
                        </tr>
                     </c:if>
				</table>
            </div>
              <nav class="pagebar">
                   <ul class="pagination">
                        ${pagebar2}
                    </ul>
                </nav>
        </div>
        
        <!--면접제안 목록 -->
         <div id="matchlist" class="appliedPosition" style="display: none">

            <div class="status-company">
                <div class="status-check">
                	<c:if test="${not empty matchlist.size()}">
                       <span>총 ${matchlist.size()}건</span>
                      </c:if> 
					<c:if test="${empty matchlist.size()}">
                       <span>총 0건</span>
                       </c:if> 
                    <div id="status-search">
                    <span class="glyphicon glyphicon-search"></span><input type="text" placeholder="회사/지원자명 검색">
                    </div>
                    <div style="clear: both;"></div>
                </div>
                <table id="statusTable" class="table table-striped">
                    <tr id="match">
                        <th style="width:30%;">회사명</th>
                        <th style="width:15%;">지역</th>
                        <th style="width:15%;">직무</th>
                        <th style="width:10%;">연봉</th>
		                <th style="width:10%;">상태</th>        
                        <th style="width:25%;">제안일자</th>
                    </tr>
                    <c:forEach items="${matchlist}" var="dto3">
                    <tr class="tableSel">
                        <td>${dto3.cname}</td>
                        <td>${dto3.region}</td>
                        <td>${dto3.position}</td>
                        <td>${dto3.income}</td>
                        <td>${dto3.state}</td>
                        <td>${dto3.matchDate}</td>
                    </tr>
					</c:forEach>
				 	<c:if test="${empty matchlist}">
                        <tr>
                            <td colspan="5" style="text-align: center; padding-top: 60px; color:#ccc;"> 요청하신 검색자료가 없습니다.</td>
                        </tr>
                     </c:if>
				</table>
            </div>
              <nav class="pagebar">
                   <ul class="pagination">
                        ${pagebar3}
                    </ul>
                </nav>
			</div>
    </div>
</div>    

<script>
	var flag1="true";
	var flag2="false";
	var flag3="false";

	$("#want").click(function(){
		flag1="true";
		flag2="false";
		flag3="false";
		$("#wantlist").css("display","block");
		$("#readlist").css("display","none");
		$("#matchlist").css("display","none");
		$("#want").addClass("aside-nav-item-selected");
		$("#read").addClass("aside-nav-item");
		$("#match").addClass("aside-nav-item");
		$("#want").removeClass("aside-nav-item");
		$("#read").removeClass("aside-nav-item-selected");
		$("#match").removeClass("aside-nav-item-selected");
	});

	$("#read").click(function(){
		flag1="true";
		flag2="false";
		flag3="false";
		$("#wantlist").css("display","none");
		$("#readlist").css("display","block");
		$("#matchlist").css("display","none");
		$("#want").addClass("aside-nav-item");
		$("#read").addClass("aside-nav-item-selected");
		$("#match").addClass("aside-nav-item");
		$("#want").removeClass("aside-nav-item-selected");
		$("#read").removeClass("aside-nav-item");
		$("#match").removeClass("aside-nav-item-selected");
	});
	
	$("#match").click(function(){
		flag1="true";
		flag2="false";
		flag3="false";
		$("#wantlist").css("display","none");
		$("#readlist").css("display","none");
		$("#matchlist").css("display","block");
		$("#want").addClass("aside-nav-item");
		$("#read").addClass("aside-nav-item");
		$("#match").addClass("aside-nav-item-selected");
		$("#want").removeClass("aside-nav-item-selected");
		$("#read").removeClass("aside-nav-item-selected");
		$("#match").removeClass("aside-nav-item");
	});




</script>
</body>
</html>

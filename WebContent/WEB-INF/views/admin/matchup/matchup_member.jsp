<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매치업 관리</title>
<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>

<link rel="stylesheet" href="/yaneodo/css/admin/admin.css">
<link rel="stylesheet" href="/yaneodo/css/admin/matchup_admin.css">
    

<style>

	
	
</style>

</head>
<body>
	<!-- header -->
	<div id="header">
	<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	</div>
	<div style="clear:both;"></div>
	
	<div id = outline>
	
			<div id="leftSide" style="float:left; background-color: white;">
			<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>
			</div>
		
			 <div id="content">
			 
			 <div id="jobtype">매칭 관리</div>
			 
            <form action="" id="search">
                <input type="text" class="searchbar" placeholder=" 이름" style="display:none;">
                <input type="button" value="검색" class="searchbar"style="display:none;">
            </form>

			<div id="subframe">
            <table id=tbl>
                <thead>
                    <tr>
                        <th id="th1">순서</th>
                        <th id="th2">이름</th>
                        <th class="thm">면접제안</th>
                        <th class="thm">면접응시</th>
                        <th class="thm">면접응시율</th>
                        <th class="thm">진행중</th>
                        <th class="thm">취업</th>
                    </tr>
                </thead>
                <tbody id="tbd">
					<c:forEach items="${list}" var="dto">
                    <tr>
                        <td>${dto.seq}</td>
                        <td class="getname" id="${dto.seq}">${dto.name}</td>
						<c:choose>
						<c:when test="${empty dto.suggest}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${dto.suggest}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
	                    <c:choose>
						<c:when test="${empty dto.agree}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${dto.agree}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
	                    <c:choose>
						<c:when test="${empty dto.agree}"> 
	                        <td>0%</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${((dto.agree/dto.suggest)*100)-((dto.agree/dto.suggest)*100)%1}%</td>	
	                    



                   
	                    </c:otherwise>
	                    </c:choose>
                        <c:choose>
						<c:when test="${empty dto.ing}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${dto.ing}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
                        <c:choose>
						<c:when test="${empty dto.success}"> 
	                        <td>0</td>
	                    </c:when>
	                    <c:otherwise>
	                    <td>${dto.success}</td>	                    
	                    </c:otherwise>
	                    </c:choose>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>

           
        </div>


    </div>

        <div id="forinfo"></div>

    </div>
    

	
	<!-- footer -->
	<div id="footer" >
	<%@include file="/WEB-INF/views/admin/form/footer.jsp" %>
	</div>
	
	  <script>
        


        var box;
        var box2;
        var forinfo = document.getElementById("forinfo");
        var flag = false;

        $(window).click(function() {
           
            if(flag) {
                $(".box").remove();
                flag=false;
            }
    
        });

        $(".getname").click(function() {
            //alert("면접제안 회원, 채용 회원 보기 만들기");
            
            event.cancelBubble = true;
            if (flag) {
                $(".box").remove();
            }
            

            box = document.createElement("div");

            box.className = "box";
            box.style.left = event.clientX + "px";
            box.style.top = event.clientY + "px";
            
            forinfo.appendChild(box);
            box.innerHTML = "<a href='http://www.naver.com'>프로필보기</a>";
            //alert(event.srcElement.id);
            
            flag = true;
            //alert(flag);
        
            box2 = document.createElement("div");

            box2.className = "box";
            box2.style.left = event.clientX + "px";
            box2.style.top = event.clientY+29 + "px";
            
            forinfo.appendChild(box2);
            box2.innerHTML = "<a href='http://www.naver.com'>이력서 보기 만들기</a>";

                        
        });

       

    
    </script>
</body>
</html>
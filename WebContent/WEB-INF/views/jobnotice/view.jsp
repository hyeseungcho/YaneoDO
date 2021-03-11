<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/jobnotice/inc/asset.jsp"%>

<!-- 적용CSS -->
<link rel="stylesheet" href="/yaneodo/css/member/member-main.css">
<link rel="stylesheet" href="/yaneodo/css/member/customer2.css">



    <style>

        /* 폰트 */

        body {
            /* margin-bottom: 300px; */
            font-size: 16px;
        }

        h2 {
            font-size: 20px;
            color: #333;
        }


        h4 * {
            font-size: 18px;
            color: #666;
        }

        h6 {
            font-size: 13px;
            color: #999;
        }


        /* 버튼류 */
        
        #side-btns button, #apply-menu input[type="button"], #apply-menu input[type="submit"] {
            width: 100%;
            margin-bottom: 10px;
            font-size:16px;
   
        }

        
        #like {
            margin-top: 15px;
            width: 60px;
            height: 27px;
            border-radius: 10px;
        }

        #like>span:nth-child(2) {
            font-size: 14px;
        }

        #right-aside .glyphicon {
            background-color: transparent;
            color:#CCC;
            margin-right: 2px;
        }

        .bookmark-selected {
            color:aquamarine;
        }

        .like-selected {
            color:violet;
        }



        /* 공고 내용 */

        #jobOpening {
            /* border: 1px solid cornflowerblue; */
            width: 700px;
            height: auto;
            float: left;
        }

        .right-aside {
            border: 1px solid #EEE;
            width: 320px;
            height: 170px;
            float: right;
            margin-right: 10px;
            padding: 20px;

            /* position: fixed;
            right:200px; */

        }

        
        #company-photo {
            margin-bottom: 20px;
        }

        .form-subtitle {
            /* border: 1px solid black; */
            color: #888;
            display: inline-block;
            width: 70px;
    
        }

        .form-content {
            color: #333;

        }

        #description {
            width: 700px;
            min-height: 200px;
            padding-bottom: 50px;
            border-bottom: 1px solid #CCC;
            margin-bottom: 20px;
        }


        
        #company-info {
            border: 1px solid #AAA;
            height: 90px;
            padding: 20px;
        }

        #company-info div:nth-child(1) {
            /* border: 1px solid #CCC; */
            width: 50px;
            height: 50px;    
            float: left;
            margin-right: 20px;
        }

        
        #company-info div:nth-child(2) {
            font-weight: bold;
            font-size: 18px;
        }

        #company-info div:nth-child(3) {
            color: #999;
        }

        .box {
            border: 1px solid #CCC;
            width: 700px;
            height: 100px;
            margin: 20px 0;
            color: #CCC;
        }



        /* 태그 */

        .tag {
            font-size: 13px;
            color:#666;
            background-color: #EEE;
            border-radius: 20px;
            text-align: center;
            display:inline-block;
            padding: 5px 10px;
            margin-top: 10px;
        }




        /* 지원하기 메뉴 관련 */
        
        #apply-menu {
            display: none;
            height: auto;
        }


        #apply-title {
            border-bottom: 1px solid #CCC;
            width: 100%;
            height: 50px;
            padding: 15px 0;

        }

        #apply-title > span {
            font-size: 20px;
            margin-left: 90px;
        }

        #apply-title > #apply-back {
            float:right;
            width: auto;
            height: 25px;
           
            padding-top: 5px;
        }

        .apply-subtitle {
            font-size: 18px;
            border-left: 3px solid blueviolet; 
            padding-left: 5px;
            margin-top: 40px;
            margin-bottom: 30px;
        }

        .apply-item {
            font-size: 16px;
            color: #666;
            margin: 5px 10px;
            display: inline-block;
            width: 50px;
        }

        .apply-input {
            font-size: 15px;
            border: 0px;
            border-bottom: 1px solid #CCC;
        }

        .apply-file {
            border: 1px solid #AAA;
            height: 60px;
            border-radius: 10px;
            margin-bottom: 10px;
            padding: 10px 0;
            color: #AAA;
        }

/*         .apply-file>input[type="checkbox"] {
            
            width: 30px;
            float:left;
            margin-top: 10px;
            margin-right: 20px;

        } */
        
        .apply-file input[type="radio"] {
            
            width: 30px;
            float:left;
            margin-top: 10px;
            margin-right: 20px;
            cursor: pointer;
        }

        .apply-file label {

            width: 270px;
            font-weight: normal;
        }

        #resume-name {
            font-size: 15px;    
            color: #666;
        }
        #resume-regdate {
            font-size: 13px;
        }
    
        #btn-container {
            margin-top: 30px;
        }

        
  


    </style>

</head>
<body>


  
	<!-- 상단헤더 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- 상단헤더 -->



    <div id="container">

        <div id="jobOpening">

            <div id="company-photo">
                <img class="img-thumbnail" src="/yaneodo/images/jobOpening/${jdto.photo }" style="width:700px; height:500px;">
            </div>

            <div style="margin-bottom: 30px;">
                <h2 style="margin-bottom: 10px;">${jdto.job}</h2>
                <h4 style="margin-bottom: 10px;"> <a href="/yaneodo/jobnotice/company/view.do?seq=${jdto.companySeq}"> ${jdto.name }</a></h4>
                
                <div id="company-location">
                    <h6>${jdto.place }</h6>
                </div>

      
                <div id="tag-area">
                    <div class="tag">#스타트업</div> 
                    <div class="tag">#연봉 상위5%</div>
                    <div class="tag">#직원수 30명 이상</div>
                </div>
            </div>





            <div>
                <div id="description" class="">
                    ${jdto.description}
                </div>
           

            </div>

       

            <div>
                <span class="form-subtitle">마감일</span>
                <span class="form-content">${jdto.endDate }</span>
            </div>
            <div>
                <span class="form-subtitle">근무지역</span>
                <span class="form-content">${jdto.address}</span>
            </div>

            <div>
                <div id="map" class="box">지도</div>
            </div>

            
            <div id="company-info">
                <a href="/yaneodo/jobnotice/company/view.do?seq=${jdto.companySeq}">
                <div><img src="/yaneodo/images/company/${jdto.cphoto }" style="width:50px; height:50px;"></div>
                <div>${jdto.name }</div>
                <div>${jdto.industry }</div>
                </a>
            </div>
           


        </div>


        <!-- 버튼을 회원만 보이게 -->
        <%-- <c:if test="${not empty id }"> --%>
	               
        <div id="right-aside" class="right-aside">

            <div id="side-btns">

                <button id="bookmark-btn" type="button" class="btn btn-default">
                    <span id="bookmark-icon" class="glyphicon glyphicon-bookmark"></span>
                    <span class="">북마크하기</span>
                </button>
                <button id="apply-btn" type="button" class="btn btn-primary">
                    지원하기
                </button>
            </div>

            <div>
                <button id="like" class="btn btn-default">
                    <span id="like-icon" class="glyphicon glyphicon-heart"></span>
                    <span>5</span>
                </button>
            </div>

        </div>



		
        <div id="apply-menu" class="right-aside">
		<form method="POST" action="/yaneodo/jobnotice/applyok.do?">
		
            <div id="apply-title">
                <span>지원하기</span>
                <input type="button" value="뒤로" id="apply-back" class="btn">
            </div>
            
            <br>

            <div id="apply-info" style="margin-bottom:30px;">
                <div class="apply-subtitle">지원정보</div>

                <span class="apply-item">이름</span>
                <input type="text" class="apply-input" value="${mdto.name }">

                <span class="apply-item">이메일</span>
                <input type="text" class="apply-input" value="${mdto.email }">

                <span class="apply-item">연락처</span>
                <input type="text" class="apply-input" value="${mdto.phone }">

            </div>


            <div id="apply-file" style="margin-bottom:30px;">
               
                <div class="apply-subtitle">첨부파일</div>
				
				<c:forEach items="${rlist}" var="rdto">
				
                <div class="apply-file">
                   	<label>
                   		<input type="radio" name="resume" value=${rdto.resumeSeq }>
                    	<div id="resume-name">${rdto.orgfileName }</div>
                    	<div id="resume-regdate">${rdto.editDate } 작성완료</div>
                   	</label>
                </div>
                
    	 		</c:forEach>


                <div id="btn-container">
                    <input type="button" class="btn btn-default" value="새 이력서 작성" onclick="location.href='ex_board.html';">
                    
                    <input type="button" class="btn btn-default" value="파일 업로드">
                    <!-- <input type="file" class="form-control" value="파일 업로드"> -->
                    
                </div>
                
            </div>

			 <%-- <input type="hidden" name="customerSeq" value="${mdto.customerSeq }"> --%>
			 <input type="hidden" name="jobOpeningSeq" value="${jdto.jobOpeningSeq}">
			
            <input type="submit" class="btn btn-primary" value="제출하기">
	
		</form>
        </div>
		

        <%-- </c:if> --%>
		
            
        <div style="clear: both;"></div> 


    </div>


    <script>

        $("#apply-btn").click(function() {
           
            $("#right-aside").css("display", "none");

            $("#apply-menu").css("display", "block");
        });


        $("#apply-back").click(function() {

            $("#right-aside").css("display", "block");

            $("#apply-menu").css("display", "none");
        });



        $("#like").click(function() {

            $("#like-icon").toggleClass("like-selected");

        });

        $("#bookmark-btn").click(function() {

            $("#bookmark-icon").toggleClass("bookmark-selected");

        });



       
    </script>





    
</body>
</html>

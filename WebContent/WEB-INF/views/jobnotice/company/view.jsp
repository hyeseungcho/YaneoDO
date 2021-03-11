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
<link rel="stylesheet" href="/yaneodo/css/member/customer2.css">
<link rel="stylesheet" href="/yaneodo/css/member/member-main.css">




    <style>

        /* 폰트 */

        body {
            /* margin-bottom: 300px; */
            font-size: 16px;
        }


        /* 버튼 */
        
        input[type="button"] {
            /* color: red; */
            width: 100%;
            margin-bottom: 10px;
            font-size:16px;
        }



        

        /* 회사명, 로고 영역*/

        #company-title {
            font-weight: bold;
            border-bottom : 1px solid #999;
            margin-bottom: 30px;

        }



        /* 내용 */

        #contents {
            /* border: 1px solid cornflowerblue; */
            width: 700px;
            height: auto;
            float: left;
        }

        .right-aside {
            /* border: 1px solid #EEE; */
            width: 320px;
            height: 200px;
            float: right;
            margin-right: 10px;
          

            /* position: fixed;
            right:200px; */

        }


        .form-area {
            /* border: 1px solid #999; */
            width: 700px;
            height: auto;
            margin-bottom: 50px;
        }
   


        .form-subtitle {
            font-size : 20px;
            margin-top: 10px;
            margin-bottom: 10px;
        }




        /* 채용중인 포지션 */

        .form-position {
            border: 1px solid #CCC;
            width: 47%;
            height: 100px;
            margin-right: 20px;
            margin-bottom: 20px;
            float: left;
            cursor:pointer;
        }

        .position-info-area {
            width:80%;
            height:100px;
            float:left;
            padding: 20px;
        }

        .bookmark-area {
            width:20%;
            height: 100px;
            float:left;
            padding-right: 30px;
            padding-top: 40px;
        }

        

        .position-name {
            font-size: 18px;
            margin-bottom: 20px;
        }

        .position-period {
            font-size: 14px;
            color:#999;
        }

        .glyphicon {
            float: right;
            color: #999;
           
        }

        .bookmark-selected {
           color: aquamarine;
        }



        /* 회사정보들 */

        #company-introduce {
            font-size: 15px;
            color: #666;
        }

        .inner-box {
            background-color: rgb(245, 245, 245);
            width:700px;
            height: 60px;
            padding: 18px;
            text-align:center;
            font-size: 18px;
        }

        .inner-box :nth-child(1) {
            font-size: 17px;
            color:#999;
            margin-right: 30px;
            
        }

        .inner-box :nth-child(2) {
            font-weight: bold;
        }


        /* 태그 */

        .tag {
            font-size: 15px;
            color:#666;
            background-color: #EEE;
            border-radius: 20px;
            text-align: center;
            display:inline-block;
            padding: 5px 10px;
            margin-bottom: 10px;
        }






    </style>

</head>
<body>


  
	<!-- 상단헤더 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- 상단헤더 -->


    <div id="container">

        <!-- 기업로고 -->
        <div id="company-title" style=" padding: 10px 0;">

            <div id=""> <img src="/yaneodo/images/company/${dto.photo }" style="width:50px; height: 50px; float:left;margin-right:10px;"></div>
            <div id="company-name" style="font-size:25px;float:left; margin-top:10px;">${dto.name }</div>

            <div style="clear: both;"></div> 

        </div>



        <div id="contents">


            <!-- 채용중 포지션 -->
            <div id="recruit-position" class="form-area">

                <div class="form-subtitle">채용 중인 포지션</div>
    
                <div class="form-position">
                    
                    <div class="position-info-area">
                        <a href="p03_jobinfo.html">
                        <div class="position-name">프론트엔드 개발자</div>
                        <div class="position-period">2021.03.01 까지</div>
                        </a>
                    </div>

                    <div class="bookmark-area">
                        <span class="glyphicon glyphicon-bookmark bookmark" ></span>
                    </div>
                </div>

                <div class="form-position">
                    
                    <div class="position-info-area">
                        <div class="position-name">프론트엔드 개발자</div>
                        <div class="position-period">2021.03.01 까지</div>
                    </div>
                    <div class="bookmark-area">
                        <span class="glyphicon glyphicon-bookmark bookmark" ></span>
                    </div>
                </div>

                <div class="form-position">
                    
                    <div class="position-info-area">
                        <div class="position-name">프론트엔드 개발자</div>
                        <div class="position-period">2021.03.01 까지</div>
                    </div>
                    <div class="bookmark-area">
                        <span class="glyphicon glyphicon-bookmark bookmark" ></span>
                    </div>
                </div>

                <div class="form-position">
                    
                    <div class="position-info-area">
                        <div class="position-name">프론트엔드 개발자</div>
                        <div class="position-period">2021.03.01 까지</div>
                    </div>
                    <div class="bookmark-area">
                        <span class="glyphicon glyphicon-bookmark bookmark" ></span>
                    </div>
                </div>
           

                <div style="clear: both;"></div> 
    
            </div>



            <!-- 회사소개 -->
            <div id="introduce" class="form-area">
                <div class="form-subtitle">회사 소개</div>

                
                <div id="company-photo" >
                    <img class="img-thumbnail" src="/yaneodo/images/company/${dto.photo }" style="width:200px; height:100px; margin-bottom:10px">
                </div>


                <div id="company-introduce"> 
                    <p>
                        ${dto.introduction }
                    </p>


                </div>

                

            </div>



            <!-- 매출액 -->
            <div id="sales" class="form-area">
                <div class="form-subtitle">매출액</div>
                <div class="inner-box">
                    
                    <span></span>
                    <span>
                  	 ${dto.sales }
                     만원</span>
          
                </div>


            </div>


            <!-- 직원수 -->
            <div id="employee" class="form-area">
                <div class="form-subtitle">직원수</div>
                <div class="inner-box">
                    <span>전체 인원</span>
                    <span>${dto.employeeNum } 명</span>
                </div>
                
            </div>
    

        </div>


        <!-- 태그 -->
        <div id="right-aside" class="right-aside">


            <div class="form-subtitle">태그</div>

            <div id="tag-area">
                <div class="tag">#스타트업</div> 
                <div class="tag">#연봉 상위5%</div>
                <div class="tag">#직원수 30명 이상</div>
            </div>


        </div>


    
            
        <div style="clear: both;"></div> 


    </div>


    <script>

        $(".bookmark").click(function() {

            $(this).toggleClass("bookmark-selected");

        })


    </script>





    
</body>
</html>











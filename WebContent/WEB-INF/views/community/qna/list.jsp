<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/community/inc/asset.jsp"%>

    
    <style>


        #tbl1 {
            margin-top: 50px;
            border-bottom: 1px solid #CCC;

        }
    
    
        #tbl1 tr > td {
            height: 110px;
            border-top: 1px solid #CCC;
            padding: 5px 10px;
        }
    


        #question-title {
            font-size: 16px;
            margin-bottom: 5px;
        }

        #question-content {
            font-size: 15px;
            color: #999;
            margin-left: 20px;
            width: 600px;
            /* margin-bottom: 10px; */

        }

        #comment > div {
            /* border: 1px solid black; */
            display: inline-block;
        }


        #comment :nth-child(1) {
           
            margin-top: 10px;
            
        }

        #comment :nth-child(2) {
            margin-top: 5px;
            margin-left: 500px;
        }

        #comment :nth-child(3) {
            margin-top: 0px;
            float: right;
        }


  


   
        button {
            float: right;
        }
        

    </style>
    


</head>
<body>
    

    <div id="headerContainer">
        <nav id="nav">
            <ul>
                <li id="logo"><img src="" id="logo">yaneoDO</li>
                <li><a class="menuLink" href="#">탐색</a></li>
                <li><a class="menuLink" href="#">직무별연봉</a></li>
                <li><a class="menuLink" href="#">이력서</a></li>
                <li><a class="menuLink" href="#">매치업</a></li>
                <li><a class="menuLink" href="#">코딩테스트</a></li>
                <li><a class="menuLink" href="#">커뮤니티</a></li>
                <li><a class="menuLink2" id="search"><img src="">검색</a></li>
                <li><a class="menuLink2" id="alarm"><img src="">알람</a></li>
                <li><a class="menuLink2" id="photo"><img src="">사진</a></li>
                <li><a class="menuLink2" id="bservice">기업서비스</a></li>   
                <div style="clear: both;"></div>              
            </ul>
        </nav>
    </div>



    <div id="container">


        <!-- SIDE MENU -->
        <div id="side">
            <div class="sideGroup">
                <div class="sideName">커뮤니티</div>
                <ul> 
                    <li class="side-list-item side-list-item-selected">개발자 Q&A</li>
                    <li class="side-list-item ">자유게시판</li>
           
                </ul>
            </div>
    
            
        </div>


        <!-- CONTENT -->


        <div id="content">

            <div class="title">
                개발자 Q&A
                <small>Board</small>
            </div>

            <table id="tbl1" class="table table-condensed">
       
                <tr>
                    <td>
                        <div id="question-title">
                            <span>Q.</span>
                            <span>웹문서 인코딩 질문 드려요</span>
                        </div>
                        <div id="question-content">
                            euc-kr로 문서타입으로 저장하고 html문서에 charset utf-8으로 저장하면 브라우저는 어떤게 우선 타입인가요?
                        </div>
                        <div id="comment">
                            <div>답변 0</div>
                            <div>나도 궁금해요 3</div>
                            <input type="button" value="답변하기 >" class="btn btn-default">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div id="question-title">
                            <span>Q.</span>
                            <span>웹문서 인코딩 질문 드려요</span>
                        </div>
                        <div id="question-content">
                            euc-kr로 문서타입으로 저장하고 html문서에 charset utf-8으로 저장하면 브라우저는 어떤게 우선 타입인가요?
                        </div>
                        <div id="comment">
                            <div>답변 0</div>
                            <div>나도 궁금해요 3</div>
                            <input type="button" value="답변하기 >" class="btn btn-default">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div id="question-title">
                            <span>Q.</span>
                            <span>웹문서 인코딩 질문 드려요</span>
                        </div>
                        <div id="question-content">
                            euc-kr로 문서타입으로 저장하고 html문서에 charset utf-8으로 저장하면 브라우저는 어떤게 우선 타입인가요?
                        </div>
                        <div id="comment">
                            <div>답변 0</div>
                            <div>나도 궁금해요 3</div>
                            <input type="button" value="답변하기 >" class="btn btn-default">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div id="question-title">
                            <span>Q.</span>
                            <span>웹문서 인코딩 질문 드려요</span>
                        </div>
                        <div id="question-content">
                            euc-kr로 문서타입으로 저장하고 html문서에 charset utf-8으로 저장하면 브라우저는 어떤게 우선 타입인가요?
                        </div>
                        <div id="comment">
                            <div>답변 0</div>
                            <div>나도 궁금해요 3</div>
                            <input type="button" value="답변하기 >" class="btn btn-default">
                        </div>
                    </td>
                </tr>
                
            
            </table>
               
            
            
            <button class="btn btn-default" onclick="location.href='p07_board-write.html'">
                <span class="glyphicon glyphicon-pencil"></span>
                질문하기
            </button>

                    
            <div style="clear: both;"></div>



 

            <!-- 페이징 -->
            <div id="paging">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    </ul>
                </nav>
            </div>

  
            
    </div>








    </div>
</body>
</html>

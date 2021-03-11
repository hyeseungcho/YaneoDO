<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/community/inc/asset.jsp"%>

    
    <style>


  
        tr>th, td {
            text-align: center;
          
        }
    
        tr>th {
            background-color: #EEE;
        }
    
        #tbl1 {
            font-size: 16px;    
            border-bottom: 1px solid #DDD;
            margin-top: 70px;
        }
    
        button {
            float: right;
        }


    </style>
    


</head>
<body>
   

	<!-- 상단 헤더 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- 상단 헤더 -->


    <div id="container">


        <!-- SIDE MENU -->
        <div id="side">
            <div class="sideGroup">
                <div class="sideName">커뮤니티</div>
                <ul> 
                    <!-- <li class="side-list-item side-list-item-selected" onclick="location.href='layout.html';"> 전체보기 </li> -->
                    <li class="side-list-item">개발자 Q&A</li>
                    <li class="side-list-item side-list-item-selected">자유게시판</li>
                    <!-- <li class="side-list-item" onclick="location.href='matchup.html';">매치업</li> -->
                </ul>
            </div>
    
            
        </div>


        <!-- CONTENT -->


        <div id="content">

            <div class="title">
                자유게시판 
                <small>Board</small>
            </div>

            <table id="tbl1" class="table table-condensed">
                <tr>
                    <th style="width:50px">번호</th>
                    <th style="width:300px">글제목</th>
                    <th style="width:75px">작성자</th>
                    <th style="width:75px">작성일</th>
                </tr>
                

				<c:forEach items="${list}" var="dto" varStatus="status">
                <tr>
                    <td>${list.size() - status.index}</td>
                    <td>
                    <a href="/yaneodo/community/board/view.do?seq=${dto.boardSeq}">${dto.title}</a>
                    </td>
                    <td>${dto.name}</td>
                    <td>${dto.writeDate}</td>
                </tr>
                </c:forEach>

                
            </table>


    
            <button class="btn btn-default" onclick="/yaneodo/community/board/write.do">
                <span class="glyphicon glyphicon-pencil"></span>
                글쓰기
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
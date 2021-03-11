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

        button {
            float: right;
        }


        #content-box {
            border: 1px solid #CCC;
            width: 720px;
            margin-top: 70px;
            margin-bottom: 20px;
            margin-left: 30px;
            min-height: 360px;
            padding: 10px;
        }

        #item-title {
            margin-bottom:10px;
        }

        #tbl1 {
            font-size : 16px;
        }

        #tbl1 .subject-area .subject {
            font-size : 17px;
            margin-left: 5px;
        }

        #tbl1 .name, #tbl1 .date, #tbl1 .readcount { 
            float: right;
            font-size: 14px;
            color: #999;
        }

        #tbl1 .name, #tbl1 .date {
            margin-right: 10px;
        }

        #tbl1 .content-area { 
            padding-bottom: 100px;
            color: #666;
        }


        .btn-group {
            float: right;
            margin-bottom: 10px;
        }


        /* 코멘트 영역 */
        #tbl2 .name, .date, .delete { 
            float: right;
            font-size: 12px;
            color: #999;
        }

        #tbl2 .comment {
            color: #666;
        }

        #tbl2 .delete { 
            margin-right: 5px;
            cursor:pointer;
        }

        #tbl2 .name { 
            margin-right: 10px;
        }


        


    </style>




</head>
<body>
   

	<!-- 상단 헤더 #################-->
	<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
	<!-- 상단 헤더 #################-->
	
	
   <div id="container">


       <!-- SIDE MENU ################# -->
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
       <!-- SIDE MENU ################# -->


       <!-- CONTENT ################# -->
       <div id="content">

       <div class="title">
           자유게시판 
           <small>Board</small>
       </div>


	      <div id="content-box">
	
	
	          <table class="table" id="tbl1"><tbody>
	             
	       
	              <tr>
	                  <td class="subject-area">
	                      <!-- <span class="seq">1</span> -->
	                      <span class="subject">${dto.title }</span>
	                      <!-- <span class="readcount">5</span> -->
	                      <span class="date">${dto.writeDate }</span>
	                      <span class="name">${dto.name }</span>
	                  </td>
	              </tr>
	              <tr>
	                  <td class="content-area">
	                  ${dto.content }
	                  </td>
	              </tr>
	
	     
	          </tbody></table>
	
	            
	
	           <div class="btn-group">

	               
	                <!-- 버튼을 회원만 보이게 -->
	               <%-- <c:if test="${not empty id }"> --%>
	               
	               <!-- 작성자만 수정/삭제 버튼이 보이게 -->
					<%-- <c:if test="${dto.id.equals(id) }"> --%>
	
	               <button type="button" class="btn btn-default" onclick="location.href='/yaneodo/community/board/edit.do?seq=${dto.boardSeq}';">
	                   <span class="glyphicon glyphicon-minus"></span>
	                   수정
	               </button>
	               
	               
	               <button type="button" class="btn btn-default" onclick="location.href='/yaneodo/community/board/delete.do?seq=${dto.boardSeq}';">
	                   <span class="glyphicon glyphicon-remove"></span>
	                   삭제
	               </button>
	                
		            <%-- </c:if> --%>
		            <%-- </c:if> --%>
		            
   	               <button type="button" class="btn btn-default" onclick="location.href='p05_board.html';">
	                   <span class="glyphicon glyphicon-th-list"></span>
	                   목록
	               </button>
		            
	           </div>

	           <div style="clear:both;"></div>
	
	
	         	<table class="table" id="tbl2">
	              <tbody>
	              <tr>
	                  <td>
	                      <span class="comment">안녕하세요.</span>
	                      <span class="date">2021-02-20 16:41:29</span>
	                      <span class="name">작성자(작성자id)</span>
	                      <!--  -->
	                      <span class="delete" onclick="location.href='/codestudy/board/deletecommentok.do?seq=3&amp;bseq=6';">[삭제]</span>
	
	               </td>
	              </tr>
	           </tbody>
	           </table>
	
	
	           <form method="POST" action="/codestudy/board/commentok.do">
	
	               <div class="">
	                   <div class="">
	                   	<!-- 
	                   		1. <input name="이름">
	                   		2. DB 테이블의 컬럼명
	                   		3. DTO 멤버변수명	
	                   	-->
	                   	
	                   	<!--
	                   		<form> 태그내에 텍스트 박스가 유일하면 
	                   		텍스트박스에 엔터를 치면 자동으로 submit이 된다.
	                   	-->
	                       <input type="text" class="form-control" placeholder="comment" id="ccontent" name="ccontent" required="" autocomplete="off">
	                   </div>
	                   <!-- 히든태그 -> 페이지소스보기로 직접 확인하기 -->
	                   <input type="hidden" name="bseq" value="5" autocomplete="off">
	               </div>
	
	           </form>
	
	         </div>

        <div style="clear: both;"></div>




    </div>
</body>
</html>
	

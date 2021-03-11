<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코딩문제관리</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>
<link rel="stylesheet" href="/yaneodo/css/admin/admin.css">
<link rel="stylesheet" href="/yaneodo/css/jquery-ui.css">

<script src="/yaneodo/js/jquery-1.12.4.js"></script>
<script src="/yaneodo/js/jquery-ui.js"></script>


<style>

       #container {
            width: 1200px;
            margin : 0px auto;
        }
        
        #top {
            margin-top : 10px;
        }

        #jobtype, #title {
            float : left;
            margin-right: 30px;
            margin-left: 5px;
        }
        
        #core {
            margin-top: 10px;
            width: 1150px;
            
        }

        #core span {
            margin-left: 5px;
            margin-right: 42%;
        }

        #core #left, #core #right {
            border: 3px solid #ccc;
            width: 540px;
            height: 600px;
            float: left;
            
            
           

        }
        #core #left {
            border-right: 0px;
        }

        #btns {
            width: 300px;
            margin-top: 20px;
            margin-left: 0px;
        }

        #btns input {
            width: 100px;
            height: 40px;
        }

        #btns input:hover {
            cursor: pointer;
        }


</style>

</head>
<body>
	    <div id=container>

        <div id="top">
            <div id="jobtype">초급</div>
            <div id="title">모든 레코드 조회하기</div>
        </div>
        <div style="clear:both;"></div>
        <div id="core">
            <div>
                <span>문제설명</span>
                <span>정답입력</span>
            </div>
            <div id="left"><textarea class="form-control" id="qcontent" placeholder="문제를 입력하세요" name="qcontent" style="border:0px;outline:none; width:540px; height: 594px;resize: none;"required ></textarea> </div>
            <div id="right"><textarea class="form-control" id="acontent" placeholder="코드를 입력하세요" name="acontent" style="border:0px;outline:none; width:534px; height: 594px;resize: none;"required ></textarea></div>
            
        </div>
        <div style="clear:both;"></div>
        
        
        <div id="btns">
            <form action="">
                <input type="button" id="next" name="next" value="돌아가기" class="btn btn-primary" onclick="location.href='/yaneodo/admin/codingtest/codingtestadd.do';">
                <input type="button" id="regist" name="regist" value="등록하기" class="btn btn-primary"onclick="location.href='project_admin_codingtest.html';">
            </form>

        </div>

    </div>

	<script>
        
	  //$("#list1").sortable();

	  

    
      


    
    </script>
</body>
</html>
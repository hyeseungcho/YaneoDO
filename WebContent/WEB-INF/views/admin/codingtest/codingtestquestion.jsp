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
                
                
            </div>
            <div id="left"><textarea class="form-control" id="content" placeholder="문제를 입력하세요" name="content" style="border:0px;outline:none; width:540px; height: 600px;resize: none;"required >ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.









                동물 보호소에 들어온 모든 동물의 정보를 ANIMAL_ID순으로 조회하는 SQL문을 작성해주세요. SQL을 실행하면 다음과 같이 출력되어야 합니다.
                
                </textarea> </div>
            <div id="right">
                <div id="rightUp">
                    <div id="uptext" style="border-bottom: 3px solid #ccc; ">코드</div>
                    <textarea class="form-control" id="qcontent" placeholder="코드를 입력하세요" name="qcontent" style="border:0px;outline:none; width:540px; height: 284px;resize: none; border-bottom: 3px solid #ccc;" required ></textarea>
                </div>
                <div id="rightDown">
                    <div id="downtext" style="border-bottom: 3px solid #ccc; ">결과</div>
                    <div class="form-control" id="acontent" style="border:0px;outline:none; width:540px; height: 255px; resize: none;" >실행 결과가 여기에 표시됩니다.</div>
                </div>
                
            </div>
            
        </div>
        <div style="clear:both;"></div>
        
        
        <div id="btns">
            <form action="">
                <input type="button" id="next" name="next" value="저장하기" class="btn btn-primary" onclick="location.href='project_admin_codingtest_add.html';">
                <input type="button" id="regist" name="regist" value="실행하기" class="btn btn-primary"onclick="location.href='project_admin_codingtest.html';">
            </form>

        </div>

    </div>

	<script>
        
	  //$("#list1").sortable();

	  

    
      


    
    </script>
</body>
</html>
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
 <section class="container" > 
        <div class="title">프로필</div>
<%@include file="/WEB-INF/views/member/inc/mymenu.jsp" %>
   
   
   <script>
		$("#customerInfo").css("height","640px");
		$("#editInfo").addClass("editSel");
		$("#editInfo").removeClass("editInfo");
		$("#account").css("display","none");
	</script>
       

        <div id="infoEditContainer">
         
            <div id="infoEdit" class="table">
                <div class="title2">기본정보 수정</span></div>
                <form id="editForm" method ="GET" action ="/yaneodo/member/myyaneodo/customer_editok.do" >
		            <div class="FormBlock-content content">
		                <label for="name" class="infomations"><h6>이름</h6><input style="width:200px;" id="name" name="name" type="text" autocomplete="off" value="${dto.name}">
		                </label> 
		                <label for="nickName" class="infomations"><h6>별명</h6><input style="width:200px;" id="nickName" name="nickName" type="text" autocomplete="off" value="${dto.nickName}">
		               </label> <input type="button" id="btnNick" class="btn btn-default" value="중복확인" style="margin-left:140px;"><span id="checkNick" style="padding-left:15px;"></span>
		                <label for="birth" class="infomations"><h6>생년월일</h6><input style="width:200px;" id="birth" name="birth" type="date" autocomplete="off" value="${dto.birth}">
		                </label>
		                <div class="infomations"><h6>연락처</h6><div class="MobileInput-body">
		                   <input  style="width:200px;" id="phone" name="phone" class="MobileInput-text" type="text" placeholder="(예시) 01034567890" value="${dto.phone}">
		                        </div>
		                    </div>
		                </div>
		                <div class="footerButton">
		                    <button id="btnSubmit" type="submit" style="background-color:#DDDDDD">확인</button>
		             </div>
                </form>
            </div>
            
        </div>
       
    </section>

	<script>
	
 	$("#btnNick").click(function(){
		
		$.ajax({
			type:"GET",
			url:"/yaneodo/member/myyaneodo/customer_editdata.do",
			//data:"key=value & key=value & key=value"
			data:"nickName=" + $("#nickName").val(),
			success:function(checkNick){
				//콜백 함수
				//console.log(checkNick);
				if(checkNick == 1){
					$("#checkNick").css("color","red");
					$("#checkNick").text("이미 사용중인 닉네임 입니다.");
					$("#btnSubmit").attr("disabled",true);
					$("#btnSubmit").css("background-color","#DDD");
				} else{
					$("#checkNick").css("color","blue");
					$("#checkNick").text("사용가능한 닉네임 입니다.");
					$("#btnSubmit").attr("disabled",false);
					$("#btnSubmit").css("background-color","#258bf7");
				}
			},
			error : function(a,b,c){
				console.log(a,b,c);
			}
		});
		
	});
 	
 
	 
	</script>
</body>
</html>
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
        <div class="title">계정설정</div>
        <div class="content">
            <!-- 메뉴 -->
            <div class="aside-nav-group">
                
                <div id="change-btn" class="aside-nav-item-selected">비밀번호 변경</div>
                <div id="delete-btn" class="aside-nav-item">회원탈퇴</div>
            </div>

			<form method="GET" action="/yaneodo/member/myyaneodo/changepw.do">
            <div id="changePassword" class="whiteContainer" >
                <div class="title2">비밀번호 변경</div>
                <div style="height:200px;">
                <label for="nowPassword" class="infomations"><h6>현재비밀번호</h6><input id="nowPassword" name="nowPassword"type="password" autocomplete="off" value="" required>
                </label>
                <label for="newPassword" class="infomations"><h6>새비밀번호</h6><input id="newPassword" type="password" autocomplete="off" value="" required>
                </label>
                <label for="checkPassword" class="infomations"><h6>비밀번호 확인</h6><input id="checkPassword" name="checkPassword" type="password" autocomplete="off" value="" required>
                </label> 
                <div style="margin-left:150px;">
                
                <div class="infomations" id="success" style="color:blue;">새비밀번호가 일치합니다.</div>
                <div class="infomations" id="danger" style="color:red;">새비밀번호가 일치하지 않습니다.</div>
    			</div>
				</div>
            
                <div class="footerButton" style="height:50px;">
                    <button type="submit" id="submit" disabled style="background-color:#DDD" >비밀번호 변경</button>
                </div>
            </div>
			</form>

	<form method="GET" action = "/yaneodo/member/myyaneodo/delaccount.do">           
		<div id="deleteAccount" class="whiteContainer" style="display: none;">
                <div class="title2">탈퇴시 주의사항</div>
                <ul class="deleteInfo">
                    <li>
                        탈퇴 시 회원님의 이력서를 포함하여 회원님의 계정에 저장된 <b>모든 정보가 영구적으로 삭제되며, 다시는 복구할 수 없습니다.</b>
                    </li>
                    <li>
                        이력서의 저장을 원하실 경우, 탈퇴 이전에 <a href="#"><b>이력서 관리 페이지</b></a>에서 다운로드 해주세요.
                    </li>
                    <li>
                        기업에 대한 채용 수수료 정산과 부정이용 방지를 위해, <b>기업에 대한 지원 내역은 관련 법령에 의거하여 탈퇴 후 최장 5년간 저장됩니다.</b>
                    </li>
                    <li>
                        기업 서비스에 등록되어 있는 계정일 경우, <b>기업 서비스 접속권한도 동시에 삭제됩니다.</b>
                    </li>
                    <li>
                        이상의 내용에 동의하여 탈퇴를 원하실 경우, 아래의 “동의하기” 버튼을 클릭 부탁드립니다.
                    </li>
                    <div class="footerButton">
                        <button type="submit" style="background-color:#258BF7" >동의하기</button>
                    </div>

                </ul>

            </div>
      
                </form>
	</div>
	  
    </div>

    <script>

$(function(){
	$("#success").hide();
	$("#danger").hide();
	$("#checkPassword").keyup(function(){
		var pw1 = $("#newPassword").val();
		var pw2 = $("#checkPassword").val();
		
		if(pw1 !="" || pw2 !=""){
			
			if(pw1 == pw2){
				$("#success").show();
				$("#danger").hide();
				$("#submit").attr("disabled",false);
				$("#submit").css("background-color","#258BF7");
			} else {
				$("#success").hide();
				$("#danger").show();
				$("#submit").attr("disabled",true);
				$("#submit").css("background-color","#DDD");
			}
			
		}
		
	});
});

        $("#delete-btn").click(function(){
            $("#change-btn").removeClass("aside-nav-item-selected");
            $("#delete-btn").removeClass("aside-nav-item");
            $("#delete-btn").addClass("aside-nav-item-selected");
            $("#change-btn").addClass("aside-nav-item");

        
            $("#changePassword").css("display","none");
            $("#deleteAccount").css("display","");

        });

        
        $("#change-btn").click(function(){
            $("#change-btn").removeClass("aside-nav-item");
            $("#delete-btn").removeClass("aside-nav-item-selected");
            $("#delete-btn").addClass("aside-nav-item");
            $("#change-btn").addClass("aside-nav-item-selected");

        
            $("#changePassword").css("display","");
            $("#deleteAccount").css("display","none");

        });


    </script>
	
</body>
</html>

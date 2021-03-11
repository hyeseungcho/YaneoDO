 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
     <!-- header -->
     <div id="headerContainer" style=" z-index:10;">
        <nav id="nav">
            <ul>
                <li id="logo" style="cursor: pointer;" onclick="location.href='/yaneodo/index.do'"><img src="" id="logo">yaneoDO</li>
                <li><a class="menuLink" href="#">탐색</a></li>
                <li><a class="menuLink" href="#">직무별연봉</a></li>
                <li><a class="menuLink" href="/yaneodo/member/resume/resume_list.do">이력서</a></li>
                <li><a class="menuLink" href="#">매치업</a></li>
                <li><a class="menuLink" href="#">코딩테스트</a></li>
                <li><a class="menuLink" href="#">커뮤니티</a></li>
                
                <!-- <li><span class="menuLink2 glyphicon glyphicon-search" id="search"></span></li> -->
                <li><button type="button" class="searchButton"><span class="glyphicon glyphicon-search"></span></button></li>
                
                
                <!-- 로그인 전 -->
                <c:if test="${empty email}">
                	<li><a class="menuLink2" id="login">로그인/회원가입</a></li>
         		</c:if>
         		
                <!-- 로그인 후 -->
                <c:if test="${not empty email}">
					<li><a class="menuLink2" id="alarm"><img src="">알람</a></li>
	                <li style="margin-bottom: -10px;"> 
	                <c:if test="${not empty photo}">
                            <input id="myYaneodo-menu" type="button" class="searchButton headerPhoto" style="background-image: url('/yaneodo/images/member/${photo}')">
                         </c:if>
                         <c:if test="${empty photo}">
                            <input id="myYaneodo-menu" type="button" class="searchButton headerPhoto" style="background-image: url('/yaneodo/images/member/man_06.png')">
                         </c:if>
	                    
	                   
	                    <input id="headerPhoto" type="hidden" value="${photo}">
	                    
	                    
	                
	                    </li>
				</c:if>
                   	 
                <!-- 공통 -->
                <li><a href="/yaneodo/company/main/index.do" class="menuLink2" id="bservice">기업서비스</a></li>   
                <div style="clear: both;"></div>            
                  
            </ul>
        </nav>
        <div id="myMenu-container" class="container" style="display: none;">
        <ul id="myMenu">
            <li class="">
                <a href="/yaneodo/member/myyaneodo/myyaneodo.do" class="" ><span>MY 야너두</span></a>
            </li>
            <li class="">
                <a href="/yaneodo/member/profile/profile.do" class="" ><span>프로필</span></a>
            </li>
            <li class="">
                <a href="/yaneodo/member/status/applied_status.do" class="" data-lnb-kind="applications"><span>지원 현황</span></a>
            </li>
            <li class="">
                <a href="/yaneodo/member/status/match_status.do" class="" data-lnb-kind="offersReceived"><span>제안받기 현황</span></a>
            </li>
            <li class="">
                <a href="/profile/likes" class="" data-lnb-kind="likes"><span>좋아요</span></a>
            </li>
            <li class="">
                <a href="/profile/bookmarks" class="" data-lnb-kind="bookmarks"><span>북마크</span></a>
            </li>
            <li>
                <a href="/yaneodo/member/logout.do" class="is-logout">로그아웃</a>
            </li>
        </ul>
        </div>
    </div>
    
    

    <script>
 
	/* 로그인/회원가입 버튼 클릭 */
    $("#login").click(function() {
        $("#clogin").show();
        $("#container").css("opacity", ".7");
    });
	
    $("#login").click(function() {
        $("#clogin").css("display", "block")
        $("#container").css("opacity", ".7");
    });

    //$("#myYaneodo-menu").css("background-image","url('/yaneodo/images/member/"+ $("#headerPhoto").val()+"')");
    
    
    /* 로그인 후 myYaneodo 메뉴 */
    var flag=false;

    $("#myYaneodo-menu").click(function(){
        if(flag==true){
            $("#myMenu-container").hide();
             $("#myYaneodo-menu").removeClass("borderLine");

            //  $(window).click(function(){
            //     $("#myMenu-container").css("display","none");
            //       $("#myYaneodo-menu").removeClass("borderLine");
            //       flag=false;
            //     });
    
             flag=false;
        } else {
        $("#myMenu-container").show();
        $("#myYaneodo-menu").addClass("borderLine");
        flag=true;

        }

        event.cancelBubble=true;
       
    });
 

    
    $(window).click(function(){
        $("#myMenu-container").hide();
         $("#myYaneodo-menu").removeClass("borderLine");
         flag=false;
        
    });

    </script>


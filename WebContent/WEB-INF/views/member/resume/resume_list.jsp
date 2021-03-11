<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="/yaneodo/css/member/resume.css">
<style>

</style>
</head>
<body>
<%@include file="/WEB-INF/views/member/inc/header.jsp" %>
   <div class="container">
            <div class="title">최근 문서</div>
            <div class="resume-item">
                <div class="resume-box">
                    <label class="resumeWrite btn btn-default" type="button">
                        <a class="wrapper linkFont" href="/yaneodo/member/resume/resume_writeok.do">
                            <div class="box blue">
                                <i class="far fa-clone"></i>
                            </div>
                            <p>이력서 작성</p>
                        </a>
                    </label>
                    </div>

                 
                    <div class="resume-box">
                        
                        <label class="resumeWrite btn btn-default" type="button" for="uploadCV" >
                            <!-- <label for="uploadCV"for="uploadCV"> -->
                            <div class="wrapper">
                                <div class="box">
                                   
                                </div>
                                <p style="font-weight: lighter;">파일업로드</p>
                        
                            <!-- </label> -->
                            </lable>
                                <input type="file" id="uploadCV" style="display: none;"> 
                             </div>
                        
        
                        </div>

                        <c:if test="${empty list.size()}">
                        <div>
                        	<span>이력서를 작성해주세요</span>
                        </div>
                        
                        </c:if>
						<c:forEach items="${list}" var="dto">
                        <div class="resume-box" style="cursor: pointer;">
                            <div class="resume-preview notcompleted" onclick ="location.href='/yaneodo/member/resume/resume_write.do?rseq=${dto.resumeSeq}'">

                                <h3 id="resume-name" class="resume-name">${dto.orgfileName}</h3>
                                <p class="resume-date">작성일 </p>
                                <p>: ${dto.writeDate}</p>
                                  <p class="notcompleted">최종 수정일  </p>
 									<p>: ${dto.editDate}</p>

                            </div>
                            
                              <div class="resume-info">


                                <input type="button" onclick ="location.href='/yaneodo/member/resume/resumedel.do?rseq=${dto.resumeSeq}'" class="btn btn-default" style="margin-left: 150px; margin-top: -8px; border:0px;" value="삭제">

                            </div>

                            <!-- <div id="drop-down-menu" class="drop-down-menu" style="display: none;"  >
                                <ul>
                                    <li>
                                        <a class="title-change">이름변경</a>
                                    </li>
                                    <li>
                                        <a href="">다운로드</a>
                                    </li>
                                    <li>
                                        <a class="resume-delete">삭제</a>
                                    </li>
    
                                </ul>

                            </div>-->
                        </div> 

					</c:forEach>
                        


<!--                         <div class="resume-box">
                            <div class="resume-preview notcompleted">

                                <h3 id="resume-name" class="resume-name">hyeseung Cho</h3>
                                <p class="resume-date">2021.02.11</p>

                            </div>
                            <div class="resume-info">

                                <span class="notcompleted">작성 중</span>
                                <input type="button" class="btn btn-default more" value="더보기">

                            </div>
                            <div id="drop-down-menu" class="drop-down-menu" style="display: none;" >
                                <ul>
                                    <li>
                                        <a id="title-change" onclick="changeTitle();">이름변경</a>
                                    </li>
                                    <li>
                                        <a href="">다운로드</a>
                                    </li>
                                    <li>
                                        <a class="resume-delete">삭제</a>
                                    </li>
    
                                </ul>
     
                            </div>
                   
                        </div> -->

                   
            </div>

        </div>            

      
     

        <!-- <div id="delete-background" class="delete-background container" stype="position:absolute">

            <div style="text-align: center; width: 200px; height: 100px; border: 1px solid #ddd; margin: 0px auto;">
                <div style="margin-top: 30px;">정말 삭제하시겠습니까?</div>
                <div>
                    <button class="btn btn-default">아니요</button>
                    <button class="btn btn-primary">네</button>
                </div>
            </div> -->

            <!-- <div class="check-delete-box" style="" >
                <div width="50" class="Content-zwkXZ delete-box">
                    <div class="resume-delete-modal-body Div-hTZHGu fEVoGZ">
                        <div><h3><span>이력서 Hyeseung Cho 5<br>삭제하시겠습니까?</span></h3></div>
                    </div>
                    <div class="resume-delete-button">
                        <button>취소</button><button>삭제</button>
                    </div>
                </div>
                <div class="Overlay-iWuiZb emhpxA"></div>
            </div> -->


        <script>

            // $(".resume-delete").click(function(){
            //     $(".check-delete-box").css("display","block");
            //     $(".Overlay-iWuiZb").addClass("emhpxA");

            // });

            // function changeTitle(){
            //     $(this).parent().parent().next().children(".resume-name")
            // }

             var flag=true;


             //더보기메뉴보이기
            $(".more").click(function(){
                
               
                if(flag) {
                    $(this).parent().next().css("display","block");
                } else {
                    $(this).parent().next().css("display","none");
                }

                 flag = !flag;

                event.cancelBubble = true;
                
            });

            $(window).click(function() {
                    $(".more").parent().next().css("display","none");
                    // flag = !flag;
                });

               

        </script>
</body>
</html>

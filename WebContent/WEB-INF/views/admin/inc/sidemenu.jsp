<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="/yaneodo/css/admin/sidemenu.css">

</head>
<body>
	<nav id="sidemenu">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true" style="width:200px">

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                회원 관리
                            </a>
                        </h4>
                    </div>
        
                    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/member/memberlist.do'">
                            일반회원 목록
                        </div>
                        <div class="panel-body sname">
                            일반회원 휴면
                        </div>
                        <div class="panel-body sname">
                            일반회원 탈퇴
                        </div>
                    </div>
                
                </div>
        
        
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            기업 관리
                            </a>
                        </h4>
                    </div>

                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/company/companyapprovelist.do'">
                            기업회원 승인관리
                        </div>
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/company/companylist.do'">
                            기업회원 목록
                        </div>
                        <div class="panel-body sname">
                            기업회원 휴면
                        </div>
                        <div class="panel-body sname">
                            기업회원 탈퇴
                        </div>
                    </div>
                </div>
        
        		<!-- 
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                고객 센터
                            </a>
                        </h4>
                    </div>

                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/service/servicelist.do'">
                            고객센터 답변
                        </div>
                    </div>
                </div>
                -->
        
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingNine">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseNine" aria-expanded="false" aria-controls="collapseNine">
                                커뮤니티
                            </a>
                        </h4>
                    </div>

                    <div id="collapseNine" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingNine">
                        <div class="panel-body sname">
                            개발자 Q&A
                        </div>
                        <div class="panel-body sname">
                            자유게시판
                        </div>
                    </div>
                </div>
        
        
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingFour">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                매칭 현황
                            </a>
                        </h4>
                    </div>

                    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                       <!--  <div class="panel-body sname" onclick="location.href='/yaneodo/admin/matchup/matchup_main.do';">
              메인
            </div> -->
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/matchup/matchup_company.do';">
                            기업 회원별
                        </div>
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/matchup/matchup_member.do';">
                            일반 회원별
                        </div>
                    </div>
                </div>
        
        
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingFive">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                수익 현황
                            </a>
                        </h4>
                    </div>

                    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
                        <div class="panel-body sname"onclick="location.href='/yaneodo/admin/gain/gain.do';">
                            전체
                        </div>
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/gain/gain_company.do';">
                            기업 회원별
                        </div>
                    </div>
                </div>
        
                <div class="panel panel-default" >
                    <div class="panel-heading" role="tab" id="headingEight">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseEight" aria-expanded="false" aria-controls="collapseEight" >
                                직무
                            </a>
                        </h4>
                    </div>

                    <div id="collapseEight" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEight">
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/jobtype/jobtype.do';">
                            직무이름
                        </div>
                    </div>
                </div>
        
        
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingSix">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                                태그
                            </a>
                        </h4>
                    </div>

                    <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/tag/tagcategory.do';">
                            태그 카테고리
                        </div>
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/tag/tag.do';">
                            태그 이름
                        </div>
                    </div>
                </div>
        
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingSeven">
                    <h4 class="panel-title">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
                        코딩테스트
                        </a>
                    </h4>
                    </div>

                    <div id="collapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/codingtest/codingtest.do';">
                            문제관리
                        </div>
                        <div class="panel-body sname" onclick="location.href='/yaneodo/admin/codingtest/codingtestadd.do';">
                            문제추가하기
                        </div>
                    </div>
                </div>
            </div>
        </nav>  
	
</body>
</html>
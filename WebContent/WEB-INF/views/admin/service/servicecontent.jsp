<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>
    <link rel="stylesheet" href="/yaneodo/css/admin/admin-service.css">

    
</head>
<body>
	<!-- header -->
	<div id="header">
	
		<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	
	</div>
	<div style="clear:both;"></div>
    
    <div id="pageAll">
        <div class="aperture"></div>
        <div class="container">
            <div class="col-md-9 col-sm-9 col-xs-12" style="float: left;">
                <ol class="serviceMove">
                    <li title="원티드 고객센터">
                        <a href="#">원티드 고객센터</a>
                    </li>
                    <span>&gt</span>
                    <li title="기업회원">
                        <a href="#">기업회원</a>
                    </li>
                    <span>&gt</span>
                    <li title="이용방법">
                        <a href="#">이용방법</a>
                    </li>
                </ol>
            </div>
            <div class="com-md-3 col-sm-3 col-xs-12 input-group search" stlye="float: right;">
                <input type="search" class="form-control" placeholder="검색" id="search" name="search">              
                <span class="input-group-addon" id="commit" style="cursor:pointer;"><span class="glyphicon glyphicon-search"></span></span>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-sm-9 col-xs-12" style="margin-top: 40px;">
                    <section class="content">
                        <div class="content-head">
                            <h3>아이디를 변경하고 싶어요.</h3>
                        </div>
                        <div class="content-body">
                            <p>
                                <span>내정보 -> 프로필 -> 기본정보 -> 수정으로 들어가 수정이 가능합니다.</span>
                            </p>
                        </div>
                    </section>
                </div>
                <div class="com-md-3 col-sm-3 col-xs-12" style="float: right; border: 1px solid #CCC; padding: 20px 20px; margin-top: -120px; margin-right: 10px; border-radius: 5px;">
                    <aside class="sidemenu">
                        <h3>이 섹션의 문서</h3>
                        <ul>
                            <li><a href="#">지원한 회사에서 피드백이 없습니다. 어떻게 하면 되나요?</a></li>
                            <li><a href="#">내가 업로드한 파일을 삭제하고 싶어요.</a></li>
                            <li><a href="#">원티드 이력서 양식을 꼭 사용해야 하나요?</a></li>
                            <li><a href="#">내가 만든 파일을 사용하고 싶어요.</a></li>
                            <li><a href="#">지원 현황은 어디에서 확인 하나요? 수정도 가능한가요?</a></li>
                            <li><a href="#">제출하기 버튼이 비활성화(회색)되어 있어요.</a></li>
                        </ul>
                    </aside>
                </div>
            </div>
        </div>
        <div class="container" id="under">
            <span>
                또 다른 질문이 있으십니까?&nbsp;&nbsp;&nbsp;
                <a href="#">다른 문의 등록하기 ></a>
            </span>
        </div>
    </div>
</body>
</html>
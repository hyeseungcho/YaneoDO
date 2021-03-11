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
                        <a href="#">문의 등록</a>
                    </li>
                </ol>
            </div>
            <div class="com-md-3 col-sm-3 col-xs-12 input-group search" stlye="float: right;">
                <input type="search" class="form-control" placeholder="검색" id="search" name="search">              
                <span class="input-group-addon" id="commit" style="cursor:pointer;"><span class="glyphicon glyphicon-search"></span></span>
            </div>
        </div>
        <div>
            <section class="question-enrollment">
                <h2 style="font-size: 1.5em;">문의 등록</h2>
                <div class="email-input interval">
                    <label for="email-input">이메일 주소 *</label>
                    <input type="text" name="email-input" id="email-input" placeholder="가입하신 이메일 주소를 기입해주세요.(비회원은 수신 가능한 이메일)">
                </div>
                <div class="tel-input interval">
                    <label for="tel-input">연락처 *</label>
                    <input type="text" name="tel-input" id="tel-input" placeholder="'-' 없이 번호만 입력">
                </div>
                <div style="clear: both;"></div>
                <div class="title-input interval">
                    <label for="title-input">제목 *</label>
                    <input type="text" name="title-input" id="title-input" placeholder="알맞은 제목을 넣어주세요.">
                </div>
                <div class="content-input interval">
                    <label for="content-input">설명 *</label>
                    <textarea name="content-input" id="content-input" cols="30" rows="10" placeholder="상세한 문의 사항을 기입해주세요. 주말을 제외한 1~2일 이내 가능한 빨리 답변 드릴 수 있도록 노력하겠습니다."></textarea>
                </div>
                <div class="file-input interval">
                    <label for="file-input">첨부파일</label>
                    <input type="file" name="file-input" id="file-input" placeholder="알맞은 제목을 넣어주세요.">
                </div>
                <div class="service-input interval">
                    <p>
                        <strong>개인정보 수집 및 이용에 대한 동의 내용</strong>
                        <br>
                        야너두는 정보통신망 이용촉진 및 정보보호 등에 관한 법률을 준수하며 고객님의 개인정보를 수집하고 소중하게 다루고 있습니다. ①개인정보 수집 항목: 이름, 이메일 주소 ②수집목적: 고객식별, 문의응대, 서비스 품질 향상 ③보유 및 이용기간: 수집 목적이 달성되면 지체없이 모든 개인정보를 파기합니다. 단, 관계법령에서 일정 기간 정보의 보관을 규정한 경우에 한해 분리 보관 후 파기합니다.
                    </p>
                    <input type="checkbox" name="service-input" id="service-input">
                    <label for="service-input">동의합니다.</label>
                </div>
                <footer>
                    <input type="submit" value="제출" id="commit" name="commit" class="btn btn-lg">
                </footer>
            </section>
        </div>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/match/main.css">
<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div class="section-image">
		<div class="image"></div>
		<div class="title">지원자를 기다리지 말고 먼저 찾아보세요</div>
		<div class="content">MatchUp은 기업이 직접 우수인재를 찾아보고, 마음에 드는 인재에게 면접
			제안을 할 수 있는 새로운 채용 솔루션 입니다</div>
		<div class="button-area">
			<input type="button" class="btn btn-primary" value="검증된 인재 만나기" onclick="location.href='/yaneodo/company/match/list.do';">
			<input type="button" class="btn btn-primary" value="무료체험 신청하기">
		</div>
	</div>


	<div class="section">
		<div class="title">MatchUp 서비스의 장점</div>
		<div class="content">우수한 인재풀 - 구직의사를 가진 30만명의 검증된 인력풀 - 경력 · 학력
			· 연차 · 스킬 검색 가능 - 인기 많은 인재, 원티드에서 선별한 우수 인재 모아보기</div>
		<div class="content">② 알아서 척척! 추천AI - 기존 공고 대비 채용기간 1/6 단축 - AI가
			합격 가능성 높은 인재 추천 - 80만건 이상의 전형 데이터를 바탕으로 한 높은 정확도</div>
		<div class="content">③ 합리적인 가격 - 정액제 상품: 열람권(월 50~100만원)구매 / 수수료
			무료 - 무제한 상품: 무제한 열람 / 후보자 채용 시 수수료 부과</div>
	</div>


	<div class="section">
		<div class="title">MatchUp 이용 절차</div>
		<div class="content">① 프로필 무료 조회 - 다양한 검색어로 유저 프로필 조회 가능 - 열람 ,
			주요 프로필 미리보기</div>
		<div class="content">② 이력서 열람 및 면접 제안 - 이력서 열람 후 면접 진행을 원할 시 맞춤형
			메세지로 직접 제안 - 회사 및 포지션 소개, 연봉, 복지 등 면접제안 발송</div>
		<div class="content">③ 제안 수락 시 면접 진행 - 면접 제안 수락 시 후보자 연락처가 공개 -
			공개된 연락처로 직접 연락하여 면접 진행</div>
	</div>

	<div class="section">
		<div class="title">MatchUp 이용 가격</div>
		<div class="content">※ 정액제 상품(라이트, 베이직): 채용 수수료 무료, VAT 별도</div>
		<div class="content">① 라이트 500,000원 / 30개 상세 이력서 열람 / 30일</div>
		<div class="content">② 베이직 1,000,000원 / 100개 상세 이력서 열람 / 30일</div>
		<div class="content">③ 무제한 요금제 합격자 연봉의 7% / 무제한 상세 이력서 열람 / 기간
			제한 없음</div>
	</div>



	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<script>

	</script>
</body>
</html>
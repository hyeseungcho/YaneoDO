<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<%@include file="/WEB-INF/views/member/inc/asset.jsp"%>

<link rel="stylesheet" href="/yaneodo/css/company/main/main.css">
<link rel="stylesheet" href="/yaneodo/css/company/main/header.css">
<link rel="stylesheet" href="/yaneodo/css/company/main/register.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/regHeader.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<form method="POST" action="/yaneodo/company/main/registerok.do" enctype="multipart/form-data" id="companyJoin">
		<div class="box" id="title">
		
			<c:if test="${dto.state == null}">
				<p>회사 정보를 등록해 주세요.</p>
				<p>야너도는 추천인/후보자들에게 좋은 일자리를 제공하기 위해, 다음 정보를 리뷰하여 회사등록을 승인하고 있습니다.</p>
			</c:if>
			
			<c:if test="${dto.state == 0}">
				<p></p>
				<p style="font-weight:bold">회사정보가 아래와 같이 등록 완료되었습니다. <br>
					기업 승인 후 기업 정보 서비스를 이용하실 수 있습니다.</p>
			</c:if>
			
		</div>
		
		
		<div class="subbox" style="width: 750px;">
			<label for="inputAddress">회사이름*</label> <input type="text"
				class="form-control" id="name" name="name" placeholder="회사 이름"
				required>
		</div>

		<div class="box">
			<div class="withFloat subbox" style="width: 350px;">
				<label for="country">국가*</label> <select class="form-control" id="country" name="country">
					<option value="한국">한국</option>
					<option value="대만" disabled>대만</option>
					<option value="싱가폴" disabled>싱가폴</option>
					<option value="일본" disabled>일본</option>
					<option value="홍콩" disabled>홍콩</option>
					<option value="기타" disabled>기타</option>
				</select>
			</div>
			<div class="withFloat subbox" style="width: 350px;">
				<label for="region">지역*</label> <select class="form-control" id="region" name="region">
					<option value="서울">서울</option>
					<option value="부산">부산</option>
					<option value="대구">대구</option>
					<option value="인천">인천</option>
					<option value="광주">광주</option>
					<option value="대전">대전</option>
					<option value="울산">울산</option>
					<option value="세종">세종</option>
					<option value="경기">경기</option>
					<option value="강원">강원</option>
					<option value="충북">충북</option>
					<option value="충남">충남</option>
					<option value="전북">전북</option>
					<option value="전남">전남</option>
					<option value="경북">경북</option>
					<option value="경남">경남</option>
					<option value="제주">제주</option>
				</select>
			</div>
		</div>


		<div class="subbox" style="width: 750px;">
			<label for="address">대표 주소*</label> <input type="text"
				class="form-control" id="address" name="address"
				placeholder="대표 주소 입력" required>
		</div>


		<div class="box">
			<div class="withFloat subbox" style="width: 350px;">
				<label for="regNum">사업자 등록 번호*</label> <input type="text"
					class="form-control" id="regNum" name="regNum"
					placeholder="'-'제외 10자리" required>
			</div>
			<div class="withFloat subbox" style="width: 350px;">
				<label for="sales">매출액/투자금액*(승인기준: 매출액/투자유치 5억원 이상)*</label> <input
					type="text" class="form-control" id="sales" name="sales"
					placeholder="매출액 / 투자금액 입력 (단위: 억원)" required>
			</div>
		</div>


		<div class="box">
			<div class="withFloat subbox" style="width: 350px;">
				<label for="industry">산업군*</label> <select class="form-control"
					id="industry" name="industry">
					<option selected>IT/컨텐츠</option>
				</select>
			</div>
			
			<div class="withFloat subbox" style="width: 350px;">
				<label for="employeeNum">직원수(승인기준: 팀원 10명 이상)*</label> 
				<input type="text" class="form-control" id="employeeNum" name="employeeNum" required>
			</div>
		</div>


		<div class="subbox" style="width: 750px;">
			<label for="introduction">회사/서비스 소개 (1,300자 제한)*</label>
			<textarea class="form-control" id="introduction" name="introduction"
				style="height: 200px; resize: none;" placeholder="회사 정보 입력" required></textarea>
		</div>                  


		<div class="box">
		
			<div class="withFloat subbox" style="width: 350px;">
				<label for="establishment">설립연도*</label> 
				<select class="form-control" id="establishment" name="establishment">
					<option selected disabled>ex)2012년</option>
				</select>
			</div>
			
			<div class="withFloat subbox" style="width: 350px;">
				<label for="email">정보수신 이메일*</label> <input type="text"
					class="form-control" id="email" name="email" required>
			</div>
			
		</div>


		<div class="box">
			<div class="withFloat subbox" style="width: 350px;">
				<label for="webAddress">웹사이트 주소*</label> <input type="text"
					class="form-control" id="webAddress" name="webAddress" required>
			</div>
	
			<div class="withFloat subbox" style="width: 350px; backgound: transparent; border: none; padding:7px, 10px;">
				<label for="photo">대표사진</label>
				<input type="file" id="photo" name="photo" placeholder="Picture" class="form-control">
			</div>
		</div>

		<div class="subbox" style="width: 750px;">
			<label for="terms">기업회원 이용약관</label>
			<textarea class="form-control" id="terms"
				style="height: 200px; resize: none; overflow-y: scroll;">제 1 조 (목적)
                본 약관은 주식회사 원티드랩 (이하 "회사")이 운영하는 "서비스"를 이용함에 있어 "회사"와 회원간의 이용 조건 및 제반 절차, 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 한다.
                
                제 2 조 (용어의 정의)
                이 약관에서 사용하는 용어의 정의는 아래와 같다.
                1. "사이트"라 함은 회사가 서비스를 "회원"에게 제공하기 위하여 컴퓨터 등 정보 통신 설비를 이용하여 설정한 가상의 영업장 또는 회사가 운영하는 아래 웹사이트를 말한다.</textarea>
		</div>

		<hr>


		<div class="form-check subbox">
			<input class="form-check-input" type="checkbox" id="checked"
				name="checked" value="checked"> 이용약관 및 야나도 기업회원 가입에 동의합니다.
			<button type="submit" class="btn btn-primary" id="submit">제출하기</button>
		</div>


	</form>




	<script>

	    var establishment = document.getElementById("establishment");
	
	    for (var i = 1900; i <= 2021; i++) {
	        var op = new Option();
	        op.value = i;
	        op.text = i + "년";
	        establishment.options.add(op);
	    }
	    
	    <c:if test="${dto.state == '0'}">
	    	$("input[name=checked]").prop("checked", true);
	    	$("input[class=form-control]").prop("disabled", true);
	    	$("textarea[class=form-control]").prop("disabled", true);
	    	$("select[class=form-control]").prop("disabled", true);
	    	$("input[name=checked]").prop("disabled", true);
	    	
	    	
	    	$("input[name=name]").val("${dto.name}");
	    	$("select[name=country]").val("${dto.country}").prop("selected", true);
	    	$("select[name=region]").val("${dto.region}").prop("selected", true);
	    	$("input[name=address]").val("${dto.address}");
	    	$("input[name=regNum]").val("${dto.regNum}");
	    	$("input[name=sales]").val("${dto.sales}");
	    	//$("select[name=industry]").val("${dto.industry}").prop("selected", true);
	    	$("input[name=employeeNum]").val("${dto.employeeNum}");
	    	$("textarea[name=introduction]").val("${dto.introduction}");
	    	$("select[name=establishment]").val("${dto.establishment}").prop("selected", true);
	    	$("input[name=email]").val("${dto.email}");
	    	$("input[name=webAddress]").val("${dto.webAddress}");
	    	$("input[name=photo]").val("${dto.photo}");
	     
	    </c:if>
	    
	    
	    /* 입력한 정보 유효성 검사 */
		$("#companyJoin").submit(function(evt) {

			if ($("#name").length > 5) {
				alert("기업명은 15자 이내로 입력해주세요.");
				$("#managerName").focus();
				evt.preventDefault();
				return false;
			}           
	
			
			if ($("#address").length > 30) {
				alert("주소는 30자 이내로 입력해주세요.");
				$("#address").focus();
				evt.preventDefault();
				return false;
			}		
			
			if(isNaN($("#regNum").val())) {
				alert("사업자 등록 번호는 숫자로 입력해주세요.");
				$("#regNum").focus();
				evt.preventDefault();
				return false;
			}
			
			if ($("#regNum").val().trim().replace(/-/gi, "").length > 10) {
				alert("사업자 등록 번호는 '-' 제외 10자입니다.");
				$("#regNum").focus();
				evt.preventDefault();
				return false;
			}
			
			if(isNaN($("#sales").val())) {
				alert("매출액/투자금액은 숫자만 입력해주세요.(단위: 원)");
				$("#sales").focus();
				evt.preventDefault();
				return false;
			}
			
 			if(isNaN($("#employeeNum").val())) {
				alert("직원수는 숫자만 입력해주세요.");
				$("#employeeNum").focus();
				evt.preventDefault();
				return false;
			}
			
			if ($("#introduction").val().length > 1300) {
				alert("회사/서비스소개는 1300자 이내로 입력해주세요.");
				$("#introduction").focus();
				evt.preventDefault();
				return false;
			}
			
			
			if ($("#webAddress").val().length > 50) {
				alert("웹사이트 주소는 50자 이내로 입력해주세요.");
				$("#webAddress").focus();
				evt.preventDefault();
				return false;
			}
	
			if (!$("#checked").prop('checked')) {
				alert("이용약관 및 야나도 기업회원 가입에 동의해주세요.");
				evt.preventDefault();
				return false;
			}
	
		});
	    

    
	</script>
</body>
</html>
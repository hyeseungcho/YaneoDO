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

<link rel="stylesheet" href="/yaneodo/css/member/register.css">
<link rel="stylesheet" href="/yaneodo/css/member/header.css">
<link rel="stylesheet" href="/yaneodo/css/member/footer.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>



<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/member/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<form method="POST" action="/yaneodo/member/registerok.do" enctype="multipart/form-data" id="form1">
		<div class="form-group box" id="jointitle">회원가입</div>

		<div class="box">
			<label for="name">이름</label> <input type="text" class="form-control"
				id="name" name="name" placeholder="이름을 입력해주세요." required>
		</div>

		<div class="box">
			<label for="nickName">닉네임</label> <input type="text"
				class="form-control" id="nickName" name="nickName"
				placeholder="사용할 닉네임을 입력해주세요." required>
		</div>

		<div class="box">
			<label for="email">이메일</label> <input type="email"
				class="form-control" id="email" name="email"
				placeholder="이메일을 입력해주세요." required>
		</div>

		<div class="box">
			<label for="phone">휴대폰 번호</label> <input type="text"
				class="form-control" id="phone" name="phone"
				placeholder="(예시)01034567890" required>
		</div>

		<div class="box">
			<label for="password">비밀번호</label> <input type="password"
				class="form-control" id="password" name="password"
				placeholder="비밀번호를 6자 이상 입력해주세요." required>
		</div>

		<div class="box">
			<label for="cpassword">비밀번호 확인</label> <input type="password"
				class="form-control" id="cpassword" name="cpassword"
				placeholder="비밀번호를 다시 한번 입력해주세요." required>
		</div>

		<div class="box">
			<label for="birth">생년월일</label>

			<div class="" id="birth">
				<div class="withFloat" id="">
					<select class="form-control" id="year" name="year"
						style="width: 100px;">
						<!-- <option selected>1990년</option> -->
					</select>
				</div>

				<div class="withFloat" id="">
					<select class="form-control" id="month" name="month"
						style="width: 80px;">
						<option value="1">1월</option>
						<option value="2">2월</option>
						<option value="3">3월</option>
						<option value="4">4월</option>
						<option value="5">5월</option>
						<option value="6">6월</option>
						<option value="7">7월</option>
						<option value="8">8월</option>
						<option value="9">9월</option>
						<option value="10">10월</option>
						<option value="11">11월</option>
						<option value="12">12월</option>
					</select>
				</div>

				<div class="withFloat" id="">
					<select class="form-control" id="date" name="date"
						style="width: 80px;">
					</select>
				</div>
				<div style="clear: both;"></div>
				<!-- </div> -->
			</div>
		</div>

		<div class="form-check box">
			<input type="checkbox" class="form-check-input" id="agree"
				name="agree" value="checked">개인정보 수집 및 이용 동의(필수) <a><small>자세히</small></a>
		</div>
		<div class="box">
			<button type="submit" class="btn btn-primary" id="submit">회원가입</button>
		</div>

	</form>



	<script>
	
		var year = document.getElementById("year");
		var month = document.getElementById("month");
		var date = document.getElementById("date");

		var now = new Date();
		curYear = now.getFullYear();

		for (var i = curYear - 60; i <= curYear; i++) {
			var op = new Option();
			op.value = i;
			op.text = i + "년";
			year.options.add(op);
		}

		for (var i = 1; i <= 31; i++) {
			var op = new Option();
			op.value = i;
			op.text = i + "일";
			date.options.add(op);
		}

		//기본 선택
		// console.log(year = year.value.substr(0, 4));
		// console.log(month.value.substr(0, month.value.length - 1) - 1);

		//년 선택 -> 해당 년/월의 마지막 날 동적으로 추가  
		year.onchange = function() {

			//해당 월의 마지막 날짜?
			var lastDate = new Date(year.value, month.value, 0).getDate();

			date.options.length = 0;

			for (var i = 1; i <= lastDate; i++) {

				var op = new Option();
				op.value = i;
				op.text = i + "일";
				date.options.add(op);
			}
		}

		//월 선택 -> 해당 월의 마지막 날 동적으로 추가
		month.onchange = function() {

			//해당 월의 마지막 날짜?
			var lastDate = new Date(year.value, month.value, 0).getDate();

			date.options.length = 0;

			for (var i = 1; i <= lastDate; i++) {

				var op = new Option();
				op.value = i;
				op.text = i + "일";
				date.options.add(op);
			}

		}
		
		
		/* 입력한 정보 유효성 검사 */
		$("#form1").submit(function(evt) {
			
			var name = $("#name").val().trim();
			
			//이름, 닉네임 길이 확인
			if (name.length < 2 || name.length > 5) {
				alert("이름은 2자 이상 5자 이내로 입력해주세요.");
				$("#name").focus();
				evt.preventDefault();
				return false;
			}           

			for (var i = 0; i < name.length; i++) {
				if (name.charAt(i) < '가' || name.charAt(i) > '힣') {
					alert("이름은 한글로 입력해주세요.");
					$("#name").focus();
					evt.preventDefault();
					return false;
				}			
			}
		

			if ($("#nickName").val().trim().length < 2 || $("#nickName").val().trim().length > 6) {
				alert("닉네임은 2자 이상 6자 이내로 입력해주세요.");
				$("#nickName").focus();
				evt.preventDefault();
				return false;
			}

			
			//휴대폰 번호
			if ($("#phone").val().trim().replace(/-/gi, "").length > 11) {
				alert("휴대폰 번호는 '-' 제외 11자 이내로 입력해주세요.");
				$("#phone").focus();
				evt.preventDefault();
				return false;
			}
			
			//암호 & 암호 확인이 일치하는지?	
			if ($("#password").val().trim().length < 6) {
				alert("비밀번호는 6자 이상 입력해주세요.");
				$("#password").focus();
				evt.preventDefault();
				return false;
			}
			
			if ($("#password").val() != $("#cpassword").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("password").focus();			
				evt.preventDefault();
				return false;
			}
			
			console.log($("#agree").prop('checked'));
			
			if (!$("#agree").prop('checked')) {
				alert("개인정보 수집 및 이용에 동의해주세요.");
				evt.preventDefault();
				return false;
			}

		});

		
	</script>
</body>
</html>
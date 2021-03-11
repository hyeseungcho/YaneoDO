<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/match/list.css">
<style>
.modal-body .row {
	margin-top: 30px;
}
#search-reasult .glyphicon-star .glyphicon-star-empty {
	color: blue;
	font-size: 15px;
	line-height: 30px;
}
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="container">
		<!-- search -->
		<div id="section-search">
			<div id="searcharea">
				<div class="row">
					<div class="title">찾고 있는 인재의 직무를 설정하고 검색할 수 있습니다</div>
				</div>
				<form method="GET" action="/yaneodo/company/match/list.do"
					id="searchForm">
					<div class="row">
						<div class="col-md-3">
							<select class="form-control search-slt" id="jobtype"
								name="jobtype">
								<option value="">전체직무</option>
								<c:forEach items="${jlist}" var="job">
									<option value="${job}">${job}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-7">
							<input type="text" id="search" name="search"
								class="form-control search-slt" placeholder="검색어를 입력하세요">
						</div>
						<div class="col-md-2 ">
							<button type="submit" class="btn btn-primary btn-search">검색</button>
						</div>
					</div>
				</form>

				<div class="row">
					<div class="col-md-3 col-md-offset-9 ">
						<input type="radio" name="gender" value="male" class="radio-item">
						<label for="male">이력서 있음</label> <input type="radio" name="gender"
							value="female" class="radio-item"> <label for="female">최신순</label>
						<input type="radio" name="gender" value="other" class="radio-item">
						<label for="other">열람순</label>
					</div>
				</div>
			</div>
		</div>
		<!-- search 끝 -->



		<!-- sidemenu -->
		<div id="side-matchup">
			<div class="sideGroup">
				<div>
					<input type="button" value="서비스 결제하기"
						class="btn btn-primary btn-middle" data-toggle="modal"
						data-target="#service">
				</div>
				<ul>
					<li class="side-list-item side-list-item-selected"
						onclick="location.href='/yaneodo/company/match/list.do';">
						목록전체</li>
					<li class="side-list-item"
						onclick="location.href='/yaneodo/company/match/list.do?isdibs=1';">찜한
						목록</li>
					<li class="side-list-item"
						onclick="location.href='/yaneodo/company/match/list.do?isread=0';">미열람
						목록</li>
					<li class="side-list-item"
						onclick="location.href='/yaneodo/company/match/list.do?isread=1';">열람한
						목록</li>
					<li class="side-list-item"
						onclick="location.href='/yaneodo/company/match/list.do?ismatch=1';">면접
						제안한 목록</li>
				</ul>
			</div>
		</div>
		<!-- sidemenu 끝 -->


		<!-- search-reasult -->
		<div id="search-reasult">
			<div class="container matchList">
				<c:forEach items="${list}" var="dto">
					<div class="row">
						<div class="col-md-2 left-item">
							<div class="pic">
								<img src="/yaneodo/images/company/man_01.png" alt="">
							</div>
							<!-- <div>번호</div> -->

						</div>
						<div class="col-md-10 right-item">
							<div class="matchTitle">${dto.jobtype}</div>
							<div class="subInfo">
								<c:if test="${dto.career.equals('신입')}">
                        신입
                        </c:if>
								<c:if test="${!dto.career.equals('신입')}">
                        경력
                        </c:if>
								| 직장명 : ${dto.company } <span class="subInfo"> <c:if
										test="${!dto.career.equals('신입')}">
                       	(${dto.career })
                        </c:if>
								</span>
							</div>
							<div>
								<span>${dto.introduction }</span>
							</div>
							<div class="subInfo">${dto.school }
								<span>${dto.major }</span>
							</div>
							<div class="row">
								<c:if test="${dto.isdibs.equals('1')}">
									<button class="btn btn-default col-md-offset-7"
										onclick="location.href='/yaneodo/company/match/dibsdeleteok.do?pseq=${dto.profileseq}&isdibs=${isdibs}&jobtype=${jobjype }&isread=${isread}&ismatch=${ismatch}&search=${search}&page=${pate}'">
										<span class="glyphicon glyphicon-star"
											style="color: #2886FA; font-size: 12px;"></span>&nbsp;찜하기 취소
									</button>
								</c:if>

								<c:if test="${dto.isdibs.equals('0')}">
									<button class="btn btn-default col-md-offset-8"
										onclick="location.href='/yaneodo/company/match/dibsaddok.do?pseq=${dto.profileseq}&isdibs=${isdibs}&jobtype=${jobjype }&isread=${isread}&ismatch=${ismatch}&search=${search}&page=${pate}'">
										<span class="glyphicon glyphicon-star-empty"
											style="color: #2886FA; font-size: 12px;"></span>&nbsp;찜하기
									</button>
								</c:if>


								<c:if test="${dto.isread.equals('1')}">
									<input type="button" class="btn btn-primary col-md-offset-0"
										data-toggle="modal" data-profileseq="${dto.profileseq}"
										data-resumeseq="${dto.resumeseq }"
										data-target="#modalResumeDetail" value="이력서 상세보기">
								</c:if>

								<c:if test="${dto.isread.equals('0')}">
									<input type="button" class="btn btn-primary col-md-offset-0"
										data-toggle="modal" data-profileseq="${dto.profileseq}"
										data-resumeseq="${dto.resumeseq }"
										data-target="#modalResumePreview" value="이력서 미리보기">
								</c:if>

							</div>

						</div>
					</div>
				</c:forEach>
			</div>




			<!-- 페이지네이션 -->
			<div id="paging">
				<nav aria-label="Page navigation">
					<ul class="pagination">${pagebar}
					</ul>
				</nav>
			</div>

		</div>
		<div style="clear: both;"></div>

	</div>

	<!-- 이력서 미리보기 Modal -->
	<div class="modal modal-center fade" id="modalResumePreview"
		tabindex="-1" role="dialog">
		<div class="modal-dialog modal-center modal-80size " role="document">
			<div class="modal-content modal-80size">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이력서 미리보기</h4>
				</div>
				<div class="modal-body first-body">
					<div class="title" id="mrpName">박OO</div>
					<div class="subtitle">
						이메일 : <span class="text masking" id="mrpEmail">test@test.com</span>
					</div>
					<div class="subtitle">
						연락처 : <span class="text masking" id="mrpPhone">010-1234-5678</span>
					</div>
					<div class="text" id="mrpIntro">
						<span>착목한는 곳이 원대하고 그들은 피가 더운지라 실현에 대한 자신과 용기가 있다 그러므로 그들은
							이상의 보배를 능히 품으며</span><span class="masking">그들의 이상은 아름답고 소담스러운 열매를
							맺어 우리 인생을 풍부하게 하는 것이다 보라 청춘을 ! 그들의</span>
					</div>
				</div>
				<div class="modal-body" id="mrpResumeData">
					<!-- JSON으로 받아온 데이터  -->
				</div>
				<div class="modal-footer viewinfo">
					<span class="modal-footer-text">상세이력 확인시, 열람권이 1회 차감됩니다</span>
					<button type="button" class="btn btn-info" name="btnresumedetail" data-toggle="modal"
						data-target="#modalReading">이력서 상세보기</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- 열람권 차감 Modal -->
	<div class="modal fade" id="modalReading" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">이력서 상세보기</h4>
				</div>
				<div class="modal-body">이력서 상세보기는 열람권 1개가 차감됩니다 이 회원의 이력서에
					열람권을 사용하시겠습니까?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" name="btnReading" id="btnReading" class="btn btn-primary"
						data-toggle="modal" data-target="#modalResumeDetail">사용하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 열람권 차감 Modal 끝-->


	<!-- 이력서 상세보기 Modal -->
	<div class="modal modal-center fade" id="modalResumeDetail"
		tabindex="-1" role="dialog">
		<div class="modal-dialog modal-center modal-80size " role="document">
			<div class="modal-content modal-80size">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">이력서 상세보기</h4>
				</div>
				<div class="modal-body first-body">
					<div class="modal-content-top">
						<div class="title">
							<span id="mrdName"></span>
							<div class="downlaod">
								<span class="modal-body-title-download">이력서 다운로드하기</span> <span
									class="glyphicon glyphicon-download-alt"></span>
							</div>
						</div>
						<div class="subtitle">
							이메일 : <span class="text" id="mrdEmail"></span>
						</div>
						<div class="subtitle">
							연락처 : <span class="text" id="mrdPhone"></span>
						</div>
						<div class="text" id="mrdIntro"></div>
					</div>
					<div class="blue-masking">후보자가 제안을 수락할 경우 이름과 이메일, 연락처를 확인할 수
						있습니다</div>
					<div class="modal-content-middle" id="mrdResumeData"></div>


					<div class="modal-footer resume-detail-footer">
						<div class="footer-left">
							<p class="resume-detail-footer-text">후보자가 마음에 든다면, 면접을 제안하세요</p>
							<p class="resume-detail-footer-text">열람된 이력서는 지원자 탭에 별도로
								보관됩니다</p>
						</div>
						<div class="footer-right">
							<button type="button" class="btn btn-info" data-toggle="modal" name="btnoffer"
								data-target="#interview" id="btnInterview">제안 보내러 가기</button>
						</div>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>


	<!-- 면접제안 Modal -->
	<div class="modal modal-center fade" id="interview" tabindex="-1"
		role="dialog">
		<div class="modal-dialog modal-center modal-60size " role="document">
			<div class="modal-content modal-60size">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">면접 제안</h4>
				</div>
				<div class="modal-body">
					<div class="modal-body-title">제안 메세지</div>
					<div>
						<textarea class="form-control" rows="8"></textarea>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="modal-body-title">직급</div>
						</div>
						<div class="col-md-8">
							<div class="modal-body-title">
								연봉<span style="font-size: 0.7em;"> (단위:만원)</span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<input type="text" class="form-control">
						</div>
						<div class="col-md-8">
							<div class="col-md-5">
								<input type="text" class="form-control">
							</div>
							<div class="col-md-1">~</div>
							<div class="col-md-5">
								<input type="text" class="form-control">
							</div>
						</div>
					</div>
					<div class="modal-body-title">포지션 선택</div>
					<select name="" id="" class="form-control">
						<option value="test">test</option>
					</select>
					<div class="modal-body-title">근무 지역</div>
					<input type="text" class="form-control">
					<div class="modal-body-title">스톡옵션 여부</div>
					<input type="text" class="form-control">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary">보내기</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- 서비스 플랜 Modal -->
	<div class="modal modal-center fade" id="service" tabindex="-1"
		role="dialog">
		<div class="modal-dialog modal-center modal-70size" role="document">
			<div class="modal-content modal-70size">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">서비스 플랜</h4>
				</div>
				<div class="modal-body">
					<div class="container">
						<div class="col-md-5 service-box basic">
							<div class="top">
								<p class="title">베이직
								<p>
								<p class="subtitle">1,000,000 원</p>
								<p class="detail">부가세 별도</p>
							</div>
							<div class="bottom">
								<p class="subtitle">30일간 최대 100건의 이력서 열람 및 면접제안</p>
								<p class="detail">채용 수수료 무료</p>
								<p class="detail">학력/경력 등 상세 이력 확인</p>
								<p class="detail">100건 상세 이력서 열람</p>
								<p class="detail">100회 제안 보내기 기능</p>
								<p class="detail">유효기간 : 구매일로부터 30일</p>
							</div>


						</div>
						<div class="col-md-5 service-box lite">
							<div class="top">
								<p class="title">라이트
								<p>
								<p class="subtitle">500,000 원</p>
								<p class="detail">부가세 별도</p>
							</div>
							<div class="bottom">
								<p class="subtitle">30일간 최대 30건의 이력서 열람 및 면접제안</p>
								<p class="detail">채용 수수료 무료</p>
								<p class="detail">학력/경력 등 상세 이력 확인</p>
								<p class="detail">30건 상세 이력서 열람</p>
								<p class="detail">30회 제안 보내기 기능</p>
								<p class="detail">유효기간 : 구매일로부터 30일</p>
							</div>

						</div>
					</div>
				</div>
				<div class="modal-footer container">
					<button type="button" class="btn btn-primary col-md-12">선택하기</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<script>
    
	
    // modal 창 조작
    $(document).ready(function() {
        $("#btnReading").click(function() {
            $('#modalResumePreview').modal('hide');
            $('#modalReading').modal('hide');
        });
        $("#btnInterview").click(function() {
            $('#modalResumeDetail').modal('hide');
        });
        
        // 검색어 상태유지
        $("#search").val("${search}");
        
        // 직무선택 select 유지
        $("#jobtype").val("${jobtype}").prop("selected", true);
        
       	// 사이드 메뉴 클릭
    	$(".sideGroup ul li").click(function() {
   		  //alert(this);
   		  this.addClass("side-list-item-selected");
   		});
    });
    /*
    let pseq = $('#btnresumedetail');
    console.log(pseq);
    let rseq = $('#btnresumedetail').data('resumeseq');
    */
    
    let pseq;
    let rseq;
    
 
    //이력서 미리보기 Modal
    $('#modalResumePreview').on('show.bs.modal', function(e) {
        //get data-id attribute of the clicked element
        pseq = $(e.relatedTarget).data('profileseq');
        rseq = $(e.relatedTarget).data('resumeseq');
        
        //populate the textbox
        //$(e.currentTarget).find('input[name="bookId"]').val(bookId);
        
        //alert(pseq + ' ' +rseq);
      
        
        //json ajax 요청 - 이력서 코드
        $.ajax({
        	type: "GET",
        	url: "/yaneodo/company/match/resumedata.do",
        	dataType: "text",
        	data: "rseq=" + rseq,
        	success: function(result) {
        		//console.log(result);
        		$("#mrpResumeData").html(result);
        		$("#mrpResumeData").children("div").nextAll("div").remove();
       	},
        	error: function(a,b,c) {
        		console.log(a,b,c);
        	}
        })
        
        
        //json ajax 요청 - 사용자정보
        $.ajax({
        	type: "GET",
        	url: "/yaneodo/company/match/customerdata.do",
        	dataType: "json",
        	data: "pseq=" + pseq,
        	success: function(result) {
        		//console.log(result);
        		$("#mrpName").text(result.name);
        		$("#mrpEmail").text(result.eamil);
        		$("#mrpPhone").text(result.phone);
        		$("#mrpIntro").text(result.intro);
        		
        	},
        	error: function(a,b,c) {
        		console.log(a,b,c);
        	}
        })
        
    });
    
    //onclick="location.href='/yaneodo/company/match/resumedetailok.do'"
    
    // 이력서 상세보기 확인 Modal - 열람권 차감
    $('#modalReading').on('show.bs.modal', function(e) {
    	
    	//pseq = $(e.relatedTarget).data('profileseq');
        //rseq = $(e.relatedTarget).data('resumeseq');
        
        
    	 $('#btnReading').click(function() {
    		//json ajax 요청 - 열람권 1회 차감 + resumeread 테이블에 추가
    	        $.ajax({
    	        	type: "GET",
    	        	url: "/yaneodo/company/match/resumedetailok.do",
    	        	dataType: "text",
    	        	data: "pseq=" + pseq,
    	        	success: function(result) {
    	        		console.log(result);
    	        		if (result == 1) {
	    	        		alert("열람권 1개가 차감되었습니다.")
	    	        		
    	        		} else {
    	        			alert("열람권이 부족합니다")
    	        			return;
    	        		}
    	       	},
				error: function(a,b,c) {
    	        		console.log(a,b,c);
    	        	}
    	        })
    	        
    	 });
    	 
    });
    
    
    // 이력서 상세보기 Modal
 
    $('#modalResumeDetail').on('show.bs.modal', function(e) {
    	
    	//pseq = $(e.relatedTarget).data('profileseq');
        //rseq = $(e.relatedTarget).data('resumeseq');
        
       
        
      //json ajax 요청 - 이력서 코드
        $.ajax({
        	type: "GET",
        	url: "/yaneodo/company/match/resumedata.do",
        	dataType: "text",
        	data: "rseq=" + rseq,
        	success: function(result) {
        		//console.log(result);
        		$("#mrdResumeData").html(result);
       	},
        	error: function(a,b,c) {
        		console.log(a,b,c);
        	}
        })
        
        
        //json ajax 요청 - 사용자정보
        $.ajax({
        	type: "GET",
        	url: "/yaneodo/company/match/customerdata.do",
        	dataType: "json",
        	data: "pseq=" + pseq,
        	success: function(result) {
        		//console.log(result);
        		$("#mrdName").text(result.name);
        		$("#mrdEmail").text(result.eamil);
        		$("#mrdPhone").text(result.phone);
        		$("#mrdIntro").text(result.intro);
        		
        	},
        	error: function(a,b,c) {
        		console.log(a,b,c);
        	}
        })
        
    	
    });
    
    
    </script>
</body>
</html>
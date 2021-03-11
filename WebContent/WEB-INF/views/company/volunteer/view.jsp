<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/volunteer/view.css">
    <style>

        .resumeData .row {
            border-top: 1px solid #ccc;
            padding-top: 25px;
            padding-bottom: 10px;
        }

    </style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="container">
		<!-- sidemenu -->
		<div id="side-member">
			<div class="sideGroup">
				<div class="sideName">채용중인 포지션</div>
				<ul>
					<li class="side-list-item side-list-item-selected"
						onclick="location.href='layout.html';">전체보기</li>
					<li class="side-list-item">Android developer</li>
					<li class="side-list-item">IOS developer</li>
					<li class="side-list-item" onclick="location.href='matchup.html';">매치업</li>
				</ul>
			</div>
			<div class="sideGroup">
				<div class="sideName">마감된 포지션</div>
				<ul>
					<li class="side-list-item">서버개발자</li>
				</ul>
			</div>
		</div>
		<!-- sidemenu 끝 -->


		<div id="content">
			<div class="view-info">
				<div class="container">
					<div class="row make-line">
						<div class="col-md-8 title ">
							<div class="col-md-3 pic">
								<img src="/project/views/image/man_01.png" alt="">
							</div>

							<div class="col-md-3 name">
								<span>${vdto.name }</span>
							</div>
							<div class="col-md-1">
								<span class="label label-warning tag">매치업</span>
							</div>

						</div>
						<div class="col-md-4">
							<input type="button" class="btn btn-default" style="margin-left: 10px;" onclick="history.back();" value="돌아가기">
							<input type="button" class="btn btn-primary" data-toggle="modal" data-target="#interview" id="btnInterview" value="보낸 제안 확인">
						</div>
					</div>

					<div class="row">
						<div class="col-md-2 subtitle">타임라인</div>
						<div class="col-md-9 subtitle">
							<p>매칭 : ${vdto.readdate }</p>
							<p>제안 : ${vdto.sgdate }</p>
						</div>
					</div>
				</div>
			</div>

			<!-- 이력서 부분 -->
			<div class="view-resume">
				<div class="view-resume-header">
					<div class="title">이력서 & 첨부파일</div>
					<div>
						<span class="glyphicon glyphicon-file"></span> 원티드 이력서
					</div>
				</div>
				<div class="view-resume-container">
					<div class="view-resume-body">
						<div class="title">${vdto.name }</div>
						<div class="subtitle">
							이메일 : <span class="text ">test@test.com</span>
						</div>
						<div class="subtitle">
							연락처 : <span class="text ">010-1234-5678</span>
						</div>
						<p>착목한는 곳이 원대하고 그들은 피가 더운지라 실현에 대한 자신과 용기가 있다 그러므로 그들은 이상의 보배를
							능히 품으며 그들의 이상은 아름답고 소담스러운 열매를 맺어 우리 인생을 풍부하게 하는 것이다 보라 청춘을 ! 그들의</p>
						
						<div class="container resumeData">
							${resumeData}
						</div>
					</div>
					<div class="masking">후보자가 제안을 수락할 경우 이름, 연락처, 이메일을 확인할 수 있습니다
					</div>

				</div>
			</div>
		</div>
		<div style="clear: both;"></div>

	</div>
	
	<!-- 면접제안 Modal -->
     <div class="modal modal-center fade" id="interview" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-center modal-60size " role="document">
          <div class="modal-content modal-60size">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">면접 제안</h4>
            </div>
            <div class="modal-body">
                <div class="modal-body-title"> 제안 메세지 </div>
                <div><textarea class="form-control" rows="8" >${vdto.message }</textarea></div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="modal-body-title">직급</div>
                    </div>
                    <div class="col-md-6">
                        <div class="modal-body-title">연봉<span style="font-size: 0.7em;"> (단위:만원)</span></div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <input type="text" class="form-control" value="${vdto.rank }">
                    </div>
                    <div class="col-md-6">
                        <input type="text" class="form-control" value="${vdto.income }"> 
                    </div>
                </div>
                <div class="modal-body-title"> 포지션 선택 </div>
                <select name="" id="" class="form-control">
                    <option value="test">test</option>
                </select>
                <div class="modal-body-title"> 근무 지역 </div>
                <input type="text" class="form-control" value="${vdto.area }">
                <div class="modal-body-title"> 스톡옵션 여부 </div>
                <input type="text" class="form-control" value="${vdto.stock }">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
              <button type="button" class="btn btn-primary">보내기</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
      </div><!-- /.modal -->


	<!-- ########## 하단 푸터 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 하단 푸터 끝 -->

	<script>

	</script>
</body>
</html>
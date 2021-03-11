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
<link rel="stylesheet" href="/yaneodo/css/company/position/list.css">
<style>
.btnGroup {
	text-align: right;
	position: relative;
	z-index: 10;
}

.caption {
	text-align: left;
}
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="container">
		<!-- section-heade -->
		<div id="section-header">
			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<h1>등록된 모집 공고</h1>
					</div>
					<div class="btn btn-primary col-md-offset-5"
						onclick="location.href='/yaneodo/company/position/add.do'";>모집공고
						등록하기</div>
				</div>
			</div>
		</div>
		<!-- section-heade end -->


		<!-- section-body -->
		<div id="section-body">
			<div class="row">
				<c:forEach items="${list}" var="dto">
					<div class="col-md-4">
						<div class="thumbnail position-item">
							<div onclick="location.href='/yaneodo/company/position/view.do?jseq=${dto.jobopeningseq}'">
								<div style="padding: 10px">
									<img src="/yaneodo/files/${dto.photo}" alt="...">
								</div>
								<div class="caption">
									<h3>${dto.title }</h3>
									<div>채용직무 : ${dto.job}</div>
									<div>채용시작일 : ${dto.startdate}</div>
									<div>채용마감일 : ${dto.enddate}</div>
								</div>
							</div>
							<div>
								<div class="btnGroup">
									<a href="#" class="btn btn-primary" role="button"
										onclick="location.href='/yaneodo/company/position/edit.do?jseq=${dto.jobopeningseq}'" )>수정하기</a>
									<a href="#" class="btn btn-default" role="button">삭제하기</a>
								</div>
							</div>

						</div>

					</div>
				</c:forEach>

			</div>
			<!-- section-body end -->

		</div>
	</div>


	<!-- ########## 푸터 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 푸터 끝 -->

	<script>
		
	</script>
</body>
</html>
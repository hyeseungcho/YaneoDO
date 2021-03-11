<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("replaceChar", "\n"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/position/view.css">

<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="container">
		<!-- section-header -->
		<div class="section-header">
			<div class="container">
				<div class="row">
					<div class="col-md-9">
						<h1>모집공고 조회</h1>
					</div>
					<div class="btn btn-primary col-md-1"
						onclick="location.href='/yaneodo/company/position/edit.do?jseq=${jseq}'">수정하기
					</div>
					<div class="btn btn-danger col-md-1" data-toggle="modal"
						data-target="#positionDelete">삭제하기</div>
				</div>
			</div>
		</div>
		<!-- section-header end -->

		<div class="section-body">
			<div class="section-image">
				<img src='/yaneodo/files/${pdto.photo}' style="width: 795px; height: 595px;">
			</div>
			<div class="title">${pdto.title}</div>
			<div class="subtitle">${pdto.name}/${pdto.region}</div>
			<div class="tag">
				<c:forEach items="${taglist}" var="tag">
					<span class="label label-default">${tag.tagname}</span>
				</c:forEach>
			</div>
			<div class="content detail">${fn:replace(pdto.description, replaceChar, "<br/>")}
			</div>
		</div>

		<div class="section-body">
			<div class="subtitle">
				마감일 :&nbsp;<span class="detail">${pdto.enddate}</span>
			</div>
			<div class="subtitle">
				근무지역 :&nbsp;<span class="detail">${pdto.place}</span>
			</div>
			<!-- 카카오맵 -->
			<div id="map" style="width: 900px; height: 500px;"></div>
		</div>

		<div class="section-footer">
			<div>
				<a class="btn btn-default" onclick="location.href='/yaneodo/company/position/list.do'">돌아가기</a>
			</div>
		</div>
	</div>

	<!-- 포지션 삭제 Modal -->
	<div class="modal fade" id="positionDelete" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">모집공고 삭제하기</h4>
				</div>
				<div class="modal-body">정말 이 모집공고를 삭제하시겠습니까?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" id="btnReading" class="btn btn-danger" onclick="location.href='/yaneodo/company/position/deleteok.do?jseq=${jseq}'">삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 포지션 삭제 Modal 끝-->


	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=775d31cad8ed3352ed197ee1a04cc700&libraries=services"></script>
	<script>
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	// var place = ${pdto.place} + '';
	geocoder.addressSearch('${pdto.place}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${pdto.place}<br>${pdto.name}</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
		
	</script>
</body>
</html>
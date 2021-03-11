<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/info/view.css">
<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	   <%@include file="/WEB-INF/views/company/inc/header.jsp" %>
	<!-- ########## 상단 헤더 끝 -->
		
	 <div id="container">
        <!-- section-header -->
        <div class="section-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <h1>회사정보 조회</h1>
                    </div>
                    <div class="col-md-3">
                    	<input type="button" class="btn btn-primary" onclick="history.back();" value="수정완료하기">
                    </div>
                </div>
            </div>
        </div>
        <!-- section-header end -->
        <div class="section-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-11">
                        <div class="title">회사이름</div>
                        <input type="text" class="form-control">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5">
                        <div class="title">국가</div>
                        <select name="" id="" class="form-control">
                            <option value="테스트">테스트</option>
                        </select>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-5">
                        <div class="title">지역</div>
                        <select name="" id="" class="form-control">
                            <option value="테스트">테스트</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-11">
                        <div class="title">대표 주소</div>
                        <input type="text" class="form-control">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5">
                        <div class="title">사업자 등록 번호</div>
                        <input type="text" class="form-control">
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-5">
                        <div class="title">매출액/투자금액</div>
                        <input type="text" class="form-control">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5">
                        <div class="title">산업군</div>
                        <select name="" id="" class="form-control">
                            <option value="테스트">테스트</option>
                        </select>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-5">
                        <div class="title">직원수</div>
                        <input type="text" class="form-control">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-11">
                        <div class="title">회사 / 서비스소개</div>
                        <textarea name="" id="" cols="30" rows="10" class="form-control"></textarea>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5">
                        <div class="title">설립연도</div>
                        <input type="text" class="form-control">
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-5">
                        <div class="title">정보 수신 이메일</div>
                        <input type="text" class="form-control">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-5">
                        <div class="title">담당자 연락처</div>
                        <input type="text" class="form-control">
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-5">
                        <div class="title">웹사이트 주소</div>
                        <input type="text" class="form-control">
                    </div>
                </div>
            </div>
        </div>

        <div class="section-footer">

        </div>
    </div>
	
	
	<!-- ########## 하단 푸터 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 하단 푸터 끝 -->
	
	<script>

	</script>
</body>
</html>
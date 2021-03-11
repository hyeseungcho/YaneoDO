<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/company/inc/asset.jsp"%>
<link rel="stylesheet" href="/yaneodo/css/company/position/add.css">
<style>
</style>
</head>
<body>

	<!-- ########## 상단 헤더 시작 -->
	<%@include file="/WEB-INF/views/company/inc/header.jsp"%>
	<!-- ########## 상단 헤더 끝 -->

	<div id="container">
		<!-- section-heade -->
		<div class="section-header">
			<div class="container">
				<div class="row">
					<div class="col-md-9">
						<h1>모집공고 등록</h1>
					</div>
				</div>
			</div>
		</div>
		<!-- section-head end -->

		<!-- section-body -->
		<form method="POST" action="/yaneodo/company/position/addok.do"
			enctype="multipart/form-data">
			<div class="section-body">
				<div class="container">
					<div class="row">
						<div class="col-md-2 title">제목</div>
						<div class="col-md-3 content">
							<input type="text" id="title" name="title" class="form-control">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 title">공고 이미지</div>
						<div class="col-md-3 content">
							<input type="file" id="image" name="image"
								onchange="setThumbnail(event);">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 title"></div>
						<div class="col-md-3 content">
							<div class="col-md-3" id="imageContainer"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 title">채용 직무</div>
						<div class="col-md-2 content">
							<select class="form-control" id="job" name="job">
								<c:forEach items="${jlist}" var="job">
									<option value="${job}">${job}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 title">태그 등록</div>
						<div class="col-md-3 content">
							<input type="button" class="btn btn-primary" value="태그 등록하기"
								data-toggle="modal" data-target="#addTag">
						</div>
					</div>
					<div class="row">
						<div id="seleted-result" class="col-md-9">
<!-- 							<span class="label label-primary">#선택<span
								class="glyphicon glyphicon-remove remove"></span></span> <span
								class="label label-primary">#선택<span
								class="glyphicon glyphicon-remove remove"></span></span> <span
								class="label label-primary">#선택<span
								class="glyphicon glyphicon-remove remove"></span></span> <span
								class="label label-primary">#선택<span
								class="glyphicon glyphicon-remove remove"></span></span> <span
								class="label label-primary">#선택<span
								class="glyphicon glyphicon-remove remove"></span></span> -->
						</div>
						<div id="selectd-result-data">
<!-- 					<input type="hidden" name="tag" value="#태그명1"> 
						<input type="hidden" name="tag" value="#태그명2"> 
						<input type="hidden" name="tag" value="#태그명3"> 
						<input type="hidden" name="tag" value="#태그명4"> -->
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 title">마감일</div>
						<div class="col-md-3 content">
							<input type="text" class="form-control" id="enddate"
								name="enddate">
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 title">우편 번호</div>
						<div class="col-md-2 content">
							<input type="text" class="form-control" id="sample6_postcode" placeholder="우편번호" style="background-color: white;" disabled > 
							
						</div>
						<div class="col-md-2">
							<input type="button" class="btn btn-default" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" ><br> 
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 title" >근무 지역</div>
						<div class="col-md-6 content">
							<input type="text" class="form-control" id="sample6_address" name="place" placeholder="주소" style="background-color: white;" ><br>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 title">모집 상세 내용</div>
					</div>
					<div class="row">
						<div class="col-md-11">
							<textarea class="form-control" name="description"
								id="description" cols="50" rows="30"></textarea>
						</div>
					</div>
				</div>

			</div>

			<!-- section-body end -->


			<div class="section-footer">
				<div>
					<input type="submit" class="btn btn-primary" value="등록하기"
						style="margin-right: 20px"> <a class="btn btn-default"
						onclick="history.back();">돌아가기</a>
				</div>
			</div>
		</form>
	</div>

	<!-- container 끝 -->

	<!-- 태그등록 modal -->

	<div class="modal modal-center fade" id="addTag" tabindex="-1"
		role="dialog">
		<div class="modal-dialog modal-center modal-60size " role="document">
			<div class="modal-content modal-60size">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">태그 등록하기</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="title">태그 카테고리</div>
						<div class="col-md-6">
						<select class="form-control" id="tagcate" name="tagcate">
							<c:forEach items="${tclist}" var="tcdto">
								<option value="${tcdto.tagcategoryseq}">${tcdto.tagcategoryname}</option>
							</c:forEach>
						</select>
						</div>
					</div>
					<div class="row">
						<div class="title">검색 결과</div>
						<div id="search-result" class="search-result">
							<!-- 검색 결과도 동적으로 표시해야 한다 -->
<!-- 							<span class="label label-primary">#칼퇴보장</span> <span
								class="label label-primary">#간식</span> <span
								class="label label-primary">#커피</span> <span
								class="label label-primary">#50명이내</span> <span
								class="label label-primary">#스타트업</span> <span
								class="label label-primary">#중식</span> <span
								class="label label-primary">#이벤트</span> <span
								class="label label-primary">#태그입니다1</span> <span
								class="label label-primary">#태그입니다2</span> -->
						</div>
					</div>
					<div class="row">
						<div class="title">선택한 태그(최대 10개)</div>
						<div id="seleted-tag" class="seleted-tag">
<!-- 							<span class="label label-primary">#선택명<sapn
									class="glyphicon glyphicon-remove remove"></sapn></span> -->
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary" id="btnAddTag">등록완료</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->





	<!-- ########## 하단 푸터 시작 -->
	<%@include file="/WEB-INF/views/company/inc/footer.jsp"%>
	<!-- ########## 하단 푸터 끝 -->

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		var thumbnail = document.getElementById("imageContainer");

		function setThumbnail(event) {

			// alert(thumbnail.hasChildNodes())

			// 이미 선택된 이미지가 존재 한다면?
			if (thumbnail.hasChildNodes()) {
				// 삭제
				thumbnail.removeChild(thumbnail.firstChild);
			}
			;
			var reader = new FileReader();

			reader.onload = function(event) {

				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				img.style.width = 250 + "px";
				img.style.height = 250 + "px";
				img.style.border = "solid 1px #CCC"

				document.querySelector("div#imageContainer").appendChild(img);
			};

			reader.readAsDataURL(event.target.files[0]);
		}

		function sample6_execDaumPostcode() {
			new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수

					//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}

					// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					if (data.userSelectedType === 'R') {
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== ''
								&& /[동|로|가]$/g.test(data.bname)) {
							extraAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== ''
								&& data.apartment === 'Y') {
							extraAddr += (extraAddr !== '' ? ', '
									+ data.buildingName
									: data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraAddr !== '') {
							extraAddr = ' (' + extraAddr + ')';
						}
						// 조합된 참고항목을 해당 필드에 넣는다.
						//document.getElementById("sample6_extraAddress").value = extraAddr;

					} else {
						//document.getElementById("sample6_extraAddress").value = '';
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample6_postcode').value = data.zonecode;
					document.getElementById("sample6_address").value = addr;
				}
			}).open();
		}
		
		
		$("#addTag").on('show.bs.modal', function (e) {
			
			// 초기화
			$("#seleted-tag").html('');
			$("#seleted-tag").append($("#seleted-result").html());
			
			
			// 카테고리 변경시 카테고리에 맞는 태그를 불러온다
			$("#tagcate").on('change', function(e) {
				//alert($("#tagcate").val());
				
				$.ajax({
		        	type: "GET",
		        	url: "/yaneodo/company/position/tagdata.do",
		        	dataType: "JSON",
		        	data: "tagcate=" + $("#tagcate").val(),
		        	success: function(result) {
		        		console.log(result);
		        		
		        		// 초기화
						$("#search-result").html(""); 
		        		
		        		//<span class="label label-primary">#칼퇴보장</span>
		        		
						$(result).each(function(index, item) {
							
							let temp = "";
							
							temp += "<span class='label label-primary tagitem' ";
							temp += "data-value='" + item.tagseq
							temp += "'>";
							temp += item.tagname;
							temp += "</span>";
							
							console.log(temp);
							
							$("#search-result").append(temp);
						});
		        		
		        	},
		        	error: function(a,b,c) {
		        		console.log(a,b,c);
		        	}
		        })
				
			});
			
			
			// 등록하기 버튼을 눌렀을때
			$("#btnAddTag").on('click', function(e) {
				console.log(e);
				$("#seleted-result").html($("#seleted-tag").html());
				$('#addTag').modal('hide');
			});
			
			
			
		});
		
		
		// 검색 결과의 태그를 선택했을때
		$(document).on("click",".tagitem",function(e){ 
			
			//console.log(e);
			//console.log(e.target);
			//console.log(this);
			//console.log(e.currentTarget);
			
			console.log($(this).attr('selected'));
			
			if ($(this).attr('selected') == 'selected') {
				return;
			}
			
			 
			
			

			console.log($(this).attr('data-value'));
			
			let selected = "";
			
			selected += "<span class='label label-primary' name='tag'";
			selected += "data-value=" + $(this).attr('data-value');
			selected += ">";
			selected += $(this).html();
			selected += "<sapn class='glyphicon glyphicon-remove remove'></sapn></span>";
			
			
			// <input type="hidden" name="tag" value="#태그명1">
			let data = "";
			
			data += "<input type='hidden' name='tag' value=";
			data += $(this).attr('data-value');
			data += ">";
			
		
			// 선택한 태그에 추가
			$("#seleted-tag").append(selected);
			$("#seleted-tag").append(data);
			$(this).attr('selected', true);
			
		}); 
		
		// 선택된 태그의 x 표시를 눌렀을때 제거
		$(document).on("click",".remove",function(e){ 
			
			let temp = $(this).parent().attr('data-value');
			//console.log(temp);
		
			//console.log($(this).parent());
			//$("#seleted-tag span[data-value="+temp+"]").attr('selected', false);
			console.log($("#search-result").children("span[data-value='"+temp+"']"));
			$("#search-result").children("span[data-value='"+temp+"']").attr('selected', false);
			
			$(this).parent().next().detach();
			$(this).parent().detach();
			
		}); 
		
		
	</script>
</body>
</html>
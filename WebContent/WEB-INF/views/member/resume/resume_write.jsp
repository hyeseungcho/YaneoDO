<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%


   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/member/inc/asset.jsp" %>
<!-- 적용CSS -->
<link rel="stylesheet" href="/yaneodo/css/member/member-main.css">
<link rel="stylesheet" href="/yaneodo/css/member/member-menu.css">
<link rel="stylesheet" href="/yaneodo/css/member/resume.css">

<style>

</style>
</head>
<body>
<%@include file="/WEB-INF/views/member/inc/header.jsp" %>

	   <div id="resume-app" class="react-container background-white" >
        <div class="container" >
            <div id="resume-detail" class="" >
                <div class="resume-toolbar" >
                    <!-- <div class="resume-select-lang ko">
                        <i class="icon-ic-language" ></i>
                        <select class="resume-lang">
                            <option selected="" value="ko">한국어</option>
                            <option value="ja">日本語</option>
                            <option value="tw">繁體中文</option>
                            <option value="en">English</option>
                        </select>
                        <i class="icon-arrow_bottom_fill"></i>
                    </div> -->
                    <div class="other-btns">
                    <!-- <a class="btn" href="/yaneodo/member/resume/resume_write.do" download>PDF 다운로드</a>
                        <button class="border-gray btn btn-default" type="button" >
                            <i class="icon-download"></i> -->
                        </button>
                    </div>
                </div>
                <div class="resume-basic-info" >
                    <div class="resume-basic-header">
                        <div class="resume-input-form-group">
					<form method="GET" action = "/yaneodo/member/resume/resumeedit.do" > 
				
					 <input type="hidden" id="rseq" name="rseq" value="${dto.resumeSeq}">
                            <input class="resume-input resume_title" type="text" maxlength="100" placeholder="이력서 제목(필수)" name="title" value="${dto.fileName}" required>
                        </div>
                    </div>
                    <div class="resume-input-form-group" >
                        <input class="resume-input name" type="text" maxlength="100" placeholder="이름(필수)" name="name" value="${dto.name}" required>
                    </div>
                    <div class="resume-input-form-group" >
                        <input class="resume-input email" type="text" maxlength="120" placeholder="이메일(필수)" name="email" value="${dto.email}" required>
                    </div>
                    <div class="resume-input-form-group"><input class="resume-input mobile" type="text" maxlength="200" placeholder="연락처(필수) ex) 010-0000-0000" name="phone" value="${dto.phone}" required>
                    </div>
                </div>
            
                        
                <div class="resume-about-info">
                    <div class="resume-about-header" >간단 소개글</div>
                    <div class="resume-input-form-group">
                        <div class="dynamic-textarea">
                            <textarea style="height:120px;" name="info" class="resume-input about" maxlength="4000" placeholder="간단한 자기소개를 통해 이력서를 돋보이게 만들어보세요. (5~10줄 권장)">${dto.introduce}</textarea>
                            <textarea class="textarea-clone" readonly="" style="top: 0px; left: 0px; width: 900px; padding: 0px; font-size: 16px; line-height: 22.8571px; font-weight: 400; position: absolute; visibility: hidden; z-index: -9999; height: 0px;">간단한 자기소개를 통해 이력서를 돋보이게 만들어보세요. (3~5줄 권장)</textarea>
                        </div>
                        <div style="margin-left:900px;">
                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
                        </div>
                         </form>
                        
                    </div>
                </div>
                <div class="resume-lists" >
                    <div class="resume-list careers">
                        <div class="resume-list-header" >
                            <span>경력</span>
                        </div>
                      
                        <div class="resume-list-body" id="careerBody">
                    	<form method="GET" action="/yaneodo/member/resume/experienceadd.do">
                         <input type="hidden" id="rseq" name="rseq" value="${dto.resumeSeq}">
                        <c:if test="${exlist.size()==3}">
                            <button class="btn-add btn btn-default" type="submit" id="careerAdd2" disabled>+ 추가</button>
                        </c:if>    
                        <c:if test="${exlist.size()<3}">
                        
                            <button class="btn-add btn btn-default" type="submit" id="careerAdd">+ 추가</button>
                        </c:if> 
                       
                         </form> 
                            
                           <c:if test="${exlist.size()>0}"> 
 							<c:forEach items="${exlist}" var="exlist">
                            	<ul id="no"  class="list-group sortable-list careers">
                            		<li class="list-group-item sortable-item careers">
                            			<div class="portlet-handler">
                            				<div class="handler">
                            				</div>
                            				</div>
                            				<div class="career-item clearfix">
                            					<div class="col-sm-3">
                            						<div class="period">
                            							<div class="datetime">
                            								<div class="start-time">
                            									<div>
                            									<input type="hidden" name="exseq" value="${exlist.experienceseq}">
                            									<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            										<input style="border: 0px; width:120px; "  name="exstartDate" type="text"  placeholder="YYYY-MM-DD" class="form-control" value="${exlist.startdate}">
                            									</div>
                            								</div>
                            									<div class="end-time">
                            										<span class="delimiter" style="margin-left:30px;">~</span>
                            										<div>
                            											<input style="border: 0px; width:120px;" name="exendDate" type="text" placeholder="YYYY-MM-DD" class=" form-control" value="${exlist.enddate}">
                            										</div>
                            									</div>
                            								</div>
                            									<div class="form-group">
                            										<div class="checkbox">
                            											<label class="">
                            												<input class="selectBtn" type="checkbox" label="현재 재직중" >
                            													<span>현재 재직중</span>
                            											</label>
                            										</div>
                            									</div>
                            								</div>
                            							</div>
                            							<form method="GET" action = "/yaneodo/member/resume/experienceedit.do" > 
                            						<div class="col-sm-9">
                            							<div class="search-input-box resume-input-form-group">
                            							<input type="hidden" name="exseq" value="${exlist.experienceseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            								<input type="text" class="resume-input company_name" name="excompany" placeholder="회사명" value="${exlist.company}">
                            							</div>
                            								<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="부서명/직책" name="exfield" value="${exlist.field}">
                            								</div>
                            							<div class="dynamic-textarea">
                        
                            								<textarea style="height: 114px; width: 710px; margin-top:10px" name="exjob" class="resume-input description" placeholder="상세 업무 내용과 성과를 기입해주세요(600자이내)">${exlist.job}</textarea>
                            							</div>
                            						</div>
                            						 <div style="margin-left:900px;">
								                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								                       </div> 
								                       </form>
                            					<form method="GET" action="/yaneodo/member/resume/experiencedelete.do">
                            						 <input type="hidden" name="exseq" value="${exlist.experienceseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            						<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            						</button>
                            						
                            						 </form>
                            					</div>
                            				</li>
                            			</ul>
                            	</c:forEach>
                            	 </c:if>
                            </div>
                    	</div>
                    <div class="resume-list educations"><div class="resume-list-header">
                        <span>학력</span>
                    </div>
                   
                    <div class="resume-list-body" id="educationBody">  
                     <form method="GET" action="/yaneodo/member/resume/educationadd.do">
            		<input type="hidden"  name="rseq" value="${dto.resumeSeq}">  
                    <c:if test="${edlist.size()==3}">
                       	<button class="btn-add btn btn-default" type="button" id="educationAdd2" disabled>+ 추가</button>
                    </c:if>    
                    <c:if test="${edlist.size()<3}">
                         <button class="btn-add btn btn-default" type="submit" id="educationAdd">+ 추가</button>
                    </c:if>
                    </form>
                    <c:if test="${edlist.size()>0}"> 
 							<c:forEach items="${edlist}" var="edlist">
                            	<ul id="no"  class="list-group sortable-list careers">
                            		<li class="list-group-item sortable-item careers">
                            			<div class="portlet-handler">
                            				<div class="handler">
                            				</div>
                            				</div>
                            				<div class="career-item clearfix">
                            				<form method="GET" action = "/yaneodo/member/resume/educationedit.do" > 
                            					<div class="col-sm-3">
                            						<div class="period">
                            							<div class="datetime">
                            								<div class="start-time">
                            									<div>
                            									 <input type="hidden" id="rseq" name="rseq" value="${dto.resumeSeq}">
                            										<input style="border: 0px; width:120px; "  name="edstartDate" type="text"  placeholder="YYYY-MM-DD" class="form-control"  value="${edlist.startdate}">
                            									</div>
                            								</div>
                            									<div class="end-time">
                            										<span class="delimiter" style="margin-left:30px;">~</span>
                            										<div>
                            											<input style="border: 0px; width:120px;" name="edendDate" type="text" placeholder="YYYY-MM-DD" class=" form-control"  value="${edlist.enddate}">
                            										</div>
                            									</div>
                            								</div>
                            									<div class="form-group">
                            										<div class="checkbox">
                            											<label class="">
                            												<input class="selectBtn" type="checkbox" label="현재 재학중" >
                            													<span>현재 재학중</span>
                            											</label>
                            										</div>
                            									</div>
                            								</div>
                            							</div>
                            						<div class="col-sm-9">
                            							<div class="search-input-box resume-input-form-group">
                            							<input type="hidden" name="edseq" value="${edlist.educationseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            								<input type="text" class="resume-input company_name" name="edschool" placeholder="학교명" value="${edlist.schoolname}">
                            							</div>
                            								<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="학위" name="eddegree" value="${edlist.schooltype}">
                            								</div>
                            							<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="전공" name="edmajor" value="${edlist.major}">
                            								</div>
                            									<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="졸업현황(졸업/자퇴/기타)" name="edstate" value="${edlist.state}">
                            								</div>
                            						</div>
                            						   <div style="margin-left:900px;">
								                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								                       </div> 
								                       </form>
                            						<form method="GET" action="/yaneodo/member/resume/educationdelete.do">
                            						 <input type="hidden" name="edseq" value="${edlist.educationseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            						<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            						</button> 
                            						
                            						</form>
                            					</div>
                            				</li>
                            			</ul>
                            	</c:forEach>
                            	 </c:if>
                     
                    </div>
                </div>
                <div class="resume-list activities">
                    <div class="resume-list-header">
                        <span>자격증</span>
                    </div>
                   
                    <div class="resume-list-body" id="certifiBody">
                    <form method="GET" action="/yaneodo/member/resume/certificateadd.do">
            		<input type="hidden"  name="rseq" value="${dto.resumeSeq}">  
                    <c:if test="${celist.size()==3}">
                       	<button class="btn-add btn btn-default" type="button" id="certifiAdd2" disabled>+ 추가</button>
                    </c:if>    
                    <c:if test="${celist.size()<3}">
                         <button class="btn-add btn btn-default" type="submit" id="certifiAdd">+ 추가</button>
                    </c:if>
                    </form>
                    <c:if test="${celist.size()>0}"> 
 							<c:forEach items="${celist}" var="celist">
                            	<ul id="no"  class="list-group sortable-list careers">
                            		<li class="list-group-item sortable-item careers">
                            			<div class="portlet-handler">
                            				<div class="handler">
                            				</div>
                            				</div>
                            				<div class="career-item clearfix">
                            				<form method="GET" action = "/yaneodo/member/resume/certificateedit.do" >
                            					<div class="col-sm-3">
                            						<div class="period">
                            							<div class="datetime">
                            								<div class="start-time">
                            									<div class="form-group">
                            										<input style="border: 0px; width:120px;"  name="cegetDate" type="text"  class="year form-control" placeholder="YYYY-MM-DD" value="${celist.getdate}">
                            									</div>
                            								</div>
                     
                            								</div>
                            									
                            								</div>
                            							</div>
                            						<div class="col-sm-9">
                            							<div class="search-input-box resume-input-form-group">
                            							<input type="hidden" name="ceseq" value="${celist.certificateseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            								<input type="text" class="resume-input company_name" name="cetype" placeholder="자격증명" value="${celist.type}">
                            							</div>
                            								<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="등급및점수" name="cegrade" value="${celist.grade}">
                            								</div>
                            							<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="발행기관" name="ceagency" value="${celist.agency}">
                            								</div>
                            									
                            						</div>
                            						 <div style="margin-left:900px;">
								                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								                       </div> 
								                       </form>
                            						<form method="GET" action="/yaneodo/member/resume/certificatedelete.do">
                            						 <input type="hidden" name="ceseq" value="${celist.certificateseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            						<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            						</button> 
                            						
                            						</form>
                            					</div>
                            				</li>
                            			</ul>
                            	</c:forEach>
                            	 </c:if>
                    
                    </div>
                 
                </div>
                <div class="resume-list activities">
                    <div class="resume-list-header">
                        <span>수상</span>
                    </div>
                    <div class="resume-list-body" id="awardBody">
                     <form method="GET" action="/yaneodo/member/resume/awardadd.do">
            		<input type="hidden"  name="rseq" value="${dto.resumeSeq}">  
                    <c:if test="${awlist.size()==3}">
                       	<button class="btn-add btn btn-default" type="button" id="awardAdd2" disabled>+ 추가</button>
                    </c:if>    
                    <c:if test="${awlist.size()<3}">
                         <button class="btn-add btn btn-default" type="submit" id="awardAdd">+ 추가</button>
                    </c:if>
                    </form>
                    <c:if test="${awlist.size()>0}"> 
 							<c:forEach items="${awlist}" var="awlist">
                            	<ul id="no"  class="list-group sortable-list careers">
                            		<li class="list-group-item sortable-item careers">
                            			<div class="portlet-handler">
                            				<div class="handler">
                            				</div>
                            				</div>
                            				<div class="career-item clearfix">
                            				<form method="GET" action = "/yaneodo/member/resume/awardedit.do" >
                            					<div class="col-sm-3">
                            						<div class="period">
                            							<div class="datetime">
                            								<div class="start-time">
                            									<div class="form-group">
                            										<input style="border: 0px; width:120px;"  name="awgetDate" type="text"  class="year form-control" placeholder="YYYY-MM-DD" value="${awlist.getdate}">
                            									</div>
                            								</div>
                     
                            								</div>
                            									
                            								</div>
                            							</div>
                            						<div class="col-sm-9">
                            							<div class="search-input-box resume-input-form-group">
                            							<input type="hidden" name="awseq" value="${awlist.awardseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            								<input type="text" class="resume-input company_name" name="awname" placeholder="수상명" value="${awlist.awardname}">
                            							</div>
                            							<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="발행기관" name="awagency" value="${awlist.agency}">
                            								</div>
                            									
                            						</div>
                            						  <div style="margin-left:900px;">
								                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								                       </div> 
								                       </form>
                            						<form method="GET" action="/yaneodo/member/resume/awarddelete.do">
                            						 <input type="hidden" name="awseq" value="${awlist.awardseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            						<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            						</button> 
                            						
                            						</form>
                            					</div>
                            				</li>
                            			</ul>
                            	</c:forEach>
                            	 </c:if>
                    </div>
                </div>
                <div class="resume-list activities">
                    <div class="resume-list-header" >
                        <span>대외활동 및 교육</span>
                    </div>
                    <div class="resume-list-body" id="trainingBody">
                     <form method="GET" action="/yaneodo/member/resume/trainingadd.do">
            		<input type="hidden"  name="rseq" value="${dto.resumeSeq}">  
                    <c:if test="${trlist.size()==3}">
                       	<button class="btn-add btn btn-default" type="button" id="trainingAdd2" disabled>+ 추가</button>
                    </c:if>    
                    <c:if test="${trlist.size()<3}">
                         <button class="btn-add btn btn-default" type="submit" id="trainingAdd">+ 추가</button>
                    </c:if>
                    </form>
                   <c:if test="${trlist.size()>0}"> 
 							<c:forEach items="${trlist}" var="trlist">
                            	<ul id="no"  class="list-group sortable-list careers">
                            		<li class="list-group-item sortable-item careers">
                            			<div class="portlet-handler">
                            				<div class="handler">
                            				</div>
                            				</div>
                            				<div class="career-item clearfix">
                            				
                            					<div class="col-sm-3">
                            						
                                     				<div class="period">
                            							<div class="datetime">
                            								<div class="start-time">
                            								<form method="GET" action="/yaneodo/member/resume/trainingedit.do">
                            									<div>
                            										<input style="border: 0px; width:120px; "  name="trstartDate" type="text"  placeholder="YYYY-MM-DD" class="form-control"  value="${trlist.startDate}">
                            										
                            									</div>
                            									
                            								</div>
                            									<div class="end-time">
                            										<span class="delimiter" style="margin-left:30px;">~</span>
                            										<div>
                            										
                            											<input style="border: 0px; width:120px;" name="trendDate" type="text"  placeholder="YYYY-MM-DD" class="form-control"  value="${trlist.enddate}">
                            										</div>  
                            									</div>
                            								</div>
                            								<div class="form-group">
                            										<div class="checkbox">
                            											<label class="">
                            												<input class="selectBtn" type="checkbox" label="현재 진행중" >
                            													<span>현재 진행중</span>
                            											</label>
                            										</div>
                            									</div>
                            								</div>
                            							</div>
                            						<div class="col-sm-9">
                            							<div class="search-input-box resume-input-form-group">
                            								<input type="text" class="resume-input company_name" name="trname" placeholder="활동명" value="${trlist.name}">
                            							</div>
                            								<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="종류" name="trtype" value="${trlist.type}">
                            								</div>
                            							<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="기관" name="tragency" value="${trlist.agency}">
                            								</div>
                            							</div>
                            						</div>
                            						   <div style="margin-left:900px;">
                            						   <input type="hidden" name="trseq" value="${trlist.trainingseq}">
                            						   <input type="hidden" name="rseq" value="${dto.resumeSeq}">
								                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								                       </div>
								                        
								                     </form>
                            						<form method="GET" action="/yaneodo/member/resume/trainingdelete.do">
                            						 <input type="hidden" name="trseq" value="${trlist.trainingseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            						<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            						</button> 
                            						
                            						</form>
                            						</div>
                            					 
                            				</li>
                            			</ul>
                            	</c:forEach>
                            	 </c:if>
                       </div>
                    
                </div>
                <div class="resume-list activities">
                    <div class="resume-list-header">
                        <span>해외연수</span>
                    </div>
                     <div class="resume-list-body" id="abroadBody">
                     <form method="GET" action="/yaneodo/member/resume/abroadadd.do">
            		<input type="hidden"  name="rseq" value="${dto.resumeSeq}">  
                    <c:if test="${ablist.size()==3}">
                       	<button class="btn-add btn btn-default" type="button" id="abroadAdd2" disabled>+ 추가</button>
                    </c:if>    
                    <c:if test="${ablist.size()<3}">
                         <button class="btn-add btn btn-default" type="submit" id="abroadAdd">+ 추가</button>
                    </c:if>
                    </form>
                   <c:if test="${ablist.size()>0}"> 
 							<c:forEach items="${ablist}" var="ablist">
                            	<ul id=""  class="list-group sortable-list careers">
                            		<li class="list-group-item sortable-item careers">
                            			<div class="portlet-handler">
                            				<div class="handler">
                            				</div>
                            				</div>
                            				<div class="career-item clearfix">
                            				<form method="GET" action="/yaneodo/member/resume/abroadedit.do">
                            					<div class="col-sm-3">
                            						<div class="period">
                            							<div class="datetime">
                            								<div class="start-time">
                            									<div>
                            										<input style="border: 0px; width:120px; "  name="abstartDate" type="text"  placeholder="YYYY-MM-DD" class="form-control"  value="${ablist.startDate}">
                            									</div>
                            								</div>
                            									<div class="end-time">
                            										<span class="delimiter" style="margin-left:30px;">~</span>
                            										<div>
                            											<input style="border: 0px; width:120px;" name="abendDate" type="text" placeholder="YYYY-MM-DD" class="form-control"  value="${ablist.endDate}">
                            										</div>
                            									</div>
                            								</div>
                            									<div class="form-group">
                            										<div class="checkbox">
                            											<label class="">
                            												<input class="selectBtn" type="checkbox" label="현재 진행중" >
                            													<span>현재 진행중</span>
                            											</label>
                            										</div>
                            									</div>
                            								</div>
                            							</div>
                            						<div class="col-sm-9">
                            							<div class="search-input-box resume-input-form-group">
                            								<input type="text" class="resume-input company_name" name="abtype" placeholder="해외연수명" value="${ablist.type}">
                            							</div>
                            								<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" name="abcountry" maxlength="255" placeholder="나라" value="${ablist.country}">
                            								</div>
                            							<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="비고" name="abnote" value="${ablist.note}">
                            								</div>
                            							
                            						</div>
                            						   <div style="margin-left:900px;">
                            						   <input type="hidden" name="abseq" value="${ablist.abroadseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
								                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								                       </div> 
								                       </form>
                            						<form method="GET" action="/yaneodo/member/resume/abroaddelete.do">
                            						 <input type="hidden" name="abseq" value="${ablist.abroadseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            						<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            						</button> 
                            						
                            						</form>
                            					</div>
                            				</li>
                            			</ul>
                            	</c:forEach>
                            	 </c:if>
                       </div>
                </div>
                <div class="resume-list language_certs">
                    <div class="resume-list-header" >
                        <span>외국어</span>
                    </div>
                    <div class="resume-list-body" id="languageBody">
                    <form method="GET" action="/yaneodo/member/resume/languageadd.do">
            		<input type="hidden"  name="rseq" value="${dto.resumeSeq}">  
                    <c:if test="${lalist.size()==3}">
                       	<button class="btn-add btn btn-default" type="button" id="languageAdd2" disabled>+ 추가</button>
                    </c:if>    
                    <c:if test="${lalist.size()<3}">
                         <button class="btn-add btn btn-default" type="submit" id="languageAdd">+ 추가</button>
                    </c:if>
                    </form>
  				<c:if test="${lalist.size()>0}"> 
 						<c:forEach items="${lalist}" var="lalist">
					    <ul id="languageNo" class="list-group sortable-list careers">
					        <li class="list-group-item sortable-item careers">
					            <div class="portlet-handler">
					                <div class="handler">
					                </div>
					            </div>
					            <div class="career-item clearfix">
					                <div class="col-sm-3">
					                    <div class="period">
					                        <div class="datetime">
					
					                        </div>
					                    </div>
					                    </div>
					                    <div class="col-sm-9">
					                   
					                    <div class="search-input-box resume-input-form-group">
					                     <form method="GET" action="/yaneodo/member/resume/languageedit.do">
					                            <input type="text" name="language" class="resume-input company_name" placeholder="언어" value="${lalist.languagetype}">
					                    </div>
					                    <div class="resume-input-form-group">
					                        <select name="level" value="${lalist.grade}" class="form-control" style="margin-top: 10px; width:200px;" >
					                        	<option value="">언어수준</option>
					                            <option value="일상 회화">일상 회화</option>
					                            <option value="비즈니스 회화">비즈니스 회화</option>
					                            <option value="유창함">유창함</option>
					                         
					                        </select>
					                        
					                    </div>
					                </div>
					                       <div style="margin-left:900px;">
					                       <input type="hidden" name="laseq" value="${lalist.languageseq}">
                            			<input type="hidden" name="rseq" value="${dto.resumeSeq}">
								              <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								          </div> 
								          </form>
					            <form method="GET" action="/yaneodo/member/resume/languagedelete.do">
                            	<input type="hidden" name="laseq" value="${lalist.languageseq}">
                            	<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            	<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            	</button> 
                            	</form>
					        </div>
					        
					    </li>
					</ul>
					</c:forEach>
                   </c:if>
					</div>
                </div>
                <div class="resume-list activities">
                    <div class="resume-list-header">
                        <span>취업우대사항</span>
                    </div>
                    <div class="resume-list-body" id="specialBody">
                       <form method="GET" action="/yaneodo/member/resume/preferenceadd.do">
            		<input type="hidden"  name="rseq" value="${dto.resumeSeq}">  
                    <c:if test="${prlist.size()==3}">
                       	<button class="btn-add btn btn-default" type="button" id="preferenceAdd2" disabled>+ 추가</button>
                    </c:if>    
                    <c:if test="${prlist.size()<3}">
                         <button class="btn-add btn btn-default" type="submit" id="preferenceAdd">+ 추가</button>
                    </c:if>
                    </form>
                    <c:if test="${prlist.size()>0}"> 
 							<c:forEach items="${prlist}" var="prlist">
                            	<ul id="no"  class="list-group sortable-list careers">
                            		<li class="list-group-item sortable-item careers">
                            			<div class="portlet-handler">
                            				<div class="handler">
                            				</div>
                            				</div>
                            				<div class="career-item clearfix">
                            					<div class="col-sm-3">
                            						<div class="period">
                            							<div class="datetime">
                            								
                     
                            								</div>
                            									
                            								</div>
                            							</div>
                            							<form method="GET" action="/yaneodo/member/resume/preferenceedit.do">
                            						<div class="col-sm-9">
                            							<div class="search-input-box resume-input-form-group">
                            								<input type="text" class="resume-input company_name" name="prtype" placeholder="우대사항" value="${prlist.type}">
                            							</div>
                            							<div class="resume-input-form-group">
                            									<input class="resume-input title" type="text" maxlength="255" placeholder="비고" name="prnote" value="${prlist.note}">
                            								</div>
                            									
                            						</div>
                            						  <div style="margin-left:900px;">
								                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								                       </div> 
								                       </form>
                            						<form method="GET" action="/yaneodo/member/resume/preferencedelete.do">
                            						 <input type="hidden" name="prseq" value="${prlist.preferenceseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            						<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            						</button> 
                            						
                            						</form>
                            					</div>
                            				</li>
                            			</ul>
                            	</c:forEach>
                            	 </c:if>
                    </div>
                </div>
                <div class="resume-list links">
                    <div class="resume-list-header">
                        <span>포트폴리오</span>
                    </div>
                    <div class="resume-list-body" id="portfolioBody">
                     <form method="GET" action="/yaneodo/member/resume/portfolioadd.do">
            		<input type="hidden"  name="rseq" value="${dto.resumeSeq}">  
                    <c:if test="${polist.size()==2}">
                       	<button class="btn-add btn btn-default" type="button" id="portfolioAdd2" disabled>+ 추가</button>
                    </c:if>    
                    <c:if test="${polist.size()<2}">
                         <button class="btn-add btn btn-default" type="submit" id="portfolioAdd">+ 추가</button>
                    </c:if>
                    </form>
                    <c:if test="${polist.size()>0}"> 
 							<c:forEach items="${polist}" var="polist">
                            	<ul id="no"  class="list-group sortable-list careers">
                            		<li class="list-group-item sortable-item careers">
                            			<div class="portlet-handler">
                            				<div class="handler">
                            				</div>
                            				</div>
                            				<div class="career-item clearfix">
                            					<div class="col-sm-3">
                            						
                            							</div>
                            							<form method="POST" action= "/yaneodo/member/resume/portfolioedit.do" enctype="multipart/form-data">
                            						<div class="col-sm-9">
                            							<div class="search-input-box resume-input-form-group">
                            								<input type="url" class="resume-input company_name" name="pourl" placeholder="http://" value="${polist.url}">
                            							</div>
                            							<div class="resume-input-form-group">
                            									<input class="resume-input title" type="file" maxlength="255"  name="attach" value="${polist.orgfilename}">
                            									 <c:if test="${not empty polist.orgfilename}">
												                    <tr>
												                        <td>
												                            <span class="glyphicon glyphicon-floppy-disk"></span> <a href="/yaneodo/member/resume/downloadpo.do?filename=${polist.filename}&orgfilename=${polist.orgfilename}&portfolioseq=${polist.portfolioseq}">${polist.orgfilename}</a>
												                            
												                        </td>
												                    </tr>
												                 </c:if>
                            								</div>
                            								
									               
                            									
                            						</div>
                            						   <div style="margin-left:900px;">
                            						    <input type="hidden" name="poseq" value="${polist.portfolioseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
								                        <button type="submit" class="btn btn-default smbtn" >저장하기</button>
								                       </div> 
								                       </form>
                            						<form method="GET" action="/yaneodo/member/resume/portfoliodelete.do" >
                            						 <input type="hidden" name="poseq" value="${polist.portfolioseq}">
                            						<input type="hidden" name="rseq" value="${dto.resumeSeq}">
                            						<button  class="btn-delete btn glyphicon glyphicon-remove" style="width:20px; height:20px">
                            						</button> 
                            						
                            						</form>
                            					</div>
                            				</li>
                            			</ul>
                            	</c:forEach>
                           	 </c:if>
                     
                    
                </div>
            </div>
            <div class="resume-toolbar fixed-bottom" >
                <div class="save-btns">
                    <!-- <div>
                        <button class="border-primary btn btn-default" type="button">임시 저장</button>
                    </div> -->
                   
                    <div>
                        <button class="btn btn-primary" type="submit" onclick="location.href='/yaneodo/member/resume/resume_list.do?seq=${seq}';">작성 완료</button>
                    </div>
                    </div>
           
            	</div>
       		 </div>
          </div>
    </div>
    </div>




<script>


$(".selectBtn").on("change", function(){
	 $(this).parent().parent().parent().sibling(".end-time").css("display","none");

 });

</script>
</body>
</html>

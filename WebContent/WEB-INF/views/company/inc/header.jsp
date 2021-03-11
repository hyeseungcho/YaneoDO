<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- header -->
    <div id="headerContainer">
        <div id="header">
            <div id="logo">Yaneodo</div>
            <div id="aside">
                <div class="pic"><img src="/project/views/image/man_04.png" alt=""></span></div>
                <div><span>이름</span></div>
                <div class="mypage">
                    <span class="glyphicon glyphicon-chevron-down" style="padding-top: 10px;"></span>
                    <div>
                        <ul id="company-dropdown">
                            <li><a href="#" aria-label="subemnu">submenu</a></li>
                            <li><a href="#" aria-label="subemnu">submenu</a></li>
                            <li><a href="#" aria-label="subemnu">submenu</a></li>
                            <li><a href="#" aria-label="subemnu">submenu</a></li>
                        </ul>
                    </div>
                </div>
                <div class="notice">
                    <span class="glyphicon glyphicon-bell"></span>
                    <div>
                        <ul id="company-notice">
                            <li><a href="#" aria-label="notice">notice</a></li>
                            <li><a href="#" aria-label="notice">notice</a></li>
                            <li><a href="#" aria-label="notice">notice</a></li>
                            <li><a href="#" aria-label="notice">notice</a></li>
                        </ul>
                    </div>
                </div>
                <div id="count"><span class="label label-default">10</span></div>
                <div class="btn"><input type="button" class="btn btn-default" value="원티드 홈"></div>
                
                
            </div>
        </div>
        <!-- <div style="clear: both;"></div> -->
        <div id="nav">
            <ul>
	            <li><a href="/yaneodo/company/volunteer/list.do">지원자</a></li>
				<li><a href="/yaneodo/company/match/main.do">매치업</a></li>
				<li><a href="/yaneodo/company/position/list.do">포지션</a></li>
				<li><a href="/yaneodo/company/info/view.do">회사정보</a></li>
				<li><a href="/yaneodo/company/account/account.do">계정관리</a></li>
            </ul>
            <div style="clear: both;"></div>
        </div>
    </div>
    <!-- header 끝 -->


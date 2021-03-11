<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/yaneodo/css/admin/header.css?ver=1.1">

</head>
<body>
    <div id="headerContainer">
        <nav id="nav">
            <ul>
                <li id="logo"><img src="" id="logo">yaneoDO</li>
                <li><a class="menuLink" href="#">탐색</a></li>
                <li><a class="menuLink" href="#">직무별연봉</a></li>
                <li><a class="menuLink" href="#">이력서</a></li>
                <li><a class="menuLink" href="#">매치업</a></li>
                <li><a class="menuLink" href="#">코딩테스트</a></li>
                <li><a class="menuLink" href="#">커뮤니티</a></li>
                <li><a class="menuLink" id="search"><img src="">검색</a></li>
                <li><a class="menuLink" id="alarm"><img src="">알람</a></li>
                <li><a class="menuLink" id="photo"><img src="">사진</a></li>
                <li><a class="menuLink" id="bservice">기업서비스</a></li>
                <li><a class="menuLink" id="mservice" onclick="location.href='/yaneodo/admin/member/memberlist.do?'">관리자서비스</a></li>   
                <div style="clear: both;"></div>              
            </ul>
            
        </nav>
    </div>
</body>
</html>
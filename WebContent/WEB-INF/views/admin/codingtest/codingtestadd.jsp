<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코딩문제관리</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>
<link rel="stylesheet" href="/yaneodo/css/admin/admin.css">
<link rel="stylesheet" href="/yaneodo/css/jquery-ui.css">

<script src="/yaneodo/js/jquery-1.12.4.js"></script>
<script src="/yaneodo/js/jquery-ui.js"></script>


<style>

#tbl {
	width: 600px;
	height: 40px;
	text-align: center;
	margin: 90px auto;
}

th, td {
	border-bottom: 2px solid #ccc;
	text-align: left;
	
}

#tbl th {
	font-weight: normal;
 	vertical-align: middle;
}

#tbl {
	width: 450px;
}

.title {
	height: 35px;
	width: 250px;
}

.one, .two, .three {
	float: left;
	text-align: center;
	height:30px;
}

.one {
	width: 100px;
}

.two {
	width: 400px;
}

.three {
	width: 200px;
}

#list1 li {
	list-style: none;
	padding-left: 0px;
	width: 750px;
}

#list1 li::after {
	content: "";
	display: block;
	clear: both;
}

#list1 {
	margin-left: -20px;
	margin-top: 0px;
}

#subframe {
	width: 800px;
	height: 700px;
	/* border : 1px solid black; */
	overflow-y: scroll;
}

#subframe::-webkit-scrollbar {
	display: none;
}

#tbl td input {
	width : 300px;
	padding : 6px 0px;
	text-align : left;
}

#tbl .tape {
	padding-left : 10px;
}

#btns {
	margin-left : 350px;
}


</style>

</head>
<body>
	<!-- header -->
	<div id="header">
		<%@include file="/WEB-INF/views/admin/form/header.jsp"%>
	</div>
	<div style="clear: both;"></div>

	<div id="outline">

		<div id="leftSide" style="float: left;">
			<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>
		</div>

		<div id="content">

			

            <div id="jobtype">문제 추가</div>

            
            <table id="tbl" class="table table-bordered">
                <tbody id="tby">
                    <tr>
                        <th>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름:</th>
                        <td><input type="text" id="name" name="name" class="tape btn btn-default"></td>
                    </tr>
                    <tr>
                        <th>유&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;형:</th>
                        <td><input type="text" id="type" name="type" class="tape btn btn-default"></td>
                    </tr>
                    <tr>
                        <th>난&nbsp;&nbsp;이&nbsp;&nbsp;도:</th>
                        <td><select><option value="상">상</option><option value="중">중</option><option value="하">하</option></select></td>
                    </tr>
                    <tr>
                        <th>빈&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;도:</th>
                        <td><select><option value="빈번">빈번</option><option value="종종">종종</option><option value="가끔">가끔</option></select></td>
                    </tr>
                    <tr>
                        <th>지원언어:</th>
                        <td><select><option value="Oracle">Oracle</option><option value="Java">Java</option><option value="Python">Python</option></select></td>
                    </tr>
                    <tr>
                        <th>설&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;명:</th>
                        <td><input type="file" class="form-control" placeholder="file" id="explain" name="explain" style="border:0px"></td>
                    </tr>
                    <tr>
                        <th>정&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;답:</th>
                        <td><input type="file" class="form-control" placeholder="file" id="answer" name="answer" style="border:0px"></td>
                    </tr>

                </tbody>
            </table>

            <div id="btns">
                <form action="">
                    <input type="button" id="next" name="next" value="다음" class="btn btn-primary" onclick="location.href='/yaneodo/admin/codingtest/codingtestadddetail.do';">
                    <input type="button" id="regist" name="regist" value="등록하기" class="btn btn-primary">
                </form>

            </div>

       
        
        </div>
	</div>
	<div style="clear:both;"></div>


	<!-- footer -->
	<div id="footer">
		<%@include file="/WEB-INF/views/admin/form/footer.jsp"%>
	</div>

	<script>
        


	  

    
      


    
    </script>
</body>
</html>
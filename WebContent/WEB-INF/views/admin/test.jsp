<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직무 관리</title>

<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>
<link rel="stylesheet" href="/yaneodo/css/admin/admin.css">
<link rel="stylesheet" href="/yaneodo/css/admin/jquery-ui.css">

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
	text-align: center;
}

#tbl {
	width: 600px;
}

#jobtype {
	float: left;
	margin-right: 10px;
}

#ctlBtn {
	float: right;
	margin: 20px 50px 0px 10px;
}

#btn {
	margin-right: 5px;
}

.title {
	height: 35px;
	width: 250px;
}

.one, .two, .three {
	float: left;
	text-align: center;
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

#outline {
     width: 1110px;
     height:910px;
     margin : -10px auto;
}
</style>

</head>
<body>


 ${title}	
 ${jobseq}	
 ${add}	

	<script>


    
    </script>
</body>
</html>
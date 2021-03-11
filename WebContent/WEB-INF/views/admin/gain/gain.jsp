<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수익 관리</title>


<%@include file="/WEB-INF/views/admin/inc/asset.jsp" %>
<script src="/codestudy/js/highcharts.js"></script>
<link rel="stylesheet" href="/yaneodo/css/admin/admin.css">


    


<style>

  

        #tbl {
            width: 700px;
            height: 40px;
            text-align: center;
            margin : 90px auto;
            /* border : 2px solid black; */
        }
        
        th, td { 
            border-bottom: 2px solid #ccc;
            text-align: center;
                        
        }
        
        #tbl th {
	        background-color : #8A2BE2;
	        color : white;
        }
        
        #tbl td {
            border-bottom : 1px solid black;
        	
        }
        #tbl tr {
            border-left : 1px solid black;
            border-right : 1px solid black;
        }
        

        #dateSelect div, #dateSelect input {
            float : right;
            height: 30px;
        }

        #dateSelect input {
            margin-top: 10px; 
            width: 160px;
        } 

        #columnchart_values {
            margin-left: 100px;
            margin-top: -50px;
        }

        
        #chart1 {
		
		    width: 600px;
		    margin-left: 100px;
		    
		}


    
</style>
</head>
<body>
	<!-- header -->
	<div id="header">
	<%@include file="/WEB-INF/views/admin/form/header.jsp" %>
	</div>
	<div style="clear:both;"></div>
	
	<div id = "outline">
	
			<div id="leftSide" style="float:left; background-color: white;">
			<%@include file="/WEB-INF/views/admin/inc/sidemenu.jsp" %>
			</div>
		
			<div id="content">

            <div id="dateSelect">
                
                <input type="date" id="datePicker" value="">
                <div>날짜 선택 : </div> 
            </div>

            <table id=tbl class="border">
                <thead>
                    <tr>
                        <th>기간</th>
                        <th>a타입</th>
                        <th>b타입</th>
                        <th>c타입</th>
                        <th>d타입</th>
                        <th>e타입</th>
                        <th>총 수입</th>
                    </tr>
                </thead>
                <tbody id="tbd">
                    <tr>
                        <td>Today</td>
                        <td> ${dto.a}</td>
                        <td> ${dto.b}</td>
                        <td> ${dto.c}</td>
                        <td> ${dto.d}</td>
                        <td> ${dto.e}</td>
                        <td id="tsum"></td>
                    </tr>
                    <tr>
                        <td>Week</td>
                        <td> ${dtoweek.a}</td>
                        <td> ${dtoweek.b}</td>
                        <td> ${dtoweek.c}</td>
                        <td> ${dtoweek.d}</td>
                        <td> ${dtoweek.e}</td>
                        <td id="wsum"></td>
                    </tr>
                    <tr>
                        <td>Month</td>
                        <td> ${dtomonth.a}</td>
                        <td>${dtomonth.b}</td>
                        <td>${dtomonth.c}</td>
                        <td>${dtomonth.d}</td>
                        <td>${dtomonth.e}</td>
                        <td id="msum"></td>
                    </tr>
                </tbody>
            </table>

             <div id="chart1" style="border:1px solid #999;"></div>
  
  <script type="text/javascript">
  
  	let m;
	m = ${pickdate}+"";
	
	let d;

	if ( m == null ||  m =="" ) {
		d = new Date().toISOString().substring(0, 10);
	} else {			
		d = '${pickdate}';
	}
  
  
  
    Highcharts.chart('chart1', {
        chart: {
            type: 'bar'
        },
        title: {
            text: d
        },
        xAxis: {
            categories: ['Today', 'Week', 'Month'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: '판매 횟수',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' 개'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: 0,
            y: 80,
            floating: true,
            borderWidth: 1,
            backgroundColor:
                Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
            shadow: true
        },
        credits: {
            enabled: false
        },
        series: [{
            name: 'A타입',
            data: [${dto.a}, ${dtoweek.a}, ${dtomonth.a}]
        }, {
            name: 'B타입',
            data: [ ${dto.b}, ${dtoweek.b}, ${dtomonth.b}]
        }, {
            name: 'C타입',
            data: [ ${dto.c}, ${dtoweek.c}, ${dtomonth.c}]
        }, {
            name: 'D타입',
            data: [ ${dto.d}, ${dtoweek.d}, ${dtomonth.d}]
        }, {
            name: 'E타입',
            data: [ ${dto.e}, ${dtoweek.e}, ${dtomonth.e}]
        }]
    });
        </script>
  
        </div>

        </div>
       
	
	<!-- footer -->
	<div id="footer" >
	<%@include file="/WEB-INF/views/admin/form/footer.jsp" %>
	</div>
	
<script>


		if ( m == null ||  m =="" ) {
			document.getElementById("datePicker").value = new Date().toISOString().substring(0, 10);
		} else {			
			document.getElementById("datePicker").value = '${pickdate}';
		}
        
		        
        var tsum = document.getElementById("tsum");
        var wsum = document.getElementById("wsum");
        var msum = document.getElementById("msum");
        		 

        
       	tsum.innerHTML="${(dto.a*100000)+(dto.b*200000)+(dto.c*300000)+(dto.d*400000)+(dto.e*500000)}";
        wsum.innerHTML="${(dtoweek.a*100000)+(dtoweek.b*200000)+(dtoweek.c*300000)+(dtoweek.d*400000)+(dtoweek.e*500000)}";
        msum.innerHTML="${(dtomonth.a*100000)+(dtomonth.b*200000)+(dtomonth.c*300000)+(dtomonth.d*400000)+(dtomonth.e*500000)}";
        
        
  


        $("#datePicker").change(function () {
            //alert($("#datePicker").val());
            location.href="/yaneodo/admin/gain/gain.do?date="+$("#datePicker").val();
            
        });
    

       	

    </script>
</body>
</html>
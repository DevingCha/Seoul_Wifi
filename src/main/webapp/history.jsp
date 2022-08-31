<%@ page import="java.util.*" %>
<%@ page import="com.entity.LocationHistory" %>
<%@ page import="com.wifi.service.LocationHistoryService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style>
	label, button {
		font-weight: 600;
	}
		
	table {
		width: 100%;
		padding: 0px;
		border-collapse: collapse;
	}
	
	tr {
		text-align: center;
	}
	
	th {
	    padding-top: 11px;
	    padding-bottom: 11px;
	    background-color: #04AA6D;
	    color: white;
	    border: 1px solid #DDD;
	}
	
	td {
		color: black;
		border: 1px solid #DDD;
	}
	
	tr:nth-child(2n+1) {
		background-color: #DDD;
	}
	
	.home-table-info {
		font-weight: 600;
		padding-top: 22px;
		padding-bottom: 22px;
		border: 1px solid #DDD;
	}
	
</style>
</head>
<body>
	<%
		Class.forName("org.sqlite.JDBC");
		List<LocationHistory> histories = LocationHistoryService.getAllHistories();
	%>
	<h1>와이파이 정보 구하기</h1>
	<div>
		<!-- 링크 -->
		<div>
			<a href="home.jsp">홈</a> | 
			<a href="#">위치 히스토리 목록</a> | 
			<a href="data-load.jsp">Open API 와이파이 정보 가져오기</a>
		</div>
	</div>
	<br>
	
	<!-- 테이블 -->
	<div class="home-table">
	<table>
		<tr>
			<th>ID</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>조회일자</th>
			<th>비고</th>
		</tr>
		
		<% 
			for (LocationHistory history : histories) {
		%>
			<tr>
				<td><%= history.getId() %></td>
				<td><%= history.getLat()%></td>
				<td><%= history.getLnt()%></td>
				<td><%= history.getDatetime()%></td>
				<td><button>삭제</button></td>
			</tr>
		<%
			}
		%>
	</table>
	</div>
</body>
</html>
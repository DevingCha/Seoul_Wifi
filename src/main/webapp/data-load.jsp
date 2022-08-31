<%@ page import="java.sql.*" %>
<%@ page import="com.wifi.service.WifiService" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style>
	.data-load-title {
		text-align: center;
		font-weight: 800;
	}
</style>
</head>
<body>
	<%
		Class.forName("org.sqlite.JDBC");
		WifiService.resetWifi();
	%>
	<div class="data-load-title">
		<h1><%= WifiService.count %>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
		<a href="home.jsp">홈 으로 가기</a>
	</div>
	
</body>
</html>
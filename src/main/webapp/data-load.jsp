<%@ page import="java.sql.*" %>
<%@ page import="com.wifi.service.WifiService" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�������� ���� ���ϱ�</title>
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
		<h1><%= WifiService.count %>���� WIFI ������ ���������� �����Ͽ����ϴ�.</h1>
		<a href="home.jsp">Ȩ ���� ����</a>
	</div>
	
</body>
</html>
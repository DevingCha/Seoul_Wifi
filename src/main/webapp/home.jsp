<%@ page import="java.util.*" %>
<%@ page import="com.entity.Wifi" %>
<%@ page import="com.wifi.service.WifiService" %>
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
		padding: 10px;
		text-align: left;
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
		text-align: center;
	}
	
</style>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<div>
		<!-- 링크 -->
		<div>
			<a href="home.jsp">홈</a> | 
			<a href="history.jsp">위치 히스토리 목록</a> | 
			<a href="data-load.jsp">Open API 와이파이 정보 가져오기</a>
		</div>
		<br>
		<form action="home.jsp" method="GET">
			<!-- 위도(lat), 경도(lnt) 입력 -->
			<label for="lat">
				LAT: <input id="lat" type="text" name="lat" value="<%= request.getParameter("lat") == null ? "0.0" : request.getParameter("lat")%>">
			</label>
			,
			<label for="lnt">
				LNT: <input id="lnt" type="text" name="lnt" value="<%= request.getParameter("lnt") == null ? "0.0" : request.getParameter("lnt")%>">
			</label>
			
			<!-- 버튼 -->
			<button type="button" class="get-location-button">내 위치 가져오기</button>
			<button type=submit>근처 WIFI 정보 보기</button>
		</form>
	</div>
	<br>
	
	<!-- 테이블 -->
	<div class="home-table">
	<table>
		<tr>
			<th>거리(Km)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
		<% if (request.getParameter("lat") == null || request.getParameter("lnt") == null) {%>
		<tr>
			<td class="home-table-info" colspan="17">위치 정보를 입력한 후에 조회해 주세요</td>
		</tr>
		<% } else { %>
			
		<% 
			Class.forName("org.sqlite.JDBC");
			double myLat = Double.parseDouble(request.getParameter("lat"));
			double myLnt = Double.parseDouble(request.getParameter("lnt"));
			List<Wifi> nearestWifi = WifiService.getNearestWifi(myLat, myLnt);
			
			for (Wifi wifi : nearestWifi) { %>
				<tr>
					<td><%= wifi.getDistance(myLat, myLnt) %></td>
					<td><%= wifi.getX_SWIFI_MGR_NO() %></td>
					<td><%= wifi.getX_SWIFI_WRDOFC() %></td>
					<td><%= wifi.getX_SWIFI_MAIN_NM() %></td>
					<td><%= wifi.getX_SWIFI_ADRES1() %></td>
					<td><%= wifi.getX_SWIFI_ADRES2() %></td>
					<td><%= wifi.getX_SWIFI_INSTL_FLOOR() %></td>
					<td><%= wifi.getX_SWIFI_INSTL_TY() %></td>
					<td><%= wifi.getX_SWIFI_INSTL_MBY() %></td>
					<td><%= wifi.getX_SWIFI_SVC_SE() %></td>
					<td><%= wifi.getX_SWIFI_CMCWR() %></td>
					<td><%= wifi.getX_SWIFI_CNSTC_YEAR() %></td>
					<td><%= wifi.getX_SWIFI_INOUT_DOOR() %></td>
					<td><%= wifi.getX_SWIFI_REMARS3() %></td>
					<td><%= wifi.getLNT() %></td>
					<td><%= wifi.getLAT() %></td>
					<td><%= wifi.getWORK_DTTM() %></td>
				</tr>
		<% 	} %>
		
		<% } %>
	</table>
	</div>
	<script>
		const getLocationButton = document.querySelector(".get-location-button");
		const latInput = document.querySelector("#lat");
		const lntInput = document.querySelector("#lnt");
		getLocationButton.addEventListener("click", () => {
			const options = {
			  enableHighAccuracy: true,
			  timeout: 5000,
			  maximumAge: 0
			};

			function success(pos) {
			  const crd = pos.coords;
			  latInput.value = crd.latitude;
			  lntInput.value = crd.longitude;
			}

			function error(err) {
			  console.warn(`ERROR(${err.code}): ${err.message}`);
			}

			navigator.geolocation.getCurrentPosition(success, error, options);
		})
	</script>
</body>
</html>
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
	
	th {
	    padding-top: 11px;
	    padding-bottom: 11px;
	    background-color: #04AA6D;
	    color: white;
	    border: 1px solid #DDD;
	}
	
	.home-table-info {
		text-align: center;
		font-weight: 600;
		padding-top: 22px;
		padding-bottom: 22px;
		border: 1px solid #DDD;
	}
	
</style>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<div>
		<!-- 링크 -->
		<div>
			<a href="#">홈</a> | 
			<a href="#">위치 히스토리 목록</a> | 
			<a href="#">Open API 와이파이 정보 가져오기</a>
		</div>
		<br>
		
		<!-- 위도(lat), 경도(lnt) 입력 -->
		<label for="lat">
			LAT: <input id="lat" type="text" name="lat" value="0.0">
		</label>
		,
		<label for="lnt">
			LAT: <input id="lnt" type="text" name="lnt" value="0.0">
		</label>
		
		<!-- 버튼 -->
		<button>내 위치 가져오기</button>
		<button>근처 WIFI 정보 보기</button>
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
		<tr>
			<td class="home-table-info" colspan="17">위치 정보를 입력한 후에 조회해 주세요</td>
		</tr>
	</table>
	</div>
</body>
</html>
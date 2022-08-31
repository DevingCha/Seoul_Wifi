<div style="text-align: center;">

# 내 위치 기반 공공 와이파이 정보를 제공하는 서비스 개발

</div>

### 개발기간: 2022-08-23 ~ ing

---

## Version(Environment)

1. eclipse 2022-03
2. tomcat 8.5
3. jdk 1.8
4. Dynamic Web module version 3.1 -> Convert to Maven Project in eclipse
5. okhttp 4.9.3(com.squareup.okhttp3) - REST API request
6. gson 2.9.0(com.google.code.gson) - json 데이터 파싱
7. lombok 1.18.24(org.projectlombok) - Getter / Setter
8. sqlite-jdbc 3.36.0.3(org.xerial) - db

<br>

## 2022-08-23 Update

---

- 프로젝트 셋업
- 프리셋에 맞춰 간단하게 프론트단 구성(home.jsp 및 css style)
- [서울 공용 와이파이 정보](https://data.seoul.go.kr/dataList/OA-20883/S/1/datasetView.do) 샘플 코드 테스트

<br>

## 2022-08-24 Update

---

- 간편한 Dependency 관리를 위해 Maven Project로 변환
- okhttp, gson, lombok, sqlite-jdbc dependency 설정
- Open API 응답 데이터에 맞춰 Wifi 클래스 생성 및 수정
- 서울 공용 와이파이 요청 코드 수정(샘플코드 -> dependency 이용)
  - okhttp로 Get Request 요청 후 gson으로 json데이터 파싱 후 클래스 인스턴스로 적용
  - 총 데이터의 개수를 알기 위해 1개의 데이터 요청에 대한 응답을 통해 받은 총 데이터 개수를 가지고 for문을 이용하여 요청<br><span style="color: red;">(**한번에 1000건 이상의 데이터를 요청할 수 없었음.**)</span>
- 와이파이 정보 응답 Property를 기준으로 Wifi 클래스 생성 및 Api 클래스에서 Wifi 인스턴스 객체들을 리스트에 담아 리턴하는 함수를 생성

<br>

## 2022-08-25 Update

---

- lombok 설정 오류 해결 및 적용
- DB 저장을 위한 Wifi 테이블 생성(sqlite3)
- Geolocation을 활용한 현재 GPS 좌표를 가져오는 버튼 생성(javascript event-listener)
- 와이파이 정보를 sqlite db와 연결하여 저장(저장하는 동안 완료 게이지를 표시하는 ui 추가) - 총 17802개의 데이터를 저장하는데 90초정도 소요

<br>

## 2022-08-26 Update

---

- 클래스명 수정(Api -> WifiService, Db -> WifiRepository) 및 패키지명 수정(wifi관련 클래스들을 com.wifi 패키지로 이동)
- Wifi: 현재 인스턴스의 lat, lnt값과 인자로 들어오는 lat lnt를 비교하여 거리를 측정하는 기능 추가
- WifiRepository: DB(sqlite)에서 모든 와이파이 정보를 불러오는 기능 추가
- WifiService: 위 두가지 기능을 이용하여 GPS 좌표상 가장 가까운 20가지의 와이파이를 찾는 기능 추가
- form 태그를 이용하여 button 클릭 시 lat, lnt 입력값을 파라미터로 get request 요청 기능 추가
- lat, lnt input 태그의 value값을 파라미터의 값이 있을 경우 그 값으로 설정하도록 수정
- table 스타일 수정

<br>

## 2020-08-27 Update

---

- 위치 조회 history 기능 구현
- location_history table 모델링
- LocationHistory, LocationHistoryRepository, LocationHistoryService 클래스 구현
- history.jsp 구현(위치 조회 history 목록을 조회하는 페이지)

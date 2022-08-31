package com.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Wifi {
	/*
	    1	X_SWIFI_MGR_NO	관리번호
		2	X_SWIFI_WRDOFC	자치구
		3	X_SWIFI_MAIN_NM	와이파이명
		4	X_SWIFI_ADRES1	도로명주소
		5	X_SWIFI_ADRES2	상세주소
		6	X_SWIFI_INSTL_FLOOR	설치위치(층)
		7	X_SWIFI_INSTL_TY	설치유형
		8	X_SWIFI_INSTL_MBY	설치기관
		9	X_SWIFI_SVC_SE	서비스구분
		10	X_SWIFI_CMCWR	망종류
		11	X_SWIFI_CNSTC_YEAR	설치년도
		12	X_SWIFI_INOUT_DOOR	실내외구분
		13	X_SWIFI_REMARS3	wifi접속환경
		14	LAT	X좌표
		15	LNT	Y좌표
		16	WORK_DTTM	작업일자
	 */
	@Getter @Setter private String X_SWIFI_MGR_NO;		// 1 
	@Getter @Setter private String X_SWIFI_WRDOFC;		// 2
	@Getter @Setter private String X_SWIFI_MAIN_NM;		// 3
	@Getter @Setter private String X_SWIFI_ADRES1;		// 4
	@Getter @Setter private String X_SWIFI_ADRES2;		// 5
	@Getter @Setter private String X_SWIFI_INSTL_FLOOR;	// 6
	@Getter @Setter private String X_SWIFI_INSTL_TY;	// 7
	@Getter @Setter private String X_SWIFI_INSTL_MBY;	// 8
	@Getter @Setter private String X_SWIFI_SVC_SE;		// 9
	@Getter @Setter private String X_SWIFI_CMCWR;		// 10
	@Getter @Setter private int X_SWIFI_CNSTC_YEAR;	// 11
	@Getter @Setter private String X_SWIFI_INOUT_DOOR;	// 12
	@Getter @Setter private String X_SWIFI_REMARS3;		// 13
	@Getter @Setter private double LAT;					// 14
	@Getter @Setter private double LNT;					// 15
	@Getter @Setter private String WORK_DTTM;			// 16
	
	public Wifi(String x_SWIFI_MGR_NO, String x_SWIFI_WRDOFC, String x_SWIFI_MAIN_NM, String x_SWIFI_ADRES1,
			String x_SWIFI_ADRES2, String x_SWIFI_INSTL_FLOOR, String x_SWIFI_INSTL_TY, String x_SWIFI_INSTL_MBY,
			String x_SWIFI_SVC_SE, String x_SWIFI_CMCWR, int x_SWIFI_CNSTC_YEAR, String x_SWIFI_INOUT_DOOR,
			String x_SWIFI_REMARS3, double lAT, double lNT, String wORK_DTTM) {
		super();
		X_SWIFI_MGR_NO = x_SWIFI_MGR_NO;
		X_SWIFI_WRDOFC = x_SWIFI_WRDOFC;
		X_SWIFI_MAIN_NM = x_SWIFI_MAIN_NM;
		X_SWIFI_ADRES1 = x_SWIFI_ADRES1;
		X_SWIFI_ADRES2 = x_SWIFI_ADRES2;
		X_SWIFI_INSTL_FLOOR = x_SWIFI_INSTL_FLOOR;
		X_SWIFI_INSTL_TY = x_SWIFI_INSTL_TY;
		X_SWIFI_INSTL_MBY = x_SWIFI_INSTL_MBY;
		X_SWIFI_SVC_SE = x_SWIFI_SVC_SE;
		X_SWIFI_CMCWR = x_SWIFI_CMCWR;
		X_SWIFI_CNSTC_YEAR = x_SWIFI_CNSTC_YEAR;
		X_SWIFI_INOUT_DOOR = x_SWIFI_INOUT_DOOR;
		X_SWIFI_REMARS3 = x_SWIFI_REMARS3;
		LAT = lAT;
		LNT = lNT;
		WORK_DTTM = wORK_DTTM;
	}
	
	public double getDistance(double myLat, double myLnt) {
		double theta = myLnt - this.LNT;
        double dist = Math.sin(deg2rad(myLat)) * Math.sin(deg2rad(this.LAT)) + Math.cos(deg2rad(myLat)) * Math.cos(deg2rad(this.LAT)) * Math.cos(deg2rad(theta));
        dist = rad2deg(Math.acos(dist)) * 111.189557;
        return Math.round(dist * 10000) / 10000.0;
	}
	
	// This function converts decimal degrees to radians
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    // This function converts radians to decimal degrees
    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    } 

	@Override
	public String toString() {
		return "Wifi [X_SWIFI_MGR_NO=" + X_SWIFI_MGR_NO + ", X_SWIFI_WRDOFC=" + X_SWIFI_WRDOFC + ", X_SWIFI_MAIN_NM="
				+ X_SWIFI_MAIN_NM + ", X_SWIFI_ADRES1=" + X_SWIFI_ADRES1 + ", X_SWIFI_ADRES2=" + X_SWIFI_ADRES2
				+ ", X_SWIFI_INSTL_FLOOR=" + X_SWIFI_INSTL_FLOOR + ", X_SWIFI_INSTL_TY=" + X_SWIFI_INSTL_TY
				+ ", X_SWIFI_INSTL_MBY=" + X_SWIFI_INSTL_MBY + ", X_SWIFI_SVC_SE=" + X_SWIFI_SVC_SE + ", X_SWIFI_CMCWR="
				+ X_SWIFI_CMCWR + ", X_SWIFI_CNSTC_YEAR=" + X_SWIFI_CNSTC_YEAR + ", X_SWIFI_INOUT_DOOR="
				+ X_SWIFI_INOUT_DOOR + ", X_SWIFI_REMARS3=" + X_SWIFI_REMARS3 + ", LAT=" + LAT + ", LNT=" + LNT
				+ ", WORK_DTTM=" + WORK_DTTM + "]";
	}
}

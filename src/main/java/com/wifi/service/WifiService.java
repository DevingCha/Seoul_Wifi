package com.wifi.service;

import com.entity.Wifi;
import com.google.gson.*;
import com.ui.ProgressBar;
import com.wifi.repository.LocationHistoryRepository;
import com.wifi.repository.WifiRepository;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WifiService  {
	static ProgressBar pb;
	public static int length;
	public static int count = 0;
	
	public static void resetWifi() {
		pb = new ProgressBar();
		try {
			WifiRepository.deleteAll();
		} catch (Exception e) {
			System.out.println("삭제할 데이터가 없습니다.");
		}
		getWifiInfo();
	}
	
	public static int getWifiInfo() {
		// http://openapi.seoul.go.kr:8088/(API_KEY)/xml/TbPublicWifiInfo/start/end/
		length = getDataLength();
		count = 0;
		
		if (length == 0) {
			return 0;
		}
		
		try {
			for (int i = 1; i <= length; i += 1000) {
				pb.fill(i * 100, length);
				List<Wifi> wifiList = new ArrayList<Wifi>();
				String res = getRequest(i, i+999 < length ? i+999 : length);
				
				JsonObject jsonObject = new Gson().fromJson(res, JsonObject.class);
				JsonObject result = jsonObject.get("TbPublicWifiInfo").getAsJsonObject();		
				JsonArray wifies = result.getAsJsonArray("row");
				
				Gson gson = new Gson();
				wifies.forEach(e -> {
					try {
						Wifi wifi = gson.fromJson(e, Wifi.class);
						wifiList.add(wifi);
						count++;
					} catch (Exception se) {
						System.out.println("와이파이 정보 저장 실패 " + se.getMessage());
					}
				});
				WifiRepository.save(wifiList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		pb.quit();
		return count;
	}
	
	public static int getDataLength() {
		String res = getRequest(1, 1);
		
		if (res == null) {
			return 0;
		}
		
		JsonObject jsonObject = new Gson().fromJson(res, JsonObject.class);
		JsonObject result = jsonObject.get("TbPublicWifiInfo").getAsJsonObject();
		int length = result.get("list_total_count").getAsInt();
		
		return length;
	}
	
	public static String getRequest(int start, int end) {
		String url = "http://openapi.seoul.go.kr:8088/6c756c577979326b37364c78715448/json/TbPublicWifiInfo/" + start + "/" + end + "/";
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		
		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Wifi> getNearestWifi(double myLat, double myLnt) {
		// TODO: 가까운 와이파이 정보 가져올 때 히스토리 테이블에 데이터 저장
		List<Wifi> wifiList = WifiRepository.getAllWifi();
		LocationHistoryRepository.saveHistory(myLat, myLnt);
		wifiList.sort((w1, w2) -> Double.compare(w1.getDistance(myLat, myLnt), w2.getDistance(myLat, myLnt)));
		List<Wifi> nearestWifi = new ArrayList<>();
		
		for (int i = 0; i < ((wifiList.size() > 20) ? 20 : wifiList.size()); i++) {
			nearestWifi.add(wifiList.get(i));
		}
		return nearestWifi;
	}
}
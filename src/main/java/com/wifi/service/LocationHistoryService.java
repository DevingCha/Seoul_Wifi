package com.wifi.service;

import java.util.List;

import com.entity.LocationHistory;
import com.wifi.repository.LocationHistoryRepository;

public class LocationHistoryService {
	public static List<LocationHistory> getAllHistories() {
		return LocationHistoryRepository.getAllHistory();
	}
}

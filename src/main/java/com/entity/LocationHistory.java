package com.entity;

import lombok.Getter;
import lombok.Setter;

public class LocationHistory {
	@Getter @Setter private int id;
	@Getter @Setter private double lat;
	@Getter @Setter private double lnt;
	@Getter @Setter private String datetime;
	
	public LocationHistory(int id, double lat, double lnt, String datetime) {
		super();
		this.id = id;
		this.lat = lat;
		this.lnt = lnt;
		this.datetime = datetime;
	}
}

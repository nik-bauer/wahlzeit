package org.wahlzeit.model;

public class Coordinate {

	private final double latitude;
	private final double longitude;

	public Coordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getDistance(Coordinate coordinate) {
		//TODO
		return 0.0;
	}
}

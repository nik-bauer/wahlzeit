package org.wahlzeit.model;

public class Coordinate {

	private final double latitude;
	private final double longitude;

	public Coordinate(double latitude, double longitude) {

		if(latitude < -90.0 || latitude > 90.0) {
			throw new IllegalArgumentException("Latitude of " + latitude + " exceeds valid boundaries: [-90.0, 90.0]");
		}
		if(longitude < -180.0 || longitude > 180.0) {
			throw new IllegalArgumentException("Longitude of " + longitude + " exceeds valid boundaries: [-180.0, 180.0]");
		}

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

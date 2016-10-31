package org.wahlzeit.model;

public class Coordinate {

	public static final double EARTH_RADIUS_METERS = 6371000.0;

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

		double absDiffLat = Math.toRadians(Math.abs(coordinate.latitude - this.latitude));
		double absDiffLong = Math.toRadians(Math.abs(coordinate.longitude - this.longitude));

		double root = Math.pow(Math.sin(absDiffLat / 2), 2) + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(coordinate.latitude)) * Math.pow(Math.sin(absDiffLong / 2), 2);
		double centralAngle = 2 * Math.asin(Math.sqrt(root));

		//TODO: other formula seemed overkill -> check for rounding errors
		//double y = Math.sqrt(Math.pow(Math.cos(Math.toRadians(coordinate.latitude)) * Math.sin(absDiffLongitude), 2) + Math.pow(Math.cos(Math.toRadians(this.latitude)) * Math.sin(Math.toRadians(coordinate.latitude)) - Math.sin(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(coordinate.latitude)) * Math.cos(absDiffLongitude), 2));
		//double x = Math.sin(Math.toRadians(this.latitude)) * Math.sin(Math.toRadians(coordinate.latitude)) + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(coordinate.latitude)) * Math.cos(absDiffLongitude);
		//double centralAngle = Math.atan2(y, x);

		double distance = EARTH_RADIUS_METERS * centralAngle;
		return distance;
	}
}

package org.wahlzeit.model;

public class Location {

	public static final Location NO_LOCATION = new Location();

	private SphericCoordinate coordinate;

	public Location() {

	}

	public Location(SphericCoordinate coordinate) {
		// TODO: check if coordinate is null
		this.coordinate = coordinate;
	}

	public void setCoordinate(SphericCoordinate coordinate) {
		this.coordinate = coordinate;
	}

	public SphericCoordinate getCoordinate() {
		return coordinate;
	}

}

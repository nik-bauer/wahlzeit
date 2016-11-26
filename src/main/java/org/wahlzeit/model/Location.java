package org.wahlzeit.model;

public class Location {

	private SphericCoordinate coordinate;


	public Location(SphericCoordinate coordinate) {
		this.coordinate = coordinate;
	}

	public void setCoordinate(SphericCoordinate coordinate) {
		this.coordinate = coordinate;
	}

	public SphericCoordinate getCoordinate() {
		return coordinate;
	}

}

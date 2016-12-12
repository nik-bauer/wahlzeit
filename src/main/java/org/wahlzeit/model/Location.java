package org.wahlzeit.model;

import static org.wahlzeit.utils.CustomAssert.assertNotNull;

public class Location {

	private SphericCoordinate coordinate;


	public Location(SphericCoordinate coordinate) {
		assertNotNull(coordinate);
		this.coordinate = coordinate;
	}

	public void setCoordinate(SphericCoordinate coordinate) {
		assertNotNull(coordinate);
		this.coordinate = coordinate;
	}

	public SphericCoordinate getCoordinate() {
		return coordinate;
	}

}

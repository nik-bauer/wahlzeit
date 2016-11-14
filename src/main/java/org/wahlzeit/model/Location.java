package org.wahlzeit.model;

public class Location {

	public static final Location NO_LOCATION = new Location(null);

	private Coordinate coordinate;

	public Location() {

	}

	public Location(Coordinate coordinate) {
		// TODO: check if coordinate is null
		this.coordinate = coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

}

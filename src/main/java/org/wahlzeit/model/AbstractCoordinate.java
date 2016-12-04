package org.wahlzeit.model;

import static java.lang.Math.*;

public abstract class AbstractCoordinate implements Coordinate {

	public double EQUALS_DELTA = 0.01;

	public double getDistance(Coordinate coordinate) {

		assertCoordinateNotNull(coordinate);

		CartesianCoordinate thisCoord = this.asCartesian();
		CartesianCoordinate thatCoord = coordinate.asCartesian();

		double deltaX = pow(thisCoord.getX() - thatCoord.getX(), 2);
		double deltaY = pow(thisCoord.getY() - thatCoord.getY(), 2);
		double deltaZ = pow(thisCoord.getZ() - thatCoord.getZ(), 2);

		// pythagoras's theorem
		double distance = sqrt(deltaX + deltaY + deltaZ);

		assertDistanceIsValid(distance);
		assertClassInvariants();

		return distance;
	}

	public boolean isEqual(Coordinate coordinate) {

		assertCoordinateNotNull(coordinate);

		if(this.getDistance(coordinate) <= EQUALS_DELTA) {
			return true;
		}
		return false;
	}

	public abstract CartesianCoordinate asCartesian();

	/**
	 * @methodtype assert
	 * @param coordinate
	 */
	protected void assertCoordinateNotNull(Coordinate coordinate) {
		if(coordinate == null) {
			throw new IllegalArgumentException("Coordinate must not be null!");
		}
	}

	/**
	 * @metodtype assert
	 * @param distance
	 */
	protected void assertDistanceIsValid(double distance) {
		if(distance < 0) {
			throw new IllegalArgumentException("Distance must not be negative!");
		}
	}

	/**
	 * @methodtype assert
	 */
	protected abstract void assertClassInvariants();
}

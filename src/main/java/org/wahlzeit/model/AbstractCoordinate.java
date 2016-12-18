package org.wahlzeit.model;

import org.wahlzeit.utils.CustomExceptions.CoordinateParameterException;

import static java.lang.Math.*;
import static org.wahlzeit.utils.CustomAssert.assertNotNull;

public abstract class AbstractCoordinate implements Coordinate {

	public double EQUALS_DELTA = 0.01;

	public double getDistance(Coordinate coordinate) {

		assertNotNull(coordinate);

		CartesianCoordinate thisCoord = this.asCartesian();
		CartesianCoordinate thatCoord = coordinate.asCartesian();

		double deltaX = pow(thisCoord.getX() - thatCoord.getX(), 2);
		double deltaY = pow(thisCoord.getY() - thatCoord.getY(), 2);
		double deltaZ = pow(thisCoord.getZ() - thatCoord.getZ(), 2);

		// pythagoras's theorem
		double distance = sqrt(deltaX + deltaY + deltaZ);

		assertDistanceIsValid(distance);

		return distance;
	}

	public boolean isEqual(Coordinate coordinate) {

		assertNotNull(coordinate);

		if(this.getDistance(coordinate) <= EQUALS_DELTA) {
			return true;
		}
		return false;
	}

	public abstract CartesianCoordinate asCartesian();

	/**
	 * @metodtype assert
	 * @param distance
	 */
	protected void assertDistanceIsValid(double distance) {
		if(distance < 0) {
			throw new IllegalArgumentException("Distance must not be negative!");
		}
	}
}

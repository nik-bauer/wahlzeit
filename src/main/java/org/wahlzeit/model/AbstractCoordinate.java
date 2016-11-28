package org.wahlzeit.model;

import static java.lang.Math.*;

public abstract class AbstractCoordinate implements Coordinate {

	public double EQUALS_DELTA = 0.01;

	public double getDistance(Coordinate coordinate) {

		CartesianCoordinate thisCoord = this.asCartesian();
		CartesianCoordinate thatCoord = coordinate.asCartesian();

		double deltaX = pow(thisCoord.getX() - thatCoord.getX(), 2);
		double deltaY = pow(thisCoord.getY() - thatCoord.getY(), 2);
		double deltaZ = pow(thisCoord.getZ() - thatCoord.getZ(), 2);

		// pythagoras's theorem
		double distance = sqrt(deltaX + deltaY + deltaZ);

		return distance;
	}

	public boolean isEqual(Coordinate coordinate) {
		if(this.getDistance(coordinate) <= EQUALS_DELTA) {
			return true;
		}
		return false;
	}

	public abstract CartesianCoordinate asCartesian();
}

package org.wahlzeit.model;


public interface Coordinate {

    /**
     *
     * @param coordinate
     * @return distance in km
     */
    double getDistance(Coordinate coordinate);

	/**
	 *
	 * @param coordinate
	 * @return
	 */
    boolean isEqual(Coordinate coordinate);

	CartesianCoordinate asCartesian();
}

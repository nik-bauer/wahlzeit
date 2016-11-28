package org.wahlzeit.model;


public interface Coordinate {

    /**
     *
     * @param coordinate
     * @return distance in km
     */
    public double getDistance(Coordinate coordinate);

	/**
	 *
	 * @param coordinate
	 * @return
	 */
    public boolean isEqual(Coordinate coordinate);

	public CartesianCoordinate asCartesian();
}

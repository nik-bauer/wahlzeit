package org.wahlzeit.model;


import org.wahlzeit.utils.CustomExceptions.CoordinateParameterException;

public interface Coordinate {

    /**
     *
     * @param coordinate
     * @return distance in km
     */
    public double getDistance(Coordinate coordinate) throws CoordinateParameterException;

	/**
	 *
	 * @param coordinate
	 * @return
	 */
    public boolean isEqual(Coordinate coordinate) throws CoordinateParameterException;

	public CartesianCoordinate asCartesian() throws CoordinateParameterException;
}

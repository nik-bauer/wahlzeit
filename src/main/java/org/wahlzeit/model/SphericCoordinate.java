package org.wahlzeit.model;

import org.wahlzeit.utils.CustomExceptions.CoordinateParameterException;

import static java.lang.Math.*;

public class SphericCoordinate extends AbstractCoordinate {

    static final double EARTH_RADIUS_KM = 6371.0;

    private final double latitude;
    private final double longitude;
    private final double radius;

    /**
     * @methodtype constructor
     */
    public SphericCoordinate() {
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.radius = EARTH_RADIUS_KM;
    }

    /**
     * @methodtype constructor
     * @param latitude
     * @param longitude
     */
    public SphericCoordinate(double latitude, double longitude) {
        this(latitude, longitude, EARTH_RADIUS_KM);
    }

    /**
     * @methodtype constructor
     * @param latitude
     * @param longitude
     * @throws IllegalArgumentException
     */
    public SphericCoordinate(double latitude, double longitude, double radius) {

        assertLatitudeIsValid(latitude);
        assertLongitudeIsValid(longitude);
        assertRadiusIsValid(radius);

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    /**
     * @methodtype get
     * @return latitude
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * @methodtype get
     * @return longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * @methodtype get
     * @return earth radius in km
     */
    public double getRadius() {
        return this.radius;
    }

	/**
	 * @methodtype conversion
	 * @return cartesian representation
	 */
	@Override
	public CartesianCoordinate asCartesian() {
        assertLatitudeIsValid(latitude);
        assertLongitudeIsValid(longitude);
        assertRadiusIsValid(radius);

        double x = radius * sin(toRadians(longitude)) * cos(toRadians(latitude));
        double y = radius * sin(toRadians(longitude)) * sin(toRadians(latitude));
        double z = radius * cos(toRadians(longitude));

        return new CartesianCoordinate(x, y, z);
    }

    /**
     * @methodtype assert
     * @param latitude
     */
    private void assertLatitudeIsValid(double latitude) {
        if(latitude < -90.0 || latitude > 90.0 || Double.isNaN(latitude)) {
            throw new CoordinateParameterException("Latitude of " + latitude + " exceeds valid boundaries: [-90.0, 90.0]");
        }
    }

    /**
     * @methodtype assert
     * @param longitude
     */
    private void assertLongitudeIsValid(double longitude) {
        if(longitude < -180.0 || longitude > 180.0 || Double.isNaN(longitude)) {
            throw new CoordinateParameterException("Longitude of " + longitude + " exceeds valid boundaries: [-180.0, 180.0]");
        }
    }

    /**
     * @methodtype assert
     * @param radius
     */
    private void assertRadiusIsValid(double radius) {
        if(radius < 0.0 || Double.isNaN(radius) || Double.isInfinite(radius)) {
            throw new CoordinateParameterException("Radius of " + radius + " exceeds valid boundaries: [0.0, " + Double.MAX_VALUE + "[");
        }
    }
}

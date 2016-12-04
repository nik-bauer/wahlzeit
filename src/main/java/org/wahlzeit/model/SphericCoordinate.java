package org.wahlzeit.model;

import static java.lang.Math.*;

public class SphericCoordinate extends AbstractCoordinate {

    static final double EARTH_RADIUS_KM = 6371.0;

    private double latitude;
    private double longitude;
    private double radius;

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
    public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException {

        assertLatitudeIsValid(latitude);
        assertLongitudeIsValid(longitude);
        assertRadiusIsValid(radius);

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @methodtype set
     * @param latitude
     */
    public void setLatitude(double latitude) {
        assertLatitudeIsValid(latitude);

        this.latitude = latitude;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @methodtype set
     * @param longitude
     */
    public void setLongitude(double longitude) {
        assertLongitudeIsValid(longitude);

        this.longitude = longitude;

        assertClassInvariants();
    }

    /**
     * @methodtype get
     * @return earth radius in km
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @methodtype set
     * @param radius
     */
    public void setRadius(double radius) {
        assertRadiusIsValid(radius);

        this.radius = radius;

        assertClassInvariants();
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

        assertClassInvariants();

        return new CartesianCoordinate(x, y, z);
    }

    /**
     * @methodtype assert
     * @param latitude
     */
    private void assertLatitudeIsValid(double latitude) {
        if(latitude < -90.0 || latitude > 90.0 || Double.isNaN(latitude)) {
            throw new IllegalArgumentException("Latitude of " + latitude + " exceeds valid boundaries: [-90.0, 90.0]");
        }
    }

    /**
     * @methodtype assert
     * @param longitude
     */
    private void assertLongitudeIsValid(double longitude) {
        if(longitude < -180.0 || longitude > 180.0 || Double.isNaN(longitude)) {
            throw new IllegalArgumentException("Longitude of " + longitude + " exceeds valid boundaries: [-180.0, 180.0]");
        }
    }

    /**
     * @methodtype assert
     * @param radius
     */
    private void assertRadiusIsValid(double radius) {
        if(radius < 0.0 || Double.isNaN(radius)) {
            throw new IllegalArgumentException("Radius of " + radius + " exceeds valid boundaries: [0.0, " + Double.MAX_VALUE + "[");
        }
    }

    /**
     * @methodtype assert
     */
    @Override
    protected void assertClassInvariants() {
        assertLatitudeIsValid(this.latitude);
        assertLongitudeIsValid(this.longitude);
        assertRadiusIsValid(this.radius);
    }
}

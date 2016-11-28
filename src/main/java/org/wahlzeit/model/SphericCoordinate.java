package org.wahlzeit.model;

import static java.lang.Math.*;

public class SphericCoordinate extends AbstractCoordinate {

    public final double EARTH_RADIUS_KM = 6371.0;

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
    public SphericCoordinate(double latitude, double longitude) throws IllegalArgumentException {

        if(latitude < -90.0 || latitude > 90.0) {
            throw new IllegalArgumentException("Latitude of " + latitude + " exceeds valid boundaries: [-90.0, 90.0]");
        }
        if(longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("Longitude of " + longitude + " exceeds valid boundaries: [-180.0, 180.0]");
        }

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = EARTH_RADIUS_KM;
    }

    /**
     * @methodtype constructor
     * @param latitude
     * @param longitude
     * @throws IllegalArgumentException
     */
    public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException {

        if(latitude < -90.0 || latitude > 90.0) {
            throw new IllegalArgumentException("Latitude of " + latitude + " exceeds valid boundaries: [-90.0, 90.0]");
        }
        if(longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("Longitude of " + longitude + " exceeds valid boundaries: [-180.0, 180.0]");
        }

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
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
        if(latitude < -90.0 || latitude > 90.0) {
            throw new IllegalArgumentException("Latitude of " + latitude + " exceeds valid boundaries: [-90.0, 90.0]");
        }
        this.latitude = latitude;
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
        if(longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("Longitude of " + longitude + " exceeds valid boundaries: [-180.0, 180.0]");
        }
        this.longitude = longitude;
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
        this.radius = radius;
    }

	/**
	 * @methodtype conversion
	 * @return cartesian representation
	 */
	@Override
	public CartesianCoordinate asCartesian() {
        double x = radius * sin(toRadians(longitude)) * cos(toRadians(latitude));
        double y = radius * sin(toRadians(longitude)) * sin(toRadians(latitude));
        double z = radius * cos(toRadians(longitude));

        return new CartesianCoordinate(x, y, z);
    }
}

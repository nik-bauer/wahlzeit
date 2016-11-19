package org.wahlzeit.model;

import static java.lang.Math.*;

public class SphericCoordinate implements Coordinate {

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
     *
     * @param coordinate
     * @return great-circle distance between both coordinates in km
     * @throws IllegalArgumentException
     */
    @Override
    public double getDistance(Coordinate coordinate) throws IllegalArgumentException {
        SphericCoordinate coord;

        if(coordinate instanceof CartesianCoordinate) {
            coord = convertCartesianToSpherical((CartesianCoordinate) coordinate);
        } else if (coordinate instanceof SphericCoordinate) {
            coord = (SphericCoordinate) coordinate;
        } else {
            throw new IllegalArgumentException("Unknown coordinate type.");
        }

        double absDiffLat = toRadians(abs(coord.latitude - latitude));
        double absDiffLong = toRadians(abs(coord.longitude - longitude));

        double root = pow(sin(absDiffLat / 2), 2) + cos(toRadians(latitude)) * cos(toRadians(coord.latitude)) * pow(sin(absDiffLong / 2), 2);
        double centralAngle = 2 * asin(sqrt(root));

        double distance = EARTH_RADIUS_KM * centralAngle;

        return distance;
    }

    /**
     *
     * @param cartesianCoordinate
     * @return conversion to spherical coordinate
     */
    private SphericCoordinate convertCartesianToSpherical(CartesianCoordinate cartesianCoordinate) {
        double radius = sqrt(pow(cartesianCoordinate.getX(), 2) + pow(cartesianCoordinate.getY(), 2) + pow(cartesianCoordinate.getZ(), 2));
        double latitude = acos(cartesianCoordinate.getZ() / radius);
        double longitude = atan2(cartesianCoordinate.getY(), cartesianCoordinate.getX());

        return new SphericCoordinate(latitude, longitude, radius);
    }
}

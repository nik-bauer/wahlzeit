package org.wahlzeit.model;

import static java.lang.Math.*;

public class CartesianCoordinate implements Coordinate {

    private double x;
    private double y;
    private double z;

    /**
     * @methodtype constructor
     */
    public CartesianCoordinate() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    /**
     * @methodtype constructor
     * @param x
     * @param y
     * @param z
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * @methodtype get
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * @methodtype set
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @methodtype get
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * @methodtype set
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @methodtype get
     * @return z
     */
    public double getZ() {
        return z;
    }

    /**
     * @methodtype set
     * @param z
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     *
     * @param coordinate
     * @return shortest distance between both coordinates in km
     * @throws IllegalArgumentException
     */
    @Override
    public double getDistance(Coordinate coordinate) throws IllegalArgumentException {
        CartesianCoordinate coord;

        if(coordinate instanceof SphericCoordinate) {
            coord = convertSphericalToCartesian((SphericCoordinate) coordinate);
        } else if (coordinate instanceof CartesianCoordinate) {
            coord = (CartesianCoordinate) coordinate;
        } else {
            throw new IllegalArgumentException("Unknown coordinate type.");
        }

        double deltaX = pow(coord.getX() - x, 2);
        double deltaY = pow(coord.getY() - y, 2);
        double deltaZ = pow(coord.getZ() - z, 2);

        // pythagoras's theorem
        double distance = sqrt(deltaX + deltaY + deltaZ);

        return distance;
    }

    /**
     *
     * @param sphericCoordinate
     * @return conversion to cartesian coordinate
     */
    public CartesianCoordinate convertSphericalToCartesian(SphericCoordinate sphericCoordinate) {
        double x = sphericCoordinate.EARTH_RADIUS_KM * cos(sphericCoordinate.getLatitude()) * cos(sphericCoordinate.getLongitude());
        double y = sphericCoordinate.EARTH_RADIUS_KM * sin(sphericCoordinate.getLatitude()) * sin(sphericCoordinate.getLongitude());
        double z = sphericCoordinate.EARTH_RADIUS_KM * sin(sphericCoordinate.getLatitude());

        return new CartesianCoordinate(x, y, z);
    }
}

package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

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
     * @methodtype conversion
     * @return cartesian representation
     */
    @Override
    public CartesianCoordinate asCartesian() {
        return this;
    }
}

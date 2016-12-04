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

        assertClassInvariants();
    }

    /**
     * @methodtype constructor
     * @param x
     * @param y
     * @param z
     */
    public CartesianCoordinate(double x, double y, double z) {

        assertXIsValid(x);
        assertYIsValid(y);
        assertZIsValid(z);

        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
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
        assertXIsValid(x);
        this.x = x;
        assertClassInvariants();
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
        assertYIsValid(y);
        this.y = y;
        assertClassInvariants();
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
        assertZIsValid(z);
        this.z = z;
        assertClassInvariants();
    }

    /**
     * @methodtype conversion
     * @return cartesian representation
     */
    @Override
    public CartesianCoordinate asCartesian() {
        return this;
    }

    /**
     * @methodtype assert
     * @param x
     */
    private void assertXIsValid(double x) {
        if(Double.isNaN(x)) {
            throw new IllegalArgumentException("X is not a number!");
        }
    }

    /**
     * @methodtype assert
     * @param y
     */
    private void assertYIsValid(double y) {
        if(Double.isNaN(y)) {
            throw new IllegalArgumentException("Y is not a number!");
        }
    }

    /**
     * @methodtype assert
     * @param z
     */
    private void assertZIsValid(double z) {
        if(Double.isNaN(z)) {
            throw new IllegalArgumentException("Z is not a number!");
        }
    }

    /**
     * @methodtype assert
     */
    @Override
    protected void assertClassInvariants() {
        assertXIsValid(this.x);
        assertYIsValid(this.y);
        assertZIsValid(this.z);
    }
}

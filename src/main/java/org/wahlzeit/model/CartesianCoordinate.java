package org.wahlzeit.model;

import static org.wahlzeit.utils.CustomAssert.assertIsValidDouble;

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

        assertIsValidDouble(x, "x");
        assertIsValidDouble(y, "y");
        assertIsValidDouble(z, "z");

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
        assertIsValidDouble(x, "x");
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
        assertIsValidDouble(y, "y");
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
        assertIsValidDouble(z, "z");
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
     */
    @Override
    protected void assertClassInvariants() {
        assertIsValidDouble(this.x, "x");
        assertIsValidDouble(this.y, "y");
        assertIsValidDouble(this.z, "z");
    }
}

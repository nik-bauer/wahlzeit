package org.wahlzeit.model;

import static org.wahlzeit.utils.CustomAssert.assertIsValidDouble;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

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

        assertIsValidDouble(x, "x");
        assertIsValidDouble(y, "y");
        assertIsValidDouble(z, "z");

        this.x = x;
        this.y = y;
        this.z = z;
	}

    /**
     * @methodtype get
     * @return x
     */
    public double getX() {
        return this.x;
    }

    /**
     * @methodtype get
     * @return y
     */
    public double getY() {
        return this.y;
    }

    /**
     * @methodtype get
     * @return z
     */
    public double getZ() {
        return this.z;
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

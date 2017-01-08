package org.wahlzeit.model;

import java.util.concurrent.ConcurrentHashMap;

import static org.wahlzeit.utils.CustomAssert.assertIsValidDouble;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

	private static ConcurrentHashMap<CartesianCoordinate, CartesianCoordinate> allInstances = new ConcurrentHashMap<>();


	public static CartesianCoordinate getInstance(final double x, final double y, final double z) {
		CartesianCoordinate cartesianCoord = new CartesianCoordinate(x, y, z);
		CartesianCoordinate coord = allInstances.get(cartesianCoord);

		if(coord == null) {
			allInstances.put(cartesianCoord, cartesianCoord);
			coord = cartesianCoord;
		}

		return coord;
	}

    /**
     * @methodtype constructor
     * @param x
     * @param y
     * @param z
     */
    private CartesianCoordinate(double x, double y, double z) {

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

	/**
	 * @methodtype compare
	 * @param o
	 * @return
	 * (auto_generated)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CartesianCoordinate that = (CartesianCoordinate) o;

		if (Double.compare(that.getX(), getX()) != 0) return false;
		if (Double.compare(that.getY(), getY()) != 0) return false;
		return Double.compare(that.getZ(), getZ()) == 0;
	}

	/**
	 * @methodtype compare
	 * @return
	 * (auto_generated)
	 */
	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(getX());
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getY());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getZ());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}

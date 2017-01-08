package org.wahlzeit.model;

import org.wahlzeit.utils.CustomExceptions.CoordinateParameterException;

import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Math.*;

public class SphericCoordinate extends AbstractCoordinate {

    static final double EARTH_RADIUS_KM = 6371.0;

    private final double latitude;
    private final double longitude;
    private final double radius;

	private static ConcurrentHashMap<SphericCoordinate, SphericCoordinate> allInstances = new ConcurrentHashMap<>();

	public static SphericCoordinate getInstance(final double latitude, final double longitude) {
		SphericCoordinate sphericCoord = new SphericCoordinate(latitude, longitude);
		SphericCoordinate coord = allInstances.get(sphericCoord);

		if(coord == null) {
			allInstances.put(sphericCoord, sphericCoord);
			coord = sphericCoord;
		}

		return coord;
	}

	public static SphericCoordinate getInstance(final double latitude, final double longitude, final double radius) {
		SphericCoordinate sphericCoord = new SphericCoordinate(latitude, longitude, radius);
		SphericCoordinate coord = allInstances.get(sphericCoord);

		if(coord == null) {
			allInstances.put(sphericCoord, sphericCoord);
			coord = sphericCoord;
		}

		return coord;
	}

    /**
     * @methodtype constructor
     * @param latitude
     * @param longitude
     */
    private SphericCoordinate(double latitude, double longitude) {
        this(latitude, longitude, EARTH_RADIUS_KM);
    }

    /**
     * @methodtype constructor
     * @param latitude
     * @param longitude
     * @throws IllegalArgumentException
     */
    private SphericCoordinate(double latitude, double longitude, double radius) {

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

        return CartesianCoordinate.getInstance(x, y, z);
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

		SphericCoordinate that = (SphericCoordinate) o;

		if (Double.compare(that.getLatitude(), getLatitude()) != 0) return false;
		if (Double.compare(that.getLongitude(), getLongitude()) != 0) return false;
		return Double.compare(that.getRadius(), getRadius()) == 0;
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
		temp = Double.doubleToLongBits(getLatitude());
		result = (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getLongitude());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getRadius());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
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

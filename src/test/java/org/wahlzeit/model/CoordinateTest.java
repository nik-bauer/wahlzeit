package org.wahlzeit.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CoordinateTest {

	@Test
	public void testConstructor() {
		Coordinate c = new Coordinate(12.34, 56.78);

		assertEquals(c.getLatitude(), 12.34);
		assertEquals(c.getLongitude(), 56.78);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorValidationLatitude() {
		Coordinate c = new Coordinate(99.99, 12.34);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorValidationLongitude() {
		Coordinate c = new Coordinate(12.34, -199.99);
	}

	@Test
	public void testDistance() {
		Coordinate c1 = new Coordinate(49.593900, 11.009808);
		// c1 -> c2 = 2m
		Coordinate c2 = new Coordinate(49.593885, 11.009815);
		// c1 -> c3 = 2558m
		Coordinate c3 = new Coordinate(49.573906, 11.027360);

		double distance1_2 = Math.round(c1.getDistance(c2));
		double distance1_3 = Math.round(c1.getDistance(c3));

		assertEquals(distance1_2, 2.0);
		assertEquals(distance1_3, 2558.0);
	}
}
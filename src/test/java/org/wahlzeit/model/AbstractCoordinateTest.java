package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.utils.CustomExceptions.CoordinateParameterException;

import static org.junit.Assert.*;

public class AbstractCoordinateTest {

	CartesianCoordinate cartesianCoordinate;
	SphericCoordinate sphericCoordinate;

	@Before
	public void setUp() {
		try {
			cartesianCoordinate = new CartesianCoordinate(0.10, 0.00, 3.00);
			sphericCoordinate = new SphericCoordinate(1, 2, 3);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getDistance() {
		try {
			assertEquals(0.0, cartesianCoordinate.getDistance(cartesianCoordinate), 0.01);
			assertEquals(0.0, sphericCoordinate.getDistance(sphericCoordinate), 0.01);
			assertEquals(0.0, cartesianCoordinate.getDistance(sphericCoordinate), 0.1);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void isEqual() {
		try {
			assertTrue(cartesianCoordinate.isEqual(cartesianCoordinate));
			assertTrue(sphericCoordinate.isEqual(sphericCoordinate));
			assertTrue(cartesianCoordinate.isEqual(sphericCoordinate));
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}

	}
}
package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.wahlzeit.utils.CustomExceptions.CoordinateParameterException;

import static org.junit.Assert.*;


public class SphericCoordinateTest {

    public final double EARTH_RADIUS_KM = 6371.0;
    private SphericCoordinate coordHamburg;
    private SphericCoordinate coordErlangen;

    @Before
    public void setUp() throws CoordinateParameterException {
        coordHamburg = new SphericCoordinate(53.56, 10.00); // 657.128257, 890.005556, 6274.210194
        coordErlangen = new SphericCoordinate(49.58, 11.01); // 788.9139567, 926.3154512, 6253.734521
    }

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest1() {
		try {
			SphericCoordinate coord = new SphericCoordinate(-91.0, 0.0);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest2() {
		try {
			SphericCoordinate coord = new SphericCoordinate(91.0, 0.0);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest3() {
		try {
			SphericCoordinate coord = new SphericCoordinate(0.0, -181.0);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest4() {
		try {
			SphericCoordinate coord = new SphericCoordinate(0.0, 181.0);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest5() {
		try {
			SphericCoordinate coord = new SphericCoordinate(0.0, 0.0, -1.0);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getterSetterTest() {
		SphericCoordinate coord = new SphericCoordinate();
		assertEquals(EARTH_RADIUS_KM, coord.getRadius(), 0);

		try {
			coord.setLatitude(12.34);
			coord.setLongitude(56.78);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
		assertEquals(12.34, coord.getLatitude(), 0);
		assertEquals(56.78, coord.getLongitude(), 0);
	}

    @Test
    public void getDistanceTest() {
		try {
			assertEquals(138.22, coordHamburg.getDistance(coordErlangen), 1);
			assertEquals(138.22, coordErlangen.getDistance(coordHamburg), 1);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
    }

	@Test
	public void asCartesianTest() {
		SphericCoordinate sphCoord = null;
		CartesianCoordinate convCoord = null;
		try {
			sphCoord = new SphericCoordinate(1, 2, 3);
			convCoord = sphCoord.asCartesian();
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}

		assertEquals(0.10, convCoord.getX(), 0.1);
		assertEquals(0.00, convCoord.getY(), 0.1);
		assertEquals(3.00, convCoord.getZ(), 0.1);
	}

	@Test
	public void isEqualTest() {
		try {
			assertTrue(coordHamburg.isEqual(coordHamburg));
			assertFalse(coordHamburg.isEqual(coordErlangen));
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}
}

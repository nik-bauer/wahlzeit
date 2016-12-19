package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SphericCoordinateTest {

    public final double EARTH_RADIUS_KM = 6371.0;
    private SphericCoordinate coordHamburg;
    private SphericCoordinate coordErlangen;

    @Before
    public void setUp() {
        coordHamburg = SphericCoordinate.getInstance(53.56, 10.00); // 657.128257, 890.005556, 6274.210194
        coordErlangen = SphericCoordinate.getInstance(49.58, 11.01); // 788.9139567, 926.3154512, 6253.734521
    }

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest1() {
		SphericCoordinate coord = SphericCoordinate.getInstance(-91.0, 0.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest2() {
		SphericCoordinate coord = SphericCoordinate.getInstance(91.0, 0.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest3() {
		SphericCoordinate coord = SphericCoordinate.getInstance(0.0, -181.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest4() {
		SphericCoordinate coord = SphericCoordinate.getInstance(0.0, 181.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest5() {
		SphericCoordinate coord = SphericCoordinate.getInstance(0.0, 0.0, -1.0);
	}

	@Test
	public void getterTest() {
		assertEquals(53.56, coordHamburg.getLatitude(), 0);
		assertEquals(10.0, coordHamburg.getLongitude(), 0);
		assertEquals(EARTH_RADIUS_KM, coordHamburg.getRadius(), 0);

		assertEquals(49.58, coordErlangen.getLatitude(), 0);
		assertEquals(11.01, coordErlangen.getLongitude(), 0);
		assertEquals(EARTH_RADIUS_KM, coordErlangen.getRadius(), 0);
	}

    @Test
    public void getDistanceTest() {
		assertEquals(138.22, coordHamburg.getDistance(coordErlangen), 1);
		assertEquals(138.22, coordErlangen.getDistance(coordHamburg), 1);
	}

	@Test
	public void asCartesianTest() {
		SphericCoordinate sphCoord = null;
		CartesianCoordinate convCoord = null;
		sphCoord = SphericCoordinate.getInstance(1, 2, 3);
		convCoord = sphCoord.asCartesian();

		assertEquals(0.10, convCoord.getX(), 0.1);
		assertEquals(0.00, convCoord.getY(), 0.1);
		assertEquals(3.00, convCoord.getZ(), 0.1);
	}

	@Test
	public void isEqualTest() {
		assertTrue(coordHamburg.isEqual(coordHamburg));
		assertFalse(coordHamburg.isEqual(coordErlangen));
	}
}

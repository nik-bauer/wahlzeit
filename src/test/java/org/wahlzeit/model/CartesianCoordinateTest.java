package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CartesianCoordinateTest {

    public final double EARTH_RADIUS_KM = 6371.0;
    private CartesianCoordinate coordOrigin;
    private CartesianCoordinate coord_1_1_1;

    @Before
    public void setUp() {
        coordOrigin = new CartesianCoordinate(0.0, 0.0, 0.0);
        coord_1_1_1 = new CartesianCoordinate(1.0, 1.0, 1.0);
    }

    @Test
    public void constructorTest(){
        assertNotNull(coordOrigin);
        assertNotNull(coord_1_1_1);
    }

    @Test
    public void getterTest() {
		assertEquals(0.0, coordOrigin.getX(), 0);
		assertEquals(0.0, coordOrigin.getY(), 0);
		assertEquals(0.0, coordOrigin.getZ(), 0);

		assertEquals(1.0, coordOrigin.getX(), 0);
		assertEquals(1.0, coordOrigin.getY(), 0);
		assertEquals(1.0, coordOrigin.getZ(), 0);
	}

	@Test
	public void getDistanceTest() {
		assertEquals(1.73, coordOrigin.getDistance(coord_1_1_1), 0.1);
		assertEquals(1.73, coord_1_1_1.getDistance(coordOrigin), 0.1);
	}

	@Test
	public void asCartesianTest() {
		assertEquals(coord_1_1_1, coord_1_1_1.asCartesian());
	}

	@Test
	public void isEqualTest() {
		assertTrue(coord_1_1_1.isEqual(coord_1_1_1));
		assertFalse(coord_1_1_1.isEqual(coordOrigin));
	}
}
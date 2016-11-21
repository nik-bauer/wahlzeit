package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class SphericCoordinateTest {

    public final double EARTH_RADIUS_KM = 6371.0;
    private SphericCoordinate coordHamburg;
    private SphericCoordinate coordErlangen;

    @Before
    public void setUp() {
        coordHamburg = new SphericCoordinate(53.56, 10.00);
        coordErlangen = new SphericCoordinate(49.58, 11.01);
    }

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest1(){
		SphericCoordinate coord = new SphericCoordinate(-91.0, 0.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest2(){
		SphericCoordinate coord = new SphericCoordinate(91.0, 0.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest3(){
		SphericCoordinate coord = new SphericCoordinate(0.0, -181.0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorValidationTest4(){
		SphericCoordinate coord = new SphericCoordinate(0.0, 181.0);
	}

    @Test
    public void getDistanceTest() {
        assertEquals(448.01, coordHamburg.getDistance(coordErlangen), 1);
        assertEquals(448.01, coordErlangen.getDistance(coordHamburg), 1);
    }

    @Test
    public void convertCartesianToSphericalTest() {
        CartesianCoordinate cartCoord = new CartesianCoordinate(1.0, 2.0, 3.0);
        SphericCoordinate convCoord = new SphericCoordinate();
        convCoord = convCoord.convertCartesianToSpherical(cartCoord);

        assertEquals(0.64, convCoord.getLatitude(), 0.1);
        assertEquals(1.11, convCoord.getLongitude(), 0.1);
        assertEquals(3.74, convCoord.getRadius(), 0.1);
    }

    @Test
    public void getterSetterTest() {
        SphericCoordinate coord = new SphericCoordinate();
        assertEquals(EARTH_RADIUS_KM, coord.getRadius(), 0);

        coord.setLatitude(12.34);
        assertEquals(12.34, coord.getLatitude(), 0);

        coord.setLongitude(56.78);
        assertEquals(56.78, coord.getLongitude(), 0);
    }

    @Ignore
	@Test
	public void getDistanceWithConversionTest() {
		CartesianCoordinate cartErlangen = new CartesianCoordinate(123, 456, 789);
		System.out.println(coordHamburg.convertCartesianToSpherical(cartErlangen).getLatitude()+" "+
				coordHamburg.convertCartesianToSpherical(cartErlangen).getLongitude()+" "+
				coordHamburg.convertCartesianToSpherical(cartErlangen).getRadius());
		assertEquals(448.01, coordHamburg.getDistance(cartErlangen), 1);
	}

}
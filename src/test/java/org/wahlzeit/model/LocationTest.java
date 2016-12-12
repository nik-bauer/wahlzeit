package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.utils.CustomExceptions.CoordinateParameterException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class LocationTest {

	private Coordinate c;
	private Location l;

	@Before
	public void initLocation() {
		try {
			c = new SphericCoordinate(12.34, 56.78);
			l = new Location((SphericCoordinate)c);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConstructor() {
		assertNotNull(c);
		assertNotNull(l);

		assertEquals(l.getCoordinate(), c);
	}

	@Test
	public void testGetterSetter() {
		Coordinate coord = null;
		try {
			coord = new SphericCoordinate(1.0, 1.0);
			l.setCoordinate((SphericCoordinate) coord);
		} catch (CoordinateParameterException e) {
			e.printStackTrace();
		}
		assertEquals(coord, l.getCoordinate());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructorExeption(){
		c = null;
		l = new Location((SphericCoordinate)c);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetterExeption(){
		l.setCoordinate(null);
	}
}

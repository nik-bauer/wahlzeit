package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class LocationTest {

	private Coordinate c;
	private Location l;

	@Before
	public void initLocation() {
		c = new SphericCoordinate(12.34, 56.78);
		l = new Location((SphericCoordinate)c);
	}

	@Test
	public void testConstructor() {
		assertNotNull(c);
		assertNotNull(l);

		assertEquals(l.getCoordinate(), c);
	}
}

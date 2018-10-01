package org.linuxx.moonserver.java7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TestFinal {

	Point pointSUT;
	
	@Before
	public void setUp() {
		pointSUT = new Point(1,2);
	}

	@Test
	public void testX() {
		Assert.assertEquals(1, pointSUT.x);
	}

	@Test
	public void testY() {
		Assert.assertEquals(2, pointSUT.y);
	}

	@Ignore
	@Test
	public void testOrigin() {
		Assert.assertEquals(0, pointSUT.origin.x);
		Assert.assertEquals(0, pointSUT.origin.y);
	}

	@Test
	public void testManipulateOrigin() {
		pointSUT.origin.x = 2;
		pointSUT.origin.y = 3;
		Assert.assertEquals(2, pointSUT.origin.x);
		Assert.assertEquals(3, pointSUT.origin.y);
	}

	public static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static final Point origin = new Point(0, 0);
	}
}

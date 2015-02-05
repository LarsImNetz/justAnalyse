package de.lla.tools;

import org.junit.Assert;
import org.junit.Test;

public class TestExcelColumns {

	@Test
	public void test1() {
		Assert.assertEquals("A", new ExcelColumns().get(1 - 1));
	}

	@Test
	public void test2() {
		Assert.assertEquals("B", new ExcelColumns().get(2 - 1));
	}

	@Test
	public void test3() {
		Assert.assertEquals("C", new ExcelColumns().get(3 - 1));
	}

	@Test
	public void test26() {
		Assert.assertEquals("Z", new ExcelColumns().get(26 - 1));
	}

	@Test
	public void test27() {
		Assert.assertEquals("AA", new ExcelColumns().get(27 - 1));
	}

	@Test
	public void testBB() {
		Assert.assertEquals("BB", new ExcelColumns().get(26 + 26 + 1 - 1));
	}

	// @Test
	// public void test() {
	// for (int i = 0; i < 100; i++) {
	// System.out.println(new ExcelColumns().get(i));
	// }
	// }
}

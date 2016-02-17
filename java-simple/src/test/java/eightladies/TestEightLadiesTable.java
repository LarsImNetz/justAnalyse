package eightladies;

import org.junit.Assert;
import org.junit.Test;

public class TestEightLadiesTable {
	EightLadiesTable etable = new EightLadiesTable(new int[8][8]);

	@Test
	public void testName() throws Exception {
		System.out.println(etable.output());
	}
	
	@Test
	public void testBackgroundColor() throws Exception {
		Assert.assertEquals("bgcolor=#ffffff", etable.backgroundColor(0, 0));
		Assert.assertEquals("bgcolor=#e0e0e0", etable.backgroundColor(1, 0));
		Assert.assertEquals("bgcolor=#ffffff", etable.backgroundColor(2, 0));

		Assert.assertEquals("bgcolor=#e0e0e0", etable.backgroundColor(0, 1));
		Assert.assertEquals("bgcolor=#ffffff", etable.backgroundColor(1, 1));
		Assert.assertEquals("bgcolor=#e0e0e0", etable.backgroundColor(2, 1));
	}
}

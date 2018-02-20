package privat.lla;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class TestWillAlsoFail {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testOtherGood() {
		int a = 1;
		Assert.assertEquals(1, a);
	}
}

package functions;


import org.junit.Assert;
import org.junit.Test;



public class TestFies {

	@Test
	public void testBöse() {
		Assert.assertEquals(1, böse());
	}

	private int böse() {
		return 1;
	}
}

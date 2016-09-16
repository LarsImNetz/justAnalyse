package text;

import org.junit.Assert;
import org.junit.Test;

public class TestSatzDreher {

	@Test
	public void testSatz() {
		SatzDreher satzDreher = new SatzDreher("Hello World");
		Assert.assertEquals("Hello World", satzDreher.getSatz());
	}
}

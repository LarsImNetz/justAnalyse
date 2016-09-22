package text;

import org.junit.Assert;
import org.junit.Test;

public class TestSatzDreher {

	@Test
	public void testSatz() {
		SatzDreher satzDreher = new SatzDreher("Hello World");
		Assert.assertEquals("Hello World", satzDreher.getSatz());
	}

	@Test
	public void testGetVerdrehtenSatz() throws Exception {
		SatzDreher satzDreher = new SatzDreher("Dieser Satz sollte noch lesbar sein, auch wenn er etwas komisch aussieht.");
		System.out.println(satzDreher.getVerdrehtenSatz());
	}
}

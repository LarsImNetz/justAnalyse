package org.lla.phrasendrescher;

import org.junit.Assert;
import org.junit.Test;

public class TestWort {

	@Test
	public void testGetWort() {
		final Wort wortSUT = new Wort("Hallo Welt");
		Assert.assertEquals(" Hallo", wortSUT.getWort());
	}

	@Test
	public void testGetWort2() {
		final Wort wortSUT = new Wort("a b", "a b");
		Assert.assertEquals(" aa", wortSUT.getWort());
	}
}

package org.lla.phrasendrescher;

import org.junit.Assert;
import org.junit.Test;

public class TestWortListe {

	@Test
	public void testGetWort() {
		final WortListe wortSUT = new WortListe("Hallo Welt");
		Assert.assertEquals(" Hallo", wortSUT.getWort());
	}

	@Test
	public void testGetWort2() {
		final WortListe wortSUT = new WortListe("a b", "a b");
		Assert.assertEquals(" aa", wortSUT.getWort());
	}
}

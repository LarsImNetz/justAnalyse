package de.lla.tools;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestOption {

	de.lla.tools.Option options;

	@Before
	public void setUp() {
		options = new Option();
	}

	@Test
	public void testSetIgnoreMoreToken_true() {
		options.setIgnoreMoreToken(true);
		Assert.assertEquals(true, options.isIgnoreMoreToken());
	}

	@Test
	public void testSetIgnoreMoreToken_false() {
		options.setIgnoreMoreToken(false);
		Assert.assertEquals(false, options.isIgnoreMoreToken());
	}

}

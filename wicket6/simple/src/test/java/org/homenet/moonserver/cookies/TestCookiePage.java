package org.homenet.moonserver.cookies;

import org.apache.wicket.util.tester.WicketTester;
import org.homelinux.moonserver.WicketApplication;
import org.junit.Before;
import org.junit.Test;

public class TestCookiePage {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void homepageRendersSuccessfully() {
		// start and render the test page
		tester.startPage(CookiePage.class);

		// assert rendered page class
		tester.assertRenderedPage(CookiePage.class);
	}

	@Test
	public void homepageContainsTable() {
		tester.startPage(CookiePage.class);
		tester.debugComponentTrees();
	}
}

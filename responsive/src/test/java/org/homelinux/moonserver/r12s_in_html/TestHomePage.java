package org.homelinux.moonserver.r12s_in_html;

import org.apache.wicket.util.tester.WicketTester;
import org.homelinux.moonserver.WicketApplication;
import org.homelinux.moonserver.r12s_in_html.HomePage;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void homepageRendersSuccessfully() {
		// start and render the test page
		tester.startPage(HomePage.class);

		// assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}

	@Test
	public void homepageContainsComponents() {
		tester.startPage(HomePage.class);
		tester.debugComponentTrees();
		tester.assertContains("title");
		tester.assertContains("ajaxLink");
		tester.assertContains("ajaxText");
	}
}

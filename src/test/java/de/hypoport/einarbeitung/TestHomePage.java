package de.hypoport.einarbeitung;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.hypoport.einarbeitung.homepage.WicketApplication;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Ignore
	@Test
	public void homepageRendersSuccessfully() {
		//start and render the test page
		tester.startPage(HomePage.class);
		// tester.startPage(ZinsRechnerPage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}
}

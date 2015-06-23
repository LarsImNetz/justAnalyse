package de.vergleich.sample;

import org.apache.wicket.Component;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
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
		setup();
		tester.assertRenderedPage(HomePage.class);
	}

	@Test
	public void testForm() throws Exception {
		setup();

		Component component = tester.getComponentFromLastRenderedPage("form");
		Assert.assertNotNull(component);
		tester.assertUsability(component);
	}

	@Test
	public void testFormComponents() throws Exception {
		setup();

		Component name = tester.getComponentFromLastRenderedPage("form:name");
		Assert.assertNotNull(name);
		tester.assertUsability(name);

		Component darlehensbetrag = tester.getComponentFromLastRenderedPage("form:darlehensbetrag");
		Assert.assertNotNull(darlehensbetrag);
		tester.assertUsability(darlehensbetrag);

		Component immobilienwert = tester.getComponentFromLastRenderedPage("form:immobilienwert");
		Assert.assertNotNull(immobilienwert);
		tester.assertUsability(immobilienwert);

		Component monatlicheRate = tester.getComponentFromLastRenderedPage("form:monatlicheRate");
		Assert.assertNotNull(monatlicheRate);
		tester.assertUsability(monatlicheRate);
	}

	private void setup() {
		tester.startPage(HomePage.class);
	}
}

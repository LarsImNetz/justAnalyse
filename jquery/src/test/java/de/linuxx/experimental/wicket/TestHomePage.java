package de.linuxx.experimental.wicket;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHomePage {

	WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester();

		tester.startPage(new HomePage(null));
	}

	@Test
	public void test() {
		Page page = tester.getLastRenderedPage();
		tester.assertUsability(page);
	}

	@Test
    public void testLabel() throws Exception {
	    Component component = tester.getComponentFromLastRenderedPage("label");
	    Assert.assertNotNull(component);
	}
}

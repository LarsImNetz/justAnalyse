package org.homelinux.moonserver;


import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLabelPanel {

	WicketTester tester;

	@Before
	public void before() {
		tester = new WicketTester();
	}

	@Test
	public void testUsability() {
		LabelPanel component = tester.startComponentInPage(new LabelPanel("panel"));
		tester.assertUsability(component);
	}
	
	@Test
	public void testLabelComponent() {
		LabelPanel component = tester.startComponentInPage(new LabelPanel("panel"));
		// component.labelText
		Assert.assertEquals("leer", component.labelText.getObject());
	}
	
	@Test
	public void testCountWords() {
		int count = LabelPanel.countWords(null);
		Assert.assertEquals(0, count);

		count = LabelPanel.countWords("");
		Assert.assertEquals(0, count);

		count = LabelPanel.countWords("one");
		Assert.assertEquals(1, count);

		count = LabelPanel.countWords("one two");
		Assert.assertEquals(2, count);
	}

}

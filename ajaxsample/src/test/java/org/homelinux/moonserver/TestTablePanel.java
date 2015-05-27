package org.homelinux.moonserver;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTablePanel {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester();
		tester.startComponentInPage(new TablePanel("panel"));
	}

	@Test
	public void testUsability() {
		Component component = tester.getComponentFromLastRenderedPage("panel");
		tester.assertUsability(component);
	}

	@Test
	public void test() {
		// tester.dumpPage();
		// tester.debugComponentTrees();
		// Sicherstellen, das die Componente existiert
		tester.assertComponent("panel:cell2", Label.class);

		// sicherstellen, das es ein Tag wicket:id="cell2" gibt
		TagTester tagById = tester.getTagByWicketId("cell2");
		Assert.assertNotNull(tagById);

		// sicherstellen, das im Attribute "class" der value 'label' drin ist.
		String attribute = tagById.getAttribute("class");
		Assert.assertEquals("label", attribute);
	}

}

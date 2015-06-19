package org.homelinux.moonserver;

import org.apache.wicket.Component;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestLabelPanel {

	WicketTester tester;

	@Before
	public void before() {
		WicketApplication wicketApplication = new WicketApplication();
		tester = new WicketTester(wicketApplication);
	}

	@Test
	public void testUsability() {
		LabelPanel component = tester.startComponentInPage(new LabelPanel("panel"));
		tester.assertUsability(component);
	}

	@Test
	public void testLabelComponent() {
		LabelPanel component = tester.startComponentInPage(new LabelPanel("panel"));
		Assert.assertEquals("leer", component.labelText.getObject());
	}

	@Test
	public void testButtonPressed() {
		SimplePayload payloadMock = Mockito.mock(SimplePayload.class);
		LabelPanel component = tester.startComponentInPage(new LabelPanel("panel"));

		// press button simulation
		component.getPage().send(component, Broadcast.DEPTH, payloadMock);

		Mockito.verify(payloadMock, Mockito.atLeastOnce()).update(Mockito.any(Component.class));
	}

}

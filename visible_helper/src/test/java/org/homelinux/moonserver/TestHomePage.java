package org.homelinux.moonserver;

import org.apache.wicket.Component;
import org.apache.wicket.util.tester.WicketTester;
import org.homelinux.moonserver.bean.Bean;
import org.homelinux.moonserver.guice.VisibilityHelperModule;
import org.homelinux.moonserver.visible.ILabelVisibilityHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {
	private WicketTester tester;

	private ILabelVisibilityHelper visibilityHelper;
	
	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());

		Injector injector = Guice.createInjector(new VisibilityHelperModule());
		visibilityHelper = injector.getInstance(ILabelVisibilityHelper.class);
	}

	@Test
	public void homepageRendersSuccessfully() {
		// start and render the test page
		tester.startPage(HomePage.class);

		// assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}
	
	@Test
	public void testOnClick() {
		tester.startPage(HomePage.class);
		Component component = tester.getComponentFromLastRenderedPage("button");
		Assert.assertNotNull(component);

		Bean bean = visibilityHelper.getBean(component);
		Assert.assertNotNull(bean);
		Assert.assertNull(bean.getA());

		tester.executeAjaxEvent(component, "click");

		Bean bean2 = visibilityHelper.getBean(component);
		Assert.assertEquals("leer", bean2.getA());

		Assert.assertSame(bean,  bean2);

	}
}

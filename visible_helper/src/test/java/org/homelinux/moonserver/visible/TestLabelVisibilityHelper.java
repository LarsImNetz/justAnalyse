package org.homelinux.moonserver.visible;

import java.io.Serializable;

import org.apache.wicket.Session;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.tester.WicketTester;
import org.homelinux.moonserver.HomePage;
import org.homelinux.moonserver.WicketApplication;
import org.homelinux.moonserver.bean.Bean;
import org.homelinux.moonserver.guice.VisibilityHelperModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestLabelVisibilityHelper {

	private ILabelVisibilityHelper visibilityHelper;

	private WicketTester tester;
	
	@Before
	public void before() {
		WicketApplication app = new WicketApplication();
		tester = new WicketTester(app);

		Injector injector = Guice.createInjector(new VisibilityHelperModule());
		visibilityHelper = injector.getInstance(ILabelVisibilityHelper.class);
	}

//	@Test(expected=IllegalArgumentException.class)
//	public void testVisibility_with_NULL() {
//		boolean visible = visibilityHelper.isVisible();
//		Assert.assertEquals(false, visible);
//	}

	@Test
	public void testPage() throws Exception {
		PageParameters params = new PageParameters();
		params.add("a", "ein Label");
		tester.startPage(new HomePage(params));

		tester.assertRenderedPage(HomePage.class);

		Session session = tester.getSession();
		Assert.assertNotNull(session);
		
		Serializable attribute = session.getAttribute(HomePage.GLOBAL_BEAN);
		Assert.assertNotNull(attribute);
		
		if (attribute instanceof Bean) {
			Bean bean = (Bean)attribute;
			String a = bean.getA();
			Assert.assertEquals("ein Label", a);
		}
		else {
			Assert.fail("attribute ist kein Bean, sollte es aber sein");
		}
	}
	//	@Test
//	public void testVisibility_with_Component() {
//		Mockito 
//		boolean visible = visibilityHelper.isVisible(null);
//		Assert.assertEquals(false, visible);
//	}
	
	@Test
	public void testCountWords() {
		Assert.assertNotNull(visibilityHelper);
		
		int count = visibilityHelper.countWords(null);
		Assert.assertEquals(0, count);

		count = visibilityHelper.countWords("");
		Assert.assertEquals(0, count);

		count = visibilityHelper.countWords("one");
		Assert.assertEquals(1, count);

		count = visibilityHelper.countWords("one two");
		Assert.assertEquals(2, count);
	}


}

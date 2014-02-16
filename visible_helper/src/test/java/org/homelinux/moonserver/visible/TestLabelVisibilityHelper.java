package org.homelinux.moonserver.visible;

import org.homelinux.moonserver.guice.VisibilityHelperModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestLabelVisibilityHelper {

	private ILabelVisibilityHelper visibilityHelper;

	@Before
	public void before() {
		Injector injector = Guice.createInjector(new VisibilityHelperModule());
		visibilityHelper = injector.getInstance(ILabelVisibilityHelper.class);		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testVisibility_with_NULL() {
		boolean visible = visibilityHelper.isVisible(null);
		Assert.assertEquals(false, visible);
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

package de.hypoport.einarbeitung.guice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class TestGuiceWithProvider {

	private static Injector injector;

	private ISampleClass iTestClass;

	@Before
	public void before() {
		System.out.println("create Injector");
		injector = Guice.createInjector(new MyModule());
		System.out.println("get instance");
		iTestClass = injector.getInstance(ISampleClass.class);
	}

	@Test
	public void testAccess() {
		System.out.println("test Access");
		Assert.assertNotNull(iTestClass);
		iTestClass.setValue("b");
		Assert.assertEquals("b", iTestClass.getValue());
	}

	@Test
	public void testSecondTestClass() {
		System.out.println("test Second Access");
		ISampleClass iTestClass2 = injector.getInstance(ISampleClass.class);

		Assert.assertNotSame(iTestClass, iTestClass2);

		Assert.assertNotNull(iTestClass2);
		iTestClass2.setValue("c");
		Assert.assertEquals("c", iTestClass2.getValue());
		Assert.assertEquals("something", iTestClass.getValue());
	}

	@Test
	public void testNotSame() {
		ISampleClass iTestClass2 = injector.getInstance(ISampleClass.class);

		Assert.assertNotSame(iTestClass, iTestClass2);

		ISampleClass iTestClass3 = injector.getInstance(ISampleClass.class);

		Assert.assertNotSame(iTestClass2, iTestClass3);

	}

	private static class MyModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(ISampleClass.class).toProvider(TestClassProvider.class);
		}
	}

	private static class TestClassProvider implements Provider<SampleClass> {

		@Override
		public SampleClass get() {
			return new SampleClass();
		}
	}

}

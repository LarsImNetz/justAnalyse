package de.hypoport.einarbeitung.guice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestGuice {

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
		iTestClass.setValue("other");
		Assert.assertEquals("other", iTestClass.getValue());
	}

	@Test
	public void testSecondTestClass() {
		System.out.println("test Second Access");
		ISampleClass iTestClass2 = injector.getInstance(ISampleClass.class);

		Assert.assertNotSame(iTestClass, iTestClass2);

		Assert.assertNotNull(iTestClass2);
		iTestClass2.setValue("c is other");
		Assert.assertEquals("c is other", iTestClass2.getValue());
		Assert.assertEquals("something", iTestClass.getValue());
	}

	private static class MyModule extends AbstractModule {

		@Override
		protected void configure() {
			// bind(ITestClass.class).toInstance(new TestClass()); // Der Baut mir einen Singleton
			bind(ISampleClass.class).to(SampleClass.class);
			// noop bind(ITestClass.class).to(TestClass.class).in(Singleton.class); // initialisiert erst beim Zugriff auf getInstance
			// noop bind(ITestClass.class).to(TestClass.class).asEagerSingleton(); // initialisiert so früh wie möglich, noch vor getInstance
		}
	}

}

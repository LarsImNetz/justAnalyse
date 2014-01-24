package de.hypoport.einarbeitung.guice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

public class TestGuiceAsSingleton {

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

		Assert.assertSame(iTestClass, iTestClass2);

		Assert.assertNotNull(iTestClass2);
		iTestClass2.setValue("c");
		Assert.assertEquals("c", iTestClass2.getValue());
		Assert.assertEquals("c", iTestClass.getValue());
	}

	private static class MyModule extends AbstractModule {

		@Override
		protected void configure() {
			// bind(ITestClass.class).toInstance(new TestClass()); // Der Baut mir einen Singleton
			// bind(ISampleClass.class).to(SampleClass.class);
			bind(ISampleClass.class).to(SampleClass.class).in(Singleton.class); // initialisiert erst beim Zugriff auf getInstance
			// noop bind(ITestClass.class).to(TestClass.class).asEagerSingleton(); // initialisiert so früh wie möglich, noch vor getInstance
		}
	}

}

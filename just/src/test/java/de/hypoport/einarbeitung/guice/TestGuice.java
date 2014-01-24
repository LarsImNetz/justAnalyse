package de.hypoport.einarbeitung.guice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Singleton;

public class TestGuice {

	private static Injector injector;

	private ITestClass iTestClass;

	@Before
	public void before() {
		System.out.println("create Injector");
		injector = Guice.createInjector(new MyModule());
		System.out.println("get instance");
		iTestClass = injector.getInstance(ITestClass.class);
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
		ITestClass iTestClass2 = injector.getInstance(ITestClass.class);

		Assert.assertNotSame(iTestClass, iTestClass2);

		Assert.assertNotNull(iTestClass2);
		iTestClass2.setValue("c");
		Assert.assertEquals("c", iTestClass2.getValue());
		Assert.assertEquals("ein", iTestClass.getValue());
	}

	private static class MyModule extends AbstractModule {

		@Override
		protected void configure() {
			// bind(ITestClass.class).toInstance(new TestClass()); // Der Baut mir einen Singleton
			// ok. bind(ITestClass.class).to(TestClass.class);
			// noop bind(ITestClass.class).to(TestClass.class).in(Singleton.class); // initialisiert erst beim Zugriff auf getInstance
			// noop bind(ITestClass.class).to(TestClass.class).asEagerSingleton(); // initialisiert so früh wie möglich, noch vor getInstance
			// ok. bind(ITestClass.class).toProvider(TestClassProvider.class);
			bind(ITestClass.class).toProvider(TestClassProvider.class).asEagerSingleton();
		}
	}

	private interface ITestClass {

		String setValue(String a);

		String getValue();
	}

	private static class TestClassProvider implements Provider<TestClass> {

		@Override
		public TestClass get() {
			return new TestClass();
		}
	}

	private static class TestClass implements ITestClass {

		String value;

		public TestClass() {
			value = "ein";
			System.out.println("C'Tor TestClass init value to " + value);
		}

		@Override
		public String setValue(String a) {
			this.value = a;
			System.out.println("setValue to " + value);
			return this.value;
		}

		@Override
		public String getValue() {
			System.out.println("getValue " + value);
			return value;
		}

	}
}

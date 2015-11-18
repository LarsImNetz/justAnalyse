package experiment.lars.dependency.injection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class TestCDI {

	public static Injector injector;

	@Inject
	@FooServerAnnotation("hallo")
	private IFooClient client;

	@Inject
	@Named("c")
	int value;

	@BeforeClass
	public static void beforeClass() {
		injector = Guice.createInjector(new FooModule("a"));
	}

	@Test
	public void test() {
		injector.injectMembers(this);

		Assert.assertNotNull(client);
		Assert.assertEquals("a", client.get());
		Assert.assertEquals(30, value);
	}

	@Test
	public void testName() throws Exception {

	}

	private static class FooModule extends AbstractModule {

		private final String fooServerAddress;

		public FooModule(final String fooServerAddress) {
			this.fooServerAddress = fooServerAddress;
		}

		@Override
		protected void configure() {
			bindConstant().annotatedWith(FooServerAnnotation.class).to(fooServerAddress);
			bind(IFooClient.class).annotatedWith(FooServerAnnotation.class).toInstance(new FooClient(fooServerAddress));

			bindConstant().annotatedWith(Names.named("c")).to("30");
		}
	}

	private interface IFooClient {

		String get();
	}

	private static class FooClient implements IFooClient {

		private final String fooServerAddress;

		@Inject
		public FooClient(@FooServerAddress final String fooServerAddress) {
			System.out.println("c'tor " + fooServerAddress);
			this.fooServerAddress = fooServerAddress;
		}

		@Override
		public String get() {
			return fooServerAddress;
		}
	}
}

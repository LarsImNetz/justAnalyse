package experiment.lars.dependency.injection;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;

public class TestGuiceProvider {

	/*
	 * Zugriff auf entsprechende Provider Objekte geht nur über Annotations, sonst gibt es keinerlei Unterscheidungsmöglichkeiten
	 */
	@Test
	public void testGuice() {
		Injector injector = Guice.createInjector(new RealViaProviderModule());
		IReal r = injector.getInstance(Key.get(IReal.class, FooServerAddress.class));

		Assert.assertNotNull(r);
		Assert.assertEquals("provider 1", r.getValue());
	}

	@Test
	public void testGuice2() {
		Injector injector = Guice.createInjector(new RealViaProviderModule());
		IReal r = injector.getInstance(Key.get(IReal.class, FooServerAnnotation.class));

		Assert.assertNotNull(r);
		Assert.assertEquals("provider 2", r.getValue());
	}

	private static class RealViaProviderModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(IReal.class).annotatedWith(FooServerAddress.class).toProvider(RealProvider.class);
			bind(IReal.class).annotatedWith(FooServerAnnotation.class).toProvider(RealProvider2.class);
		}
	}

	private static class RealProvider implements Provider<Real> {

		@Override
		public Real get() {
			Real r = new Real("provider 1");
			return r;
		}
	}

	private static class RealProvider2 implements Provider<Real> {

		@Override
		public Real get() {
			Real r = new Real("provider 2");
			return r;
		}
	}

	public interface IReal {

		String getValue();
	}

	private static class Real implements IReal {

		String a = "real";

		public Real(String value) {
			a = value;
		}

		@Override
		public String getValue() {
			return a;
		}
	}
}

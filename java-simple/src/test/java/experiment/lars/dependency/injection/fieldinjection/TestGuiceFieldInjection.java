package experiment.lars.dependency.injection.fieldinjection;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestGuiceFieldInjection {

	@Test(expected = NullPointerException.class)
	public void testGuiceFieldInject() {
		/* Injector injector = */Guice.createInjector(new RealModule());
		/// IReal r = injector.getInstance(IReal.class);

		IReal real = new RealImpl(); // zustand 1: internes Real Object ist noch nicht injected
		Assert.assertNotNull(real);

		Assert.assertEquals("real", real.getValue());
	}

	@Test
	public void testGuiceFieldInjectReallyInjected() {
		Injector injector = Guice.createInjector(new RealModule());
		/// IReal r = injector.getInstance(IReal.class);

		IReal real = new RealImpl(); // zustand 1: noch!
		injector.injectMembers(real); // Zustand 2: internes Real Object wurde injected

		Assert.assertEquals("real", real.getValue());
	}

	private static class RealModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(IReal.class).to(Real.class);
		}

	}

	public interface IReal {

		String getValue();
	}

	private static class Real implements IReal {

		@SuppressWarnings("unused")
		public Real() {
		}

		@Override
		public String getValue() {
			return "real";
		}
	}

	private static class RealImpl implements IReal {

		@Inject
		private Real real;

		@Override
		public String getValue() {
			return real.getValue();
		}

	}
}

package experiment.lars.dependency.injection;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestGuice {

	@Test
	public void testGuice() {
		Injector injector = Guice.createInjector(new RealModule());
		IReal r = injector.getInstance(IReal.class);

		Assert.assertNotNull(r);
		Assert.assertEquals("real", r.getValue());
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

		String a = "real";

		@SuppressWarnings("unused")
		public Real() {
		}

		@Override
		public String getValue() {
			return a;
		}
	}
}

package experiment.lars.dependency.injection.ctorinjection;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestGuiceConstructorInjection {

	@Test
	public void testGuiceCTorInjection() {
		Injector injector = Guice.createInjector(new RealModule());
		// IReal r = injector.getInstance(IReal.class);
		IReal2 r2 = injector.getInstance(IReal2.class);

		Assert.assertEquals("real", r2.getValue());
	}

	private static class RealModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(IReal.class).to(Real.class);
			bind(IReal2.class).to(RealImpl.class);
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

	public interface IReal2  extends IReal {
	}

	private static class RealImpl implements IReal2 {

		private final IReal real;

		@Inject
		public RealImpl(IReal real) {
			this.real = real;
		}

		@Override
		public String getValue() {
			return real.getValue();
		}

	}
}

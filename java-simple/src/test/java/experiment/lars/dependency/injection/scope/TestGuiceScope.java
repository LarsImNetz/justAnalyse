package experiment.lars.dependency.injection.scope;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Singleton;

public class TestGuiceScope {

	private Injector injector;

	@Before
	public void setUp() {
		injector = Guice.createInjector(new RealModule());
	}

	@Test
	public void testGuiceSingleton() {
		final IReal first = injector.getInstance(Key.get(IReal.class, RealSingleton.class));
		final IReal second = injector.getInstance(Key.get(IReal.class, RealSingleton.class));

		Assert.assertSame(first, second);
	}

	@Test
	public void testGuiceNotSingleton() {
		final IReal first = injector.getInstance(Key.get(IReal.class, RealNotSingleton.class));
		final IReal second = injector.getInstance(Key.get(IReal.class, RealNotSingleton.class));

		Assert.assertNotEquals(first, second);
	}

	private static class RealModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(IReal.class).annotatedWith(RealSingleton.class).to(Real.class).in(Singleton.class);
			bind(IReal.class).annotatedWith(RealNotSingleton.class).to(Real.class);
		}

	}

	public interface IReal {

	}

	private static class Real implements IReal {

		final Double n;

		@SuppressWarnings("unused")
		public Real() {
			n = Math.random();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((n == null)
					? 0
					: n.hashCode());
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Real other = (Real) obj;
			if (n == null) {
				if (other.n != null) {
					return false;
				}
			}
			else if (!n.equals(other.n)) {
				return false;
			}
			return true;
		}

	}
}

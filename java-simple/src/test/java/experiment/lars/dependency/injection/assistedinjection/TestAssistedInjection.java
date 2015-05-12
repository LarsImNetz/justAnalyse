package experiment.lars.dependency.injection.assistedinjection;

import org.junit.Assert;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class TestAssistedInjection {

	// Dieser Test soll zeigen, wie eine Assisted Injection erstellt wird
	@Test
	public void testCreationOfSimple() {

		// initialisierung des Guice Injector Frameworks
		final Injector injector = Guice.createInjector(new AbstractModule() {

			@Override
			protected void configure() {
				// Der spezielle Service, den wir verwenden wollen
				bind(IService.class).to(MyService.class);

				// erstellen der Factory, die für Assisted Injection verwendet werden soll
				install(new FactoryModuleBuilder().implement(Simple.class, Simple.class).build(SimpleFactory.class));
			}
		});

		// eine SimpleFactory Instance holen (die Factory selbst wird automatisch von Guice erstellt)
		final SimpleFactory simpleFactory = injector.getInstance(SimpleFactory.class);

		// nutzen der Factory um ein Simple Objekt zu erstellen
		final Simple simple = simpleFactory.create("my");

		// eigentliche Tests
		Assert.assertNotNull(simple);
		Assert.assertEquals("myService", simple.doSomething());
	}

	private static class MyService implements IService {

		@Override
		public String something() {
			return "Service";
		}

	}
}

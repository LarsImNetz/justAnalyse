package experiment.lars.dependency.injection.ctorinjection;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestGuiceConstructorInjection2 {

	@Test
	public void testGuiceCTorInjection() {
		Injector injector = Guice.createInjector(new RealModule());
		Person person = injector.getInstance(Person.class);
		Assert.assertEquals("hello world", person.doGreeting());
	}

	@Test
	public void testPeronImpl() {
		HelloService mock = Mockito.mock(HelloService.class);
		Mockito.when(mock.sayHello()).thenReturn("bla");
		PersonImpl person = new PersonImpl(mock);

		System.out.println(person.doGreeting());
	}

	private static class RealModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(HelloService.class).to(HelloServiceImpl.class);
			bind(Person.class).to(PersonImpl.class);
		}

	}

	interface HelloService {

		public String sayHello();
	}

	static class HelloServiceImpl implements HelloService {

		@Override
		public String sayHello() {
			return "hello world";
		}

	}

	interface Person {

		public String doGreeting();
	}

	static class PersonImpl implements Person {

		private final HelloService service;

		@Inject
		public PersonImpl(HelloService service) {
			this.service = service;
		}

		@Override
		public String doGreeting() {
			return this.service.sayHello();
		}

	}
}

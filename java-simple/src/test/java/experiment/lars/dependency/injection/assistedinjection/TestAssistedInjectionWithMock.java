package experiment.lars.dependency.injection.assistedinjection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestAssistedInjectionWithMock {

	@Mock
	private IService serviceMock;

	@Test
	public void testDoSomething() {
		Mockito.doReturn("ber").when(serviceMock).something();

		final Simple simple = new Simple(serviceMock, "a");

		Assert.assertEquals("aber", simple.doSomething());
	}

}

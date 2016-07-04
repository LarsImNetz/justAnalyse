package experiment.lars.java.generics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestGenericsWithMockitoTest {

	private static class MyClass {

		private MyClass() {
		}

		public String getString(final String anyString) {
			return anyString;
		}

		public String getComplicated(final Map<String, List<String>> map) {
			return "complicated";
		}
	}

	@Test
	public void testAnyString() {
		final MyClass myMock = Mockito.mock(MyClass.class);
		final String value = "hallo Mockito";
		Mockito.when(myMock.getString(Mockito.anyString())).thenReturn(value);

		final String actual = myMock.getString("schnubbel");
		Assert.assertEquals("hallo Mockito", actual);
	}

	@Test
	public void testGetComplicated() {
		final MyClass myMock = Mockito.mock(MyClass.class);
		final String value = "hallo Mockito";
		final Map<String, List<String>> map = new HashMap<>();
		Mockito.when(myMock.getComplicated(map)).thenReturn(value);

		final String actual = myMock.getComplicated(map);
		Assert.assertEquals("hallo Mockito", actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetComplicated_anyMap() {
		final MyClass myMock = Mockito.mock(MyClass.class);
		final String value = "hallo Mockito";
		Mockito.when(myMock.getComplicated(Mockito.anyMap())).thenReturn(value);

		final String actual = myMock.getComplicated(null);
		Assert.assertEquals("hallo Mockito", actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetComplicated_any() {
		final MyClass myMock = Mockito.mock(MyClass.class);
		final String value = "hallo Mockito";
		Mockito.when(myMock.getComplicated(Mockito.any(Map.class))).thenReturn(value);

		final String actual = myMock.getComplicated(null);
		Assert.assertEquals("hallo Mockito", actual);
	}

	@Test
	public void testGetComplicated_anyWithGeneric() {
		final MyClass myMock = Mockito.mock(MyClass.class);
		final String value = "hallo Mockito";
		Mockito.when(myMock.getComplicated(Mockito.<Map<String, List<String>>> any())).thenReturn(value);

		final String actual = myMock.getComplicated(null);
		Assert.assertEquals("hallo Mockito", actual);
	}

}

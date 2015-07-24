package experiment.lars.java.generics;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestGenerics {

	@Test
	public void testWithString() {
		final ArrayList<String> a = new ArrayList<>();
		a.add("a String");
        // nicht möglich, weil nicht String a.add(1);
        Assert.assertEquals(1, a.size());
        Assert.assertEquals("a String", a.get(0));
	}

    @Test
	public void testWithInteger() {
		final ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
        // nicht möglich, weil nicht String a.add(1);
        Assert.assertEquals(1, a.size());
        Assert.assertEquals(Integer.valueOf(1), a.get(0));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Test
	public void testNoGeneric() {
		final ArrayList a = new ArrayList();
		a.add(null);
		a.add("string");
		a.add(1);
		Assert.assertEquals(3, a.size());
	}

	@Test
	public void testNumber() {
		final ArrayList<Number> a = new ArrayList<>();
		a.add(null);
		// a.add("string");
		a.add(Integer.valueOf(1));
		a.add(Float.valueOf(1.1f));
		Assert.assertEquals(3, a.size());
	}

}

package experiment.lars.java.generics;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class TestGenerics {

	@Test
	public void testWildcardExtendsObject() {
		final ArrayList<? extends Object> a = new ArrayList<>();
		a.add(null);
		//		a.add("string");
		//		a.add(1);

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

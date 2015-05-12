package experiment.lars.interfaces;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class TestInterfaces {

	@Test
	public void test() {
		String values = "";
		for (String zahl : new MyIterable()) {
			values += zahl;
		}
		Assert.assertEquals("einszweidrei", values);
	}

	public static class MyIterable implements Iterable<String> {

		@Override
		public Iterator<String> iterator() {
			return new MyIterator();
		}
	}

	public static class MyIterator implements Iterator<String> {

		String[] array = {"eins", "zwei", "drei"};
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < array.length;
		}

		@Override
		public String next() {
			final String result = array[index];
			if (hasNext()) {
				index++;
			}
			return result;
		}

		@Override
		public void remove() {
		}
	}
}

package experiment.lars.java;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class TestSets {

	@Test
	public void testSingleString() throws Exception {
		final Set<String> stringSet = new HashSet<>();
		stringSet.add("eins");

		Assert.assertTrue(stringSet.contains("eins"));
	}

	@Test
	public void testTwoStrings() throws Exception {
		final Set<String> stringSet = new HashSet<>();
		stringSet.add("eins");
		stringSet.add("zwo");

		Assert.assertTrue(stringSet.contains("eins"));
		Assert.assertTrue(stringSet.contains("zwo"));
	}

	@Test
	public void testSetWithMyStrings() throws Exception {
		final MyStrings my = new MyStrings("first", "second");
		final MyStrings my2 = new MyStrings("first", "second");
		final Set<MyStrings> stringSet = new HashSet<>();
		stringSet.add(my);
		stringSet.add(my2);

		// will only be 1, if we implement equals and hashcode by our self
		Assert.assertEquals(1, stringSet.size());
	}

	private static class MyStrings {

		private final String one;
		private final String two;

		MyStrings(final String first, final String second) {
			one = first;
			two = second;
		}

		String getOne() {
			return one;
		}

		String getTwo() {
			return two;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((one == null)
					? 0
					: one.hashCode());
			result = prime * result + ((two == null)
					? 0
					: two.hashCode());
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
			final MyStrings other = (MyStrings) obj;
			if (one == null) {
				if (other.one != null) {
					return false;
				}
			}
			else if (!one.equals(other.one)) {
				return false;
			}
			if (two == null) {
				if (other.two != null) {
					return false;
				}
			}
			else if (!two.equals(other.two)) {
				return false;
			}
			return true;
		}

	}
}

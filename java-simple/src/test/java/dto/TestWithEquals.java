package dto;

import org.junit.Assert;
import org.junit.Test;


public class TestWithEquals {

	@Test
	public void testLearnEquals() {
		final WithEquals first = new WithEquals(1);
		final WithEquals second = new WithEquals(1);

		Assert.assertEquals(first, second);
		Assert.assertEquals(first.hashCode(), second.hashCode());
	}

	@Test
	public void testLearnWithoutEquals() {
		final WithoutEquals first = new WithoutEquals(1);
		final WithoutEquals second = new WithoutEquals(1);

		Assert.assertNotEquals(first.hashCode(), second.hashCode());
		Assert.assertNotEquals(first, second);
	}

	private static class WithoutEquals {

		private final int value;

		public WithoutEquals(final int value) {
			this.value = value;
		}
	}

	private static class WithEquals {

		private final int value;

		public WithEquals(final int value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + value;
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
			final WithEquals other = (WithEquals) obj;
			if (value != other.value) {
				return false;
			}
			return true;
		}

	}
}

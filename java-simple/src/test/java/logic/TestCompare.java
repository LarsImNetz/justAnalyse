package logic;

import org.junit.Assert;
import org.junit.Test;

public class TestCompare {

	private static final String item1 = "item1";
	private static final String item2 = "item2";

	@Test
	public void testCheckNullBoth() {
		Assert.assertEquals(1234, checkNull(item1, item2));
	}

	@Test
	public void testCheckNullOnlyFirst() {
		Assert.assertEquals(1, checkNull(item1, null));
	}

	@Test
	public void testCheckNullNone() {
		Assert.assertEquals(0, checkNull(null, null));
	}

	@Test
	public void testCheckNullSecond() {
		Assert.assertEquals(-1, checkNull(null, item2));
	}

	private int checkNull(String item1, String item2) {
		if (item1 == null && item2 == null) {
			return 0;
		}

		if (item1 == null /* && item2 != null */ ) {
			return -1;
		}

		if (item1 != null && item2 == null) {
			return 1;
		}

		return 1234;
	}

	@Test
	public void testCompareNone() {
		Assert.assertEquals(0, compare("", ""));
	}

	@Test
	public void testCompareFirst() {
		Assert.assertEquals(1, compare(item1, ""));
	}

	@Test
	public void testCompareSecond() {
		Assert.assertEquals(-1, compare("", item2));
	}

	@Test
	public void testCompareBoth() {
		Assert.assertEquals(-1, compare(item1, item2));
	}

	private int compare(String item1, String item2) {
		if (item1.isEmpty() && item2.isEmpty()) {
			return 0;
		}

		if (item1.isEmpty() && !item2.isEmpty()) {
			return -1;
		}

		if (!item1.isEmpty() && item2.isEmpty()) {
			return 1;
		}
		return item1.compareTo(item2);
	}
	
	@Test
	public void testCompareFirstSmaller() {
		Assert.assertEquals(-1, "a".compareTo("b"));
	}
	@Test
	public void testCompareEqual() {
		Assert.assertEquals(0, "a".compareTo("a"));
	}
	@Test
	public void testCompareFirstGreater() {
		Assert.assertEquals(1, "b".compareTo("a"));
	}
}

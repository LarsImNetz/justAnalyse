package text;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class TestWordCollection {

	@Test
	public void test() {
		WordCollection collection = new WordCollection("Hello und World");

		List<String> list = collection.stream().collect(Collectors.toList());
		
		Assert.assertNotNull(list);
		Assert.assertEquals(3, list.size());
		Assert.assertArrayEquals(new String[] {"Hello","und","World"}, list.toArray());
	}

	@Test
	public void testFilter() {
		WordCollection collection = new WordCollection("Hello und World");

		List<String> list = collection.stream().filter(n->!"und".equals(n)).collect(Collectors.toList());
		
		Assert.assertNotNull(list);
		Assert.assertEquals(2, list.size());
		Assert.assertArrayEquals(new String[] {"Hello","World"}, list.toArray());
	}

	@Test
	public void testFilterFunction() {
		WordCollection collection = new WordCollection("Hello und World");
		List<String> list = collection.stream().filter(notUnd()).collect(Collectors.toList());
		Assert.assertNotNull(list);

		Assert.assertEquals(2, list.size());
		list.forEach(System.out::println);
	}

	private Predicate<? super String> notUnd() {
		return n -> !"und".equals(n);
	}

}

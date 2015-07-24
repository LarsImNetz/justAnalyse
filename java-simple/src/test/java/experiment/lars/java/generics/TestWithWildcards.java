package experiment.lars.java.generics;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestWithWildcards {

	private MyContainer<String> strings;

	@Before
	public void setup() {
		strings = new MyContainer<>();
	}

	@Test
	public void testAdd() {
		strings.add("a string");
		strings.add("a second string");

		Assert.assertEquals("a string", strings.getExtendsList().get(0));
	}

	@Test
	public void testGetExtendsList() {
		List<? extends String> unmodifiable = strings.getExtendsList();
		Assert.assertNotNull(unmodifiable);
		// unmodifiable.add("test"); das ist nicht erlaubt
		unmodifiable.add(null); // das einzige akzeptierte Object

		Assert.assertEquals(1, strings.getExtendsList().size());
	}

	@Test
	public void testGetList() {
		strings.add("a string");
		Assert.assertEquals("a string", strings.getList().get(0));

		// DON'T wir bekommen vollen Zugriff auf die Liste
		List<String> modifiable = strings.getList();
		modifiable.add("egal");
		Assert.assertEquals(2, modifiable.size());

		// Damit ist dann auch unsere Liste mit mehr Werten gefüllt...
		Assert.assertEquals(2, strings.getList().size());
	}

	@Test
	public void testSetExtendsList() {
		strings.add("a string");

		// erstellen eine neue Liste
		List<String> list = new ArrayList<>();
		list.add("egal");

		// übergeben die Liste
		strings.setExtendsList(list);

		// löschen die Liste
		list.clear();
		Assert.assertTrue(list.isEmpty());

		// aber in unserem Objekt sind die Elemente noch vorhanden 
		Assert.assertEquals(1, strings.getExtendsList().size());
		Assert.assertEquals("egal", strings.getExtendsList().get(0));
	}

	@Test
	public void testSetList() {
		strings.add("a string");

		// erstellen eine neue Liste
		List<String> list = new ArrayList<>();
		list.add("egal");

		// übergeben die Liste
		strings.setList(list);

		// löschen die Liste
		list.clear();
		Assert.assertTrue(list.isEmpty());

		// auch in unserem Objekt sind die Elemente noch vorhanden 
		Assert.assertEquals(0, strings.getExtendsList().size());
	}

	private static class MyContainer<T> {

		// DON'T leave out final! Es verhindert das wir die Liste neu setzen können
		private/* final */List<T> container;

		public MyContainer() {
			container = new ArrayList<T>();
		}

		// DO: support only an add() for new elements
		public void add(T t) {
			container.add(t);
		}

		public List<? extends T> getExtendsList() {
			return container;
		}

		// DON'T give back the list, damit können wir die Liste ändern
		public List<T> getList() {
			return container;
		}

		// DON'T support a setter to a list, we can change our inner data from outside
		public void setList(List<T> list) {
			container = list;
		}

		// DO: copy every object
		public void setExtendsList(List<? extends T> list) {
			// wir müssen die Elemente einzeln holen und neu hinzufügen
			container.clear();

			for (T t : list) {
				container.add(t);
			}
		}
	}
}

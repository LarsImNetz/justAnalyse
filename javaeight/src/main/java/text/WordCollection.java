package text;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class WordCollection implements Collection<String> {

	private List<String> words;

	WordCollection(String sentence) {
		words = Arrays.asList(sentence.split(" "));
	}

	@Override
	public boolean add(String e) {
		words.add(e);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		return words.addAll(c);
	}

	@Override
	public void clear() {
		words.clear();

	}

	@Override
	public boolean contains(Object o) {
		return words.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return words.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return words.isEmpty();
	}

	@Override
	public Iterator<String> iterator() {
		return words.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return words.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return words.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return words.retainAll(c);
	}

	@Override
	public int size() {
		return words.size();
	}

	@Override
	public Object[] toArray() {
		return words.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return words.toArray(a);
	}

}

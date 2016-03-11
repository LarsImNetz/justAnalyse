package org.linuxx.moonserver.lambda;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestDefaultMethodsAufListe {

	@Test
	public void test() {
		final List<String> liste = new ArrayList<>();
		liste.add("abc");
		liste.add("");
		liste.add("  def  ");
		liste.add(null);
		liste.add("ghi");
		liste.add("  ");
		liste.add("xyz");
		liste.removeIf(s -> s == null);
		liste.replaceAll(String::trim);
		liste.removeIf(String::isEmpty);
		liste.forEach(System.out::println);
	}

}

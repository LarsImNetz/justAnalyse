package org.lla.phrasendrescher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WortListe {

	private final List<String> liste;
	private int pointer;

	public WortListe(final String liste) {
		final ArrayList<String> singles = new ArrayList<>();
		final String[] split = liste.split(" ");
		for (int i = 0; i < split.length; i++) {
			singles.add(split[i]);
		}
		this.liste = singles;
	}

	public WortListe(final String liste, final String liste2) {
		final ArrayList<String> list1 = new ArrayList<>();
		Collections.addAll(list1, liste.split(" "));

		final ArrayList<String> list2 = new ArrayList<>();
		Collections.addAll(list2, liste2.split(" "));

		final ArrayList<String> zusammen = new ArrayList<>();
		for (final String wort : list1) {
			for (final String wort2 : list2) {
				zusammen.add(wort + wort2);
			}
		}
		this.liste = zusammen;
	}

	public String getWort() {
		final String wort = " " + liste.get(pointer);
		pointer++;
		if (pointer >= liste.size()) {
			pointer = 0;
		}
		return wort;
	}
}

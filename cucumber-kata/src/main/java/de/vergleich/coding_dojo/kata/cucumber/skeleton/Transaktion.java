package de.vergleich.coding_dojo.kata.cucumber.skeleton;

import org.joda.time.DateTime;

public class Transaktion {

	private final int wert;
	private final DateTime date;

	public Transaktion(int wert) {
		this.wert = wert;
		date = DateTime.now();
	}

	public int getWert() {
		return wert;
	}

	public DateTime getDatum() {
		return date;
	}
}

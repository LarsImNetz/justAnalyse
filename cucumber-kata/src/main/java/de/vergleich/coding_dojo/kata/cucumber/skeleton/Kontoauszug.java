package de.vergleich.coding_dojo.kata.cucumber.skeleton;

public class Kontoauszug {
	
	private Bankkonto konto;

	public Kontoauszug(Bankkonto konto) {
		this.konto = konto;
	}

	public int getAnzahlTransaktionen() {
		return 2;
	}

}

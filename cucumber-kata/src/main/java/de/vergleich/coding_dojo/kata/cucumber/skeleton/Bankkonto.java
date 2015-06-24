package de.vergleich.coding_dojo.kata.cucumber.skeleton;

import java.util.ArrayList;
import java.util.List;

public class Bankkonto {
	
	private List<Transaktion> transaktionsListe;
	private int deposit;
	
	public Bankkonto() {
		this.deposit = 0;
		transaktionsListe = new ArrayList<Transaktion>();
	}

	public void deposit(int betrag) {
		deposit += betrag;
		Transaktion transaktion = new Transaktion(betrag);
		transaktionsListe.add(transaktion);
	}
	
	public int getDeposit() {
		return deposit;
	}

	public void withdraw(int betrag) {
		deposit -= betrag;
		Transaktion transaktion = new Transaktion(-betrag);
		transaktionsListe.add(transaktion);
	}

	public Kontoauszug getKontoauszug() {
		// TODO Auto-generated method stub
		return new Kontoauszug(this);
	}

}

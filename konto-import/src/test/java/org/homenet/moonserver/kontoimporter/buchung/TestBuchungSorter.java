package org.homenet.moonserver.kontoimporter.buchung;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class TestBuchungSorter {

	private final BuchungSorter sorter = new BuchungSorter();
	
	// Verwendungszweck unterscheidet sich
	@Test
	public void testVerwendungszweck_ungleich() throws Exception {
		final String[] buchung1 = {"1.1.2000", "1.1.2000", "verwendungszweck", "", "1", "EUR"};
		final IBuchung buchungOne = new CSVBuchung(buchung1);

		final String[] buchung2 = {"1.1.2000", "1.1.2000", "verwendungszweck 2", "", "1", "EUR"};
		final IBuchung buchungTwo = new CSVBuchung(buchung2);

		final Set<IBuchung> buchungenSet = new HashSet<>();
		buchungenSet.add(buchungOne);
		buchungenSet.add(buchungTwo);

		Assert.assertEquals(2,  buchungenSet.size());

		final Set<IBuchung> sortedSet = sorter.getSortedSet(buchungenSet);
		final Iterator<IBuchung> iterator = sortedSet.iterator();
		Assert.assertEquals(buchungOne,  iterator.next());
		Assert.assertEquals(buchungTwo,  iterator.next());
	}

	// Buchungsdatum und Verwendungszweck sind gleich, Haben ist unterschiedlich.
	// sollte in der Natur nicht auftreten, aber zum testen/sortieren praktisch, wir erwarten einen Eintrag im sortiertem Ergebnis
	@Test
	public void testGetSortedSet_All_important_the_same() throws Exception {
		final String[] buchung1 = {"1.1.2000", "1.1.2000", "verwendungszweck", "", "1", "EUR"};
		final IBuchung buchungOne = new CSVBuchung(buchung1);

		final String[] buchung2 = {"1.1.2000", "1.1.2000", "verwendungszweck", "", "2", "EUR"};
		final IBuchung buchungTwo = new CSVBuchung(buchung2);

		final Set<IBuchung> buchungenSet = new HashSet<>();
		buchungenSet.add(buchungOne);
		buchungenSet.add(buchungTwo);

		Assert.assertEquals(2,  buchungenSet.size());
		
		// wir berücksitigen beim sortieren nur das Buchungsdatum und den Verwendungszweck
		final Set<IBuchung> sortedSet = sorter.getSortedSet(buchungenSet);
		Assert.assertEquals(1,  sortedSet.size());
	}

	// Buchungsdatum unterschiedlich, wir erwarten eine gewisse Reihenfolge
	@Test
	public void testGetSortedSet_Datum_differ() throws Exception {
		final String[] buchung1 = {"2.1.2000", "1.1.2000", "verwendungszweck", "", "1", "EUR"};
		final IBuchung buchungOne = new CSVBuchung(buchung1);

		final String[] buchung2 = {"1.1.2000", "1.1.2000", "verwendungszweck", "", "2", "EUR"};
		final IBuchung buchungTwo = new CSVBuchung(buchung2);

		final Set<IBuchung> buchungenSet = new HashSet<>();
		buchungenSet.add(buchungOne);
		buchungenSet.add(buchungTwo);

		Assert.assertEquals(2,  buchungenSet.size());
		
		final Set<IBuchung> sortedSet = sorter.getSortedSet(buchungenSet);
		final Iterator<IBuchung> iterator = sortedSet.iterator();
		Assert.assertEquals(buchungTwo,  iterator.next());
		Assert.assertEquals(buchungOne,  iterator.next());
	}

}

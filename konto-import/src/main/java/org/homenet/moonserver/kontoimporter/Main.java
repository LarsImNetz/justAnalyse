package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;

import com.google.common.base.Preconditions;

public class Main {

	protected Main() {
	}

	public static void main(final String[] args) {
		final Main main = new Main();
		main.importing();
	}

	public void importing() {
		final String baseFolder = System.getProperty("user.home") + "/download/konto";
		final File baseFolderFile = new File(baseFolder);
		Preconditions.checkState(baseFolderFile.exists(), "Base folder (" + baseFolder + ") not found.");

		final CSVDirectoryReader reader = new CSVDirectoryReader(baseFolderFile, new DBCSVFilenameFilter());
		final Collection<Object[]> csvFiles = reader.findAllCSVFiles();

		final Iterator<Object[]> iterator = csvFiles.iterator();

		final Set<IBuchung> buchungenSet = new HashSet<>();

		while (iterator.hasNext()) {
			final Object[] csvFileObject = iterator.next();
			final File csvFile = (File) csvFileObject[0];

			final CSVKontoInterpreter interpreter = new CSVKontoInterpreter(csvFile);
			final List<IBuchung> buchungen = interpreter.interpret();
			// TODO: alle Buchungen in einer Liste halten
			// TODO: für alle Buchungen Zugriffe per Datum erlauben
			buchungenSet.addAll(buchungen);
		}
		
		// sortiert ausgeben
		final Set<IBuchung> sortedSet = getSortedSet(buchungenSet);
		
		for(final IBuchung buchung : sortedSet) {
			// nur Buchungen ausgeben, die im Dezember 2015 getätigt wurden
			if (amGebucht(buchung, 2015, 12)) {
				if (einkaufen(buchung)) {
					System.out.println(buchung.toString());
				}
			}
		}
	}

	private boolean amGebucht(final IBuchung buchung, final int year, final int month) {
		return buchung.getBuchungsdatum().getYear() == year && buchung.getBuchungsdatum().getMonthOfYear() == month;
	}

	public boolean einkaufen(final IBuchung buchung) {
		// TODO: mit einem Pattern drüber gucken, was getan wurde...
		final String verwendungszweck = buchung.getVerwendungszweck();
		final String classToCheck = "(.* )?ALDI( .*)?";

		final Pattern pattern = Pattern.compile(classToCheck);
		final Matcher matcher = pattern.matcher(verwendungszweck);

		// Assert.assertTrue(matcher.matches());
		return true;
	}

	public static Set<IBuchung> getSortedSet(final Set<IBuchung> unsortedSet) {
		final SortedSet<IBuchung> set = new TreeSet<IBuchung>();

		for (final IBuchung buchung : unsortedSet) {
			set.add(buchung);
		}

		return set;
	}

}

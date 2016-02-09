package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.joda.time.DateTime;

import com.google.common.base.Preconditions;

public class Main {

	public Main() {
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

		Set<IBuchung> buchungenSet = new HashSet<>();

		while (iterator.hasNext()) {
			final Object[] csvFileObject = iterator.next();
			final File csvFile = (File) csvFileObject[0];

			final CSVKontoInterpreter interpreter = new CSVKontoInterpreter(csvFile);
			final List<IBuchung> buchungen = interpreter.interpret();
			// TODO: alle Buchungen in einer Liste halten
			// TODO: für alle Buchungen Zugriffe per Datum erlauben
			buchungenSet.addAll(buchungen);
		}
		Set<IBuchung> sortedSet = getSortedSet(buchungenSet);
		
		for(IBuchung buchung : sortedSet) {
			System.out.println(buchung.toString());
		}
	}

	public static Set<IBuchung> getSortedSet(Set<IBuchung> unsortedSet) {
		SortedSet<IBuchung> set = new TreeSet<IBuchung>();

		for (IBuchung buchung : unsortedSet) {
			set.add(buchung);
		}

		return set;
	}

}

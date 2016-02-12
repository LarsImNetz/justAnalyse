package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.homenet.moonserver.kontoimporter.buchung.BuchungSorter;
import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.homenet.moonserver.kontoimporter.classification.BuchungClassification;
import org.homenet.moonserver.kontoimporter.classification.Classification;
import org.homenet.moonserver.kontoimporter.classification.ClassificationEnum;
import org.homenet.moonserver.kontoimporter.classification.IBuchungClassification;

import com.google.common.base.Preconditions;

public class Main {

	protected Main() {
	}

	public static void main(final String[] args) {
		final Main main = new Main();
		main.importing();
	}

	private final BuchungSorter sorter = new BuchungSorter();
	private final Classification classification = new Classification();

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
			buchungenSet.addAll(buchungen);
		}

		// klassifizierung
		Set<IBuchungClassification> classifiedBuchungen = classification.classify(buchungenSet);

		// sortiert ausgeben
		final Set<IBuchung> sortedSet = sorter.getSortedSet(classifiedBuchungen);

		double soll = 0;
		double haben = 0;
		for (final IBuchung buchung : sortedSet) {
			// nur Buchungen ausgeben, die im Oktober 2015 getätigt wurden
			// if (amGebucht(buchung, 2015, 10) || amGebucht(buchung, 2015, 11)) {
				if (amGebucht(buchung, 2015)) {
				if (buchung instanceof IBuchungClassification) {
					IBuchungClassification classification = (IBuchungClassification) buchung;
					if (classification.getClassification() == ClassificationEnum.UNKNOWN) {
						System.out.println(buchung.toString());
						soll += buchung.getSoll();
						haben += buchung.getHaben();
					}
				}
			}
		}
		System.out.println("Haben: " + haben);
		System.out.println(" Soll: " + soll);
	}

	private boolean amGebucht(final IBuchung buchung, final int year, final int month) {
		return buchung.getBuchungsdatum().getYear() == year && buchung.getBuchungsdatum().getMonthOfYear() == month;
	}
	private boolean amGebucht(final IBuchung buchung, final int year) {
		return buchung.getBuchungsdatum().getYear() == year;
	}

}

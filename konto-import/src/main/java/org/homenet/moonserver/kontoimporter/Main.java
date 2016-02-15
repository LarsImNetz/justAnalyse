package org.homenet.moonserver.kontoimporter;

import java.io.File;
import java.io.FilenameFilter;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.homenet.moonserver.kontoimporter.buchung.BuchungSorter;
import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.homenet.moonserver.kontoimporter.classification.AnjaClassification;
import org.homenet.moonserver.kontoimporter.classification.Classification;
import org.homenet.moonserver.kontoimporter.classification.ClassificationEnum;
import org.homenet.moonserver.kontoimporter.classification.IBuchungClassification;

import com.google.common.base.Preconditions;

public class Main {

	private static final FilenameFilter CSV_FILENAME_FILTER = new AnjaDeutscheBankCSVFilenameFilter();
	private final Classification classification =  new Classification(new AnjaClassification());

	protected Main() {
	}

	public static void main(final String[] args) {
		final Main main = new Main();
		main.importing();
	}

	private final BuchungSorter sorter = new BuchungSorter();

	public void importing() {
		final String baseFolder = System.getProperty("user.home") + "/download/konto";
		final File baseFolderFile = new File(baseFolder);
		Preconditions.checkState(baseFolderFile.exists(), "Base folder (" + baseFolder + ") not found.");

		final CSVDirectoryReader reader = new CSVDirectoryReader(baseFolderFile, CSV_FILENAME_FILTER);
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
		final Set<IBuchungClassification> classifiedBuchungen = classification.classifyAll(buchungenSet);

		// sortiert ausgeben
		final Set<IBuchung> sortedSet = sorter.getSortedSet(classifiedBuchungen);

		double gesamtSoll = 0;
		double gesamtHaben = 0;
		for (final ClassificationEnum classification : ClassificationEnum.values()) {
			final SollHaben sollHaben = showAusgaben(sortedSet, classification);

			System.out.println();
			System.out.println("Classification: " + classification.name());
			System.out.println("Haben: " + outputBetrag(sollHaben.haben));
			System.out.println(" Soll: " + outputBetrag(sollHaben.soll));

			gesamtHaben += sollHaben.haben;
			gesamtSoll += sollHaben.soll;
		}

		System.out.println();
		System.out.println("Haben: " + outputBetrag(gesamtHaben));
		System.out.println(" Soll: " + outputBetrag(gesamtSoll));
	}

	private static class SollHaben {

		public final double soll;
		public final double haben;

		public SollHaben(final double soll, final double haben) {
			this.soll = soll;
			this.haben = haben;
		}
	}

	private SollHaben showAusgaben(final Set<IBuchung> sortedSet, final ClassificationEnum classification4Interest) {
		double soll = 0;
		double haben = 0;
		for (final IBuchung buchung : sortedSet) {
			// nur Buchungen ausgeben, die im Oktober 2015 getätigt wurden
			// if (amGebucht(buchung, 2015, 10) || amGebucht(buchung, 2015, 11)) {
			if (amGebucht(buchung, 2015)) {
				if (buchung instanceof IBuchungClassification) {
					final IBuchungClassification classification = (IBuchungClassification) buchung;
					if (classification.getClassification() == classification4Interest) {
						// if (classification.getClassification() == ClassificationEnum.UNKNOWN) {
							System.out.println(buchung.toString());
						// }
						soll += buchung.getSoll();
						haben += buchung.getHaben();
					}
				}
			}
		}
		return new SollHaben(soll, haben);
	}

	private String outputBetrag(final double betrag) {
		final NumberFormat instance = NumberFormat.getInstance(Locale.GERMAN);
		instance.setMaximumFractionDigits(2);
		final String format = instance.format(betrag);
		return format;
	}

	private boolean amGebucht(final IBuchung buchung, final int year, final int month) {
		return buchung.getBuchungsdatum().getYear() == year && buchung.getBuchungsdatum().getMonthOfYear() == month;
	}

	private boolean amGebucht(final IBuchung buchung, final int year) {
		return buchung.getBuchungsdatum().getYear() == year;
	}

}

package org.homenet.moonserver.kontoimporter.classification;

import java.util.HashSet;
import java.util.Set;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;

public class Classification {

	public Set<BuchungClassification> classify(final Set<IBuchung> buchungen) {
		final Set<BuchungClassification> classifications = new HashSet<>();
		for (final IBuchung buchung : buchungen) {
			final ClassificationEnum classification = classify(buchung);
			final BuchungClassification classified = new BuchungClassification(buchung, classification);
			classifications.add(classified);
		}
		return classifications;
	}

	private ClassificationEnum classification;

	public ClassificationEnum classify(final IBuchung buchung) {
		final String verwendungszweck = buchung.getVerwendungszweck();
		geldautomat(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		kosmetik(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		einkaufen(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		return ClassificationEnum.UNKNOWN;
	}

	// TODO Klassifizierung!
	public void geldautomat(final String verwendungszweck) {

		if (verwendungszweck.contains("GA NR") || verwendungszweck.contains("COMMERZBANK")) {
			classification = ClassificationEnum.GELDAUTOMAT;
		}
	}

	public void kosmetik(final String verwendungszweck) {

		if (verwendungszweck.contains("ROSSMANN") || verwendungszweck.contains("DOUGLAS") || verwendungszweck.contains("PARFUEMERIE SCHUBAC")) {
			classification = ClassificationEnum.KOSMETIC;
		}
	}

	public void einkaufen(final String verwendungszweck) {
		// TODO: mit einem Pattern drüber gucken, was getan wurde...

		if (verwendungszweck.contains("ALDI") || verwendungszweck.contains("SKY MARKT") || verwendungszweck.contains("BOFROST")) {
			classification = ClassificationEnum.EINKAUFEN;
		}
	}

}

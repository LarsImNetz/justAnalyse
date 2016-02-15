package org.homenet.moonserver.kontoimporter.classification;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;

public class LarsClassification implements IClassification {

	private ClassificationEnum classification;

	@Override
	public ClassificationEnum classify(final IBuchung buchung) {
		classification = ClassificationEnum.UNKNOWN;
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
		gehalt(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		telefon(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		dauerauftrag(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		baumarkt(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		spielzeug(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		buecher(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		klamotten(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		amazon(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		sport(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		return ClassificationEnum.UNKNOWN;
	}

	// TODO Klassifizierung!
	private void geldautomat(final String verwendungszweck) {

		if (verwendungszweck.contains("GA NR") || verwendungszweck.contains("COMMERZBANK")) {
			classification = ClassificationEnum.GELDAUTOMAT;
		}
	}

	private void gehalt(final String verwendungszweck) {

		if (verwendungszweck.contains("Lohn/Gehalt")) {
			classification = ClassificationEnum.GEHALT;
		}
	}

	private void amazon(final String verwendungszweck) {

		if (verwendungszweck.contains("Amazon")) {
			classification = ClassificationEnum.AMAZON;
		}
	}

	private void buecher(final String verwendungszweck) {

		if (verwendungszweck.contains("HUGENDUBEL") || verwendungszweck.contains("HUENICKE H.GMBH")) {
			classification = ClassificationEnum.BUECHER;
		}
	}

	private void dauerauftrag(final String verwendungszweck) {

		if (verwendungszweck.contains("Dauerauftrag")) {
			classification = ClassificationEnum.DAUERAUFTRAG;
		}
	}

	private void telefon(final String verwendungszweck) {

		if (verwendungszweck.contains("TCHIBO") || verwendungszweck.contains("TELEKOM")) {
			classification = ClassificationEnum.TELEFON;
		}
	}

	private void baumarkt(final String verwendungszweck) {

		if (verwendungszweck.contains("OBI") || verwendungszweck.contains("BAUHAUS")) {
			classification = ClassificationEnum.BAUMARKT;
		}
	}

	private void kosmetik(final String verwendungszweck) {

		if (verwendungszweck.contains("Rossmann") || verwendungszweck.contains("ROSSMANN") || verwendungszweck.contains("DOUGLAS") || verwendungszweck.contains("PARFUEMERIE SCHUBAC")
				|| verwendungszweck.contains("DER MODE SALON") || verwendungszweck.contains("APOTHEKE")) {
			classification = ClassificationEnum.KOSMETIK;
		}
	}

	private void klamotten(final String verwendungszweck) {

		if (verwendungszweck.contains("MANCHESTER-GROSSE") || verwendungszweck.contains("KARSTADT") || verwendungszweck.contains("DEICHMANN")
				|| verwendungszweck.contains("C&A") || verwendungszweck.contains("GOERTZ") || verwendungszweck.contains("ZERO") || verwendungszweck.contains("ERNSTINGS") || verwendungszweck.contains("P&C")) {
			classification = ClassificationEnum.KLAMOTTEN;
		}
	}

	private void spielzeug(final String verwendungszweck) {

		if (verwendungszweck.contains("MYTOYS") || verwendungszweck.contains("RAPPEL") || verwendungszweck.contains("LEGO")) {
			classification = ClassificationEnum.SPIELZEUG;
		}
	}

	private void sport(final String verwendungszweck) {

		if (verwendungszweck.contains("CARSTENS") || verwendungszweck.contains("URBAN")) {
			classification = ClassificationEnum.SPORT;
		}
	}

	private void einkaufen(final String verwendungszweck) {
		// TODO: mit einem Pattern drüber gucken, was getan wurde...

		if (verwendungszweck.contains("ALDI") || verwendungszweck.contains("FAMILA") || verwendungszweck.contains("SKY MARKT")
				|| verwendungszweck.contains("BOFROST") || verwendungszweck.contains("IHR LIDL")) {
			classification = ClassificationEnum.EINKAUFEN;
		}
	}

}

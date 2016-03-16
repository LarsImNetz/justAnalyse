package org.homenet.moonserver.kontoimporter.classification;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;

public class AnjaClassification implements IClassification {

	private ClassificationEnum classification;

	public ClassificationEnum getClassification() {
		return classification;
	}
	
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
		sport(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		garten(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		versicherungen(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		sparenKinder(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		haus(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		zeitschriften(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		ear(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		schule(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		kindergeld(verwendungszweck);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		return ClassificationEnum.UNKNOWN;
	}

	// TODO Klassifizierung!
	private void geldautomat(final String verwendungszweck) {
		final String[] all = {"GA NR"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.GELDAUTOMAT;
		}
	}

	private boolean checkStrings(final String verwendungszweck, final String[] all) {
		for (final String one : all) {
			if (verwendungszweck.contains(one)) {
				return true;
			}
		}
		return false;
	}
	private void gehalt(final String verwendungszweck) {
		final String[] all = {"GEHALT"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.GEHALT;
		}
	}

	private void kindergeld(final String verwendungszweck) {
		final String[] all = {"Bundesagentur füer Arbeit - Familienkasse KG"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.GEHALT;
		}
	}

	private void buecher(final String verwendungszweck) {
		final String[] all = {"HUENECKE GMBH", "HUENICKE", "HUGENDUBEL", "hugendubel.de", "buecher.de"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.BUECHER;
		}
	}

	private void dauerauftrag(final String verwendungszweck) {

		if (verwendungszweck.contains("Dauerauftrag")) {
			classification = ClassificationEnum.DAUERAUFTRAG;
		}
	}

	
	private void telefon(final String verwendungszweck) {
		
		if (verwendungszweck.contains("Telekom Deutschland")) {
			classification = ClassificationEnum.TELEFON;
		}
	}

	private void herrentunnel(final String verwendungszweck) {
		
		if (verwendungszweck.contains("Herrentunnel Luebeck")) {
			classification = ClassificationEnum.HERRENTUNNEL;
		}
	}

	private void kosmetik(final String verwendungszweck) {
		final String[] all = {"Rossmann", "ROSSMANN", "DOUGLAS", "DER MODE SALON", "APOTHEKE", "PARFUEMERIE SCHUBAC", "DM FIL"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.KOSMETIK;
		}
	}

	private void klamotten(final String verwendungszweck) {
		
		final String[] all = {"MANCHESTER-GROSSE", "S.OLIVER", "KARSTADT", "DEICHMANN",
				"GOERTZ", "ZERO", "zero Fil.", "ERNSTINGS", "P&C", "C&A", "SCHUHBODE", "CB MODE", "GERRY WEBER", "TORKUHL GMBH"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.KLAMOTTEN;
		}		
	}

	private void spielzeug(final String verwendungszweck) {

		if (verwendungszweck.contains("MYTOYS") || verwendungszweck.contains("RAPPEL") || verwendungszweck.contains("LEGO")) {
			classification = ClassificationEnum.SPIELZEUG;
		}
	}

	private void sport(final String verwendungszweck) {
		final String[] all = {"TuS Luebeck" /*, "Mitgliedsbeitrag"*/};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.SPORT;
		}
	}

	private void haus(final String verwendungszweck) {
		final String[] all = {"Baufinanzierung", "Grundsteuer", "Schildfarneck 10a Abschlag", "Schildfarneck 10a", "04 SPAR", "05 ZINS", "05 SPAR"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.HAUS;
		}
	}

	private void ear(final String verwendungszweck) {
		final String[] all = {"EAR", "EaR"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.EAR;
		}
	}

	private void zeitschriften(final String verwendungszweck) {
		final String[] all = {"STERN", "TV Movie", "LNL", "ct Gesamtbetrag", "TIERFREUND", "Lisa Kochen Backen", "Rundfunk"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.ZEITSCHRIFTEN;
		}
	}

	private void versicherungen(final String verwendungszweck) {
		final String[] all = {"MULTIPLUS", "VERS-NR: 01AV", "VERS-NR: 01FL", "VERS-NR: 01LV", "KV22305", "LV 1711", "Sterbekasse Deutsche Bank", "Vita34"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.VERSICHERUNG;
		}
	}

	private void sparenKinder(final String verwendungszweck) {
		final String[] all = {"DWS Verm."};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.SPARENKINDER;
		}
	}

	private void schule(final String verwendungszweck) {
		final String[] all = {"5502"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.BETREUUNG;
		}
	}

	private void amazon(final String verwendungszweck) {
	}

	private void garten(final String verwendungszweck) {
		final String[] all = {"OBI", "FLORA", "AESCHLIMANN", "BLUMENHAUS PIEL", "IKEA"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.BAUMARKT;
		}
	}

	private void einkaufen(final String verwendungszweck) {
		final String[] all = {"ARKO FRANCHISE", "ALDI", "FAMILA", "SKY MARKT", "BOFROST", "IHR LIDL", "MA-ANTEIL"};
		if (checkStrings(verwendungszweck, all)) {
			classification = ClassificationEnum.EINKAUFEN;
		}
		// TODO: mit einem Pattern drüber gucken, was getan wurde...
	}

}
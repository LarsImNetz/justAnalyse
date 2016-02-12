package org.homenet.moonserver.kontoimporter.classification;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;
import org.joda.time.DateTime;

public class BuchungClassification implements IBuchung {

	private final IBuchung buchung;
	private final ClassificationEnum classification;

	public BuchungClassification(final IBuchung buchung, final ClassificationEnum classification) {
		this.buchung = buchung;
		this.classification = classification;
	}

	public ClassificationEnum getClassification() {
		return classification;
	}

	@Override
	public Double getSoll() {
		return buchung.getSoll();
	}

	@Override
	public Double getHaben() {
		return buchung.getHaben();
	}

	@Override
	public DateTime getBuchungsdatum() {
		return buchung.getBuchungsdatum();
	}

	@Override
	public String getVerwendungszweck() {
		return buchung.getVerwendungszweck();
	}

	@Override
	public int compareTo(final IBuchung other) {
		return buchung.compareTo(other);
	}
}

package org.homenet.moonserver.kontoimporter.classification;

import java.util.HashSet;
import java.util.Set;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;

public class Classification {

	private final IClassification userClassification;
	
	public Classification(final IClassification userClassification) {
		this.userClassification = userClassification;
	}
	
	public Set<IBuchungClassification> classifyAll(final Set<IBuchung> buchungen) {
		final Set<IBuchungClassification> classifications = new HashSet<>();
		for (final IBuchung buchung : buchungen) {
			final ClassificationEnum classification = classify(buchung);
			final BuchungClassification classified = new BuchungClassification(buchung, classification);
			classifications.add(classified);
		}
		return classifications;
	}

	public ClassificationEnum classify(final IBuchung buchung) {
		ClassificationEnum classification = userClassification.classify(buchung);
		if (classification != ClassificationEnum.UNKNOWN) {
			return classification;
		}
		return ClassificationEnum.UNKNOWN;
	}

}

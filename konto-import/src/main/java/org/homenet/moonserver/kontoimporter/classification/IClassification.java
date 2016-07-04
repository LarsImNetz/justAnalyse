package org.homenet.moonserver.kontoimporter.classification;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;

public interface IClassification {

	ClassificationEnum classify(final IBuchung buchung);
}

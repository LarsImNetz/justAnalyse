package org.homenet.moonserver.kontoimporter.classification;

import org.homenet.moonserver.kontoimporter.buchung.IBuchung;

public interface IBuchungClassification extends IBuchung {

	ClassificationEnum getClassification();
}

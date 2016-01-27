package org.homenet.moonserver.kontoimporter.buchung;

import org.joda.time.DateTime;

public interface Buchung {
	Double getSoll();
	Double getHaben();
	DateTime getBuchungsdatum();
	String getVerwendungszweck();
}
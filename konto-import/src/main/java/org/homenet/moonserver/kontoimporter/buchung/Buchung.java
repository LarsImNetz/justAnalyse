package org.homenet.moonserver.kontoimporter.buchung;

import org.joda.time.DateTime;

public interface Buchung {
	double getSoll();
	double getHaben();
	DateTime getBuchungsdatum();
	String getVerwendungszweck();
}
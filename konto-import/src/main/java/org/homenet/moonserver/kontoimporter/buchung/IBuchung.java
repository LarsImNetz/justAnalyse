package org.homenet.moonserver.kontoimporter.buchung;

import org.joda.time.DateTime;

public interface IBuchung {
	Double getSoll();
	Double getHaben();
	DateTime getBuchungsdatum();
	String getVerwendungszweck();
}
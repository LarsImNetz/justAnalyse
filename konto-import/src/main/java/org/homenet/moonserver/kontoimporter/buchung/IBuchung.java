package org.homenet.moonserver.kontoimporter.buchung;

import org.joda.time.DateTime;

public interface IBuchung extends Comparable<IBuchung> {

	Double getSoll();

	Double getHaben();

	DateTime getBuchungsdatum();

	String getVerwendungszweck();
	
	public int compareTo(IBuchung other);
	
	String toString();
}

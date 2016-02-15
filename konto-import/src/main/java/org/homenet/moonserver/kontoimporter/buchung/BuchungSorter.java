package org.homenet.moonserver.kontoimporter.buchung;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class BuchungSorter {

	public Set<IBuchung> getSortedSet(final Set<? extends IBuchung> unsortedSet) {
		final SortedSet<IBuchung> set = new TreeSet<IBuchung>();

		for (final IBuchung buchung : unsortedSet) {
			set.add(buchung);
		}

		return set;
	}

}

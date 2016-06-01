package org.homelinux.moonserver;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITestSimpleDTOMultiple {

	private static ObjectMapperHelper OBJECTMAPPER;

	@BeforeClass
	public static void setUp() {
		OBJECTMAPPER = new ObjectMapperHelper();
	}

	@Test
	public void testClassSimpleSerializeMultiple() {
		final SimpleDTO s = new SimpleDTO();
		s.setVorname("Lars");
		s.setNachname("Langhans");
		final LocalDate geburtstag = LocalDate.of(1968, Month.JANUARY, 4);
		s.setGeburtstag(geburtstag);
		s.setStrasse("Eine Strasse");
		s.setHausnummer("1");
		int plz = 10001;
		s.setPlz(plz);
		s.setOrt("Ein Ort");

		long start = System.currentTimeMillis();
		for (plz = 1; plz <= 100000; plz++) {
			s.setPlz(plz);
			final String json = OBJECTMAPPER.createJsonString(s);
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("Serialize Time: " + end + "ms");
	}

	@Test
	public void testClassSimpleDeserializeMultiple() {

		long start = System.currentTimeMillis();
		for (int plz = 1; plz <= 100000; plz++) {
			final StringBuilder builder = new StringBuilder().append(
					"{\"vorname\":\"Lars\",\"nachname\":\"Langhans\",\"geburtstag\":\"04.01.1968\",\"strasse\":\"Eine Strasse\",\"hausnummer\":\"1\",\"plz\":").append(
							plz).append(",\"ort\":\"Ein Ort\"}");

			final Object obj = OBJECTMAPPER.createObject(builder.toString(), SimpleDTO.class);
			Assert.assertNotNull(obj);
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("Deserialize Time: " + end + "ms");
	}

}

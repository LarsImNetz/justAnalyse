package org.homelinux.moonserver;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestJsonDeserialisation {

	private static ObjectMapperHelper OBJECTMAPPER;

	@BeforeClass
	public static void setUp() {
		OBJECTMAPPER = new ObjectMapperHelper();
	}

	@Test
	public void testClassBDeserialize() {
		final String json = "{\"vorname\":\"Lars\",\"nachname\":\"Langhans\",\"geburtstag\":\"04.01.1968\"}";

		final Object obj = OBJECTMAPPER.createObject(json, SimpleDTO.class);
		Assert.assertNotNull(obj);

		final SimpleDTO b = (SimpleDTO) obj;
		
		Assert.assertEquals(1968,  b.getGeburtstag().getYear());
		Assert.assertEquals(1,  b.getGeburtstag().getMonthValue());
		Assert.assertEquals(4,  b.getGeburtstag().getDayOfMonth());
		
		Assert.assertEquals("Lars", b.getVorname());
		Assert.assertEquals("Langhans", b.getNachname());
	}
}

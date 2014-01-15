package de.hypoport.einarbeitung.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestJustBean {

	private JustBean bean;

	@Before
	public void before() {
		bean = new JustBean();

	}
	@Test
	public void testNotNull() {
		Assert.assertNotNull(bean);
	}

	@Test
	public void testName() throws Exception {
		bean.setName("Langhans");
		bean.setVorname("Lars");

		bean.setTelefonnummer("451 625592");
	}
}

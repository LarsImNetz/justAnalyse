package de.vergleich.sample.adapter;


import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.junit.Assert;
import org.junit.Test;

import de.vergleich.sample.bean.Bean;

public class TestBeanAdapter {

	@Test
	public void testParametersToBean_WithEmptyParams() {
		PageParameters params = new PageParameters();
		Bean bean = new BeanAdapter().adapt(params);
		Assert.assertNotNull(bean);
	}

	@Test
	public void testParametersToBean_WithFilledParams() {
		PageParameters params = new PageParameters();
		params.add("name", "egal");
		params.add("darlehensbetrag", "123");
		//TODO lla: das geht nicht! params.add("immobilienwert", new Double(123d));

		Bean bean = new BeanAdapter().adapt(params);
		Assert.assertNotNull(bean);

		Assert.assertEquals("egal", bean.getName());
		Assert.assertEquals("123.0", bean.getDarlehensbetrag().toString());
		// siehe oben: Assert.assertEquals("123.0", bean.getImmobilienwert().toString());
	}

	@Test
	public void testBeanToPageParameters() {
		Bean bean = new Bean();
		bean.setName("egal");
		bean.setDarlehensbetrag(123d);
		bean.setImmobilienwert(123d);
		bean.setMonatlicheRate(123d);
		PageParameters params = new BeanAdapter().adapt(bean);

		Assert.assertNotNull(params);
		Assert.assertEquals("egal", params.get("name").toString());
		String darlehensbetragAsString = params.get("darlehensbetrag").toString();
		Assert.assertEquals("123,00", darlehensbetragAsString);

		double darlehensbetrag = params.get("darlehensbetrag").toDouble();
		Assert.assertEquals(123d, darlehensbetrag, 0.01);
	}
}

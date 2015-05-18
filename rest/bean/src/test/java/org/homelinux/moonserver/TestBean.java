package org.homelinux.moonserver;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.homelinux.moonserver.bean.Bean;
import org.junit.Assert;
import org.junit.Test;

public class TestBean {

	@Test
	public void testSerializeBaugeldAntrag() {
		Bean bean = new Bean();
		bean.setA("Aber ein A");

		final Serializable original = bean;
		final Serializable copy = SerializationUtils.clone(original);

		Assert.assertEquals(original, copy);

		Bean copyOfBean = (Bean) copy;
		Assert.assertEquals("Aber ein A", copyOfBean.getA());
	}
}

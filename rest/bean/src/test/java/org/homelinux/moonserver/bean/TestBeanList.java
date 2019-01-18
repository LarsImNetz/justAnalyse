package org.homelinux.moonserver.bean;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TestBeanList {

	BeanList beanListSUT;
	
	@Before
	public void setUp() {
		beanListSUT = new BeanList();
		
		beanListSUT.add("eins");
		beanListSUT.add("zwei");
		beanListSUT.add("drei");
	}
	
	@Test
	public void testSize() {
		Assert.assertEquals(3, beanListSUT.size());
	}
	
	@Test
	public void testJsonBean() throws Exception {
		BeanList list = new BeanList();
		list.add("a");
		list.add("b");

		BeanArray array = new BeanArray(list);
		
		final String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(array);
		JSONAssert.assertEquals("{'elements': [ 'a', 'b' ] }", json, false);
	}

}

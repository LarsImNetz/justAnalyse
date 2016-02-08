package system.property;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Properties;

import org.junit.Test;

public class TestSystemProperty {

	@Test
	public void test() {
		Properties properties = System.getProperties();
		Enumeration<Object> keys = properties.keys();
		while(keys.hasMoreElements()) {
			Object key = keys.nextElement();
			System.out.println(key.toString() + " := " + System.getProperty(key.toString()) );
		}
	}

}

package org.homenet.moonserver.pattern.builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @see: https://en.wikipedia.org/wiki/Builder_pattern
 *
 */

public class TestBuilderPattern {

	Address addressSUT;

	@Before
	public void setUp() {
		addressSUT = new AddressBuilder().eMail("h@bkei.ne").name("name").build();
	}

	@Test
	public void test() {
		Assert.assertNotNull(addressSUT);
	}

	@Test
	public void testEMail() {
		IEMail eMail = addressSUT;
		Assert.assertEquals("name", eMail.getName());
		Assert.assertEquals("h@bkei.ne", eMail.getEMail());
	}

	@Test
	public void testAddress() {
		IAddress iAddress = addressSUT;
		Assert.assertEquals("name", iAddress.getName());
		Assert.assertEquals("", iAddress.getPlz());
		Assert.assertEquals("", iAddress.getOrt());
		// Assert.assertEquals("h@bkei.ne", iAddress.getEMail());
	}

	private interface IAddress {
		String getName();

		String getPlz();

		String getOrt();
	}

	private interface IEMail {
		String getName();

		String getEMail();
	}

	private static class Address implements IAddress, IEMail {

		private String name;
		private String plz;
		private String ort;
		private String eMail;

		private Address() {
			this.name = "";
			this.plz = "";
			this.ort = "";
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public String getPlz() {
			return plz;
		}

		@Override
		public String getOrt() {
			return ort;
		}

		@Override
		public String getEMail() {
			return eMail;
		}

	}

	interface IAddressBuilder {
		IAddressBuilder name(String name);

		IAddressBuilder plz(String plz);

		IAddressBuilder ort(String ort);

		IAddressBuilder eMail(String eMail);

		Address build();
	}

	private static class AddressBuilder implements IAddressBuilder {
		private final Address address;

		public AddressBuilder() {
			address = new Address();
		}

		public Address build() {
			return address;
		}

		@Override
		public IAddressBuilder name(String name) {
			address.name = name;
			return this;
		}

		@Override
		public IAddressBuilder plz(String plz) {
			address.plz = plz;
			return this;
		}

		@Override
		public IAddressBuilder ort(String ort) {
			address.ort = ort;
			return this;
		}

		@Override
		public IAddressBuilder eMail(String eMail) {
			address.eMail = eMail;
			return this;
		}
	}
}

package org.linuxx.moonserver.db.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.linuxx.moonserver.db.persistence.guice.provider.EntityManagerTestProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ITTestNameDao {
	private static NameDao nameDaoSUT;
	private static AddressDao addressDaoSUT;
	
	private static Injector injector;

	@BeforeClass
	public static void beforeClass() {
		injector = Guice.createInjector(new AddressDaoTestModule());

		EntityManager em = injector.getInstance(EntityManager.class);
		nameDaoSUT = new NameDao(em);
		addressDaoSUT = new AddressDao(em);
	}

	private static class AddressDaoTestModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(EntityManager.class).toProvider(EntityManagerTestProvider.class);
		}
	}
/*
 CREATE TABLE Address (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'name' varchar(50) NOT NULL,
  'ort' varchar(200) NOT NULL 
);

CREATE TABLE Name (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'vorname' varchar(200) NOT NULL,
  'name' varchar(200) NOT NULL,
  'address' varchar(50) NOT NULL,
  PRIMARY KEY ('id'),
  FOREIGN KEY ('address') REFERENCES address('name')
);
*/

	@Before
	public void fillTable() {

		// tipp: versuche es nicht mit '0' als ID, das geht schief
		// http://stackoverflow.com/questions/22026715/jpa-null-or-zero-primary-key-encountered-in-unit-of-work-clone
		// <property name="eclipselink.allow-zero-id" value="true"/>
		nameDaoSUT.deleteAll();
		addressDaoSUT.deleteAll();
		
//		final NameEntity entity2 = new NameEntity();
//		entity2.setId(2);
//		entity2.setName("solo");
//		entity2.setVorname("han");
//		entity2.setGeburtsdatum(new DateTime(2015, 1, 1, 0, 0).toDate());
//		nameDaoSUT.save(entity2);

		insertName(1, "lars", "langhans", "lars", new DateTime(1968, 1, 4, 0, 0).toDate());

		insertAddress("lars", "Tremskamp", 1968);
		insertAddress("lars", "Karavellenstraße", 1969);
		insertAddress("lars", "Klipperstraße", 1970);
		insertAddress("lars", "Narzissenweg", 1975);
		insertAddress("lars", "Ewerstraße", 1977);
		insertAddress("lars", "Ziegelstraße", 1984);
		insertAddress("lars", "Korvettenstraße", 1986);
		insertAddress("lars", "Loignystraße", 1992);
		insertAddress("lars", "Schildfarneck", 1999);
	}

	private static void insertName(Integer id, String vorname, String name, String addressLink, Date date) {
		final NameEntity entity = new NameEntity();
		entity.setId(id);
		entity.setName(name);
		entity.setVorname(vorname);
		entity.setAddress(addressLink);
		entity.setGeburtsdatum(date);
		nameDaoSUT.save(entity);
	}

	private static void insertAddress(String name, String ort, int jahr) {
		final AddressEntity address = new AddressEntity();
		address.setName(name);
		address.setOrt(ort);
		address.setSeitJahr(jahr);
		addressDaoSUT.save(address);
	}
	
	@After
	public void clearTable() {
		addressDaoSUT.deleteAll();
		nameDaoSUT.deleteAll();
	}

	@Test
	public void testFetchAddress() {
		List<AddressEntity> names = addressDaoSUT.fetch("lars");
		Assert.assertTrue(names.size() > 1);		
	}
	
	@Test
	public void testFetchName() {
		final NameEntity name = nameDaoSUT.fetch(1);
		Assert.assertEquals("langhans", name.getName());
		Assert.assertEquals("lars", name.getVorname());
	}
	
	@Test
	public void testFetch() {
		final NameEntity name = nameDaoSUT.fetch(1);
		Assert.assertEquals("langhans", name.getName());
		Assert.assertEquals("lars", name.getVorname());

//		List<AddressEntity> names = name.getAddressList();
//		Assert.assertTrue(names.size() > 1);
	}
}

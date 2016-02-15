package org.linuxx.moonserver.db.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.linuxx.moonserver.db.persistence.guice.provider.EntityManagerTestProvider;
import org.linuxx.moonserver.db.persistence.update.ITry2Dao;
import org.linuxx.moonserver.db.persistence.update.Try2Dao;
import org.linuxx.moonserver.db.persistence.update.Try2Entity;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestTryDao {

	private static TryDao dao;
	private static Try2Dao dao2;

	private static Injector injector;

	@BeforeClass
	public static void beforeClass() {
		injector = Guice.createInjector(new TryDaoTestModule());

		dao = new TryDao();
		injector.injectMembers(dao);

		dao2 = injector.getInstance(Try2Dao.class);
	}

	@Before
	public void fillTable() {

		// tipp: versuche es nicht mit '0' als ID, das geht schief
		// http://stackoverflow.com/questions/22026715/jpa-null-or-zero-primary-key-encountered-in-unit-of-work-clone
		// <property name="eclipselink.allow-zero-id" value="true"/>
		dao.deleteAll();

		TryEntity entity = new TryEntity();
		entity.setId(1);
		entity.setName("testname");
		dao.save(entity);


		TryEntity entity2 = new TryEntity();
		entity2.setId(1);
		entity2.setName("testname");
		dao.save(entity2);
	}

	@After
	public void clearTable() {
		dao.deleteAll();
	}

	@AfterClass
	public static void cleanUpAfterClass() {
		EntityManager em = injector.getInstance(EntityManager.class);
		EntityManagerFactory factory = em.getEntityManagerFactory();

		em.clear();
		em.close();
		factory.close();
	}

	@Test
	public void testDao() throws Exception {
		TryEntity entity = dao.fetch(1);
		Assert.assertEquals("testname", entity.getName());
	}

	@Test
	public void testTry2Entity() {
		Try2Entity entity = new Try2Entity();
		entity.setId(3);
		entity.setName("zweiter Name");
		dao2.save(entity);

		Try2Entity entity2 = dao2.fetch(3);
		entity2.setName("geändert");
		dao2.save(entity2);

		Try2Entity entity3 = dao2.fetch(3);
		Assert.assertEquals("geändert", entity3.getName());
	}

	@Test
	public void testName() {
		TryEntity fetch = dao.fetch(1);
		Assert.assertEquals("testname", fetch.getName());
	}

	private static class TryDaoTestModule extends AbstractModule {

		@Override
		protected void configure() {
			bind(EntityManager.class).toProvider(EntityManagerTestProvider.class);

			bind(ITryDao.class).to(TryDao.class);

			bind(ITry2Dao.class).to(Try2Dao.class);
		}

	}
}

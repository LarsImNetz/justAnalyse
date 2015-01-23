package org.linuxx.moonserver.db.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.AfterClass;
import org.junit.Assert;
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

		TryEntity entity = new TryEntity();
		entity.setId(0);
		entity.setName("testname");
		dao.save(entity);
	}

	@AfterClass
	public static void cleanUpAfterClass() {
		injector.getInstance(EntityManager.class).close();
		injector.getInstance(EntityManagerFactory.class).close();
	}

	@Test
	public void testDao() throws Exception {
		TryEntity entity = dao.fetch(0);
		Assert.assertEquals("testname", entity.getName());
	}

	@Test
	public void testTry2Entity() {
		Try2Entity entity = new Try2Entity();
		entity.setId(1);
		entity.setName("zweiter Name");
		dao2.save(entity);

		Try2Entity entity2 = dao2.fetch(1);
		entity2.setName("geändert");
		dao2.save(entity2);

		Try2Entity entity3 = dao2.fetch(1);
		Assert.assertEquals("geändert", entity3.getName());

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

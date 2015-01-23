package org.linuxx.moonserver.db.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.linuxx.moonserver.db.persistence.guice.provider.EntityManagerTestProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestTrySqlDao {

	static Injector injector;

	static TrySqlDao dao;

	@BeforeClass
	public static void setUp() {
		injector = Guice.createInjector(new AbstractModule() {

			@Override
			protected void configure() {
				bind(EntityManager.class).toProvider(EntityManagerTestProvider.class);

				bind(ITryDao.class).to(TryDao.class);
			}
		});
		dao = new TrySqlDao();
		injector.injectMembers(dao);

		createDBContent();
	}

	// @AfterClass
	// public static void cleanUpAfterClass() {
	// injector.getInstance(EntityManager.class).close();
	// injector.getInstance(EntityManagerFactory.class).close();
	// }

	public static void createDBContent() {
		// dao.deleteAll();
		dao.insertInto(1, "Skywalker", "Luke");
		dao.insertInto(2, "Skywalker", "Anakin");
		dao.insertInto(3, "Solo", "Han");
	}

	@Test
	public void test_fetchAll() {

		List<Object[]> resultList = dao.fetchAll();

		Assert.assertNotNull(resultList);
		Assert.assertEquals(3, resultList.size());

		Object[] objs = resultList.get(0);
		Assert.assertEquals(1, objs[0]);
		Assert.assertEquals("Luke", objs[1]);
		Assert.assertEquals("Skywalker", objs[2]);
	}

	@Test
	public void test_fetch() {
		Object[] objs = (Object[]) dao.fetch(1);

		Assert.assertNotNull(objs);

		Assert.assertEquals(1, objs[0]);
		Assert.assertEquals("Luke", objs[1]);
		Assert.assertEquals("Skywalker", objs[2]);

	}
}

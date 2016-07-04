package org.linuxx.moonserver.db.persistence;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.AfterClass;
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
		dao.deleteAll();

		createDBContent();
	}

	@AfterClass
	public static void cleanUpAfterClass() {
		final EntityManager em = injector.getInstance(EntityManager.class);
		System.out.println("Properties of EntityManager");
		final Map<String, Object> properties = em.getProperties();
		show(properties);

		System.out.println("Properties of EntityManagerFactory");
		final EntityManagerFactory factory = em.getEntityManagerFactory();
		final Map<String, Object> properties2 = factory.getProperties();
		show(properties2);

		em.close();
		factory.close();
	}

	private static void show(final Map<String, Object> properties) {
		for (final String key : properties.keySet()) {
			final Object obj = properties.get(key);
			System.out.println(key + ":=" + obj.toString());
		}
		System.out.println();
	}

	public static void createDBContent() {
		dao.deleteAll();

		final Date today = getTodayAsDate();
		dao.insertInto(1, today, "Skywalker", "Luke", 1d);
		dao.insertInto(2, today, "Skywalker", "Anakin", 2d);
		dao.insertInto(3, today, "Solo", "Han", 2d);
		dao.insertInto(4, today, "Zahl", "Pi", 3.14159265358926);
		dao.insertInto(5, today, "Zahl", "1mrd", 1_000_000_000d);
		dao.insertInto(6, today, "Zahl", "1bil", 1_000_000_000_000d);
		dao.insertInto(7, today, "Zahl", "1brd", 1_000_000_000_000_000d);
	}

	/**
	 * Nur der heutige Tag, nicht auch noch die Uhrzeit!
	 * 
	 * @return
	 */
	private static LocalDateTime getToday() {
		final LocalDateTime ldt = LocalDateTime.now();
		return LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), 0, 0);
	}

	private static Date getTodayAsDate() {
		final Instant instant = getToday().atZone(ZoneId.systemDefault()).toInstant();
		final Date today = Date.from(instant);
		return today;
	}

	@Test
	public void test_fetchAll() {

		final List<Object[]> resultList = dao.fetchAll();

		Assert.assertNotNull(resultList);
		Assert.assertEquals(7, resultList.size());

		final Object[] objs = resultList.get(0);
		Assert.assertEquals(1, objs[0]);
		Assert.assertEquals("Luke", objs[1]);
		Assert.assertEquals("Skywalker", objs[2]);
		Assert.assertEquals(getToday(), convertToLocalDateTime(objs[3]));
	}

	private static LocalDateTime convertToLocalDateTime(final Object obj) {
		final Date date = (Date) obj;
		final LocalDateTime ldt = LocalDateTime.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), 0, 0);
		return ldt;
	}

	@Test
	public void test_fetchZahl() {

		final List<Object[]> resultList = dao.fetchAll();

		Assert.assertNotNull(resultList);
		Assert.assertEquals(7, resultList.size());

		Object[] objs = resultList.get(6);
		Assert.assertEquals("1brd", objs[1]);
		Assert.assertEquals("Zahl", objs[2]);
		Assert.assertEquals(Double.valueOf(1_000_000_000_000_000d), Double.valueOf((double) objs[4]));

		objs = resultList.get(3);
		Assert.assertEquals("Pi", objs[1]);
		Assert.assertEquals("Zahl", objs[2]);
		Assert.assertEquals(3.141592653589, ((double) objs[4]), 0.000000000001);

	}

	@Test
	public void test_fetch() {
		final Object[] objs = (Object[]) dao.fetch(1);

		Assert.assertNotNull(objs);

		Assert.assertEquals(1, objs[0]);
		Assert.assertEquals("Luke", objs[1]);
		Assert.assertEquals("Skywalker", objs[2]);
	}

	@Test
	public void testFetchOther() throws Exception {
		final Object obj = dao.fetchOther();
		Assert.assertNotNull(obj);
	}
}

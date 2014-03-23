package org.linuxx.moonserver.db.persistence;



import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.linuxx.moonserver.db.persistence.guice.provider.EntityManagerTestProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestTryDao {

	private static TryDao dao;
	
	@BeforeClass
	public static void beforeClass() {
		Injector injector = Guice.createInjector(new TryDaoTestModule());

		dao = new TryDao();
		injector.injectMembers(dao);

		// dao.fetch(1);
		TryEntity entity = new TryEntity();
		entity.setName("testname");
		dao.save(entity);
	}

	@Test
	public void testDao() throws Exception {
			TryEntity entity = dao.fetch(0); 
	}
	
	private static class TryDaoTestModule extends AbstractModule {

		@Override
		protected void configure() {
			// TODO Auto-generated method stub
			bind(EntityManager.class).toProvider(EntityManagerTestProvider.class);

			bind(ITryDao.class).to(TryDao.class);
		}
		
	}
}

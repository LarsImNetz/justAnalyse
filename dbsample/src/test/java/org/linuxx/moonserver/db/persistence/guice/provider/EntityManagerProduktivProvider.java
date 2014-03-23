package org.linuxx.moonserver.db.persistence.guice.provider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.inject.Provider;

public class EntityManagerProduktivProvider implements Provider<EntityManager> {

	private static final String PERSISTENCE_UNIT_NAME = "komasProduktiv";

	@Override
	public EntityManager get() {
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		return factory.createEntityManager();
	}

}

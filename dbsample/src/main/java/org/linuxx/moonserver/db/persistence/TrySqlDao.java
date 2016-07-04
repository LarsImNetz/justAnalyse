package org.linuxx.moonserver.db.persistence;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TrySqlDao {

	@Inject
	private EntityManager em;

	public List<Object[]> fetchAll() {
		final String sql = "SELECT a.id, a.vorname, a.name, a.erstelltam,a.zahl FROM Try a";
		final Query nativeQuery = em.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		final List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	public Object fetchOther() {
		final String sql = "SELECT a.id, a.vorname, a.name FROM Try a";
		final Query nativeQuery = em.createNativeQuery(sql);
		final Object result = nativeQuery.getResultList();
		return result;
	}

	public Object fetch(final int id) {
		final String sql = "SELECT a.id, a.vorname, a.name FROM Try a WHERE a.id=?";
		final Query nativeQuery = em.createNativeQuery(sql);
		nativeQuery.setParameter(1, id);
		final Object result = nativeQuery.getSingleResult();
		return result;
	}

	public void insertInto(final int id, final Date date, final String name, final String vorname, final double zahl) {
		em.getTransaction().begin();

		final String sql = "INSERT INTO Try (id, erstelltam, name, vorname, zahl) VALUES (?, ?, ?, ?, ?)";

		final Query query = em.createNativeQuery(sql);
		query.setParameter(1, id);
		query.setParameter(2, date);
		query.setParameter(3, name);
		query.setParameter(4, vorname);
		query.setParameter(5, zahl);
		query.executeUpdate();

		em.getTransaction().commit();
	}

	public void deleteAll() {
		em.getTransaction().begin();

		final String sql = "DELETE FROM Try";
		final Query query = em.createNativeQuery(sql);
		query.executeUpdate();

		em.getTransaction().commit();
	}
}

package org.linuxx.moonserver.db.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TrySqlDao {

	@Inject
	private EntityManager em;

	public List<Object[]> fetchAll() {
		String sql = "SELECT a.id, a.vorname, a.name FROM Try a";
		Query nativeQuery = em.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = nativeQuery.getResultList();
		return resultList;
	}

	public Object fetch(int id) {
		String sql = "SELECT a.id, a.vorname, a.name FROM Try a WHERE a.id=?";
		Query nativeQuery = em.createNativeQuery(sql);
		nativeQuery.setParameter(1, id);
		Object result = nativeQuery.getSingleResult();
		return result;
	}

	public void insertInto(int id, String name, String vorname) {
		em.getTransaction().begin();

		String sql = "INSERT INTO Try (id, name, vorname) VALUES (?,?,?)";

		Query query = em.createNativeQuery(sql);
		query.setParameter(1, id);
		query.setParameter(2, name);
		query.setParameter(3, vorname);
		query.executeUpdate();

		em.getTransaction().commit();
	}
}

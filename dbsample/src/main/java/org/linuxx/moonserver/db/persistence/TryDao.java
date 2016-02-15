package org.linuxx.moonserver.db.persistence;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;

import com.google.inject.Inject;

public class TryDao implements ITryDao {

	private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TryDao.class);
	@Inject
	private EntityManager em;

	@Override
	public TryEntity fetch(Integer id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<TryEntity> query = criteriaBuilder.createQuery(TryEntity.class);

		Root<TryEntity> table = query.from(TryEntity.class);
		Path<Integer> column = table.get(TryEntity_.id);

		Predicate criteria = criteriaBuilder.equal(column, id);
		query.where(criteria);

		try {
			return em.createQuery(query).getSingleResult();
		}
		catch (NoResultException e) {
			LOGGER.error("Exception: " + e.getMessage());
		}
		return null;

	}

	public void deleteAll() {
		em.getTransaction().begin();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<TryEntity> deleteQuery = criteriaBuilder.createCriteriaDelete(TryEntity.class);
		// Root<TryEntity> from = deleteQuery.from(TryEntity.class);
		// Root<TryEntity> root = deleteQuery.getRoot();
		// Root<TryEntity> from = deleteQuery.from(TryEntity.class);
		Query createQuery = em.createQuery(deleteQuery);

		createQuery.executeUpdate();

		em.getTransaction().commit();
	}

	public void save(final TryEntity entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

}

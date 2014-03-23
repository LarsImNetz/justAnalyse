package org.linuxx.moonserver.db.persistence;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.google.inject.Inject;

public class TryDao implements ITryDao {

	@Inject
	private EntityManager em;

	@Override
	public TryEntity fetch(Integer id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<TryEntity> query = criteriaBuilder.createQuery(TryEntity.class);

		Root<TryEntity> table = query.from(TryEntity.class);
//		Path<Integer> column = table.get(TryEntity_.id);
//
//		Predicate criteria = criteriaBuilder.equal(column, id);
//		query.where(criteria);
//
//		try {
//			return em.createQuery(query).getSingleResult();
//		}
//		catch (NoResultException e) {
//		}
		return null;

	
	}

	public void save(final TryEntity entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

}

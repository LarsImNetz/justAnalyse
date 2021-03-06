package org.linuxx.moonserver.db.persistence;

import java.rmi.dgc.Lease;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;

import com.google.inject.Inject;

public class NameDao implements INameDao {
	
	private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(NameDao.class);

	private final EntityManager em;

	@Inject
	public NameDao(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public NameEntity fetch(Integer id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<NameEntity> query = criteriaBuilder.createQuery(NameEntity.class);

		Root<NameEntity> nameTable = query.from(NameEntity.class);

//		Join<NameEntity, AddressEntity> sJoin = nameTable.join("address", JoinType.LEFT);
//		sJoin.on(criteriaBuilder.equal(sJoin.get("address"), "lars"));

		Path<Integer> column = nameTable.get(NameEntity_.id);
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
		CriteriaDelete<NameEntity> deleteQuery = criteriaBuilder.createCriteriaDelete(NameEntity.class);
		// Root<TryEntity> from = deleteQuery.from(TryEntity.class);
		// Root<TryEntity> root = deleteQuery.getRoot();
		// Root<TryEntity> from = deleteQuery.from(TryEntity.class);
		Query createQuery = em.createQuery(deleteQuery);

		createQuery.executeUpdate();

		em.getTransaction().commit();
	}

	public void save(final NameEntity entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

}

package org.linuxx.moonserver.db.persistence;

import java.util.List;

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

public class AddressDao implements IAddressDao {
	
	private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AddressDao.class);

	private final EntityManager em;

	@Inject
	public AddressDao(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public List<AddressEntity> fetch(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<AddressEntity> query = criteriaBuilder.createQuery(AddressEntity.class);

		Root<AddressEntity> table = query.from(AddressEntity.class);
		Path<String> column = table.get(AddressEntity_.name);

		Predicate criteria = criteriaBuilder.equal(column, id);
		query.where(criteria);

		try {
			return em.createQuery(query).getResultList();
		}
		catch (NoResultException e) {
			LOGGER.error("Exception: " + e.getMessage());
		}
		return null;
	}

	public void deleteAll() {
		em.getTransaction().begin();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<AddressEntity> deleteQuery = criteriaBuilder.createCriteriaDelete(AddressEntity.class);
		Query createQuery = em.createQuery(deleteQuery);

		createQuery.executeUpdate();

		em.getTransaction().commit();
	}

	public void save(final AddressEntity entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

}

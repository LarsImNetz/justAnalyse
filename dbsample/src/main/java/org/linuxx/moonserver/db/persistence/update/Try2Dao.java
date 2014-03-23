package org.linuxx.moonserver.db.persistence.update;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;

import com.google.inject.Inject;

public class Try2Dao implements ITry2Dao {

	private static Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Try2Dao.class);
	@Inject
	private EntityManager em;

	@Override
	public Try2Entity fetch(Integer id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Try2Entity> query = criteriaBuilder.createQuery(Try2Entity.class);

		Root<Try2Entity> table = query.from(Try2Entity.class);
		Path<Integer> column = table.get(Try2Entity_.id);

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

	public void save(final Try2Entity entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

}

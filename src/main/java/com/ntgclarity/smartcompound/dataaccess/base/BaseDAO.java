package com.ntgclarity.smartcompound.dataaccess.base;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.dom4j.tree.AbstractEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.base.BaseEntity;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Group;

@Repository
@Transactional
public abstract class BaseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Object saveOrUpdate(Object entity) {
		getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	public List getAll(Class cls) {
		Query query = getCurrentSession().createQuery(
				"from " + cls.getCanonicalName());
		List result = query.list();
		return result;
	}

	public Object get(Class<? extends BaseEntity> clazz, Long id) {
		return getCurrentSession().get(clazz, id);
	}

	// What does filters represent?
	public List load(Class cls, int first, int pageSize, String sortField,
			Boolean ascending, Map<String, Object> filters) {
		Query query;

		String queryString = "select x from " + cls.getCanonicalName() + " x ";

		if (sortField != null && ascending != null) {
			queryString += (ascending) ? " order by x." + sortField
					: " order by x." + sortField + " desc";
		}

		query = getCurrentSession().createQuery(queryString);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		List<Object> result = query.list();
		return result;
	}

	public int getNumOfRows(Class cls, Map<String, Object> filters) {

		Query query = getCurrentSession().createQuery(
				"select count(x) from " + cls.getCanonicalName() + " x ");
		int result =( (Long) query.uniqueResult()).intValue();
		return result;
	}
	
	public List getAllByCompound(Class cls,Compound compound) {
		// query statement (SELECT x FROM className x WHEERE x.compound =:compound)  (x Alias)
		Query query = getCurrentSession().createQuery(
				"from " + cls.getCanonicalName()+" x where x.compound =:compound");
		query.setParameter("compound", compound);
		List result = query.list();
		return result;
	}
}

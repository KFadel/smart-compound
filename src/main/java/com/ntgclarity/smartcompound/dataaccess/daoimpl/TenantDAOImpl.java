package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.TenantDAO;

/**Author: Heba**/

@Repository
public class TenantDAOImpl extends BaseDAO implements TenantDAO {

	@Override
	public List<Tenant> getAllTenants(Compound comp) {

	Query  query=getCurrentSession().createQuery("select o from Tenant o where o.compound.id=1");
	List<Tenant> result = query.list();
	System.out.println("result size in dao"+result.size());
	return result;
	}

	@Override
	public Tenant getTenant(Long id) {
		return  (Tenant) super.get(Tenant.class , id);
	}
	@Override
	public Tenant updateTenant(Tenant tenant) {
		// TODO Auto-generated method stub
		return (Tenant) super.saveOrUpdate(tenant);
	}

	/**
	 *methodCreater:nessma 
	 *create Tenant 
	 *this metohd will call saveOrUpdate() in the super class BaseDAO
	 
	  **/
	@Override
	public Tenant insertTenant(Tenant tenant) {
		
		return (Tenant) super.saveOrUpdate(tenant);
		
		
	}
	@Override
	public List<Tenant> loadTenants(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
			
		return super.load(Tenant.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfTenantsRows(Map<String, Object> filters) {
		
		return super.getNumOfRows(Tenant.class,filters);
	}

	@Override
	public List<Tenant> getCompoundTenants(Compound compound,String searchParam) {
//		return (List<Tenant>) super.getAllByCompound(Tenant.class, compound);
		Query query = getCurrentSession().createQuery(
				"from " + Tenant.class.getCanonicalName()
						+ " x where x.compound =:compound AND x.username LIKE :username");
		query.setParameter("compound", compound);
		query.setParameter("username", "%" + searchParam + "%");
		return  query.list();
	}

}

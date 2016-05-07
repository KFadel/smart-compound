package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.LookupType;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.CompoundDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.LookupDAO;

/**Author: Heba**/

@Repository
public class LookupDAOImpl extends BaseDAO implements LookupDAO {

	@Override
	public List<Lookup> getLookups(LookupType lookupTypes) {
		
	Query query = getCurrentSession().createQuery("select o from Lookup o where o.lookupType =:lookupType");
	
	query.setParameter("lookupType", lookupTypes);
	List result = query.list();
	return result;
	}


}

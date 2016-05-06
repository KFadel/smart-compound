package com.ntgclarity.smartcompound.dataaccess.dao;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Tenant;

/**Author: Heba**/

public interface TenantDAO {

	List<Tenant> getAllTenants(Compound comp);

	Tenant getTenant(Long id);

	Tenant insertTenant(Tenant tenant);

	Tenant updateTenant(Tenant tenant);
	
	List<Tenant> loadTenants(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfTenantsRows(Map<String, Object> filters);

	List<Tenant> getCompoundTenants(Compound compound);

}

package com.ntgclarity.smartcompound.dataaccess.dao;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.LookupType;

/**Author: Heba**/

public interface LookupDAO {

	List<Lookup> getLookups(LookupType lookupTypes);

	
	
}

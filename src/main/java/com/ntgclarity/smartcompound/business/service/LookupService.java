package com.ntgclarity.smartcompound.business.service;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.LookupType;

/**Author: Heba**/

public interface LookupService {

	
	
	public List<Lookup> getLookups(LookupType lookupTypes);
}

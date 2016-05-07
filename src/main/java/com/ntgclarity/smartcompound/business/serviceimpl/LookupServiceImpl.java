package com.ntgclarity.smartcompound.business.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.service.CompoundService;
import com.ntgclarity.smartcompound.business.service.LookupService;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.LookupType;
import com.ntgclarity.smartcompound.dataaccess.dao.CompoundDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.LookupDAO;

/**Author: Heba**/

@Service
public class LookupServiceImpl implements LookupService {

	
	@Autowired
	private LookupDAO lookupDAO;
	
	@Override
	public List<Lookup> getLookups(LookupType lookupTypes) {
		return lookupDAO.getLookups(lookupTypes);
	}

		

}

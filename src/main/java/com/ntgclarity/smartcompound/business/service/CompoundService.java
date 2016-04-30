package com.ntgclarity.smartcompound.business.service;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Compound;

/**Author: Heba**/

public interface CompoundService {

	List<Compound> getAllCompounds();

	Compound getCompound(Long id);

	Compound insertCompound(Compound compound);

	Compound updateCompound(Compound compound);
	
	List<Compound> loadCompounds(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfCompoundsRows(Map<String, Object> filters);

}

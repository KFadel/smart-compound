package com.ntgclarity.smartcompound.dataaccess.dao;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Facility;

/**Author: Heba**/

public interface FacilityDAO {

	List<Facility> getAllFacilities(Compound comp);

	Facility getFacility(Long id);

	Facility insertFacility(Facility facility);

	Facility updateFacility(Facility facility);
	
	List<Facility> loadFacilities(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfFacilitiesRows(Map<String, Object> filters);

}

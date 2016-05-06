package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.FacilityDAO;

/**Author: Heba**/

@Repository
public class FacilityDAOImpl extends BaseDAO implements FacilityDAO {

	@Override
	public List<Facility> getAllFacilities(Compound comp) {
		
		System.out.println("facilities size in thedao"+super.getAll(Facility.class).size());
		return (List<Facility>) super.getAll(Facility.class);
	}

	@Override
	public Facility getFacility(Long id) {
		return  (Facility) super.get(Facility.class , id);
	}
	@Override
	public Facility updateFacility(Facility facility) {
		// TODO Auto-generated method stub
		return (Facility) super.saveOrUpdate(facility);
	}

	/**
	 *methodCreater:nessma 
	 *create Facility 
	 *this metohd will call saveOrUpdate() in the super class BaseDAO
	 
	  **/
	@Override
	public Facility insertFacility(Facility facility) {
		
		return (Facility) super.saveOrUpdate(facility);
		
		
	}
	@Override
	public List<Facility> loadFacilities(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
			
		return super.load(Facility.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfFacilitiesRows(Map<String, Object> filters) {
		
		return super.getNumOfRows(Facility.class,filters);
	}

}

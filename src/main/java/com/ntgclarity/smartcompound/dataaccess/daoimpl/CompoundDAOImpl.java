package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.CompoundDAO;

/**Author: Heba**/

@Repository
public class CompoundDAOImpl extends BaseDAO implements CompoundDAO {

	@Override
	public List<Compound> getAllCompounds() {

		return (List<Compound>) super.getAll(Compound.class);
	}

	@Override
	public Compound getCompound(Long id) {
		return  (Compound) super.get(Compound.class, id);
	}
	@Override
	public Compound updateCompound(Compound compound) {
		return (Compound) super.saveOrUpdate(compound);
	}

	/**
	 *methodCreater:nessma 
	 *create Compound 
	 *this metohd will call saveOrUpdate() in the super class BaseDAO
	 
	  **/
	@Override
	public Compound insertCompound(Compound compound) {
		
		return (Compound) super.saveOrUpdate(compound);
		
		
	}
	@Override
	public List<Compound> loadCompounds(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
			
		return (List<Compound>)super.load(Compound.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfCompoundsRows(Map<String, Object> filters) {
		
		return super.getNumOfRows(Compound.class,filters);
	}

}

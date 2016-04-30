package com.ntgclarity.smartcompound.business.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.service.CompoundService;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.dataaccess.dao.CompoundDAO;

/**Author: Heba**/

@Service
public class CompoundServiceImpl implements CompoundService {

	@Autowired
	private CompoundDAO compoundDAO;
	
	@Override
	public List<Compound> getAllCompounds() {
		return compoundDAO.getAllCompounds();
	}

	@Override
	public Compound getCompound(Long id) {
		if(id !=null)
		{
			return compoundDAO.getCompound(id);
		}
		return null;
	}
	/**
	 *methodCreater:nessma 
	 *create Compound 
	 *this metohd will call CompoundDAO.insertCompound
	 
	  **/
	@Override
	public Compound insertCompound(Compound compound) {
		
		return compoundDAO.insertCompound(compound);
	}
	@Override
	public Compound updateCompound(Compound compound) {
		// TODO Auto-generated method stub
		return compoundDAO.updateCompound(compound);
		
	}

	@Override
	public List<Compound> loadCompounds(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return compoundDAO.loadCompounds(first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfCompoundsRows(Map<String, Object> filters) {
	
		return  compoundDAO.getNumOfCompoundsRows(filters);
	}


}

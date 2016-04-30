package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Service;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.ServiceDAO;

@Repository
public class ServiceDAOImpl extends BaseDAO implements ServiceDAO {

	@Override
	public List<Service> getAllServices() {

		return (List<Service>) super.getAll(Service.class);
	}

	@Override
	public Service getService(Long id) {
		return  (Service) super.get(Service.class , id);
	}
	@Override
	public Service updateService(Service service) {
		// TODO Auto-generated method stub
		return (Service) super.saveOrUpdate(service);
	}

	/**
	 *methodCreater:nessma 
	 *create Service 
	 *this metohd will call saveOrUpdate() in the super class BaseDAO
	 
	  **/
	@Override
	public Service insertService(Service service) {
		
		return (Service) super.saveOrUpdate(service);
		
		
	}
	@Override
	public List<Service> loadServices(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
			
		return super.load(Service.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfServicesRows(Map<String, Object> filters) {
		
		return super.getNumOfRows(Service.class,filters);
	}

}

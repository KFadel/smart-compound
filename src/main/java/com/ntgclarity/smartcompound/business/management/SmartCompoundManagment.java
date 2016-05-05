package com.ntgclarity.smartcompound.business.management;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees()throws SmartCompoundException;

	Employee getEmployee(Long id);
	
	Order insertOrder(Order order)throws SmartCompoundException;
	
	
	List<Facility> getCompoundFacilites(Compound compound) throws SmartCompoundException;

	List<com.ntgclarity.smartcompound.common.entity.Service> getCompoundServices(
			Compound compound);

	com.ntgclarity.smartcompound.common.entity.Service getService(Long id);

}

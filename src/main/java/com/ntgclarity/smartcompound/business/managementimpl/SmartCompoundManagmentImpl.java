package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.business.service.FacilityService;
import com.ntgclarity.smartcompound.business.service.OrderService;
import com.ntgclarity.smartcompound.business.service.ServiceService;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;

@Service
public class SmartCompoundManagmentImpl implements SmartCompoundManagment{

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OrderService orderService;
	
	
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private ServiceService serviceService;
	
	@Override
	public List<Employee> getAllEmployees()throws SmartCompoundException {
		return employeeService.getAllEmployees();
	}


	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}


	@Override
	public Order insertOrder(Order order)throws SmartCompoundException {
		return orderService.insertOrder(order);
	}


	@Override
	public List<Facility> getCompoundFacilites(Compound compound) throws SmartCompoundException {
		return facilityService.getCompoundFacilites( compound);
	}


	@Override
	public List<com.ntgclarity.smartcompound.common.entity.Service> getCompoundServices(
			Compound compound) {
		return serviceService.getCompoundServices( compound);
	}


	@Override
	public com.ntgclarity.smartcompound.common.entity.Service getService(Long id) {
		return serviceService.getService(id);
	}

}

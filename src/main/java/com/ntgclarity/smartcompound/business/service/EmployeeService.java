package com.ntgclarity.smartcompound.business.service;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

	List<Employee> loadOrders(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfOrdersRows(Map<String, Object> filters);

	

}

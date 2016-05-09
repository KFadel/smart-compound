package com.ntgclarity.smartcompound.business.service;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Ticket;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

	/**START HEBA'S WORK**/
	Employee insertEmployee(Employee employee);	
	/**END HEBA'S WORK**/
	List<Employee> loadOrders(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfOrdersRows(Map<String, Object> filters);

	

}

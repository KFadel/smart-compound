package com.ntgclarity.smartcompound.dataaccess.dao;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);
	
	/**START HEBA'S WORK**/
	Employee insertEmployee(Employee employee);
	/**END HEBA'S WORK**/

	List<Employee> loadOrders(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfOrdersRows(Map<String, Object> filters);

}

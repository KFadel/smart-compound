package com.ntgclarity.smartcompound.business.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.dataaccess.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployee(Long id) {
		if(id !=null)
		{
			return employeeDAO.getEmployee(id);
		}
		return null;
	}

	@Override
	public List<Employee> loadOrders(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return employeeDAO.loadOrders(first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfOrdersRows(Map<String, Object> filters) {
		return  employeeDAO.getNumOfOrdersRows(filters);
	}

}

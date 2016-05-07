package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.EmployeeDAO;

@Repository
public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {

		return (List<Employee>) super.getAll(Employee.class);
	}

	@Override
	public Employee getEmployee(Long id) {
		return  (Employee) super.get(Employee.class , id);
	}
	
	/**START HEBA'S WORK**/
	public Employee insertEmployee(Employee employee){
		return (Employee) super.saveOrUpdate(employee);
	}
	/**END HEBA'S WORK**/

	@Override
	public List<Employee> loadOrders(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return super.load(Order.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfOrdersRows(Map<String, Object> filters) {
		return super.getNumOfRows(Order.class,filters);
	}

}

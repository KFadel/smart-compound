package com.ntgclarity.smartcompound.business.management;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees() throws SmartCompoundException;

	Employee getEmployee(Long id);

	public void insertCompound(Compound compound);

	/*added by Hend*/
	com.ntgclarity.smartcompound.common.entity.Service insertService(com.ntgclarity.smartcompound.common.entity.Service service) throws SmartCompoundException ;
	/*end oh Hend's part*/

	Order insertOrder(Order order) throws SmartCompoundException;

	List<Facility> getCompoundFacilites(Compound compound,String searchParam)
			throws SmartCompoundException;

	int getNumOfTicketsRows(Map<String, Object> filters);

	List<Ticket> loadTickets(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	List<Order> loadOrders(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	int getNumOfOrdersRows(Map<String, Object> filters);

	List<com.ntgclarity.smartcompound.common.entity.Service> getCompoundServices(
			Compound compound,String searchParam);

	com.ntgclarity.smartcompound.common.entity.Service getService(Long id);

	List<Tenant> getCompoundTenants(Compound compound,String searchParam);

	Tenant getTenant(Long id);

//	List<Ticket> getAllTickets();

	Ticket insertTicket(Ticket ticket);

	Ticket getTicket(Long long1);

	List<Tenant> getAllTenants(Compound comp);

	List<com.ntgclarity.smartcompound.common.entity.Service> getAllServices(
			Compound comp);

	List<Facility> getAllFacilities(Compound comp);

	Facility getFacility(Long long1);



	/**START HEBA'S WORK**/
	public Employee insertEmployee(Employee employee);
	/**END HEBA'S WORK**/

	List<Employee> loadEmployees(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	int getNumOfEmployeesRows(Map<String, Object> filters);

}

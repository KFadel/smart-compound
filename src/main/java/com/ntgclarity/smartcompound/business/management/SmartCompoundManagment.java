package com.ntgclarity.smartcompound.business.management;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees() throws SmartCompoundException;

	Employee getEmployee(Long id);

	public void insertCompound(Compound compound);

	/*added by Hend*/
	com.ntgclarity.smartcompound.common.entity.Service insertService(com.ntgclarity.smartcompound.common.entity.Service service) throws SmartCompoundException ;
	
	List<com.ntgclarity.smartcompound.common.entity.Service> loadServices(
			int first, int pageSize, String sortField, boolean b,
			Map<String, Object> filters);
	
	int getNumOfServicesRows(Map<String, Object> filters);
	/*end oh Hend's part*/

	Order insertOrder(Order order) throws SmartCompoundException;

	List<Facility> getCompoundFacilites(Compound compound)
			throws SmartCompoundException;

	int getNumOfTicketsRows(Map<String, Object> filters);

	List<Ticket> loadTickets(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	List<Order> loadOrders(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	int getNumOfOrdersRows(Map<String, Object> filters);

	List<com.ntgclarity.smartcompound.common.entity.Service> getCompoundServices(
			Compound compound);

	com.ntgclarity.smartcompound.common.entity.Service getService(Long id);

	List<Tenant> getCompoundTenants(Compound compound);

	Tenant getTenant(Long id);



}

package com.ntgclarity.smartcompound.business.management;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.entity.Ticket;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);
	
	public void insertCompound(Compound compound);
	
	//public void updateCompound(Compound compound);

	

	int getNumOfTicketsRows(Map<String, Object> filters);

	List<Ticket> loadTickets(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	List<Order> loadOrders(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	int getNumOfOrdersRows(Map<String, Object> filters);

}

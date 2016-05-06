package com.ntgclarity.smartcompound.business.management;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Ticket;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

	/**START HEBA'S WORK**/
	Ticket getTicket(Long id);
	
	List<Ticket> loadTickets(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	int getNumOfTicketsRows(Map<String, Object> filters);
	/**END HEBA'S WORK**/
}

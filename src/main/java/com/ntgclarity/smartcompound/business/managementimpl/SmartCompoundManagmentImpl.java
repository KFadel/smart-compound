package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.business.service.TicketService;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Ticket;

@Service
public class SmartCompoundManagmentImpl implements SmartCompoundManagment{

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TicketService ticketService;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}


	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}


	/**START HEBA'S WORK**/
	@Override
	public Ticket getTicket(Long id) {
		return ticketService.getTicket(id);
	}
	

	@Override
	public List<Ticket> loadTickets(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters) {
		return ticketService.loadTickets(first, pageSize, sortField, b, filters);
	}


	@Override
	public int getNumOfTicketsRows(Map<String, Object> filters) {
		return ticketService.getNumOfTicketsRows(filters);
	}
	/**END HEBA'S WORK**/
}

package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;

import com.ntgclarity.smartcompound.business.service.*;
import com.ntgclarity.smartcompound.common.entity.*;


@Service
public class SmartCompoundManagmentImpl implements SmartCompoundManagment{

	@Autowired
	private EmployeeService employeeService;
	 
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TenantService tenantService;
	
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private FacilityService facilityService;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}


	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}


//	@Override
//	public List<Ticket> getAllTickets() {
//		// TODO Auto-generated method stub
//		return ticketService.loadTickets(first, pageSize, sortField, ascending, filters);
//	}


	@Override
	public Ticket insertTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketService.insertTicket(ticket) ;
	}


	@Override
	public Ticket getTicket(Long long1) {
	
		return null;
	}


	@Override
	public List<Tenant> getAllTenants(Compound comp) {
		
		return tenantService.getAllTenants(comp);
	}


	@Override
	public List<com.ntgclarity.smartcompound.common.entity.Service> getAllServices(Compound comp) {
		// TODO Auto-generated method stub
		return serviceService.getAllServices(comp);
	}


	@Override
	public List<Facility> getAllFacilities(Compound comp) {
		// TODO Auto-generated method stub
		return facilityService.getAllFacilities(comp);
	}

}

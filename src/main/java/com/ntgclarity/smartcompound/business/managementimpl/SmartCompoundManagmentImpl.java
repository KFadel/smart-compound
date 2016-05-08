package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.business.service.CompoundService;
import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.business.service.OrderService;
import com.ntgclarity.smartcompound.business.service.TenantService;
import com.ntgclarity.smartcompound.business.service.TicketService;
import com.ntgclarity.smartcompound.business.service.FacilityService;
import com.ntgclarity.smartcompound.business.service.OrderService;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.business.service.ServiceService;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.entity.SystemConfiguration;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.business.service.*;
import com.ntgclarity.smartcompound.common.entity.*;


@Service
public class SmartCompoundManagmentImpl implements SmartCompoundManagment {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private TicketService ticketService;

	@Autowired
	private CompoundService compoundService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private FacilityService facilityService;

	@Autowired
	private TenantService tenantService;

	@Autowired
	private ServiceService serviceService;
	
	@Autowired
	private SystemConfigurationService systemConfigurationService;
	
	@Override
	public List<Employee> getAllEmployees() throws SmartCompoundException {
		return employeeService.getAllEmployees();
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}

	@Override
	public Compound insertCompound(Compound compound) {

		return compoundService.insertCompound(compound);

	}

	// @Override
	// public void updateCompound(Compound compound){
	//
	// compoundService.updateCompound(compound);
	//
	// }

	@Override
	public int getNumOfTicketsRows(Map<String, Object> filters) {
		return ticketService.getNumOfTicketsRows(filters);
	}

	@Override
	public List<Ticket> loadTickets(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return ticketService.loadTickets(first, pageSize, sortField, ascending,
				filters);
		// return null;

	}


	@Override
	public com.ntgclarity.smartcompound.common.entity.Service insertService(com.ntgclarity.smartcompound.common.entity.Service service) throws SmartCompoundException {
		return serviceService.insertService(service);
	}
	/*end oh Hend's part*/
	@Override
	public List<Order> loadOrders(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return orderService.loadOrders(first, pageSize, sortField, ascending,
				filters);

	}

	@Override
	public int getNumOfOrdersRows(Map<String, Object> filters) {
		return orderService.getNumOfOrdersRows(filters);
	}

	@Override
	public Order insertOrder(Order order) throws SmartCompoundException {
		return orderService.insertOrder(order);
	}

	@Override
	public List<Facility> getCompoundFacilites(Compound compound)
			throws SmartCompoundException {
		return facilityService.getCompoundFacilites(compound);
	}

	@Override
	public List<com.ntgclarity.smartcompound.common.entity.Service> getCompoundServices(
			Compound compound) {
		return serviceService.getCompoundServices(compound);
	}

	@Override
	public com.ntgclarity.smartcompound.common.entity.Service getService(Long id){
		return serviceService.getService(id);
	}

	@Override
	public List<Tenant> getCompoundTenants(Compound compound) {
		return tenantService.getCompoundTenants(compound);
	}

	@Override
	public Tenant getTenant(Long id) {
		return tenantService.getTenant(id);
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
		System.out.println("result size in management"+tenantService.getAllTenants(comp));
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

	@Override
	public Facility getFacility(Long id) {

			try {
				return facilityService.getFacility(id);
			} catch (SmartCompoundException e) {
				
				e.printStackTrace();
				return null ;
			}
	}
	
	@Override
	public List<SystemConfiguration> getAllSystemConfigurations() {
		return systemConfigurationService.getAllSystemConfigurations();
	}

	@Override
	public SystemConfiguration getSystemConfiguration(Long id) {
		return systemConfigurationService.getSystemConfiguration(id);
	}

	@Override
	public SystemConfiguration insertSystemConfiguration(SystemConfiguration systemConfiguration) {

		return systemConfigurationService.insertSystemConfiguration(systemConfiguration);

	}

	@Override
	public int getNumOfSystemConfigurationsRows(Map<String, Object> filters) {
		return systemConfigurationService.getNumOfSystemConfigurationsRows(filters);
	}

	@Override
	public List<SystemConfiguration> loadSystemConfigurations(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return systemConfigurationService.loadSystemConfigurations(first, pageSize, sortField, ascending, filters);
		
	}
	

}

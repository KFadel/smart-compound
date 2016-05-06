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
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;

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
	private ServiceService serviceService;

	@Autowired
	private TenantService tenantService;

	@Override
	public List<Employee> getAllEmployees() throws SmartCompoundException {
		return employeeService.getAllEmployees();
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}

	@Override
	public void insertCompound(Compound compound) {

		compoundService.insertCompound(compound);

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
	public com.ntgclarity.smartcompound.common.entity.Service getService(Long id) {
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

}

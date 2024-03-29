package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.ArrayList;
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
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.business.service.ServiceService;
import com.ntgclarity.smartcompound.business.service.TicketService;
import com.ntgclarity.smartcompound.business.service.GroupService;
import com.ntgclarity.smartcompound.business.service.MenuItemService;
import com.ntgclarity.smartcompound.business.service.MenuService;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.entity.SystemConfiguration;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.business.service.*;
import com.ntgclarity.smartcompound.common.entity.*;
import com.ntgclarity.smartcompound.common.entity.Group;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.LookupType;
import com.ntgclarity.smartcompound.common.entity.Menu;
import com.ntgclarity.smartcompound.common.entity.MenuItem;


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
	private MenuItemService menuItemService;
	
	@Autowired
	private LookupService lookupService;

	
	@Autowired
	private SystemConfigurationService systemConfigurationService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private GroupService groupService;
	
	
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
	
	@Override
	public int getNumOfServicesRows(Map<String, Object> filters) {
		return serviceService.getNumOfServicesRows(filters);
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
	public List<Facility> getCompoundFacilites(Compound compound,String searchParam)
			throws SmartCompoundException {
		return facilityService.getCompoundFacilites(compound,searchParam);
	}

	@Override
	public List<com.ntgclarity.smartcompound.common.entity.Service> getCompoundServices(
			Compound compound,String searchParam) {
		return serviceService.getCompoundServices(compound,searchParam);
	}

	@Override
	public com.ntgclarity.smartcompound.common.entity.Service getService(Long id){
		return serviceService.getService(id);
	}

	@Override
	public List<Tenant> getCompoundTenants(Compound compound,String searchParam) {
		return tenantService.getCompoundTenants(compound,searchParam);
	}

	@Override
	public Tenant getTenant(Long id) {
		return tenantService.getTenant(id);
	}

	@Override
	public List<com.ntgclarity.smartcompound.common.entity.Service> loadServices(
			int first, int pageSize, String sortField, boolean b,
			Map<String, Object> filters) {
		return serviceService.loadServices(first, pageSize, sortField, b, filters);
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
	


	/**START HEBA'S WORK**/
	
	public Employee insertEmployee(Employee employee){
		return employeeService.insertEmployee(employee);
	}
	
	/**END HEBA'S WORK**/
	@Override
	public List<Employee> loadEmployees(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return employeeService.loadOrders(first, pageSize, sortField, ascending,
				filters);
	}

	@Override
	public int getNumOfEmployeesRows(Map<String, Object> filters) {
		return employeeService.getNumOfOrdersRows(filters);
	}
	
	@Override
	public List<Lookup> getLookups(LookupType lookupType)
	{
		return lookupService.getLookups(lookupType);
		
	}

	@Override
	public Facility insertFacility(Facility facility) throws SmartCompoundException{
		return facilityService.insertFacility(facility);
	}

	@Override
	public List<Facility> loadFacilities(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters){
		return facilityService.loadFacilities(first, pageSize, sortField, ascending,
				filters);
	}

	@Override
	public int getNumOfFacilitiesRows(Map<String, Object> filters){
		return facilityService.getNumOfFacilitiesRows(filters);
	}


	@Override
	public List<MenuItem> getAllMenuItems() {
		// TODO Auto-generated method stub
		return menuItemService.getAllMenuItems();
	}


	@Override
	public MenuItem getMenuItem(Long id) {
		// TODO Auto-generated method stub
		return menuItemService.getMenuItem(id);
	}


	@Override
	public MenuItem insertMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return menuItemService.insertMenuItem(menuItem);
	}


	@Override
	public MenuItem updateMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return menuItemService.updateMenuItem(menuItem);
	}


	@Override
	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		return menuService.getAllMenus();
	}


	@Override
	public Menu getMenu(Long id) {
		// TODO Auto-generated method stub
		return menuService.getMenu(id);
	}


	@Override
	public Menu insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuService.insertMenu(menu);
	}


	@Override
	public Menu updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuService.updateMenu(menu);
	}


	@Override
	public List<Lookup> getAllLookup(String lookupTypeName) {
		// TODO Auto-generated method stub
		LookupType lookupType = new LookupType();
		lookupType.setId(1L);
		lookupType.setTypeName("status");
		
		Lookup active = new Lookup();
		active.setId(1L);
		active.setLookupName("active");
		active.setLookupType(lookupType);
		active.setTypeName(lookupType.getTypeName());
		
		Lookup notActive = new Lookup();
		notActive.setId(2L);
		notActive.setLookupName("not active");
		notActive.setLookupType(lookupType);
		notActive.setTypeName(lookupType.getTypeName());
		
		List<Lookup> lookupList = new ArrayList<Lookup>();
		lookupList.add(active);
		lookupList.add(notActive);
		return lookupList;
	}


	@Override
	public List<Group> getAllGroup() {
		// TODO Auto-generated method stub
		
		
		return groupService.getAllGroups();
	}


	@Override
	public List<MenuItem> getGroupMenuItem(Group group) {
		// TODO Auto-generated method stub
		return groupService.getGroupMenuItem(group);
	}


	@Override
	public void insertGroupMenuItem(Group group, List<MenuItem> items) {
		// TODO Auto-generated method stub
		groupService.insertGroupMenuItem(group, items);
	}


	@Override
	public Group getGroup(Long id) {
		// TODO Auto-generated method stub
		return groupService.getGroup(id);
	}


	@Override
	public List<Menu> loadMenus(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return menuService.loadMenus(first, pageSize, sortField, ascending, filters);
	}


	@Override
	public int getNumOfMenusRows(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return menuService.getNumOfMenusRows(filters);
	}


	@Override
	public List<MenuItem> loadMenuItems(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return menuItemService.loadMenuItems(first, pageSize, sortField, ascending, filters);
	}


	@Override
	public int getNumOfMenuItemsRows(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return menuItemService.getNumOfMenuItemsRows(filters);
	}

}

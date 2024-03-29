package com.ntgclarity.smartcompound.business.management;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.LookupType;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.entity.SystemConfiguration;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.entity.Group;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.Menu;
import com.ntgclarity.smartcompound.common.entity.MenuItem;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees() throws SmartCompoundException;

	Employee getEmployee(Long id);
	
	
	List<MenuItem> getAllMenuItems();

	public Compound insertCompound(Compound compound);

	/*added by Hend*/
	com.ntgclarity.smartcompound.common.entity.Service insertService(com.ntgclarity.smartcompound.common.entity.Service service) throws SmartCompoundException ;
	
	List<com.ntgclarity.smartcompound.common.entity.Service> loadServices(
			int first, int pageSize, String sortField, boolean b,
			Map<String, Object> filters);
	
	int getNumOfServicesRows(Map<String, Object> filters);
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
	
	
	/*added by Mai*/
	public List<SystemConfiguration> getAllSystemConfigurations();
	
	public SystemConfiguration getSystemConfiguration(Long id);
	
	public SystemConfiguration insertSystemConfiguration(SystemConfiguration systemConfiguration);
	
	public int getNumOfSystemConfigurationsRows(Map<String, Object> filters);

	public List<SystemConfiguration> loadSystemConfigurations(int first, int pageSize,String sortField, boolean b, Map<String, Object> filters);
	/*End of Mai's part */


	/**START HEBA'S WORK**/
	public Employee insertEmployee(Employee employee);
	/**END HEBA'S WORK**/
	
	/**
	 *@author KFadel 
	**/
	List<Employee> loadEmployees(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters);

	int getNumOfEmployeesRows(Map<String, Object> filters);

	List<Lookup> getLookups(LookupType lookupType);

	
	public Facility insertFacility(Facility facility) throws SmartCompoundException;
				   
	List<Facility> loadFacilities(int first, int pageSize, String sortField,
			boolean b, Map<String, Object> filters) ;

	int getNumOfFacilitiesRows(Map<String, Object> filters);
	
	MenuItem getMenuItem(Long id);

	MenuItem insertMenuItem(MenuItem menuItem);

	MenuItem updateMenuItem(MenuItem menuItem);
	
	List<Menu> getAllMenus();

	Menu getMenu(Long id);

	Menu insertMenu(Menu menu);

	Menu updateMenu(Menu menu);
	
	List<Lookup> getAllLookup(String lookupTypeName);
	
	List<Group> getAllGroup();
	
	List<MenuItem> getGroupMenuItem(Group group);
	
    void insertGroupMenuItem(Group group,List<MenuItem> items);

    Group getGroup(Long id);
    
	List<Menu> loadMenus(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfMenusRows(Map<String, Object> filters);
	
	List<MenuItem> loadMenuItems(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfMenuItemsRows(Map<String, Object> filters);

	

}

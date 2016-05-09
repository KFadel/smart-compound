package com.ntgclarity.smartcompound.business.management;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Group;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.Menu;
import com.ntgclarity.smartcompound.common.entity.MenuItem;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);
	
	
	List<MenuItem> getAllMenuItems();

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

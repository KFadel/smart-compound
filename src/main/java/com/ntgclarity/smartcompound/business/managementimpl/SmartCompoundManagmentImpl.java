package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.business.service.GroupService;
import com.ntgclarity.smartcompound.business.service.MenuItemService;
import com.ntgclarity.smartcompound.business.service.MenuService;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Group;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.LookupType;
import com.ntgclarity.smartcompound.common.entity.Menu;
import com.ntgclarity.smartcompound.common.entity.MenuItem;

@Service
public class SmartCompoundManagmentImpl implements SmartCompoundManagment{

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private GroupService groupService;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}


	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
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
		active.setType_id(lookupType);
		active.setTypeName(lookupType.getTypeName());
		
		Lookup notActive = new Lookup();
		notActive.setId(2L);
		notActive.setLookupName("not active");
		notActive.setType_id(lookupType);
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

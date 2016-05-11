package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Menu;
import com.ntgclarity.smartcompound.common.entity.MenuItem;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.MenuItemDAO;

@Repository
public class MenuItemDAOImpl extends BaseDAO implements MenuItemDAO {

	@Override
	public List<MenuItem> getAllMenuItems() {

		return (List<MenuItem>) super.getAll(MenuItem.class);
	}

	@Override
	public MenuItem getMenuItem(Long id) {
		return  (MenuItem) super.get(MenuItem.class , id);
	}
	@Override
	public MenuItem updateMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return (MenuItem) super.saveOrUpdate(menuItem);
	}

	@Override
	public MenuItem insertMenuItem(MenuItem menuItem) {
		
		return (MenuItem) super.saveOrUpdate(menuItem);
		
		
	}

	@Override
	public List<MenuItem> loadMenuItems(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return super.load(MenuItem.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfMenuItemsRows(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return super.getNumOfRows(MenuItem.class, filters);
	}
	
}

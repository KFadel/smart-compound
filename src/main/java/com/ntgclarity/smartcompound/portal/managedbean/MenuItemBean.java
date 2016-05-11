package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.Menu;
import com.ntgclarity.smartcompound.common.entity.MenuItem;
import com.ntgclarity.smartcompound.portal.base.BaseBean;
@ManagedBean
@ViewScoped
public class MenuItemBean extends BaseBean implements Serializable{

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	
	private List<Menu> allMenus;
	private List<Lookup> allLookup;


	private MenuItem menuItem;
	

	private MenuItem selectedMenuItem;
	private LazyDataModel<MenuItem> lazyMenuItemModel;
	

	@PostConstruct
	public void init() {
		menuItem= new MenuItem();
		loadAllMenus();
		loadAllLookup();
		LoadData();
		selectedMenuItem=new MenuItem();
	}

	private void LoadData() {
		lazyMenuItemModel = new LazyDataModel<MenuItem>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<MenuItem> result;

			@Override
			public MenuItem getRowData(String rowKey) {
				for (MenuItem menuItem : result) {
					if (menuItem.getId().toString().equals(rowKey))
						return menuItem;
				}

				return null;
			}

			@Override
			public Object getRowKey(MenuItem menuItem) {
				return menuItem.getId();
			}
			@Override
			public List<MenuItem> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				result = getSmartCompoundManagment().loadMenuItems(first,
						pageSize, sortField, sortOrder == SortOrder.ASCENDING,
						filters);
				this.setRowCount(getSmartCompoundManagment()
						.getNumOfMenuItemsRows(filters));

				return result;
			}

			@Override
			public void forEach(Consumer<? super MenuItem> action) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Spliterator<MenuItem> spliterator() {
				// TODO Auto-generated method stub
				return null;
			}

		};
	}


	public void loadAllMenus() {
		 allMenus = smartCompoundManagment.getAllMenus();
	}
	
	public void loadAllLookup() {
		 allLookup = smartCompoundManagment.getAllLookup("status");
		 
		 for (Lookup curr: allLookup){
			 System.out.println(curr);
		 }
	}


	public void addMenuItem(){
		smartCompoundManagment.insertMenuItem(menuItem);
		menuItem= new MenuItem();
	}
	
	public void updateMenuItem(){
		smartCompoundManagment.updateMenuItem(menuItem);
		menuItem=new MenuItem();
	}

	public List<Menu> getAllMenus() {
		return allMenus;
	}

	public void setAllMenus(List<Menu> allMenus) {
		this.allMenus = allMenus;
	}

	public List<Lookup> getAllLookup() {
		return allLookup;
	}

	public void setAllLookup(List<Lookup> allLookup) {
		this.allLookup = allLookup;
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		System.out.println(menuItem);
		this.menuItem = menuItem;
	}

	public MenuItem getSelectedMenuItem() {
		return selectedMenuItem;
	}

	public void setSelectedMenuItem(MenuItem selectedMenuItem) {
		this.selectedMenuItem = selectedMenuItem;
	}

	public LazyDataModel<MenuItem> getLazyMenuItemModel() {
		return lazyMenuItemModel;
	}

	public void setLazyMenuItemModel(LazyDataModel<MenuItem> lazyMenuItemModel) {
		this.lazyMenuItemModel = lazyMenuItemModel;
	}
	
	
}

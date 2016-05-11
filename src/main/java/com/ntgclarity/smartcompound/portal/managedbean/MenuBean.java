package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Spliterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import java.util.Map;
import java.util.function.Consumer;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Lookup;
import com.ntgclarity.smartcompound.common.entity.Menu;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class MenuBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	
	private List<Menu> allMenus;
	private List<Lookup> allLookup;


	private Menu menu;
	
	
	
	private Menu selectedMenu;
	private LazyDataModel<Menu> lazyMenuModel;
	

	@PostConstruct
	public void init() {
		//loadAllMenus();
		menu= new Menu();
		loadAllLookup();
		LoadData();
		selectedMenu=new Menu();
	}
	
	private void LoadData() {
		lazyMenuModel = new LazyDataModel<Menu>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<Menu> result;

			@Override
			public Menu getRowData(String rowKey) {
				for (Menu menu : result) {
					if (menu.getId().toString().equals(rowKey))
						return menu;
				}

				return null;
			}

			@Override
			public Object getRowKey(Menu menu) {
				return menu.getId();
			}
			@Override
			public List<Menu> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				result = getSmartCompoundManagment().loadMenus(first,
						pageSize, sortField, sortOrder == SortOrder.ASCENDING,
						filters);
				this.setRowCount(getSmartCompoundManagment()
						.getNumOfMenusRows(filters));

				return result;
			}

			@Override
			public void forEach(Consumer<? super Menu> action) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Spliterator<Menu> spliterator() {
				// TODO Auto-generated method stub
				return null;
			}

		};
	}

	public void loadAllMenus() {
		// allMenus = smartCompoundManagment.getAllMenus();
	}
	
	public void loadAllLookup() {
		 allLookup = smartCompoundManagment.getAllLookup("status");
		 
		 for (Lookup curr: allLookup){
			 System.out.println(curr);
		 }
	}


	public void addMenu(){
		smartCompoundManagment.insertMenu(menu);
		menu=new Menu();
	}
	
	public void updateMenu(){
		smartCompoundManagment.updateMenu(menu);
		menu=new Menu();
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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

	public Menu getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(Menu selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	public LazyDataModel<Menu> getLazyMenuModel() {
		return lazyMenuModel;
	}

	public void setLazyMenuModel(LazyDataModel<Menu> lazyMenuModel) {
		this.lazyMenuModel = lazyMenuModel;
	}
	
	
	

}

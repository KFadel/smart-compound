package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Spliterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.SortOrder;
import org.primefaces.model.LazyDataModel;

import java.util.Map;
import java.util.function.Consumer;

import com.ntgclarity.smartcompound.common.entity.*;
import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class OrderBean extends BaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;

	private List<Facility> facilities;
	private List<Service> services;
	private List<Tenant> tenants;
	
	private Order selectedOrder;
	private LazyDataModel<Order> lazyOrderModel;


	@PostConstruct
	public void init() {
		 initiateNewOrder();
		 LoadData();
	}
	
	private void LoadData() {
		lazyOrderModel = new LazyDataModel<Order>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<Order> result;

			@Override
			public Order getRowData(String rowKey) {
				for (Order order : result) {
					if (order.getId().toString().equals(rowKey))
						return order;
				}

				return null;
			}

			@Override
			public Object getRowKey(Order order) {
				return order.getId();
			}

			@Override
			public List<Order> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				result = getSmartCompoundManagment().loadOrders(first,
						pageSize, sortField, sortOrder == SortOrder.ASCENDING,
						filters);
				this.setRowCount(getSmartCompoundManagment()
						.getNumOfOrdersRows(filters));

				return result;
			}

			@Override
			public void forEach(Consumer<? super Order> action) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Spliterator<Order> spliterator() {
				// TODO Auto-generated method stub
				return null;
			}

		};
		
	}
	
	
	public void initiateNewOrder() {
		selectedOrder = new Order();
	}
	
		
	public List<Facility> completeFacilities(String searchParam) throws SmartCompoundException {
		Compound compound = new Compound();
		compound.setId(1L);
		facilities = smartCompoundManagment.getCompoundFacilites(compound,searchParam.trim());
        return facilities;
	}

	
	public List<Tenant> completeTenant(String query) {
		Compound compound = new Compound();
		compound.setId(1L);
		tenants = smartCompoundManagment.getCompoundTenants(compound,query);
        return tenants;
	}

	
	
	public List<Service> completeServices(String query) {
		Compound compound = new Compound();
		compound.setId(1L);
		services = smartCompoundManagment.getCompoundServices(compound,query);
        return services;
	}
	


	public void insertOrder() throws SmartCompoundException{
		selectedOrder.setChannel("Portal");
//		selectedOrder.setCreatedBy(); // session
//		selectedOrder.setCompound(); //session
		selectedOrder.setRequestDate(new Date());
//		selectedOrder.setServiceLocationlattitude();
//		selectedOrder.setServiceLocationlongtude();
//		selectedOrder.setStatus("");  // need lookup
		smartCompoundManagment.insertOrder(selectedOrder);
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public Order getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(Order selectedOrder) {
		this.selectedOrder = selectedOrder;
	}

	public LazyDataModel<Order> getLazyOrderModel() {
		return lazyOrderModel;
	}

	public void setLazyOrderModel(LazyDataModel<Order> lazyOrderModel) {
		this.lazyOrderModel = lazyOrderModel;
	}
	
	public List<Facility> getFacilities() {
		return facilities;
	}


	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}


	public List<Service> getServices() {
		return services;
	}


	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}
	
	
}

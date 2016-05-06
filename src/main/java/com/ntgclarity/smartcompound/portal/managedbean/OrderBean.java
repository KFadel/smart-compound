package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.SortOrder;

import org.primefaces.model.LazyDataModel;
import java.util.Map;

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

		};
		
	}
	
	
	public void initiateNewOrder() {
		selectedOrder = new Order();
		selectedOrder.setChannel("Portal");
//		selectedOrder.setCreatedBy(); // session
//		selectedOrder.setCompound(); //session
		selectedOrder.setRequestDate(new Date());
//		selectedOrder.setServiceLocationlattitude();
//		selectedOrder.setServiceLocationlongtude();
//		selectedOrder.setStatus("");  // need lookup
	}
	
		
//	public List<Facility> initiateFacilities(String query) throws SmartCompoundException {
//		Compound compound = new Compound();
//		compound.setId((long) 1);
//		facilities = smartCompoundManagment.getCompoundFacilites(compound);
//		List<Facility> filteredFacilities = new ArrayList<Facility>();
//        
//        for (int i = 0; i < facilities.size(); i++) {
//        	Facility facility  = facilities.get(i);
//            if(facility.getBuildingNumber().toString().startsWith(query)) {  // test
//                filteredFacilities.add(facility);
//            }
//        }
//         
//        return filteredFacilities;
//	}

//	public List<String> completeTenantName(String query) {
//		Compound compound = new Compound();
//		compound.setId(1L);
//        tenants = smartCompoundManagment.getCompoundTenants(compound);
//        List<String> tenantsUsername = new ArrayList<String>();
//        for(int i = 0; i < tenants.size(); i++) {
//        	tenantsUsername.add(tenants.get(i).getUsername());
//        }
//        return tenantsUsername;
//    }
	
	public List<Tenant> completeTenant(String query) {
		Compound compound = new Compound();
		compound.setId(1L);
		tenants = smartCompoundManagment.getCompoundTenants(compound);
		List<Tenant> filteredTenant = new ArrayList<Tenant>();
        
        for (int i = 0; i < tenants.size(); i++) {
        	Tenant tenant  = tenants.get(i);
            if(tenant.getUsername().toLowerCase().startsWith(query)) {  // test
            	filteredTenant.add(tenant);
            }
        }
        return filteredTenant;
	}

	
	
	public List<Service> completeServices(String query) {
		Compound compound = new Compound();
		compound.setId(1L);
		services = smartCompoundManagment.getCompoundServices(compound);
		List<Service> filteredServices = new ArrayList<Service>();
        
        for (int i = 0; i < services.size(); i++) {
        	Service service  = services.get(i);
            if(service.getServiceName().toLowerCase().startsWith(query)) {  // test
            	filteredServices.add(service);
            }
        }
        return filteredServices;
	}
	


	public void insertOrder() throws SmartCompoundException{
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

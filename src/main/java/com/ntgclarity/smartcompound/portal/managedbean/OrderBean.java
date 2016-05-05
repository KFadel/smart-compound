package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

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

	private Order createdOrder;
	private List<Facility> facilities;
	private List<Service> services;
	

	@PostConstruct
	public void init() {
		 initiateNewOrder();
	}
	
	private void initiateNewOrder() {
		createdOrder = new Order();
		createdOrder.setChannel("Portal");
//		createdOrder.setCreatedBy(); // session
//		createdOrder.setCompoundId(); //session
		createdOrder.setRequestDate(new Date());
//		createdOrder.setServiceLocationlattitude();
//		createdOrder.setServiceLocationlongtude();
//		createdOrder.setStatus("");  // need lookup
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

	
	public List<Service> initiateServices(String query) {
		Compound compound = new Compound();
		compound.setId((long) 1);
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


	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}


	public Order getCreatedOrder() {
		return createdOrder;
	}


	public void setCreatedOrder(Order createdOrder) {
		this.createdOrder = createdOrder;
	}
	
	public void insertOrder() throws SmartCompoundException{
		smartCompoundManagment.insertOrder(createdOrder);
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
}

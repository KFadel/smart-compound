package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.SortOrder;
import org.primefaces.model.LazyDataModel;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.*;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class TicketBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	
	
	private Ticket selectedTicket;
	private LazyDataModel<Ticket> lazyTicketModel;
	
	public LazyDataModel<Ticket> getLazyTicketModel() {
		return lazyTicketModel;
	}

	public void setLazyTicketModel(LazyDataModel<Ticket> lazyTicketModel) {
		this.lazyTicketModel = lazyTicketModel;
	}

	private List<Tenant> tenants;
	
	private List<Facility> facilites;
	private List<Service> services;


	private Compound compound ;
	public Compound getCompound() {
		return compound;
	}

	public void setCompound(Compound compound) {
		this.compound = compound;
	}

	public void initiateListOfTenant() {
		tenants = new ArrayList<>();
	}

	public void initiateListOfFacility() {
		facilites = new ArrayList<>();
	}

	public void initiateListOfService() {
		services = new ArrayList<>();
	}

	

	public void initiateNewTicket() {
		selectedTicket = new Ticket();
	}

	
	public Ticket getSelectedTicket() {
		return selectedTicket;
	}

	public void setSelectedTicket(Ticket selectedTicket) {
		this.selectedTicket = selectedTicket;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}

	public List<Facility> getFacilites() {
		return facilites;
	}

	public void setFacilites(List<Facility> facilites) {
		this.facilites = facilites;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Ticket> allTickets;

	@PostConstruct
	public void init() {
		initiateNewTicket();
		
		initiateListOfService();
		initiateListOfFacility();
		tenants=getAllTenants(compound);
		services=getAllServices(compound);
		facilites=getAllFacilities(compound);
		
		LoadData();
		loadAllTickets();
	}

	public void loadAllTickets() {
		allTickets = null; // smartCompoundManagment.getAllTickets();
	}

	public void testMethod() {

		loadAllTickets();
	}

	public void printTicket() {
		System.out.println(selectedTicket);
	}

	public List<Ticket> getAllTickets() {
		return allTickets;
	}

	public void setAllTickets(List<Ticket> allTickets) {
		this.allTickets = allTickets;
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public Ticket insertTicket() {
	
		return getSmartCompoundManagment().insertTicket(selectedTicket);

	}

	public List<Tenant> getAllTenants(Compound comp) {
		return getSmartCompoundManagment().getAllTenants(comp);

	}
	public  List<Service> getAllServices(Compound comp) {
		return getSmartCompoundManagment().getAllServices(comp);

	}
	public  List<Facility> getAllFacilities(Compound comp) {
		return getSmartCompoundManagment().getAllFacilities(comp);

	}

	private void LoadData() {
		lazyTicketModel = new LazyDataModel<Ticket>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<Ticket> result;

			@Override
			public Ticket getRowData(String rowKey) {
				for (Ticket ticket : result) {
					if (ticket.getId().equals(rowKey))
						return ticket;
				}

				return null;
			}

			@Override
			public Object getRowKey(Ticket ticket) {
				return ticket.getId();
			}

			@Override
			public List<Ticket> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				result = getSmartCompoundManagment().loadTickets(first,
						pageSize, sortField, sortOrder == SortOrder.ASCENDING,
						filters);
				this.setRowCount(getSmartCompoundManagment()
						.getNumOfTicketsRows(filters));

				return result;
			}

			@Override
			public void forEach(Consumer<? super Ticket> action) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Spliterator<Ticket> spliterator() {
				// TODO Auto-generated method stub
				return null;
			}

		};

	}
	
}

package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.*;

import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class TicketBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	private List<Tenant> tenants;
	private List<Facility> facilites;
	private List<Service> services;

	private Ticket ticket;
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

	public Ticket getTicket() {
		return ticket;
	}

	public void initiateNewTicket() {
		ticket = new Ticket();
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
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
		initiateListOfTenant();
		initiateListOfService();
		initiateListOfFacility();
		tenants=getAllTenants(compound);
		services=getAllServices(compound);
		facilites=getAllFacilities(compound);
		System.out.println("services size in the bean"+services.size());
	
		loadAllTickets();
	}

	public void loadAllTickets() {
		allTickets = null; // smartCompoundManagment.getAllTickets();
	}

	public void testMethod() {

		loadAllTickets();
	}

	public void printTicket() {
		System.out.println(ticket);
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
		return getSmartCompoundManagment().insertTicket(ticket);

	}

	public List<Tenant> getAllTenants(Compound comp) {
		return getSmartCompoundManagment().getAllTenants(comp);

	}
	public  List<Service> getAllServices(Compound comp) {
		return getSmartCompoundManagment().getAllServices(comp);

	}
	public  List<Facility> getAllFacilities(Compound comp) {
		System.out.println("facilities size in the bean"+getSmartCompoundManagment().getAllFacilities(comp).size());
		return getSmartCompoundManagment().getAllFacilities(comp);

	}
	
}

package com.ntgclarity.smartcompound.business.management;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.common.entity.Compound;
import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.common.entity.Facility;
import com.ntgclarity.smartcompound.common.entity.Tenant;
import com.ntgclarity.smartcompound.common.entity.Ticket;

@Service
public interface SmartCompoundManagment {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

//	List<Ticket> getAllTickets();

	Ticket insertTicket(Ticket ticket);

	Ticket getTicket(Long long1);

	List<Tenant> getAllTenants(Compound comp);

	List<com.ntgclarity.smartcompound.common.entity.Service> getAllServices(
			Compound comp);

	List<Facility> getAllFacilities(Compound comp);



}

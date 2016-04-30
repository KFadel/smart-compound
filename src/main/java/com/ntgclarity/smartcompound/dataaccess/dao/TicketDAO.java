package com.ntgclarity.smartcompound.dataaccess.dao;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Ticket;

/**Author: Heba**/

public interface TicketDAO {

	List<Ticket> getAllTickets();

	Ticket getTicket(Long id);

	Ticket insertTicket(Ticket ticket);

	Ticket updateTicket(Ticket ticket);
	
	List<Ticket> loadTickets(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfTicketsRows(Map<String, Object> filters);

}

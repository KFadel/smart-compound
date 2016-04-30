package com.ntgclarity.smartcompound.business.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.service.TicketService;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.dataaccess.dao.TicketDAO;



/**Author: Heba**/

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO ticketDAO;
	
	@Override
	public List<Ticket> getAllTickets() {
		return ticketDAO.getAllTickets();
	}

	@Override
	public Ticket getTicket(Long id) {
		if(id !=null)
		{
			return ticketDAO.getTicket(id);
		}
		return null;
	}
	/**
	 *methodCreater:nessma 
	 *create Ticket 
	 *this metohd will call TicketDAO.insertTicket
	 
	  **/
	@Override
	public Ticket insertTicket(Ticket ticket) {
		
		return ticketDAO.insertTicket(ticket);
	}
	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDAO.updateTicket(ticket);
		
	}

	@Override
	public List<Ticket> loadTickets(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return ticketDAO.loadTickets(first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfTicketsRows(Map<String, Object> filters) {
	
		return  ticketDAO.getNumOfTicketsRows(filters);
	}


}

package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.TicketDAO;

/**Author: Heba**/

@Repository
public class TicketDAOImpl extends BaseDAO implements TicketDAO {

	@Override
	public List<Ticket> getAllTickets() {

		return (List<Ticket>) super.getAll(Ticket.class);
	}

	@Override
	public Ticket getTicket(Long id) {
		return  (Ticket) super.get(Ticket.class , id);
	}
	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return (Ticket) super.saveOrUpdate(ticket);
	}

	/**
	 *methodCreater:nessma 
	 *create Ticket 
	 *this metohd will call saveOrUpdate() in the super class BaseDAO
	 
	  **/
	@Override
	public Ticket insertTicket(Ticket ticket) {
		
		return (Ticket) super.saveOrUpdate(ticket);
		
		
	}
	@Override
	public List<Ticket> loadTickets(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
			
		return super.load(Ticket.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfTicketsRows(Map<String, Object> filters) {
		
		return super.getNumOfRows(Ticket.class,filters);
	}

}


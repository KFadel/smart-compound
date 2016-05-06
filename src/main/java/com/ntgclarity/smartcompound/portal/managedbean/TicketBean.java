package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

/**AUTHOR: HEBA**/

@ManagedBean
@SessionScoped
public class TicketBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;

	private Ticket selectedTicket;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<Ticket> lazyTicketModel;

	public Ticket initiateNewTicket(){
		selectedTicket = new Ticket();
		return selectedTicket;
	}
	
	@PostConstruct
	public void init() {
		initiateNewTicket();
		loadData();
	}

	public void loadData() {
	    lazyTicketModel = new LazyDataModel<Ticket>() {
	    	private List<Ticket> result ;
			

			private static final long serialVersionUID = 1L;

			
		    @Override
		    public Ticket getRowData(String rowKey) {
		        for(Ticket Ticket : result) {
		            if(Ticket.getId().equals(rowKey))
		                return Ticket;
		        }
		 
		        return null;
		    }
		 
		    @Override
		    public Object getRowKey(Ticket Ticket) {
		        return Ticket.getId();
		    }
			
			@Override    
	        public List<Ticket> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
				
	        	
				result= getSmartCompoundManagment().loadTickets(first,pageSize,sortField,sortOrder==SortOrder.ASCENDING,filters);
				this.setRowCount(getSmartCompoundManagment().getNumOfTicketsRows(filters));
				
				return result;
	        }
	    };

	
	}
	public LazyDataModel<Ticket> getLazyTicketModel() {
		return lazyTicketModel;
	}

	public void setLazyTicketModel(LazyDataModel<Ticket> lazyTicketModel) {
		this.lazyTicketModel = lazyTicketModel;
	}

	public SmartCompoundManagment getSmartCompoundManagment() {
		return smartCompoundManagment;
	}

	public void setSmartCompoundManagment(
			SmartCompoundManagment smartCompoundManagment) {
		this.smartCompoundManagment = smartCompoundManagment;
	}

	public Ticket getSelectedTicket() {
		return selectedTicket;
	}

	public void setSelectedTicket(Ticket selectedTicket) {
		this.selectedTicket = selectedTicket;
	}

}

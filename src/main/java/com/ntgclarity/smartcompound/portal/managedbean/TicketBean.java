package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import org.primefaces.model.SortOrder;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Map;
import org.primefaces.model.LazyDataModel;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class TicketBean extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
	private Ticket selectedTicket;
	private LazyDataModel<Ticket> lazyTicketModel;

	@PostConstruct
	public void init() {
		initiateNewTicket();
		LoadData();

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

		};

	}

	private void initiateNewTicket() {
		selectedTicket = new Ticket();

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

	public LazyDataModel<Ticket> getLazyTicketModel() {
		return lazyTicketModel;
	}

	public void setLazyTicketModel(LazyDataModel<Ticket> lazyTicketModel) {
		this.lazyTicketModel = lazyTicketModel;
	}

}

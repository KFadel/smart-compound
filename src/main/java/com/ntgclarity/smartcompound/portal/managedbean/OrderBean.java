package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

@ManagedBean
@ViewScoped
public class OrderBean  extends BaseBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{smartCompoundManagmentImpl}")
	private SmartCompoundManagment smartCompoundManagment;
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
					if (order.getId().equals(rowKey))
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

	private void initiateNewOrder() {
		selectedOrder = new Order();
		
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
	

}

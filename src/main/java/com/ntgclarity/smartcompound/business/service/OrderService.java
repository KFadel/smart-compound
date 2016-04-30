package com.ntgclarity.smartcompound.business.service;

import java.util.List;
import java.util.Map;

import com.ntgclarity.smartcompound.common.entity.Order;

public interface OrderService {

	List<Order> getAllOrders();

	Order getOrder(Long id);

	Order insertOrder(Order order);

	Order updateOrder(Order order);
	List<Order> loadOrders(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	int getNumOfOrdersRows(Map<String, Object> filters);

}

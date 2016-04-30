package com.ntgclarity.smartcompound.business.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.service.OrderService;
import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.dataaccess.dao.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	@Override
	public Order getOrder(Long id) {
		if(id !=null)
		{
			return orderDAO.getOrder(id);
		}
		return null;
	}
	/**
	 *methodCreater:nessma 
	 *create Order 
	 *this metohd will call orderDAO.insertOrder
	 
	  **/
	@Override
	public Order insertOrder(Order order) {
		
		return orderDAO.insertOrder(order);
	}
	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDAO.updateOrder(order);
		
	}

	@Override
	public List<Order> loadOrders(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return orderDAO.loadOrders(first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfOrdersRows(Map<String, Object> filters) {
	
		return  orderDAO.getNumOfOrdersRows(filters);
	}


}

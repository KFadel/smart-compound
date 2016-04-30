package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Order;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.OrderDAO;

@Repository
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

	@Override
	public List<Order> getAllOrders() {

		return (List<Order>) super.getAll(Order.class);
	}

	@Override
	public Order getOrder(Long id) {
		return  (Order) super.get(Order.class , id);
	}
	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return (Order) super.saveOrUpdate(order);
	}

	/**
	 *methodCreater:nessma 
	 *create Order 
	 *this metohd will call saveOrUpdate() in the super class BaseDAO
	 
	  **/
	@Override
	public Order insertOrder(Order order) {
		
		return (Order) super.saveOrUpdate(order);
		
		
	}
	@Override
	public List<Order> loadOrders(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
			
		return super.load(Order.class,first,pageSize,sortField,ascending,filters);
	}

	@Override
	public int getNumOfOrdersRows(Map<String, Object> filters) {
		
		return super.getNumOfRows(Order.class,filters);
	}

}

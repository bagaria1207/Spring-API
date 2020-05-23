package com.psl.oms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.oms.bean.Customer;
import com.psl.oms.bean.Inventory;
import com.psl.oms.bean.Order;
import com.psl.oms.bean.Owner;
import com.psl.oms.dao.OMSDao;

@Service("Service")
public class OMSServiceImpl implements OMSService{

	@Autowired
	OMSDao dao;

	@Override
	public Customer loginCustomer(Customer customer) {
		return dao.loginCustomer(customer);
	}

	@Override
	public Owner loginOwner(Owner owner) {
		return dao.loginOwner(owner);
	}

	@Override
	public int placeOrder(Order order) {
		return dao.placeOrder(order);
	}

	@Override
	public List<Order> trackOrder(int orderId) {
		return dao.trackOrder(orderId);
	}
	
	@Override
	public List<Order> getCustomerOrder(int custId){
		return dao.getCustomerOrder(custId);
	}

	@Override
	public List<List<Map<Object, Object>>> popularItems(int custId) {
		return dao.popularItems(custId);
	}

	@Override
	public Map<Integer, List<Order>> placedOrders() {
		return dao.placedOrders();
	}

	@Override
	public List<Inventory> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public int addProduct(String prodName, int prodQuant, int prodPrice) {
		return dao.addProduct(prodName, prodQuant, prodPrice);
	}

	@Override
	public int updateProduct(int prodId, int prodQuant) {
		return dao.updateProduct(prodId, prodQuant);
	}

	@Override
	public int delProduct(int prodId) {
		return dao.delProduct(prodId);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public List<List<Map<Object, Object>>> chartDataPoints() {
		return dao.chartDataPoints();
	}

}

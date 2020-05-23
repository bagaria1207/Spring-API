package com.psl.oms.dao;

import java.util.List;
import java.util.Map;

import com.psl.oms.bean.Customer;
import com.psl.oms.bean.Inventory;
import com.psl.oms.bean.Order;
import com.psl.oms.bean.Owner;

public interface OMSDao {
	
	public Customer loginCustomer(Customer customer);
	public Owner loginOwner(Owner owner);
	
	public int placeOrder(Order order);
	public List<Order> trackOrder(int orderId);
	public List<Order> getCustomerOrder(int custId);
	public List<List<Map<Object, Object>>> popularItems(int custId);
	
	public List<Customer> getAllCustomer();
	public Map<Integer, List<Order>> placedOrders();
	public List<Inventory> getAllProducts();
	public int addProduct(String prodName, int prodQuant, int prodPrice);
	public int updateProduct(int prodId, int prodQuant);
	public int delProduct(int prodId);
	
	public List<List<Map<Object,Object>>> chartDataPoints();

	
}

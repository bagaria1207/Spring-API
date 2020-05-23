package com.psl.oms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.psl.oms.bean.Customer;
import com.psl.oms.bean.Inventory;
import com.psl.oms.bean.Order;
import com.psl.oms.bean.Owner;


@Repository("dao")
public class OMSDaoImpl extends JdbcDaoSupport implements OMSDao{

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	public void init() {
		this.setDataSource(dataSource);
	}
	
	//CUSTOMER LOGIN
	@Override
	public Customer loginCustomer(final Customer customer) {
		String sql = "SELECT * FROM customer";
		return this.getJdbcTemplate().query(sql, new ResultSetExtractor<Customer>() {

			@Override
			public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
				Customer custAux = new Customer();
				while(rs.next()) {
					if((customer.getCustName().equals(rs.getString(2))) && (customer.getCustPass().equals(rs.getString(4)))){
						custAux.setCustId(rs.getInt(1));
						custAux.setCustName(rs.getString(2));
						custAux.setCustAddr(rs.getString(3));
						custAux.setCustPass(rs.getString(4));
						custAux.setOrder(getCustomerOrder(custAux.getCustId()));
					}
				}
				return custAux;
			}
			
		});
	}
	
	@Override
	public List<Order> getCustomerOrder(int custId){
		String sql = "SELECT * FROM orders WHERE custId=?";
		
		return this.getJdbcTemplate().query(sql, new Object[] {custId}, new ResultSetExtractor<List<Order>>() {
			List<Order> custOrderList = new ArrayList<Order>();
			@Override
			public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Order o = new Order();
					o.setOrdId(rs.getInt(1));
					o.setCustId(rs.getInt(2));
					o.setProdName(rs.getString(3));
					o.setProdQuant(rs.getInt(4));
					custOrderList.add(o);
				}
				return custOrderList;
			}
			
		});
	}
	
	//OWNER LOGIN
	@Override
	public Owner loginOwner(final Owner owner) {
		String sql = "SELECT * FROM owner";
		return this.getJdbcTemplate().query(sql, new ResultSetExtractor<Owner>() {
			
			@Override
			public Owner extractData(ResultSet rs) throws SQLException, DataAccessException {
				Owner ownAux = new Owner();
				while(rs.next()) {
					if((owner.getOwnerName().equals(rs.getString(2))) && (owner.getOwnerPass().equals(rs.getString(3)))){
						ownAux.setOwnerId(rs.getInt(1));
						ownAux.setOwnerName(rs.getString(2));
						ownAux.setOwnerPass(rs.getString(3));
					}
				}
				return ownAux;
			}
			
		});
	}
	
	//CUSTOMER PLACING ORDER
	@Override
	public int placeOrder(Order order) {
		String sql = "INSERT INTO orders values(?,?,?,?)";
		return this.getJdbcTemplate().update(sql, new Object[] {order.getOrdId(), order.getCustId(),
				order.getProdName(), order.getProdQuant()});
	}

	//CUSTOMER TRACKING ORDER
	@Override
	public List<Order> trackOrder(int orderId) {
		
		String sql = "SELECT * FROM orders where orderId=?";
		return this.getJdbcTemplate().query(sql, new Object[]{orderId}, new ResultSetExtractor<List<Order>>() {
			List<Order> orderList = new ArrayList<Order>();
			
			@Override
			public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Order o = new Order();
					o.setOrdId(rs.getInt(1));
					o.setCustId(rs.getInt(2));
					o.setProdName(rs.getString(3));
					o.setProdQuant(rs.getInt(4));
					orderList.add(o);
				}
				return orderList;
			}
			
		});
		
	}

	//OWNER LIST OF ORDERS PLACED
	@Override
	public Map<Integer, List<Order>> placedOrders() {
		String sql = "SELECT * FROM orders";
		return this.getJdbcTemplate().query(sql, new ResultSetExtractor<Map<Integer, List<Order>>>(){
			Map<Integer, List<Order>> orders = new HashMap<Integer, List<Order>>();
			
			@Override
			public Map<Integer, List<Order>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					Order o = new Order();
					o.setOrdId(rs.getInt(1));
					o.setCustId(rs.getInt(2));
					o.setProdName(rs.getString(3));
					o.setProdQuant(rs.getInt(4));
					if(!orders.containsKey(o.getOrdId())) {
						List<Order> order = new ArrayList<Order>();
						order.add(o);
						orders.put(o.getOrdId(), order);
					}
					else {
						orders.get(o.getOrdId()).add(o);
					}
				}
				return orders;
			}
			
		});
	}

	//CUSTOMER can choose products to order from it or OWNER can check his/her INVENTORY of items
	@Override
	public List<Inventory> getAllProducts() {
		String sql = "SELECT * FROM inventory";
		
		return this.getJdbcTemplate().query(sql, new ResultSetExtractor<List<Inventory>>(){
			List<Inventory> inventory = new ArrayList<Inventory>();

			@Override
			public List<Inventory> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Inventory inv = new Inventory();
					inv.setProdId(rs.getInt(1));
					inv.setProdName(rs.getString(2));
					inv.setProdQuant(rs.getInt(3));
					inv.setProdPrice(rs.getInt(4));
					inventory.add(inv);
				}
				return inventory;
			}
			
		});
		
	}
	
	@Override
	public List<Customer> getAllCustomer(){
		String sql = "SELECT * FROM customer";
		return this.getJdbcTemplate().query(sql, new ResultSetExtractor<List<Customer>>() {
			List<Customer> customerList = new ArrayList<Customer>();
			@Override
			public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Customer c = new Customer();
					c.setCustId(rs.getInt(1));
					c.setCustName(rs.getString(2));
					c.setCustAddr(rs.getString(3));
					c.setCustPass(rs.getString(4));
					c.setOrder(null);
					customerList.add(c);
				}
				return customerList;
			}
			
		});
		
	}

	//OWNER can add Products to his shops INVENTORY
	@Override
	public int addProduct(String prodName, int prodQuant, int prodPrice) {
		String sql = "INSERT INTO inventory(prodName, prodQuant, prodPrice) values(?,?,?)";
		return this.getJdbcTemplate().update(sql, new Object[] {prodName, prodQuant, prodPrice});
	}

	//OWNER can update the amount of products in his inventory
	@Override
	public int updateProduct(int prodId, int prodQuant) {
		String sql = "UPDATE inventory set prodQuant=? WHERE prodId=?";
		return this.getJdbcTemplate().update(sql, new Object[] {prodQuant, prodId});
	}

	//OWNER can delete products from his inventory
	@Override
	public int delProduct(int prodId) {
		String sql = "DELETE FROM inventory where prodId=?";
		return this.getJdbcTemplate().update(sql, new Object[] {prodId});
	}

	@Override
	public List<List<Map<Object, Object>>> popularItems(int custId) {
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints =  new ArrayList<Map<Object,Object>>();
		System.out.println(custId);
		Map<String, Integer> mapOrder = getAllOrderCustomer(custId);
		int z = 0;
		for(String key : mapOrder.keySet()) {
			z+=mapOrder.get(key);
		}
		for(String key : mapOrder.keySet()) {
			map = new HashMap<Object,Object>();
			map.put("name", key);
			int aux = (mapOrder.get(key)*100)/z;
			map.put("y", aux);
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	
	public Map<String, Integer> getAllOrderCustomer(int custId){
		
		String sql = "SELECT * FROM orders WHERE custId=?";
		return this.getJdbcTemplate().query(sql, new Object[]{custId}, new ResultSetExtractor<Map<String, Integer>>(){
			Map<String, Integer> allOrder = new HashMap<String, Integer>();
			
			@Override
			public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()){
					String s = rs.getString(3);
					if(!allOrder.containsKey(s)) {
						allOrder.put(s, rs.getInt(4));
					}
					else {
						int aux = allOrder.get(s)+rs.getInt(4);
						allOrder.replace(s, allOrder.get(s), aux);
					}
				}
				System.out.println(allOrder);
				return allOrder;
			}
			
		});
	}
	
	@Override
	public List<List<Map<Object, Object>>> chartDataPoints() {
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints =  new ArrayList<Map<Object,Object>>();
		Map<String, Integer> mapOrder = getAllOrder();
		int z = 0;
		for(String key : mapOrder.keySet()) {
			z+=mapOrder.get(key);
		}
		for(String key : mapOrder.keySet()) {
			map = new HashMap<Object,Object>();
			map.put("name", key);
			int aux = (mapOrder.get(key)*100)/z;
			map.put("y", aux);
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}

	public Map<String, Integer> getAllOrder(){
		
		String sql="SELECT * FROM orders";
		return this.getJdbcTemplate().query(sql, new ResultSetExtractor<Map<String, Integer>>(){
			Map<String, Integer> mapOrder = new HashMap<String, Integer>();
			
			@Override
			public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					String s = rs.getString(3);
					if(!mapOrder.containsKey(s)) {
						mapOrder.put(s, rs.getInt(4));
					}
					else {
						int aux = mapOrder.get(s)+rs.getInt(4);
						mapOrder.replace(s, mapOrder.get(s), aux);
					}
				}
				return mapOrder;
			}
			
		});
		
	}	
		
}

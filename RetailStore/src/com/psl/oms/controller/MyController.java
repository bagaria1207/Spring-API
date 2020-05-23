package com.psl.oms.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psl.oms.bean.Customer;
import com.psl.oms.bean.Inventory;
import com.psl.oms.bean.Order;
import com.psl.oms.bean.Owner;
import com.psl.oms.service.OMSService;


@Controller
public class MyController {
	
	@Autowired 
	OMSService service;
	
	
	@RequestMapping("customer")
	public String gotoCustomerLoginPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("newCustomer", customer);
		return "customerlogin";
	}
	
	@RequestMapping("checkCustomer")
	public String validateCustomer(@ModelAttribute("newCustomer") @Valid Customer customer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "checkCustomer";
		}
		else {
			Customer cust = service.loginCustomer(customer);
			if(cust==null) {
				return "checkCustomer";
			}
			else {
				model.addAttribute("loginCustomer", cust);
				return "customerdash";
			}
		}
	}
	
	@RequestMapping("popularProducts")
	public String gotoPopularProducts(@RequestParam("custId") int custId, Model model) {
		System.out.println(custId);
		List<List<Map<Object,Object>>> dataPoints = service.popularItems(custId);
		model.addAttribute("dataPointsList", dataPoints);
		model.addAttribute("customerId", custId);
		return "popularProductPage";
	}
	
	@RequestMapping("owner")
	public String gotoOwnerLoginPage(Model model) {
		Owner owner = new Owner();
		model.addAttribute("newOwner", owner);
		return  "ownerlogin";
	}
		
	@RequestMapping("checkOwner")
	public String validateOwner(@ModelAttribute("newOwner") @Valid Owner owner, BindingResult result) {
		if(result.hasErrors()) {
			return "checkOwner";
		}
		else {
			Owner own = service.loginOwner(owner);
			if(own==null) {
				return "checkOwner";
			}
			else {
				return "ownerdash";
			}
		}
	}
	
	@RequestMapping("placedOrder")
	public String allPlacedOrder(@RequestParam("custId") int custId, Model model) {
		List<Order> listPlacedOrder = service.getCustomerOrder(custId);
		model.addAttribute("customerId", custId);
		model.addAttribute("listPlacedOrder", listPlacedOrder);
		return "allPlacedOrderPage";
	}
	
	@RequestMapping("newOrder")
	public String placeNewOrder(Model model) {
		Order ord = new Order();
		model.addAttribute("nOrder", ord);
		model.addAttribute("customerId", ord.getCustId());
		return "placeNewOrderPage";
	}
	
	@RequestMapping("placingNewOrder")
	public String orderAux(@ModelAttribute("nOrder") @Valid Order order, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "placingNewOrder";
		}
		else {
			int a = service.placeOrder(order);
			if(a==0) {
				return "placingNewOrder";
			}
			else {
				List<Order> newList = service.getCustomerOrder(order.getCustId());
				model.addAttribute("listPlacedOrder", newList);
				model.addAttribute("customerId", order.getCustId());
				return "allPlacedOrderPage";
			}
		}
	}
	
	@RequestMapping("customerLogout")
	public String logoutFromCustomer() {
		return "index";
	}
	
	@RequestMapping("returntoCustomerDashboard")
	public String customerDash(@RequestParam("custId") int custId, Model model) {
		List<Order> pOrder = service.getCustomerOrder(custId);
		model.addAttribute("listPlacedOrder", pOrder);
		return "customerdash";
	}
	
	@RequestMapping("ownerTracker")
	public String getAllPlacedOrder(Model model) {
		Map<Integer, List<Order>> allOrders = service.placedOrders();
		model.addAttribute("placedOrders", allOrders);
		return "ownerPlacedOrder";
	}
	
	@RequestMapping("manageInventory")
	public String gotoInventory(Model model) {
		List<Inventory> inv = service.getAllProducts();
		model.addAttribute("invList", inv);
		return "inventory";
	}
	
	@RequestMapping("customerDetail")
	public String customerDetails(Model model) {
		List<Customer> allCustomer = service.getAllCustomer();
		List<List<Map<Object,Object>>> dataPoints = service.chartDataPoints();
		model.addAttribute("allCustomerList", allCustomer);
		return "allcustomer";
	}
	
	@RequestMapping("manageBussiness")
	public String bussinessModule() {
		return "bussiness";
	}
	
	@RequestMapping("monthly")
	public String getMonthlyInsights(Model model) {
		List<List<Map<Object,Object>>> dataPoints = service.chartDataPoints();
		model.addAttribute("dataPointsList", dataPoints);
		return "month";
	}
	
	@RequestMapping("Quarterly")
	public String getQuarterlyInsights(Model model) {
		List<List<Map<Object,Object>>> dataPoints = service.chartDataPoints();
		model.addAttribute("dataPointsList", dataPoints);
		return "quarter";
	}
	
	@RequestMapping("Yearly")
	public String getYearlyInsights(Model model) {
		List<List<Map<Object,Object>>> dataPoints = service.chartDataPoints();
		model.addAttribute("dataPointsList", dataPoints);
		return "year";
	}
	
	@RequestMapping("ownerLogout")
	public String logoutFromOwner() {
		return "index";
	}
	
	@RequestMapping("getToOwnerDash")
	public String OwnerDash() {
		return "ownerdash";
	}
	
	@RequestMapping("backInventory")
	public String backToInventoryPage() {
		return "inventory";
	}
	
	@RequestMapping("addToInventory")
	public String gotoAddInventoryPage(Model model) {
		Inventory inv = new Inventory();
		model.addAttribute("newProd", inv);
		return "addproductInventory";
	}	
	
	@RequestMapping("addingNewProduct")
	public String addToInventory(@ModelAttribute("newProd") @Valid Inventory inventory, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addingNewProduct";
		}
		else {
			int a = service.addProduct(inventory.getProdName(), inventory.getProdQuant(), inventory.getProdPrice());
			if(a==0) {
				return "addingNewProduct";
			}
			else {
				List<Inventory> inv = service.getAllProducts();
				model.addAttribute("invList", inv);
				return "inventory";
			}
		}
	}
	
	@RequestMapping("updateInInventory")
	public String gotoUpdateInventory(Model model) {
		Inventory inv = new Inventory();
		model.addAttribute("updatedProd", inv);
		return "updateInventory";
	}
	
	@RequestMapping("updatingProduct")
	public String updateInventory(@ModelAttribute("updatedProd") @Valid Inventory inventory, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "updatingProduct";
		}
		else {
			int a = service.updateProduct(inventory.getProdId(), inventory.getProdQuant());
			if(a==0) {
				return "updatingProduct";
			}
			else {
				List<Inventory> inv = service.getAllProducts();
				model.addAttribute("invList", inv);
				return "inventory";
			}
		}
	}
	
	@RequestMapping("deleteProductFromInventory")
	public String gotodeleteFromInventory(Model model) {
		Inventory inv = new Inventory();
		model.addAttribute("deleteProd", inv);
		return "deleteFromInventory";
	}
	
	@RequestMapping("deletingProduct")
	public String deleteProduct(@ModelAttribute("deleteProd") @Valid Inventory inventory, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "deletingProduct";
		}
		else {
			int a = service.delProduct(inventory.getProdId());
			if(a==0) {
				return "deletingProduct";
			}
			else {
				List<Inventory> inv = service.getAllProducts();
				model.addAttribute("invList", inv);
				return "inventory";
			}
		}
	}
		
}

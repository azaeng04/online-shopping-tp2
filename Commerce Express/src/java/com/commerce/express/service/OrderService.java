package com.commerce.express.service;

import com.commerce.express.domain.Customer;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Owner
 */
public interface OrderService {

    public List<Orders> getOrders(String customerID);

    public Integer getUniqueOrderNumber();

    public void checkout(Map<String, String> cart, Customer customer);

    public String orderTable(List<Orders> orders);

    public List<Product> getProducts(String orderNumber);

    public List<OrderLine> getOrderLine(String orderNumber);
    
    public String displayProductsOnOrder(String orderID);

    public List<Orders> getAllOrders();
}

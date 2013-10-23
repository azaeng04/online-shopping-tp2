/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.app.factory.OrderLineFactory;
import com.commerce.express.app.factory.OrdersFactory;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import com.commerce.express.service.OrderService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    private static CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    private static CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    private static OrderServiceImpl orderServiceImpl;

    private OrderServiceImpl() {
    }

    public synchronized static OrderServiceImpl getInstance() {
        if (orderServiceImpl == null) {
            orderServiceImpl = new OrderServiceImpl();
        }
        return orderServiceImpl;
    }

    @Override
    public List<Orders> getOrders(String customerID) {
        Customer customer = commerceExpressCRUD.getCustomerCrudService().getByPropertyName("userID", customerID);
        List<Orders> orders = customer.getOrders();
        return orders;
    }

    @Override
    public Integer getUniqueOrderNumber() {
        Random random = new Random();
        Integer randomNumber = commerceExpressServices.getGeneralService().generateRandomNumber(10000, 99999, random);
        Orders orders1;
        Boolean isFound = true;
        while (isFound) {
            orders1 = commerceExpressCRUD.getOrdersCrudService().getByPropertyName("orderID", "ORD_" + randomNumber);
            if (orders1 != null) {
                randomNumber = commerceExpressServices.getGeneralService().generateRandomNumber(10000, 99999, random);
            } else {
                isFound = false;
            }
        }
        return randomNumber;
    }

    @Override
    public void checkout(Map<String, String> cart, Customer customer) {
        List<Orders> orders = commerceExpressServices.getOrderService().getOrders(customer.getUserID());
        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        String uniqueID;
        Product product;
        OrderLine item;
        Orders order;
        String productID;
        String quantity;
        for (Map.Entry<String, String> entry : cart.entrySet()) {
            productID = entry.getKey();
            quantity = entry.getValue();
            product = commerceExpressCRUD.getProductCrudService().findById(Long.parseLong(productID));
            uniqueID = commerceExpressServices.getOrderLineService().getUniqueOrderLineNumber().toString();
            item = OrderLineFactory.getOrderLine(uniqueID, Integer.parseInt(quantity), product);
            orderLine.add(item);
        }
        uniqueID = commerceExpressServices.getOrderService().getUniqueOrderNumber().toString();
        Date date = new DateTime().toDate();
        order = new OrdersFactory.Builder(uniqueID)
                .setDateCreated(new SimpleDateFormat("EEEE dd MMM YYYY HH:mm:ss").format(date))
                .setDateModified(new SimpleDateFormat("EEEE dd MMM YYYY HH:mm:ss").format(date))
                .setOrderLines(orderLine)
                .setStatus("Pending Delivery")
                .buildOrder();
        orders.add(order);
        customer.setOrders(orders);
        commerceExpressCRUD.getCustomerCrudService().merge(customer);
    }

    @Override
    public String orderTable(List<Orders> orders) {
        String table;
        if (!orders.isEmpty()) {
            table = "<table class='table table-bordered table-hover'>";
            table += "<th>Order ID</th>";
            table += "<th>Date created</th>";
            table +="<th>Date Modified</th>";
            table += "<th>Order Status</th>";
            table += "<tr>";
            table += "<td colspan='3' style='text-align: right'>Number of Orders</td>";
            table += "<td>" + orders.size() + "</td>";
            table += "<tr>";
            for (Orders order : orders) {
                table += "<tr>";
                table += "<td><a href='orderID=" + order.getOrderID() + "'>"+order.getOrderID()+"</a></td>";
                table += "<td>" + order.getDateCreated() + "</td>";
                table += "<td>" + order.getDateModified() + "</td>";
                table += "<td>" + order.getStatus() + "</td>";
                table += "</tr>";
            }
            table += "<tr>";
            table += "<td colspan='3' style='text-align: right'>Number of Orders</td>";
            table += "<td>" + orders.size() + "</td>";
            table += "<tr>";
            table += "</table>";
        } else {
            table = "<label>No orders made</label>";
        }
        return table;
    }

    @Override
    public List<Product> getProducts(String orderNumber) {
        Orders order = commerceExpressCRUD.getOrdersCrudService().getByPropertyName("orderID", orderNumber);
        List<Product> products = new ArrayList<Product>();
        List<OrderLine> orderLines = order.getOrderLines();
        for (OrderLine orderLine : orderLines) {
            products.add(orderLine.getProduct());
        }
        return products;
    }

    @Override
    public List<OrderLine> getOrderLines(String orderNumber) {
        Orders order = commerceExpressCRUD.getOrdersCrudService().getByPropertyName("orderID", orderNumber);
        return order.getOrderLines();
    }
}
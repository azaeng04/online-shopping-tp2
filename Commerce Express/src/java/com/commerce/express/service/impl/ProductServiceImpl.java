/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CustomerFacade;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Customer;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.service.ProductService;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.ProductCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCrudService productCrudService;
    @Autowired
    private CategoryCrudService categoryCrudService;
    private CustomerFacade customerFacade = CustomerFacade.getCustomerFacadeInstance();
    private static ProductServiceImpl productServiceImpl;
    
    private ProductServiceImpl() {
    }
    
    public synchronized static ProductServiceImpl getInstance() {
        if (productServiceImpl == null) {
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    @Override
    public void updateInStock() {        
        List<Customer> customers = customerFacade.getCustomerCrudService().findAll();
        for (Customer customer : customers) {
            List<Orders> orders = customer.getOrders();
            if (!orders.isEmpty()) {
                for (Orders orders1 : orders) {
                    List<OrderLine> productsOnOrder = orders1.getOrderLines();
                    for (OrderLine productOrdered : productsOnOrder) {
                        Long productID = productOrdered.getProduct().getId();
                        Product product = productCrudService.findById(productID);
                        
                        ProductStatus productStatus = product.getProductStatus();
                        Integer currentInStockOfProduct = productStatus.getInStock();
                        Integer amountOrderedOfProduct = productOrdered.getQuantity();
                        Integer inStockOfProductNow = currentInStockOfProduct - amountOrderedOfProduct;
                        
                        productStatus.setInStock(inStockOfProductNow);
                        product.setProductStatus(productStatus);
                        productCrudService.merge(product);
                    }
                }
            }
        }
    }

    @Override
    public List<Product> getProducts(Long categoryID) {
        Category category = categoryCrudService.findById(categoryID);
        List<Product> products = category.getProducts();
        return products;
    }
}
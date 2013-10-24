/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.service.impl;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.OrderLine;
import com.commerce.express.domain.Orders;
import com.commerce.express.domain.Product;
import com.commerce.express.domain.ProductStatus;
import com.commerce.express.service.ProductService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Owner
 */
@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    private static CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
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
    public void updateInStock(String orderID) {
        Orders order = commerceExpressCRUD.getOrdersCrudService().getByPropertyName("orderID", orderID);
        List<OrderLine> productsOnOrder = order.getOrderLines();
        for (OrderLine productOrdered : productsOnOrder) {
            Long productID = productOrdered.getProduct().getId();
            Product product = commerceExpressCRUD.getProductCrudService().findById(productID);

            ProductStatus productStatus = product.getProductStatus();
            Integer currentInStockOfProduct = productStatus.getInStock();
            Integer amountOrderedOfProduct = productOrdered.getQuantity();
            Integer inStockOfProductNow = currentInStockOfProduct - amountOrderedOfProduct;

            productStatus.setInStock(inStockOfProductNow);
            product.setProductStatus(productStatus);
            commerceExpressCRUD.getProductCrudService().merge(product);
        }
    }

    @Override
    public List<Product> getProducts(Long categoryID) {
        Category category = commerceExpressCRUD.getCategoryCrudService().findById(categoryID);
        List<Product> products = category.getProducts();
        return products;
    }
}
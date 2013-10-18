/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.facade;

import com.commerce.express.app.config.GetContext;
import com.commerce.express.service.crud.AccessDetailsCrudService;
import com.commerce.express.service.crud.AddressCrudService;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.CustomerCrudService;
import com.commerce.express.service.crud.FAQCrudService;
import com.commerce.express.service.crud.OrderLineCrudService;
import com.commerce.express.service.crud.OrdersCrudService;
import com.commerce.express.service.crud.ProductCrudService;
import com.commerce.express.service.crud.RatingCrudService;
import com.commerce.express.service.crud.RolesCrudService;
import com.commerce.express.service.crud.UsersCrudService;
import com.commerce.express.service.crud.WishListCrudService;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author om95446
 */
public class CommerceExpressCRUD {
    private static CommerceExpressCRUD commerceExpressCRUD;
    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private CategoryCrudService categoryCrudService;
    private ProductCrudService productCrudService;
    private CustomerCrudService customerCrudService;
    private OrdersCrudService ordersCrudService;
    private OrderLineCrudService orderLineCrudService;
    private AccessDetailsCrudService accessDetailsCrudService;
    private AddressCrudService addressCrudService;
    private FAQCrudService fAQCrudService;
    private RatingCrudService ratingCrudService;
    private RolesCrudService rolesCrudService;
    private UsersCrudService usersCrudService;
    private WishListCrudService wishListCrudService;
    
    private CommerceExpressCRUD() {
    }
    
    public static synchronized CommerceExpressCRUD getCommerceExpressCRUD(){
        if (commerceExpressCRUD == null) {
            commerceExpressCRUD = new CommerceExpressCRUD();
        }
        return commerceExpressCRUD;
    }
    
    public WishListCrudService getWishListCrudService() {
        wishListCrudService = (WishListCrudService) ctx.getBean("WishListCrudService");
        return wishListCrudService;
    }
    
    public AddressCrudService getAddressCrudService() {
        addressCrudService = (AddressCrudService) ctx.getBean("AddressCrudService");
        return addressCrudService;
    }
    
    public FAQCrudService getFAQCrudService() {
        fAQCrudService = (FAQCrudService) ctx.getBean("FAQCrudService");
        return fAQCrudService;
    }
    
    public RatingCrudService getRatingCrudService() {
        ratingCrudService = (RatingCrudService) ctx.getBean("RatingCrudService");
        return ratingCrudService;
    }
    
    public OrdersCrudService getOrdersCrudService() {
        ordersCrudService = (OrdersCrudService) ctx.getBean("OrdersCrudService");
        return ordersCrudService;
    }
    
    public RolesCrudService getRolesCrudService() {
        rolesCrudService = (RolesCrudService) ctx.getBean("RolesCrudService");
        return rolesCrudService;
    }
    
    public UsersCrudService getUsersCrudService() {
        usersCrudService = (UsersCrudService) ctx.getBean("UsersCrudService");
        return usersCrudService;
    }
    
    public CustomerCrudService getCustomerCrudService() {
        customerCrudService = (CustomerCrudService) ctx.getBean("CustomerCrudService");
        return customerCrudService;
    }
    
    public OrderLineCrudService getOrderLineCrudService() {
        orderLineCrudService = (OrderLineCrudService) ctx.getBean("OrderLineCrudService");
        return orderLineCrudService;
    }
    
    public AccessDetailsCrudService getAccessDetailsCrudService() {
        accessDetailsCrudService = (AccessDetailsCrudService) ctx.getBean("AccessDetailsCrudService");
        return accessDetailsCrudService;
    }
    
    public ProductCrudService getProductCrudService() {
        productCrudService = (ProductCrudService) ctx.getBean("ProductCrudService");
        return productCrudService;
    }
    
    public CategoryCrudService getCategoryCrudService() {
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        return categoryCrudService;
    }
}

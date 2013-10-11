/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.app.facade;

import com.commerce.express.app.config.GetContext;
import com.commerce.express.service.crud.BrandCrudService;
import com.commerce.express.service.crud.CategoryCrudService;
import com.commerce.express.service.crud.ProductCrudService;
import java.io.Serializable;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Ronalds
 */
public class CategoryFacade implements Serializable {
    private static CategoryFacade categoryFacade;
    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private CategoryCrudService categoryCrudService;
    private ProductCrudService productCrudService;
    private BrandCrudService brandCrudService;

    private CategoryFacade() {
    }

    public static synchronized CategoryFacade getCategoryFacadeInstance(){
        if (categoryFacade == null) {
            categoryFacade = new CategoryFacade();
        }
        return categoryFacade;
    }
    
    public ProductCrudService getProductCrudService() {
        productCrudService = (ProductCrudService) ctx.getBean("ProductCrudService");
        return productCrudService;
    }
    
    public CategoryCrudService getCategoryCrudService() {
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        return categoryCrudService;
    }
    
    public BrandCrudService getBrandCrudService() {
        brandCrudService = (BrandCrudService) ctx.getBean("BrandCrudService");
        return brandCrudService;
    }
}

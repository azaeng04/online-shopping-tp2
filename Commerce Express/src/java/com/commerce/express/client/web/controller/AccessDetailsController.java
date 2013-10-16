/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;

import com.commerce.express.app.facade.CategoryFacade;
import com.commerce.express.client.web.model.AccessDetailsModel;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Shannon
 */
@Controller
public class AccessDetailsController {

    private static CategoryFacade categoryFacade = CategoryFacade.getCategoryFacadeInstance();

//    @RequestMapping(value = "homepagedependentonrole")
//    public String home(@ModelAttribute("AccessDetailsModel") AccessDetailsModel accessDetailsModel, Model model) {
//        List<Product> products = categoryFacade.getProductCrudService().findAll();
//        categoryModel(model);
//        String username = accessDetailsModel.getUsername();
//        String password = accessDetailsModel.getPassword();
//        String page = "browser/index";
//        if (username.equals("shannon") && password.equals("weir")) {
//            page = "customer/index";
//        }
//        model.addAttribute("products", products);
//        model.addAttribute("active", "/");
//        return page;
//    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "/customer/index";
    }
    
    @RequestMapping(value = "/logout")
    public String home(Model model) {
        categoryModel(model);        
        return "redirect:/";
    }
    
    private void categoryModel(Model model) {
        List<Category> categories = categoryFacade.getCategoryCrudService().findAll();
        model.addAttribute("categories", categories);
    }
}

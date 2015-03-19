/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author om95446
 */
@Controller
public class HomeController {

    private static CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    private static CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        categoryModel(model);
        List<Product> products = commerceExpressCRUD.getProductCrudService().findAll();
        model.addAttribute("products", products);
        model.addAttribute("active", "/");
        model.addAttribute("title", "Home");
        model.addAttribute("categoryName", "All Categories");
        return "browser/index";
    }

    @RequestMapping(value = "/categoryID={id}", method = RequestMethod.GET)
    public String categorySelected(@PathVariable("id") Long id, Model model) {
        categoryModel(model);
        List<Product> products = commerceExpressServices.getProductService().getProducts(id);
        Category category = commerceExpressCRUD.getCategoryCrudService().findById(id);
        model.addAttribute("categoryName", category.getCategoryName());
        model.addAttribute("products", products);
        model.addAttribute("title", "Products in Category");
        model.addAttribute("categoryName", category.getCategoryName());
        return "browser/categorySelected";
    }

    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String aboutUs(Model model) {
        categoryModel(model);
        model.addAttribute("title", "About Us");
        model.addAttribute("active", "aboutus");
        return "browser/aboutus";
    }

    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public String contactUs(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Contact Us");
        model.addAttribute("active", "contactus");
        return "browser/contactus";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Help");
        model.addAttribute("active", "help");
        return "browser/help";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Sign Up");
        model.addAttribute("active", "signup");
        return "browser/signup";
    }

    private void categoryModel(Model model) {
        List<Category> categories = commerceExpressCRUD.getCategoryCrudService().findAll();
        model.addAttribute("categories", categories);
    }

    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String createCustomer() {
        
        return "browser/createCustomer";
    }
}

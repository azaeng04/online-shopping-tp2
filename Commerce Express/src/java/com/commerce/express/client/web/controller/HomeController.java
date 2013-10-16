/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;

import com.commerce.express.app.facade.CategoryFacade;
import com.commerce.express.domain.Category;
import com.commerce.express.domain.Product;
import com.commerce.express.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService productService;
    private static CategoryFacade categoryFacade = CategoryFacade.getCategoryFacadeInstance();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        categoryModel(model);

        List<Product> products = categoryFacade.getProductCrudService().findAll();

        model.addAttribute("products", products);
        model.addAttribute("active", "/");
        model.addAttribute("title", "Home");

        return "browser/index";
    }

    @RequestMapping(value = "/categoryID={id}", method = RequestMethod.GET)
    public String categorySelected(@PathVariable("id") Long id, Model model) {
        categoryModel(model);
        List<Product> products = productService.getProducts(id);
        model.addAttribute("products", products);
        model.addAttribute("title", "Products in Category");

        return "browser/categorySelected";
    }
    
    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String aboutUs(Model model) {
        categoryModel(model);
//                modelAndView.setViewName("browser/aboutus");
//        Product p = new Product();
//        p.setDescription("R500");
//        p.setId(new Long(743764364));
//        p.setImageURL("");
//        p.setProductName("bread");
//        p.setProductStatus(null);
//        List<Product> products = new ArrayList<Product>();
//        products.add(p);
//        products.add(p);
//        products.add(p);
//        modelAndView.addObject(products);
//        return modelAndView;
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
    
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        categoryModel(model);
//        model.addAttribute("title", "Login");
//        model.addAttribute("active", "login");
//        return "browser/login";
//    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Sign Up");
        model.addAttribute("active", "signup");
        return "browser/signup";
    }

    private void categoryModel(Model model) {
        List<Category> categories = categoryFacade.getCategoryCrudService().findAll();
        model.addAttribute("categories", categories);
    }
}

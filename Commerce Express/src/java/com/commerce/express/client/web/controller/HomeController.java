/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;

import com.commerce.express.domain.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author om95446
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        Product p = new Product();
        p.setDescription("R500");
        p.setId(new Long(743764364));
        p.setImageURL("resources/images/product.jpg");
        p.setProductName("bread");
        p.setProductStatus(null);
        List<Product> products = new ArrayList<Product>();
        products.add(p);
        products.add(p);
        products.add(p);
        List<Product> productRow1 = new ArrayList<Product>();
        model.addAttribute("products", products);

        return "browser/index";
    }

    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String aboutUs(ModelAndView modelAndView) {
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
        return "browser/aboutus";
    }

    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public String contactUs(Model model) {
        return "browser/contactus";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(Model model) {
        return "browser/help";
    }

    @RequestMapping(value = "/babyitems", method = RequestMethod.GET)
    public String babyitems(Model model) {
        return "browser/babyitems";
    }

    @RequestMapping(value = "/bakery", method = RequestMethod.GET)
    public String bakery(Model model) {
        return "browser/bakery";
    }

    @RequestMapping(value = "/bakinggoods", method = RequestMethod.GET)
    public String bakinggoods(Model model) {
        return "browser/bakinggoods";
    }

    @RequestMapping(value = "/beverages", method = RequestMethod.GET)
    public String beverages(Model model) {
        return "browser/beverages";
    }

    @RequestMapping(value = "/cannedgoods", method = RequestMethod.GET)
    public String cannedGoods(Model model) {
        return "browser/cannedgoods";
    }

    @RequestMapping(value = "/cleaners", method = RequestMethod.GET)
    public String cleaners(Model model) {
        return "browser/cleaners";
    }

    @RequestMapping(value = "/dairy", method = RequestMethod.GET)
    public String dairy(Model model) {
        return "browser/dairy";
    }

    @RequestMapping(value = "/drygoods", method = RequestMethod.GET)
    public String drygoods(Model model) {
        return "browser/drygoods";
    }

    @RequestMapping(value = "/frozenfoods", method = RequestMethod.GET)
    public String frozenfoods(Model model) {
        return "browser/frozenfoods";
    }

    @RequestMapping(value = "/meat", method = RequestMethod.GET)
    public String meat(Model model) {
        return "browser/meat";
    }

    @RequestMapping(value = "/papergoods", method = RequestMethod.GET)
    public String papergoods(Model model) {
        return "browser/papergoods";
    }

    @RequestMapping(value = "/personalcare", method = RequestMethod.GET)
    public String personalcare(Model model) {
        return "browser/personalcare";
    }

    @RequestMapping(value = "/produce", method = RequestMethod.GET)
    public String produce(Model model) {
        return "browser/produce";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "browser/login";
    }

    @RequestMapping(value = "/snacks", method = RequestMethod.GET)
    public String snacks(Model model) {
        return "browser/snacks";
    }

    @RequestMapping(value = "/spices", method = RequestMethod.GET)
    public String spices(Model model) {
        return "browser/spices";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        return "browser/signup";
    }
}

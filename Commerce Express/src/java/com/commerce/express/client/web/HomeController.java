/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web;

import com.commerce.express.app.facade.CategoryFacade;
import com.commerce.express.domain.Category;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author om95446
 */
@Controller
public class HomeController {
    private CategoryFacade categoryFacade = CategoryFacade.getCategoryFacadeInstance();
    
    @RequestMapping({"/"})
    public String home(Model model) {
        List<Category> categories = categoryFacade.getCategoryCrudService().findAll();
        model.addAttribute("categories", categories);
        return "index";
    }
    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String aboutUs(Model model) {
        return "aboutus";
    }
    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public String contactUs(Model model) {
        return "contactus";
    }
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(Model model) {
        return "help";
    }
    @RequestMapping(value = "/babyitems", method = RequestMethod.GET)
    public String babyitems(Model model) {
        return "babyitems";
    }
    @RequestMapping(value = "/bakery", method = RequestMethod.GET)
    public String bakery(Model model) {
        return "bakery";
    }
    @RequestMapping(value = "/bakinggoods", method = RequestMethod.GET)
    public String bakinggoods(Model model) {
        return "bakinggoods";
    }
    @RequestMapping(value = "/beverages", method = RequestMethod.GET)
    public String beverages(Model model) {
        return "beverages";
    }
    @RequestMapping(value = "/cannedgoods", method = RequestMethod.GET)
    public String cannedGoods(Model model) {
        return "cannedgoods";
    }
    @RequestMapping(value = "/cleaners", method = RequestMethod.GET)
    public String cleaners(Model model) {
        return "cleaners";
    }
    @RequestMapping(value = "/dairy", method = RequestMethod.GET)
    public String dairy(Model model) {
        return "dairy";
    }
    @RequestMapping(value = "/drygoods", method = RequestMethod.GET)
    public String drygoods(Model model) {
        return "drygoods";
    }
    @RequestMapping(value = "/frozenfoods", method = RequestMethod.GET)
    public String frozenfoods(Model model) {
        return "frozenfoods";
    }
    @RequestMapping(value = "/meat", method = RequestMethod.GET)
    public String meat(Model model) {
        return "meat";
    }
    @RequestMapping(value = "/papergoods", method = RequestMethod.GET)
    public String papergoods(Model model) {
        return "papergoods";
    }
    @RequestMapping(value = "/personalcare", method = RequestMethod.GET)
    public String personalcare(Model model) {
        return "personalcare";
    }
    @RequestMapping(value = "/produce", method = RequestMethod.GET)
    public String produce(Model model) {
        return "produce";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        return "register";
    }
    @RequestMapping(value = "/snacks", method = RequestMethod.GET)
    public String snacks(Model model) {
        return "snacks";
    }
    @RequestMapping(value = "/spices", method = RequestMethod.GET)
    public String spices(Model model) {
        return "spices";
    }
 }

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Shannon
 */
@Controller
public class CustomerController {
   
    @RequestMapping(value = "/memberhome", method = RequestMethod.GET)
    public String memberIndex(Model model) {
        return "customer/index";
    }
    @RequestMapping(value = "/memberaboutus", method = RequestMethod.GET)
    public String aboutUs(Model model) {
        return "customer/aboutus";
    }
    @RequestMapping(value = "/membercontactus", method = RequestMethod.GET)
    public String contactUs(Model model) {
        return "customer/contactus";
    }
    @RequestMapping(value = "/memberhelp", method = RequestMethod.GET)
    public String help(Model model) {
        return "customer/help";
    }
    @RequestMapping(value = "/memberbabyitems", method = RequestMethod.GET)
    public String babyitems(Model model) {
        return "customer/babyitems";
    }
    @RequestMapping(value = "/memberbakery", method = RequestMethod.GET)
    public String bakery(Model model) {
        return "customer/bakery";
    }
    @RequestMapping(value = "/memberbakinggoods", method = RequestMethod.GET)
    public String bakinggoods(Model model) {
        return "customer/bakinggoods";
    }
    @RequestMapping(value = "/memberbeverages", method = RequestMethod.GET)
    public String beverages(Model model) {
        return "customer/beverages";
    }
    @RequestMapping(value = "/membercannedgoods", method = RequestMethod.GET)
    public String cannedGoods(Model model) {
        return "customer/cannedgoods";
    }
    @RequestMapping(value = "/membercleaners", method = RequestMethod.GET)
    public String cleaners(Model model) {
        return "customer/cleaners";
    }
    @RequestMapping(value = "/memberdairy", method = RequestMethod.GET)
    public String dairy(Model model) {
        return "customer/dairy";
    }
    @RequestMapping(value = "/memberdrygoods", method = RequestMethod.GET)
    public String drygoods(Model model) {
        return "customer/drygoods";
    }
    @RequestMapping(value = "/memberfrozenfoods", method = RequestMethod.GET)
    public String frozenfoods(Model model) {
        return "member/frozenfoods";
    }
    @RequestMapping(value = "/membermeat", method = RequestMethod.GET)
    public String meat(Model model) {
        return "member/meat";
    }
    @RequestMapping(value = "/memberpapergoods", method = RequestMethod.GET)
    public String papergoods(Model model) {
        return "member/papergoods";
    }
    @RequestMapping(value = "/memberpersonalcare", method = RequestMethod.GET)
    public String personalcare(Model model) {
        return "member/personalcare";
    }
    @RequestMapping(value = "/memberproduce", method = RequestMethod.GET)
    public String produce(Model model) {
        return "member/produce";
    }
 
    @RequestMapping(value = "/membersnacks", method = RequestMethod.GET)
    public String snacks(Model model) {
        return "member/snacks";
    }
    @RequestMapping(value = "/memberspices", method = RequestMethod.GET)
    public String spices(Model model) {
        return "member/spices";
    }
   
}

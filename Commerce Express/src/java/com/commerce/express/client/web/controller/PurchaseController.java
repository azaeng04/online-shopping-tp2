package com.commerce.express.client.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author om95446
 */
@Controller
public class PurchaseController {

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String home() {
       
        return "customer/checkout";
    }
}

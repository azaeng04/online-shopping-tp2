/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.app.facade.CommerceExpressServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author om95446
 */
@Controller
public class PurchaseController {

    private static CommerceExpressServices commerceExpressServices = CommerceExpressServices.getCommerceExpressServices();
    private static CommerceExpressCRUD commerceExpressCRUD = CommerceExpressCRUD.getCommerceExpressCRUD();

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String home(Model model) {
       
        return "customer/checkout";
    }
}

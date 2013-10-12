/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web.controller;

import com.commerce.express.client.web.model.AccessDetailsModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Shannon
 */
@Controller
public class AccessDetailsController {
    @RequestMapping(value="homepagedependentonrole")
    public String home(@ModelAttribute("AccessDetailsModel") AccessDetailsModel accessDetailsModel, Model model) {
        String username = accessDetailsModel.getUsername();
        String password = accessDetailsModel.getPassword();
        String page ="";
        if(username.equals("shannon") && password.equals("weir"))
        {
            page = "customer/index";
        }
        else if(username.equals("nash") && password.equals("naidoo"))
        {
            page = "admin/index";
        }
        return page;
    }
}

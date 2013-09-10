/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commerce.express.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author om95446
 */
@Controller
public class HomeController {
    @RequestMapping({"/"})
    public String home(Model model) {
        return "index";
    }
}

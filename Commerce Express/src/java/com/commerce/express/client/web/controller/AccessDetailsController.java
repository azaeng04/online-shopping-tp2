package com.commerce.express.client.web.controller;

import com.commerce.express.app.facade.CommerceExpressCRUD;
import com.commerce.express.domain.Category;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Shannon
 */
@Controller
public class AccessDetailsController {

    private static final CommerceExpressCRUD CE_CRUDS = CommerceExpressCRUD.getCommerceExpressCRUD();

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Login");
        model.addAttribute("active", "login");
        return "browser/login";
    }

    @RequestMapping(value = "/memberLogout")
    public String home(Model model, HttpSession session) {
        Enumeration<String> enuma = session.getAttributeNames();
        while (enuma.hasMoreElements()) {
            session.removeAttribute(enuma.nextElement());
        }
        session.invalidate();
        categoryModel(model);
        return "redirect:login";
    }

    @RequestMapping({"/loginFailed"})
    public String loginFailed(Model model) {
        categoryModel(model);
        model.addAttribute("error", "true");
        model.addAttribute("title", "Login");
        model.addAttribute("active", "login");
        return "browser/login";
    }

    @RequestMapping({"/loginAccessDenied"})
    public String loginAccessedDenied(Model model) {
        categoryModel(model);
        model.addAttribute("error", "true");
        model.addAttribute("title", "Login");
        model.addAttribute("active", "login");
        return "browser/login";
    }
    
    @RequestMapping({"/pageNotFound"})
    public String pageNotFound(Model model) {
        categoryModel(model);
        model.addAttribute("title", "Page Not Found");
        model.addAttribute("message", "This page does not exist");
        return "browser/pageNotFound";
    }
            
    private void categoryModel(Model model) {
        List<Category> categories = CE_CRUDS.getCategoryCrudService().findAll();
        model.addAttribute("categories", categories);
    }
}

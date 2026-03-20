package com.webapp.controller;

import com.webapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() { return "login"; }

    @PostMapping("/login")
    public String handleUserLogin(ModelMap model, @RequestParam String name, @RequestParam String password) {
        if (!loginService.validateUser(name, password)) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
        model.put("name", name);
        return "welcome";
    }


}

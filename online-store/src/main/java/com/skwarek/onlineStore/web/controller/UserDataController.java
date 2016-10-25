package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Michal on 14/10/16.
 */
@Controller
@RequestMapping(value = "/users")
public class UserDataController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/{username}")
    public String getUserData(Model model, @PathVariable String username) {

        model.addAttribute("account", accountService.getAccountByUsername(username));
        return "users/userData";
    }
}

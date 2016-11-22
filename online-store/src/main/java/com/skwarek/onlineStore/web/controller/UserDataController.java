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

    private static final String VIEWS_USER_DATA = "users/userData";
    private final AccountService accountService;

    @Autowired
    public UserDataController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/{username}")
    public String getUserData(Model model, @PathVariable String username) {

        model.addAttribute("account", accountService.findAccountByUsername(username));
        return VIEWS_USER_DATA;
    }
}

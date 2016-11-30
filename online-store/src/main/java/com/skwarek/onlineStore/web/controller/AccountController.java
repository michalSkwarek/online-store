package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.web.validator.UsernameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Michal on 04.10.2016.
 */
@Controller
@RequestMapping(value = "/accounts")
public class AccountController {

    private static final String VIEWS_ACCOUNT_FORM = "accounts/accountData";
    private final AccountService accountService;
    private final UsernameValidator usernameValidator;

    @Autowired
    public AccountController(AccountService accountService, UsernameValidator usernameValidator) {
        this.accountService = accountService;
        this.usernameValidator = usernameValidator;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initCreateAccountForm(Model model) {

        model.addAttribute("account", new Account());
        return VIEWS_ACCOUNT_FORM;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processCreateAccountForm(@Valid Account account, BindingResult result) {

        usernameValidator.validate(account, result);

        if (result.hasErrors()) {
            account.setUsername(null);
            return VIEWS_ACCOUNT_FORM;
        }

        accountService.createAccount(account);
        return "redirect:/customers/new";
    }

    @RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
    public String initUpdateAccountForm(@PathVariable String username, Model model) {

        Account account = accountService.findAccountByUsername(username);
        System.out.println("qqqq " + account + " " + username);
        model.addAttribute("account", account);
        return VIEWS_ACCOUNT_FORM;
    }

    @RequestMapping(value = "/edit/{username}", method = RequestMethod.POST)
    public String processUpdateAccountForm(@PathVariable String username, @Valid Account account, BindingResult result) {

        if (result.hasErrors()) {
            return VIEWS_ACCOUNT_FORM;
        }

        accountService.updateAccount(account);
        return "redirect:/users/" + username;
    }
}

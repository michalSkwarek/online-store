package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by Michal on 04.10.2016.
 */
@Controller
@RequestMapping(value = { "/accounts" })
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/{username}")
    public String getAccountByUsername(@PathVariable String username, Model model) {

        Account account = accountService.getAccountByUsername(username);
        model.addAttribute("account", account);
        return "accounts/accountData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String createAccount(Model model) {

        model.addAttribute("account", new Account());
        return "accounts/accountData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addAccount(Account account) {

        account.setEnabled(true);
        account.setDateCreated(new Date());
        account.setRole(Account.ROLE_USER);
        accountService.create(account);
        return "redirect:/customers/new";
    }

    @RequestMapping(value = { "/edit/{username}" }, method = RequestMethod.GET)
    public String getAccount(@PathVariable String username, Model model) {

        Account account = accountService.getAccountByUsername(username);
        model.addAttribute("account", account);
        return "accounts/accountData";
    }

    @RequestMapping(value = { "/edit/{username}" }, method = RequestMethod.POST)
    public String updateAccount(@PathVariable String username, Account account) {

        Account oldAccount = accountService.getAccountByUsername(username);
        oldAccount.setPassword(account.getPassword());
        oldAccount.setEmail(account.getEmail());
        accountService.update(oldAccount);
        return "redirect:/users/" + username;
    }
}

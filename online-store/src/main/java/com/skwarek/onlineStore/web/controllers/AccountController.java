package com.skwarek.onlineStore.web.controllers;

import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
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
    public String getProductById(Model model, @PathVariable String username) {
        model.addAttribute("account", accountService.getAccountByUsername(username));
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

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String getAccount(@PathVariable Long id, Model model) {

        Account account = accountService.read(id);
        model.addAttribute("account", account);
        return "accounts/accountData";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateAccount(@PathVariable Long id, Account account) {

        Account old = accountService.read(id);
        old.setPassword(account.getPassword());
        old.setEmail(account.getEmail());
        accountService.update(old);

        String username = accountService.read(id).getUsername();
        return "redirect:/users/" + username;
    }
}

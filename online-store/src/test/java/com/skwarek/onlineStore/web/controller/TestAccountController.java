package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.web.validator.UsernameValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Michal on 29/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAccountController {

    private AccountService accountService;
    private UsernameValidator usernameValidator;
    private AccountController accountController;

    private MockMvc mockMvc;

    private String username;
    private Account newAccount;

    @Before
    public void setUp() {
        this.username = "user";

        this.newAccount = new Account();
        this.newAccount.setId(1L);
        this.newAccount.setUsername(username);
        this.newAccount.setPassword("pass");
        this.newAccount.setEnabled(true);
        this.newAccount.setEmail("email@gmail.com");
        this.newAccount.setDateCreated(new Date());
        this.newAccount.setRole(Account.ROLE_USER);

        this.accountService = mock(AccountService.class);
        this.usernameValidator = mock(UsernameValidator.class);
        this.accountController = new AccountController(accountService, usernameValidator);

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.accountController)
                .build();

        given(this.accountService.findAccountByUsername(username)).willReturn(newAccount);
    }

    @Test
    public void testInitCreateAccountForm() throws Exception {
        mockMvc.perform(get("/accounts/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("account"))
                .andExpect(view().name("accounts/accountData"));
    }

    @Test
    public void testProcessCreateAccountFormSuccess() throws Exception {
        mockMvc.perform(post("/accounts/new")
                .param("username", "user")
                .param("password", "pass")
                .param("email", "email@gmail.com")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customers/new"));
    }

    @Test
    public void testProcessCreateAccountFormHasErrors() throws Exception {
        mockMvc.perform(post("/accounts/new")
                .param("username", "us")
                .param("password", "password")
                .param("email", "emailgmail.com")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("account"))
                .andExpect(model().attributeHasFieldErrors("account", "username"))
                .andExpect(model().attributeHasFieldErrors("account", "password"))
                .andExpect(model().attributeHasFieldErrors("account", "email"))
                .andExpect(view().name("accounts/accountData"));
    }

    @Test
    public void testInitUpdateAccountForm() throws Exception {
        mockMvc.perform(get("/accounts/edit/{username}", username))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("account"))
                .andExpect(model().attribute("account", newAccount))
                .andExpect(view().name("accounts/accountData"));

        verify(accountService, times(1)).findAccountByUsername(username);
    }

    @Test
    public void testProcessUpdateAccountFormSuccess() throws Exception {
        mockMvc.perform(post("/accounts/edit/{username}", username)
                .param("password", "pass1")
                .param("email", "email1@gmail.com")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/users/" + username));
    }

    @Test
    public void testProcessUpdateAccountFormHasErrors() throws Exception {
        mockMvc.perform(post("/accounts/edit/{username}", username)
                .param("password", "password")
                .param("email", "emailgmail.com")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("account"))
                .andExpect(model().attributeHasFieldErrors("account", "password"))
                .andExpect(model().attributeHasFieldErrors("account", "email"))
                .andExpect(view().name("accounts/accountData"));
    }
}
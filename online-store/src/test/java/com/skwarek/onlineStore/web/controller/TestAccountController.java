package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.web.validator.UsernameValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Michal on 29/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestAccountController {

    @Mock
    private AccountService accountService;

    @Mock
    private UsernameValidator usernameValidator;

    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvc;

    private Account newAccount;

    @Before
    public void setUp() {
        newAccount = new Account();
        newAccount.setId(1L);
        newAccount.setUsername("user");
        newAccount.setPassword("pass");
        newAccount.setEnabled(true);
        newAccount.setEmail("email@gmail.com");
        newAccount.setDateCreated(new Date());
        newAccount.setRole(Account.ROLE_USER);

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.accountController)
                .build();

        MockitoAnnotations.initMocks(this);
        given(this.accountService.findAccountByUsername(newAccount.getUsername())).willReturn(newAccount);
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
        given(this.accountService.findAccountByUsername(newAccount.getUsername())).willReturn(newAccount);
        System.out.println("qqq " + this.accountService.findAccountByUsername(newAccount.getUsername()));

        mockMvc.perform(get("/accounts/edit/{username}", newAccount.getUsername()))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("account"))
//                .andExpect(model().attribute("account", hasProperty("username", is("user"))))
//                .andExpect(model().attribute("account", hasProperty("password", is("pass"))))
//                .andExpect(model().attribute("account", hasProperty("email", is("email@gmail.com"))))
                .andExpect(view().name("accounts/accountData"));
    }

    @Test
    public void testProcessUpdateAccountFormSuccess() throws Exception {
        mockMvc.perform(post("/accounts/edit/{username}", newAccount.getUsername())
                .param("password", "pass1")
                .param("email", "email1@gmail.com")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/users/{username}"));
    }

    @Test
    public void testProcessUpdateAccountFormHasErrors() throws Exception {
        accountService.createAccount(newAccount);
        mockMvc.perform(post("/accounts/edit/{username}", newAccount.getUsername())
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

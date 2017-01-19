package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.web.validator.UsernameValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Michal on 29/11/2016.
 */
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class TestAccountController {

    private final static String VIEWS_ACCOUNT_FORM = "accounts/accountData";
    private final static String REDIRECT_TO = "redirect:";

    private final static Long ACCOUNT_ID = 1L;
    private final static String ACCOUNT_USERNAME = "aaa";

    private final static Date ACCOUNT_DATE_CREATED = MyEmbeddedDatabase.getAccountDateCreated();

    private Account account;

    private AccountService accountService;
    private UsernameValidator usernameValidator;
    private AccountController accountController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MyEmbeddedDatabase myDB = new MyEmbeddedDatabase();

        this.account = myDB.getAccount_no_1();

        this.accountService = mock(AccountService.class);
        this.usernameValidator = mock(UsernameValidator.class);

        this.accountController = new AccountController(accountService, usernameValidator);

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.accountController)
                .build();
    }

    @Test
    public void initCreateAccountForm_ShouldAddEmptyAccountToModelAndRenderEmptyAccountFormView() throws Exception {
        mockMvc.perform(get("/accounts/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("account"))
                .andExpect(model().attribute("account", hasProperty("id", nullValue())))
                .andExpect(model().attribute("account", hasProperty("username", nullValue())))
                .andExpect(model().attribute("account", hasProperty("password", nullValue())))
                .andExpect(model().attribute("account", hasProperty("enabled", nullValue())))
                .andExpect(model().attribute("account", hasProperty("email", nullValue())))
                .andExpect(model().attribute("account", hasProperty("dateCreated", nullValue())))
                .andExpect(model().attribute("account", hasProperty("role", nullValue())))
                .andExpect(model().attribute("account", hasProperty("customer", nullValue())))
                .andExpect(forwardedUrl(VIEWS_ACCOUNT_FORM))
                .andExpect(view().name(VIEWS_ACCOUNT_FORM));

        verifyZeroInteractions(accountService);
    }

    @Test
    public void processCreateAccountForm_ShouldHasErrors() throws Exception {
        mockMvc.perform(post("/accounts/new")
                .param("username", "longUsername")
                .param("password", "longPassword")
                .param("email", "wrongEmail")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("account"))
                .andExpect(model().attributeHasErrors("account"))
                .andExpect(model().attributeHasFieldErrors("account", "username"))
                .andExpect(model().attributeHasFieldErrors("account", "password"))
                .andExpect(model().attributeHasFieldErrors("account", "email"))
                .andExpect(model().attribute("account", hasProperty("id", nullValue())))
                .andExpect(model().attribute("account", hasProperty("username", nullValue())))
                .andExpect(model().attribute("account", hasProperty("password", is("longPassword"))))
                .andExpect(model().attribute("account", hasProperty("enabled", nullValue())))
                .andExpect(model().attribute("account", hasProperty("email", is("wrongEmail"))))
                .andExpect(model().attribute("account", hasProperty("dateCreated", nullValue())))
                .andExpect(model().attribute("account", hasProperty("role", nullValue())))
                .andExpect(model().attribute("account", hasProperty("customer", nullValue())))
                .andExpect(forwardedUrl(VIEWS_ACCOUNT_FORM))
                .andExpect(view().name(VIEWS_ACCOUNT_FORM));

        verifyZeroInteractions(accountService);
    }

    @Test
    public void processCreateAccountForm_ShouldBeFine() throws Exception {
        mockMvc.perform(post("/accounts/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "user")
                .param("password", "pass")
                .param("email", "email@gmail.com")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/customers/new"))
                .andExpect(view().name(REDIRECT_TO + "/customers/new"));

        ArgumentCaptor<Account> formObjectArgument = ArgumentCaptor.forClass(Account.class);
        verify(accountService, times(1)).createAccount(formObjectArgument.capture());
        verifyZeroInteractions(accountService);

        Account formAccount = formObjectArgument.getValue();

        assertThat(formAccount.getId(), nullValue());
        assertThat(formAccount.getUsername(), is("user"));
        assertThat(formAccount.getPassword(), is("pass"));
        assertThat(formAccount.getEnabled(), nullValue());
        assertThat(formAccount.getEmail(), is("email@gmail.com"));
        assertThat(formAccount.getDateCreated(), nullValue());
        assertThat(formAccount.getRole(), nullValue());
        assertThat(formAccount.getCustomer(), nullValue());
    }

    @Test
    public void initUpdateAccountForm_ShouldAddAccountToModelAndRenderAccountFormView() throws Exception {
        given(this.accountService.findAccountByUsername(ACCOUNT_USERNAME)).willReturn(account);

        mockMvc.perform(get("/accounts/edit/{username}", ACCOUNT_USERNAME))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("account"))
                .andExpect(model().attribute("account", account))
                .andExpect(model().attribute("account", hasProperty("id", is(ACCOUNT_ID))))
                .andExpect(model().attribute("account", hasProperty("username", is(ACCOUNT_USERNAME))))
                .andExpect(model().attribute("account", hasProperty("password", is("111"))))
                .andExpect(model().attribute("account", hasProperty("enabled", is(true))))
                .andExpect(model().attribute("account", hasProperty("email", is("a1@gmail.com"))))
                .andExpect(model().attribute("account", hasProperty("dateCreated", is(ACCOUNT_DATE_CREATED))))
                .andExpect(model().attribute("account", hasProperty("role", is("ROLE_USER"))))
                .andExpect(model().attribute("account", hasProperty("customer", is(account.getCustomer()))))
                .andExpect(forwardedUrl(VIEWS_ACCOUNT_FORM))
                .andExpect(view().name(VIEWS_ACCOUNT_FORM));

        verify(accountService, times(1)).findAccountByUsername(ACCOUNT_USERNAME);
        verifyNoMoreInteractions(accountService);
    }

    @Test
    public void processUpdateAccountForm_ShouldHasErrors() throws Exception {
        mockMvc.perform(post("/accounts/edit/{username}", ACCOUNT_USERNAME)
                .param("password", "longPassword")
                .param("email", "wrongEmail")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("account"))
                .andExpect(model().attributeHasErrors("account"))
                .andExpect(model().attributeHasFieldErrors("account", "password"))
                .andExpect(model().attributeHasFieldErrors("account", "email"))
                .andExpect(model().attribute("account", hasProperty("id", nullValue())))
                .andExpect(model().attribute("account", hasProperty("username", is(ACCOUNT_USERNAME))))
                .andExpect(model().attribute("account", hasProperty("password", is("longPassword"))))
                .andExpect(model().attribute("account", hasProperty("enabled", nullValue())))
                .andExpect(model().attribute("account", hasProperty("email", is("wrongEmail"))))
                .andExpect(model().attribute("account", hasProperty("dateCreated", nullValue())))
                .andExpect(model().attribute("account", hasProperty("role", nullValue())))
                .andExpect(model().attribute("account", hasProperty("customer", nullValue())))
                .andExpect(forwardedUrl(VIEWS_ACCOUNT_FORM))
                .andExpect(view().name(VIEWS_ACCOUNT_FORM));

        verifyZeroInteractions(accountService);
    }

    @Test
    public void processUpdateAccountForm_ShouldBeFine() throws Exception {
        given(this.accountService.findAccountByUsername(ACCOUNT_USERNAME)).willReturn(account);

        mockMvc.perform(post("/accounts/edit/{username}", ACCOUNT_USERNAME)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("password", "pass1")
                .param("email", "email1@gmail.com")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users/" + ACCOUNT_USERNAME))
                .andExpect(view().name(REDIRECT_TO + "/users/" + ACCOUNT_USERNAME));

        ArgumentCaptor<Account> formObjectArgument = ArgumentCaptor.forClass(Account.class);
        verify(accountService, times(1)).updateAccount(formObjectArgument.capture());
        verifyNoMoreInteractions(accountService);

        Account formAccount = formObjectArgument.getValue();

        assertThat(formAccount.getId(), nullValue());
        assertThat(formAccount.getUsername(), is(ACCOUNT_USERNAME));
        assertThat(formAccount.getPassword(), is("pass1"));
        assertThat(formAccount.getEnabled(), nullValue());
        assertThat(formAccount.getEmail(), is("email1@gmail.com"));
        assertThat(formAccount.getDateCreated(), nullValue());
        assertThat(formAccount.getRole(), nullValue());
        assertThat(formAccount.getCustomer(), nullValue());
    }
}
package com.skwarek.onlineStore.web.validator;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Michal on 30/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
public class TestUsernameValidator {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UsernameValidator usernameValidator;

    private Account newAccount;
    private Customer newCustomer;
    private Account otherAccount;

    @Before
    public void setUp() {
        this.newCustomer = new Customer();
        this.newCustomer.setFirstName("John");
        this.newCustomer.setLastName("Doe");
        this.newCustomer.setBirthDate("2000-06-16");
        this.newCustomer.setPhoneNumber("123456789");
        this.newCustomer.setNumberOfOrders(1);

        this.newAccount = new Account();
        this.newAccount.setUsername("user");
        this.newAccount.setPassword("pass");
        this.newAccount.setEmail("email@gmail.com");
        this.newAccount.setCustomer(newCustomer);

        this.otherAccount = new Account();
        this.otherAccount.setUsername("user");
        this.otherAccount.setPassword("pass1");
        this.otherAccount.setEmail("email1@gmail.com");
    }

    @Test
    public void testInvalidAccountExistingUsername() {
        accountService.createAccount(newAccount);
        accountService.createAccount(otherAccount);
        BindException bindException = new BindException(otherAccount, "otherAccount");

        ValidationUtils.invokeValidator(usernameValidator, otherAccount, bindException);

        assertEquals(1, bindException.getErrorCount());
        assertTrue(bindException.getLocalizedMessage().
                contains("Account.username.validation.duplicate"));
    }
}

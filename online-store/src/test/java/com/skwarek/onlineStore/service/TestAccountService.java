package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Michal on 26.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestAccountService {

    @Autowired
    private AccountService accountService;

    private Account newAccount;
    private Customer newCustomer;

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
    }

    @Test
    public void testFindAccountByUsername() {
        String username = "user";
        Account notExistingAccount = accountService.findAccountByUsername(username);
        assertNull(notExistingAccount);
        accountService.create(newAccount);
        Account existingAccount = accountService.findAccountByUsername(username);
        assertNotNull(existingAccount);
        assertEquals(newAccount, existingAccount);
    }

    @Test
    public void testCreateAccount() {
        int oldSize = accountService.findAll().size();
        accountService.createAccount(newAccount);
        assertTrue(oldSize + 1 == accountService.findAll().size());
    }

    @Test
    public void testUpdateAccount() {
        accountService.create(newAccount);
        newAccount.setPassword("pass1");
        newAccount.setEmail("email1@gmail.com");
        accountService.updateAccount(newAccount);
        Account found = accountService.read(newAccount.getId());
        assertEquals("pass1", found.getPassword());
        assertEquals("email1@gmail.com", found.getEmail());
    }
}

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

import static junit.framework.Assert.*;

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

    private static Account newAccount;
    private static Customer newCustomer;

    @Before
    public void setUp() {
        newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        newCustomer.setBirthDate("2000-06-16");
        newCustomer.setPhoneNumber("123456789");
        newCustomer.setNumberOfOrders(1);

        newAccount = new Account();
        newAccount.setUsername("user");
        newAccount.setPassword("pass");
        newAccount.setEmail("email@gmail.com");
        newAccount.setCustomer(newCustomer);
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

package com.skwarek.onlineStore.data.dao;

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

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Michal on 26.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
@WebAppConfiguration
@Transactional
public class TestAccountDao {

    @Autowired
    private AccountDao accountDao;

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
        newAccount.setEnabled(true);
        newAccount.setEmail("email@gmail.com");
        newAccount.setDateCreated(new Date());
        newAccount.setRole(Account.ROLE_USER);
        newAccount.setCustomer(newCustomer);
    }

    @Test
    public void testFindAccountByUsername() {
        accountDao.create(newAccount);
        String username = "user";
        Account found = accountDao.findAccountByUsername(username);
        assertEquals(newAccount, found);
    }

    @Test
    public void testFindLastAccount() {
        accountDao.create(newAccount);
        Account found = accountDao.findLastAccount();
        assertEquals(newAccount, found);
    }

    @Test
    public void testUpdateAccount() {
        accountDao.create(newAccount);
        newAccount.setPassword("pass1");
        newAccount.setEmail("email1@gmail.com");
        accountDao.updateAccount(newAccount);
        Account found = accountDao.read(newAccount.getId());
        assertEquals("pass1", found.getPassword());
        assertEquals("email1@gmail.com", found.getEmail());
    }
}

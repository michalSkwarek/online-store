package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.configuration.ForTestsHibernateConfiguration;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Michal on 26.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ForTestsHibernateConfiguration.class)
@Transactional
public class TestAccountDao {

    private final static Long ACCOUNT_ID = 1L;
    private final static String ACCOUNT_USERNAME = "aaa";
    private final static String NOT_EXISTING_ACCOUNT_USERNAME = "abc";

    private final static Date ACCOUNT_DATE_CREATED = MyEmbeddedDatabase.getAccountDateCreated();

    private final static Long CUSTOMER_ID = 1L;

    private Account newAccount;
    private Customer customer;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private CustomerDao customerDao;

    @Before
    public void setUp() {
        this.newAccount = new Account();
        this.newAccount.setUsername("user");
        this.newAccount.setPassword("pass");
        this.newAccount.setEnabled(true);
        this.newAccount.setEmail("email@gmail.com");
        this.newAccount.setDateCreated(ACCOUNT_DATE_CREATED);
        this.newAccount.setRole(Account.ROLE_USER);

        this.customer = customerDao.read(CUSTOMER_ID);
    }

    @Test
    public void testFindAccountByUsername() {
        Account notExistingAccount = accountDao.findAccountByUsername(NOT_EXISTING_ACCOUNT_USERNAME);
        assertNull(notExistingAccount);

        Account existingAccount = accountDao.findAccountByUsername(ACCOUNT_USERNAME);
        assertNotNull(existingAccount);
        assertEquals(ACCOUNT_ID, existingAccount.getId());
        assertEquals("aaa", existingAccount.getUsername());
        assertEquals("111", existingAccount.getPassword());
        assertEquals(true, existingAccount.getEnabled());
        assertEquals("a1@gmail.com", existingAccount.getEmail());
        assertEquals(ACCOUNT_DATE_CREATED, existingAccount.getDateCreated());
        assertEquals("ROLE_USER", existingAccount.getRole());
        assertEquals(customer, existingAccount.getCustomer());
    }

    @Test
    public void testFindLastAccount() {
        Account existingAccount = accountDao.findLastAccount();
        assertNotNull(existingAccount);
        assertEquals(ACCOUNT_ID, existingAccount.getId());
        assertEquals("aaa", existingAccount.getUsername());
        assertEquals("111", existingAccount.getPassword());
        assertEquals(true, existingAccount.getEnabled());
        assertEquals("a1@gmail.com", existingAccount.getEmail());
        assertEquals(ACCOUNT_DATE_CREATED, existingAccount.getDateCreated());
        assertEquals("ROLE_USER", existingAccount.getRole());
        assertEquals(customer, existingAccount.getCustomer());
    }

    @Test
    public void testCreateAccount() {
        assertEquals(1, accountDao.findAll().size());
        assertEquals(1, customerDao.findAll().size());

        accountDao.createAccount(newAccount);

        Long newAccountId = 2L;
        Account found = accountDao.read(newAccountId);

        assertNotNull(found);
        assertEquals(newAccountId, found.getId());
        assertEquals("user", found.getUsername());
        assertEquals("pass", found.getPassword());
        assertEquals(true, found.getEnabled());
        assertEquals("email@gmail.com", found.getEmail());
        assertEquals(ACCOUNT_DATE_CREATED, found.getDateCreated());
        assertEquals("ROLE_USER", found.getRole());
        assertNull(found.getCustomer());

        assertEquals(2, accountDao.findAll().size());
        assertEquals(1, customerDao.findAll().size());
    }

    @Test
    public void testUpdateAccount() {
        assertEquals(1, accountDao.findAll().size());
        assertEquals(1, customerDao.findAll().size());

        Account toUpdate = accountDao.read(ACCOUNT_ID);
        toUpdate.setPassword("pass1");
        toUpdate.setEmail("email1@gmail.com");
        accountDao.updateAccount(toUpdate);

        Account found = accountDao.read(ACCOUNT_ID);

        assertNotNull(found);
        assertEquals(1L, (long) found.getId());
        assertEquals("aaa", found.getUsername());
        assertEquals("pass1", found.getPassword());
        assertEquals(true, found.getEnabled());
        assertEquals("email1@gmail.com", found.getEmail());
        assertEquals(ACCOUNT_DATE_CREATED, found.getDateCreated());
        assertEquals("ROLE_USER", found.getRole());
        assertEquals(customer, found.getCustomer());

        assertEquals(1, accountDao.findAll().size());
        assertEquals(1, customerDao.findAll().size());
    }
}

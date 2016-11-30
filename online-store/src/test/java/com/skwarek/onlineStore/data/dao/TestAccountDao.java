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
import static junit.framework.Assert.assertNotNull;

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

    @Before
    public void setUp() {
        newAccount = new Account();
        newAccount.setUsername("user");
        newAccount.setPassword("pass");
        newAccount.setEnabled(true);
        newAccount.setEmail("email@gmail.com");
        newAccount.setDateCreated(new Date());
        newAccount.setRole(Account.ROLE_USER);
    }

    @Test
    public void testFindLastAccount() {
        accountDao.create(newAccount);
        Account found = accountDao.findLastAccount();
        assertNotNull(found);
        assertEquals(newAccount, found);
    }
}

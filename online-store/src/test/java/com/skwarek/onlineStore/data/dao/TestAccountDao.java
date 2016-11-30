package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.user.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    private Account newAccount;

    @Before
    public void setUp() {
        this.newAccount = new Account();
        this.newAccount.setUsername("user");
        this.newAccount.setPassword("pass");
        this.newAccount.setEnabled(true);
        this.newAccount.setEmail("email@gmail.com");
        this.newAccount.setDateCreated(new Date());
        this.newAccount.setRole(Account.ROLE_USER);
    }

    @Test
    public void testFindLastAccount() {
        accountDao.create(newAccount);
        Account found = accountDao.findLastAccount();
        assertNotNull(found);
        assertEquals(newAccount, found);
    }
}

package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by Michal on 26.09.2016.
 */
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class TestAccountService {

    private final static String ACCOUNT_USERNAME = "aaa";
    private final static String NOT_EXISTING_ACCOUNT_USERNAME = "abc";

    private Account account;
    private Account newAccount;

    private AccountDao accountDao;

    @Autowired
    private AccountService accountService;

    @Before
    public void setUp() {
        MyEmbeddedDatabase myDB = new MyEmbeddedDatabase();

        this.account = myDB.getAccount_no_1();

        this.newAccount = new Account();
        this.newAccount.setUsername("user");
        this.newAccount.setPassword("pass");
        this.newAccount.setEmail("email@gmail.com");

        this.accountDao = mock(AccountDao.class);

        this.accountService = new AccountServiceImpl(accountDao);
    }

    @Test
    public void testFindAccountByUsername() {
        given(this.accountDao.findAccountByUsername(NOT_EXISTING_ACCOUNT_USERNAME)).willReturn(null);
        Account notExistingAccount = accountService.findAccountByUsername(NOT_EXISTING_ACCOUNT_USERNAME);
        assertNull(notExistingAccount);
        verify(accountDao, times(1)).findAccountByUsername(NOT_EXISTING_ACCOUNT_USERNAME);

        given(this.accountDao.findAccountByUsername(ACCOUNT_USERNAME)).willReturn(account);
        Account existingAccount = accountService.findAccountByUsername(ACCOUNT_USERNAME);
        assertNotNull(existingAccount);
        assertEquals(account, existingAccount);
        verify(accountDao, times(1)).findAccountByUsername(ACCOUNT_USERNAME);

        verifyNoMoreInteractions(accountDao);
    }

    @Test
    public void testCreateAccount() {
        accountService.createAccount(newAccount);

        assertNull(newAccount.getId());
        assertEquals("user", newAccount.getUsername());
        assertEquals("pass", newAccount.getPassword());
        assertEquals(true, newAccount.getEnabled());
        assertEquals("email@gmail.com", newAccount.getEmail());
        assertNotNull(newAccount.getDateCreated());
        assertEquals("ROLE_USER", newAccount.getRole());
        assertNull(newAccount.getCustomer());

        verify(accountDao, times(1)).createAccount(newAccount);
        verifyNoMoreInteractions(accountDao);
    }

    @Test
    public void testUpdateAccount() {
        accountService.updateAccount(account);

        verify(accountDao, times(1)).updateAccount(account);
        verifyNoMoreInteractions(accountDao);
    }
}

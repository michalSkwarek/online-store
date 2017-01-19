package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Michal on 04.10.2016.
 */
@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl extends GenericServiceImpl<Account, Long> implements AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Account findAccountByUsername(String username) {
        return accountDao.findAccountByUsername(username);
    }

    @Override
    public void createAccount(Account account) {
        account.setEnabled(true);
        account.setDateCreated(new Date());
        account.setRole(Account.ROLE_USER);
        accountDao.createAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
}

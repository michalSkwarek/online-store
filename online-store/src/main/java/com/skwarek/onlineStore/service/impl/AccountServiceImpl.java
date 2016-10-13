package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michal on 04.10.2016.
 */
@Service("accountService")
public class AccountServiceImpl extends GenericServiceImpl<Account, Long> implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getAccountByUsername(String username) {
        return accountDao.getAccountByUsername(username);
    }
}

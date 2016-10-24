package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.generic.GenericService;

/**
 * Created by Michal on 04.10.2016.
 */
public interface AccountService extends GenericService<Account, Long> {

    Account getAccountByUsername(String username);

    void createAccount(Account account);

    void updateAccount(Account account);
}

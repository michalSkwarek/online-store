package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.data.dao.generic.GenericDao;
import com.skwarek.onlineStore.data.entity.user.Account;

/**
 * Created by Michal on 04.10.2016.
 */
public interface AccountDao extends GenericDao<Account, Long> {

    Account findAccountByUsername(String username);

    Account findLastAccount();

    void updateAccount(Account account);
}

package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.user.Account;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 04.10.2016.
 */
@Repository("accountDao")
public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements AccountDao {

    @Override
    public Account getAccountByUsername(String username) {
        Query getAccount = getSession().createQuery("from Account a where a.username = :username");
        getAccount.setParameter("username", username);
        getAccount.setMaxResults(1);
        return (Account) getAccount.uniqueResult();
    }
}

package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.dao.CustomerDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 04.10.2016.
 */
@Repository("accountDao")
public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements AccountDao {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Account findAccountByUsername(String username) {
        Query getAccountQuery = getSession().createQuery("from Account a where a.username = :username");
        getAccountQuery.setParameter("username", username);
        getAccountQuery.setMaxResults(1);
        return (Account) getAccountQuery.uniqueResult();
    }

    @Override
    public Account findLastAccount() {
        Query getAccountQuery = getSession().createQuery("from Account a order by a.id desc");
        getAccountQuery.setMaxResults(1);
        return (Account) getAccountQuery.uniqueResult();
    }

    @Override
    public void updateAccount(Account account) {
        if (account.getCustomer() != null) {
            Customer customer = customerDao.read(account.getCustomer().getId());
            account.setCustomer(customer);
        }
        update(account);
    }
}

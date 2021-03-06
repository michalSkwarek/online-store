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
 * Created by Michal on 13/10/16.
 */
@Repository("customerDao")
public class CustomerDaoImpl extends GenericDaoImpl<Customer, Long> implements CustomerDao {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Customer findLastCustomer() {
        Query getCustomerQuery = getSession().createQuery("from Customer c order by c.id desc");
        getCustomerQuery.setMaxResults(1);
        return (Customer) getCustomerQuery.uniqueResult();
    }

    @Override
    public void createCustomer(Customer customer) {
        create(customer);
        Account account = accountDao.findLastAccount();
        account.setCustomer(customer);
        accountDao.updateAccount(account);
    }

    @Override
    public void updateCustomer(Customer customer) {
        update(customer);
    }
}

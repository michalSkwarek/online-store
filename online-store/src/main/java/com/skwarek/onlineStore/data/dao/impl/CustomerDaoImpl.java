package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.CustomerDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 13/10/16.
 */
@Repository("customerDao")
public class CustomerDaoImpl extends GenericDaoImpl<Customer, Long> implements CustomerDao {

    @Override
    public Customer getCustomerByUsername(String username) {
        Query getCustomerQuery = getSession().createQuery("from Customer c where c.account.username = :username");
        getCustomerQuery.setParameter("username", username);
        getCustomerQuery.setMaxResults(1);
        return (Customer) getCustomerQuery.uniqueResult();
    }

    @Override
    public Customer getLastCustomer() {
        Query getCustomerQuery = getSession().createQuery("from Customer c order by c.id desc");
        getCustomerQuery.setMaxResults(1);
        return (Customer) getCustomerQuery.uniqueResult();
    }
}

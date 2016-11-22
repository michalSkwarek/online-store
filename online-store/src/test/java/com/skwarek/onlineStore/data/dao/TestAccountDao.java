//package com.skwarek.onlineStore.data.dao;
//
//import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
//import com.skwarek.onlineStore.data.entity.user.Account;
//import com.skwarek.onlineStore.data.entity.user.Customer;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//
//import static junit.framework.Assert.assertEquals;
//
///**
// * Created by Michal on 26.09.2016.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ApplicationContextConfiguration.class)
//@WebAppConfiguration
//@Transactional
//public class TestAccountDao {
//
//    @Autowired
//    private AccountDao accountDao;
//
//    @Test
//    public void testGetAccountByUsername() {
//        String username = "user";
//        Account newAccount = new Account(username, "pass", true, "email@gmail.com", new Date(), Account.ROLE_USER);
//        accountDao.create(newAccount);
//        Account found = accountDao.findAccountByUsername(username);
//        assertEquals(newAccount, found);
//    }
//
//    @Test
//    public void testGetLastAccount() {
//        Account newAccount = new Account("user", "pass", true, "email@gmail.com", new Date(), Account.ROLE_USER);
//        accountDao.create(newAccount);
//        Account found = accountDao.findLastAccount();
//        assertEquals(newAccount, found);
//    }
//
//    @Test
//    public void testUpdateAccount() {
//        Account newAccount = new Account("user", "pass", true, "email@gmail.com", new Date(), Account.ROLE_USER);
//        Customer newCustomer = new Customer("John", "Doe", "2000-06-16", "123456789", 1);
//        newAccount.setCustomer(newCustomer);
//        accountDao.create(newAccount);
//        newAccount.setPassword("pass1");
//        newAccount.setEmail("email1@gmail.com");
//        accountDao.updateAccount(newAccount);
//        Account found = accountDao.read(newAccount.getId());
//        assertEquals("pass1", found.getPassword());
//        assertEquals("email1@gmail.com", found.getEmail());
//    }
//}

package com.skwarek.onlineStore;

import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Michal on 07/01/2017.
 */
public class MyEmbeddedDatabase {

    private final static Date ACCOUNT_DATE_CREATED = new GregorianCalendar(2015, Calendar.JANUARY, 10, 10, 20, 30).getTime();

    private Account account_no_1;
    private Customer customer_no_1;
    private Address address_no_1;

    public MyEmbeddedDatabase() {

        this.account_no_1 = new Account();
        this.account_no_1.setId(1L);
        this.account_no_1.setUsername("aaa");
        this.account_no_1.setPassword("111");
        this.account_no_1.setEnabled(true);
        this.account_no_1.setEmail("a1@gmail.com");
        this.account_no_1.setDateCreated(ACCOUNT_DATE_CREATED);
        this.account_no_1.setRole(Account.ROLE_USER);

        this.customer_no_1 = new Customer();
        this.customer_no_1.setId(1L);
        this.customer_no_1.setFirstName("Michal");
        this.customer_no_1.setLastName("Abacki");
        this.customer_no_1.setBirthDate("1990-01-20");
        this.customer_no_1.setPhoneNumber("111222333");
        this.customer_no_1.setNumberOfOrders(1);
        this.customer_no_1.setAccount(account_no_1);

        this.account_no_1.setCustomer(customer_no_1);

        this.address_no_1 = new Address();
        this.address_no_1.setId(1L);
        this.address_no_1.setStreet("Koszycka");
        this.address_no_1.setStreetNumber("6A");
        this.address_no_1.setDoorNumber("25");
        this.address_no_1.setZipCode("01-446");
        this.address_no_1.setCity("Warsaw");
        this.address_no_1.setCustomer(customer_no_1);

        this.customer_no_1.setBillingAddress(address_no_1);
    }

    public static Date getAccountDateCreated() {
        return ACCOUNT_DATE_CREATED;
    }

    public Account getAccount_no_1() {
        return account_no_1;
    }

    public Customer getCustomer_no_1() {
        return customer_no_1;
    }

    public Address getAddress_no_1() {
        return address_no_1;
    }
}

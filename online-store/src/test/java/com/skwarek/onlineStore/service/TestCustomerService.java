package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.dao.CustomerDao;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by Michal on 05/11/2016.
 */
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class TestCustomerService {

    private Customer customer;
    private Customer newCustomer;

    private CustomerDao customerDao;

    @Autowired
    private CustomerService customerService;

    @Before
    public void setUp() {
        MyEmbeddedDatabase myDB = new MyEmbeddedDatabase();

        this.customer = myDB.getCustomer_no_1();

        this.newCustomer = new Customer();
        this.newCustomer.setFirstName("John");
        this.newCustomer.setLastName("Doe");
        this.newCustomer.setBirthDate("2000-06-16");
        this.newCustomer.setPhoneNumber("123456789");

        this.customerDao = mock(CustomerDao.class);

        this.customerService = new CustomerServiceImpl(customerDao);
    }

    @Test
    public void testCreateCustomer() {
        customerService.createCustomer(newCustomer);

        assertNull(newCustomer.getId());
        assertEquals("John", newCustomer.getFirstName());
        assertEquals("Doe", newCustomer.getLastName());
        assertEquals("2000-06-16", newCustomer.getBirthDate());
        assertNull(newCustomer.getBillingAddress());
        assertEquals("123456789", newCustomer.getPhoneNumber());
        assertEquals(0, (int) newCustomer.getNumberOfOrders());
        assertNull(newCustomer.getAccount());
        assertNull(newCustomer.getOrders());

        verify(customerDao, times(1)).createCustomer(newCustomer);
        verifyNoMoreInteractions(customerDao);
    }

    @Test
    public void testUpdateCustomer() {
        customerService.updateCustomer(customer);

        verify(customerDao, times(1)).updateCustomer(customer);
        verifyNoMoreInteractions(customerDao);
    }
}

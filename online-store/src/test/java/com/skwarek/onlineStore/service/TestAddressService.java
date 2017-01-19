package com.skwarek.onlineStore.service;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.dao.AddressDao;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.service.impl.AddressServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.*;

/**
 * Created by Michal on 05/11/2016.
 */
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class TestAddressService {

    private Address address;

    private AddressDao addressDao;

    @Autowired
    private AddressService addressService;

    @Before
    public void setUp() {
        MyEmbeddedDatabase myDB = new MyEmbeddedDatabase();

        this.address = myDB.getAddress_no_1();

        this.addressDao = mock(AddressDao.class);

        this.addressService = new AddressServiceImpl(addressDao);
    }

    @Test
    public void testCreateBillingAddress() {
        addressService.createBillingAddress(address);

        verify(addressDao, times(1)).createBillingAddress(address);
        verifyNoMoreInteractions(addressDao);
    }

    @Test
    public void testUpdateBillingAddress() {
        addressService.updateBillingAddress(address);

        verify(addressDao, times(1)).updateBillingAddress(address);
        verifyNoMoreInteractions(addressDao);
    }

    @Test
    public void testCreateShippingAddress() {
        addressService.createShippingAddress(address);

        verify(addressDao, times(1)).createShippingAddress(address);
        verifyNoMoreInteractions(addressDao);
    }
}

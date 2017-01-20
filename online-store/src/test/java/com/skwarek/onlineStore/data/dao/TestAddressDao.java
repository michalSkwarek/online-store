package com.skwarek.onlineStore.data.dao;

import com.skwarek.onlineStore.configuration.ForTestsHibernateConfiguration;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Michal on 29/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ForTestsHibernateConfiguration.class)
@Transactional
public class TestAddressDao {

    private final static Long ADDRESS_ID = 1L;

    private Customer newCustomer;
    private Address address;
    private Address newBillingAddress;
    private Address newShippingAddress;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Before
    public void setUp() {
        this.newCustomer = new Customer();
        this.newCustomer.setFirstName("John");
        this.newCustomer.setLastName("Doe");
        this.newCustomer.setBirthDate("2000-06-16");
        this.newCustomer.setPhoneNumber("123456789");
        this.newCustomer.setNumberOfOrders(0);

        this.address = addressDao.read(ADDRESS_ID);

        this.newBillingAddress = new Address();
        this.newBillingAddress.setStreet("Magic Street");
        this.newBillingAddress.setStreetNumber("2B");
        this.newBillingAddress.setDoorNumber("100");
        this.newBillingAddress.setZipCode("22-333");
        this.newBillingAddress.setCity("Lublin");

        this.newShippingAddress = new Address();
        this.newShippingAddress.setStreet("No Magic Street");
        this.newShippingAddress.setStreetNumber("9");
        this.newShippingAddress.setDoorNumber("22A");
        this.newShippingAddress.setZipCode("22-333");
        this.newShippingAddress.setCity("Lublin");
    }

    @Test
    public void testUpdateBillingAddress() {
        assertEquals(1, customerDao.findAll().size());
        assertEquals(1, addressDao.findAll().size());

        Address toUpdate = addressDao.read(ADDRESS_ID);
        toUpdate.setStreet("No magic Street");
        toUpdate.setStreetNumber("3C");
        toUpdate.setDoorNumber("200");
        toUpdate.setZipCode("33-444");
        addressDao.updateBillingAddress(address);

        Address found = addressDao.read(ADDRESS_ID);

        assertNotNull(found);
        assertEquals(ADDRESS_ID, found.getId());
        assertEquals("No magic Street", found.getStreet());
        assertEquals("3C", found.getStreetNumber());
        assertEquals("200", found.getDoorNumber());
        assertEquals("33-444", found.getZipCode());
        assertEquals("Warsaw", found.getCity());

        assertEquals(1, customerDao.findAll().size());
        assertEquals(1, addressDao.findAll().size());
    }

    @Test
    public void testCreateShippingAddressWithDifferentBillingAddress() {
        assertEquals(1, addressDao.findAll().size());

        addressDao.createShippingAddress(newShippingAddress);

        Long newAddressId = 2L;
        Address found = addressDao.read(newAddressId);

        assertNotNull(found);
        assertEquals(newAddressId, found.getId());
        assertEquals("No Magic Street", found.getStreet());
        assertEquals("9", found.getStreetNumber());
        assertEquals("22A", found.getDoorNumber());
        assertEquals("22-333", found.getZipCode());
        assertEquals("Lublin", found.getCity());

        assertEquals(2, addressDao.findAll().size());
    }

    @Test
    public void testCreateShippingAddressWithSameBillingAddress() {
        assertEquals(1, addressDao.findAll().size());

        addressDao.createShippingAddress(address);

        Address found = addressDao.read(ADDRESS_ID);

        assertNotNull(found);
        assertEquals(ADDRESS_ID, found.getId());
        assertEquals("Koszycka", found.getStreet());
        assertEquals("6A", found.getStreetNumber());
        assertEquals("25", found.getDoorNumber());
        assertEquals("01-446", found.getZipCode());
        assertEquals("Warsaw", found.getCity());

        assertEquals(1, addressDao.findAll().size());
    }
}

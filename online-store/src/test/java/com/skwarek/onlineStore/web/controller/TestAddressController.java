package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.address.City;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Michal on 29/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAddressController {

    private AccountService accountService;
    private AddressService addressService;
    private AddressController addressController;

    private MockMvc mockMvc;

    private String username;
    private City newCity;
    private Address newAddress;
    private Customer newCustomer;
    private Account newAccount;

    @Before
    public void setUp() {
        this.username = "user";

        this.newCity = new City();
        this.newCity.setId(1L);
        this.newCity.setName("New City");

        this.newAddress = new Address();
        this.newAddress.setId(1L);
        this.newAddress.setStreet("Magic Street");
        this.newAddress.setStreetNumber("1A");
        this.newAddress.setDoorNumber("99");
        this.newAddress.setZipCode("11-222");
        this.newAddress.setCity(newCity);

        this.newCustomer = new Customer();
        this.newCustomer.setBillingAddress(newAddress);

        this.newAccount = new Account();
        this.newAccount.setCustomer(newCustomer);

        this.accountService = mock(AccountService.class);
        this.addressService = mock(AddressService.class);
        this.addressController = new AddressController(accountService, addressService);

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.addressController)
                .build();

        given(this.accountService.findAccountByUsername(username)).willReturn(newAccount);
    }

    @Test
    public void testInitCreateAddressForm() throws Exception {
        mockMvc.perform(get("/addresses/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("address"))
                .andExpect(view().name("addresses/addressData"));
    }

    @Test
    public void testProcessCreateAddressFormSuccess() throws Exception {
        mockMvc.perform(post("/addresses/new")
                .param("street", "Magic Street")
                .param("streetNumber", "1A")
                .param("doorNumber", "99")
                .param("zipCode", "11-222")
                .param("city.name", "New City")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/welcome"));
    }

    @Test
    public void testProcessCreateAddressFormHasErrors() throws Exception {
        mockMvc.perform(post("/addresses/new")
                .param("street", "")
                .param("streetNumber", "")
                .param("doorNumber", "99")
                .param("zipCode", "11222")
                .param("city.name", "")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("address"))
                .andExpect(model().attributeHasFieldErrors("address", "street"))
                .andExpect(model().attributeHasFieldErrors("address", "streetNumber"))
                .andExpect(model().attributeHasFieldErrors("address", "zipCode"))
                .andExpect(model().attributeHasFieldErrors("address", "city.name"))
                .andExpect(view().name("addresses/addressData"));
    }

    @Test
    public void testInitUpdateAddressForm() throws Exception {
        mockMvc.perform(get("/addresses/edit/{username}", username))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("address"))
                .andExpect(model().attribute("address", newAddress))
                .andExpect(view().name("addresses/addressData"));
    }

    @Test
    public void testProcessUpdateAccountFormSuccess() throws Exception {
        mockMvc.perform(post("/addresses/edit/{username}", username)
                .param("street", "Magic Street 1")
                .param("streetNumber", "2A")
                .param("doorNumber", "100")
                .param("zipCode", "22-222")
                .param("city.name", "New City 1")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/users/" + username));
    }

    @Test
    public void testProcessUpdateAddressFormHasErrors() throws Exception {
        mockMvc.perform(post("/addresses/edit/{username}", username)
                .param("street", "")
                .param("streetNumber", "")
                .param("doorNumber", "100")
                .param("zipCode", "11222")
                .param("city.name", "")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("address"))
                .andExpect(model().attributeHasFieldErrors("address", "street"))
                .andExpect(model().attributeHasFieldErrors("address", "streetNumber"))
                .andExpect(model().attributeHasFieldErrors("address", "zipCode"))
                .andExpect(model().attributeHasFieldErrors("address", "city.name"))
                .andExpect(view().name("addresses/addressData"));
    }
}

package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.address.Address;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Michal on 29/11/2016.
 */
@ContextConfiguration(classes = ApplicationContextConfiguration.class)
public class TestAddressController {

    private final static String VIEWS_ADDRESS_FORM = "addresses/addressData";
    private final static String REDIRECT_TO = "redirect:";

    private final static String ACCOUNT_USERNAME = "aaa";
    private final static Long ADDRESS_ID = 1L;

    private Account account;
    private Address address;

    private AccountService accountService;
    private AddressService addressService;
    private AddressController addressController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MyEmbeddedDatabase myDB = new MyEmbeddedDatabase();

        this.account = myDB.getAccount_no_1();
        this.address = myDB.getAddress_no_1();

        this.accountService = mock(AccountService.class);
        this.addressService = mock(AddressService.class);

        this.addressController = new AddressController(accountService, addressService);

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.addressController)
                .build();
    }

    @Test
    public void initCreateAddressForm_ShouldAddEmptyAddressToModelAndRenderEmptyAddressFormView() throws Exception {
        mockMvc.perform(get("/addresses/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("address"))
                .andExpect(model().attribute("address", hasProperty("id", nullValue())))
                .andExpect(model().attribute("address", hasProperty("street", nullValue())))
                .andExpect(model().attribute("address", hasProperty("streetNumber", nullValue())))
                .andExpect(model().attribute("address", hasProperty("doorNumber", nullValue())))
                .andExpect(model().attribute("address", hasProperty("zipCode", nullValue())))
                .andExpect(model().attribute("address", hasProperty("city", nullValue())))
                .andExpect(model().attribute("address", hasProperty("customer", nullValue())))
                .andExpect(model().attribute("address", hasProperty("shippingDetails", nullValue())))
                .andExpect(forwardedUrl(VIEWS_ADDRESS_FORM))
                .andExpect(view().name(VIEWS_ADDRESS_FORM));

        verifyZeroInteractions(accountService);
        verifyZeroInteractions(addressService);
    }

    @Test
    public void processCreateAddressForm_ShouldHasErrors() throws Exception {
        mockMvc.perform(post("/addresses/new")
                .param("street", "")
                .param("streetNumber", "")
                .param("doorNumber", "99")
                .param("zipCode", "11222")
                .param("city", "")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("address"))
                .andExpect(model().attributeHasErrors("address"))
                .andExpect(model().attributeHasFieldErrors("address", "street"))
                .andExpect(model().attributeHasFieldErrors("address", "streetNumber"))
                .andExpect(model().attributeHasFieldErrors("address", "zipCode"))
                .andExpect(model().attributeHasFieldErrors("address", "city"))
                .andExpect(model().attribute("address", hasProperty("id", nullValue())))
                .andExpect(model().attribute("address", hasProperty("street", isEmptyString())))
                .andExpect(model().attribute("address", hasProperty("streetNumber", isEmptyString())))
                .andExpect(model().attribute("address", hasProperty("doorNumber", is("99"))))
                .andExpect(model().attribute("address", hasProperty("zipCode", is("11222"))))
                .andExpect(model().attribute("address", hasProperty("city", isEmptyString())))
                .andExpect(model().attribute("address", hasProperty("customer", nullValue())))
                .andExpect(model().attribute("address", hasProperty("shippingDetails", nullValue())))
                .andExpect(forwardedUrl(VIEWS_ADDRESS_FORM))
                .andExpect(view().name(VIEWS_ADDRESS_FORM));

        verifyZeroInteractions(accountService);
        verifyZeroInteractions(addressService);
    }

    @Test
    public void processCreateAddressForm_ShouldBeFine() throws Exception {
        mockMvc.perform(post("/addresses/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("street", "Magic Street")
                .param("streetNumber", "1A")
                .param("doorNumber", "99")
                .param("zipCode", "11-222")
                .param("city", "New City")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/welcome"))
                .andExpect(view().name(REDIRECT_TO + "/welcome"));

        ArgumentCaptor<Address> formObjectArgument = ArgumentCaptor.forClass(Address.class);
        verify(addressService, times(1)).createBillingAddress(formObjectArgument.capture());
        verifyZeroInteractions(accountService);
        verifyZeroInteractions(addressService);

        Address formCustomer = formObjectArgument.getValue();

        assertThat(formCustomer.getId(), nullValue());
        assertThat(formCustomer.getStreet(), is("Magic Street"));
        assertThat(formCustomer.getStreetNumber(), is("1A"));
        assertThat(formCustomer.getDoorNumber(), is("99"));
        assertThat(formCustomer.getZipCode(), is("11-222"));
        assertThat(formCustomer.getCity(), is("New City"));
        assertThat(formCustomer.getCustomer(), nullValue());
        assertThat(formCustomer.getShippingDetails(), nullValue());
    }

    @Test
    public void initUpdateAddressForm_ShouldAddAddressToModelAndRenderAddressFormView() throws Exception {
        given(this.accountService.findAccountByUsername(ACCOUNT_USERNAME)).willReturn(account);

        mockMvc.perform(get("/addresses/edit/{username}", ACCOUNT_USERNAME))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("address"))
                .andExpect(model().attribute("address", address))
                .andExpect(model().attribute("address", hasProperty("id", is(ADDRESS_ID))))
                .andExpect(model().attribute("address", hasProperty("street", is("Koszycka"))))
                .andExpect(model().attribute("address", hasProperty("streetNumber", is("6A"))))
                .andExpect(model().attribute("address", hasProperty("doorNumber", is("25"))))
                .andExpect(model().attribute("address", hasProperty("zipCode", is("01-446"))))
                .andExpect(model().attribute("address", hasProperty("city", is("Warsaw"))))
                .andExpect(model().attribute("address", hasProperty("customer", is(account.getCustomer()))))
                .andExpect(model().attribute("address", hasProperty("shippingDetails",
                        is(account.getCustomer().getBillingAddress().getShippingDetails()))))
                .andExpect(forwardedUrl(VIEWS_ADDRESS_FORM))
                .andExpect(view().name(VIEWS_ADDRESS_FORM));

        verify(accountService, times(1)).findAccountByUsername(ACCOUNT_USERNAME);
        verifyNoMoreInteractions(accountService);
        verifyZeroInteractions(addressService);
    }

    @Test
    public void processUpdateAddressForm_ShouldHasErrors() throws Exception {
        mockMvc.perform(post("/addresses/edit/{username}", ACCOUNT_USERNAME)
                .param("street", "")
                .param("streetNumber", "")
                .param("doorNumber", "99")
                .param("zipCode", "11222")
                .param("city", "")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("address"))
                .andExpect(model().attributeHasErrors("address"))
                .andExpect(model().attributeHasFieldErrors("address", "street"))
                .andExpect(model().attributeHasFieldErrors("address", "streetNumber"))
                .andExpect(model().attributeHasFieldErrors("address", "zipCode"))
                .andExpect(model().attributeHasFieldErrors("address", "city"))
                .andExpect(model().attribute("address", hasProperty("id", nullValue())))
                .andExpect(model().attribute("address", hasProperty("street", isEmptyString())))
                .andExpect(model().attribute("address", hasProperty("streetNumber", isEmptyString())))
                .andExpect(model().attribute("address", hasProperty("doorNumber", is("99"))))
                .andExpect(model().attribute("address", hasProperty("zipCode", is("11222"))))
                .andExpect(model().attribute("address", hasProperty("city", isEmptyString())))
                .andExpect(model().attribute("address", hasProperty("customer", nullValue())))
                .andExpect(model().attribute("address", hasProperty("shippingDetails", nullValue())))
                .andExpect(forwardedUrl(VIEWS_ADDRESS_FORM))
                .andExpect(view().name(VIEWS_ADDRESS_FORM));

        verifyZeroInteractions(accountService);
        verifyZeroInteractions(addressService);
    }

    @Test
    public void processUpdateAddressForm_ShouldBeFine() throws Exception {
        mockMvc.perform(post("/addresses/edit/{username}", ACCOUNT_USERNAME)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("street", "Magic Street")
                .param("streetNumber", "1A")
                .param("doorNumber", "99")
                .param("zipCode", "11-222")
                .param("city", "New City")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users/" + ACCOUNT_USERNAME))
                .andExpect(view().name(REDIRECT_TO + "/users/" + ACCOUNT_USERNAME));

        ArgumentCaptor<Address> formObjectArgument = ArgumentCaptor.forClass(Address.class);
        verify(addressService, times(1)).updateBillingAddress(formObjectArgument.capture());
        verifyZeroInteractions(accountService);
        verifyZeroInteractions(addressService);

        Address formCustomer = formObjectArgument.getValue();

        assertThat(formCustomer.getId(), nullValue());
        assertThat(formCustomer.getStreet(), is("Magic Street"));
        assertThat(formCustomer.getStreetNumber(), is("1A"));
        assertThat(formCustomer.getDoorNumber(), is("99"));
        assertThat(formCustomer.getZipCode(), is("11-222"));
        assertThat(formCustomer.getCity(), is("New City"));
        assertThat(formCustomer.getCustomer(), nullValue());
        assertThat(formCustomer.getShippingDetails(), nullValue());
    }
}

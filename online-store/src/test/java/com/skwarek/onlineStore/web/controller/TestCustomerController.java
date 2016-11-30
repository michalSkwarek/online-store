package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Michal on 29/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestCustomerController {

    private AccountService accountService;
    private CustomerService customerService;
    private CustomerController customerController;

    private MockMvc mockMvc;

    private String username;
    private Customer newCustomer;
    private Account newAccount;

    @Before
    public void setUp() {
        this.username = "user";

        this.newCustomer = new Customer();
        this.newCustomer.setId(1L);
        this.newCustomer.setFirstName("John");
        this.newCustomer.setLastName("Doe");
        this.newCustomer.setBirthDate("2000-06-16");
        this.newCustomer.setPhoneNumber("123456789");
        this.newCustomer.setNumberOfOrders(1);

        this.newAccount = new Account();
        this.newAccount.setCustomer(newCustomer);

        this.accountService = mock(AccountService.class);
        this.customerService = mock(CustomerService.class);
        this.customerController = new CustomerController(accountService, customerService);

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.customerController)
                .build();

        given(this.accountService.findAccountByUsername(username)).willReturn(newAccount);
    }

    @Test
    public void testInitCreateCustomerForm() throws Exception {
        mockMvc.perform(get("/customers/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customer"))
                .andExpect(view().name("customers/customerData"));
    }

    @Test
    public void testProcessCreateCustomerFormSuccess() throws Exception {
        mockMvc.perform(post("/customers/new")
                .param("firstName", "John")
                .param("lastName", "Doe")
                .param("birthDate", "2000-06-16")
                .param("phoneNumber", "123456789")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/addresses/new"));
    }

    @Test
    public void testProcessCreateCustomerFormHasErrors() throws Exception {
        mockMvc.perform(post("/customers/new")
                .param("firstName", "")
                .param("lastName", "")
                .param("birthDate", "2000-VI-16")
                .param("phoneNumber", "123456789")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("customer"))
                .andExpect(model().attributeHasFieldErrors("customer", "firstName"))
                .andExpect(model().attributeHasFieldErrors("customer", "lastName"))
                .andExpect(model().attributeHasFieldErrors("customer", "birthDate"))
                .andExpect(view().name("customers/customerData"));
    }

    @Test
    public void testInitUpdateCustomerForm() throws Exception {
        mockMvc.perform(get("/customers/edit/{username}", username))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attribute("customer", newCustomer))
                .andExpect(view().name("customers/customerData"));

        verify(accountService, times(1)).findAccountByUsername(username);
    }

    @Test
    public void testProcessUpdateCustomerFormSuccess() throws Exception {
        mockMvc.perform(post("/customers/edit/{username}", username)
                .param("firstName", "John1")
                .param("lastName", "Doe1")
                .param("birthDate", "2000-06-17")
                .param("phoneNumber", "111222333")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/users/" + username));
    }

    @Test
    public void testProcessUpdateCustomerFormHasErrors() throws Exception {
        mockMvc.perform(post("/customers/edit/{username}", username)
                .param("firstName", "")
                .param("lastName", "")
                .param("birthDate", "2000-VI-17")
                .param("phoneNumber", "111222333")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeHasErrors("customer"))
                .andExpect(model().attributeHasFieldErrors("customer", "firstName"))
                .andExpect(model().attributeHasFieldErrors("customer", "lastName"))
                .andExpect(model().attributeHasFieldErrors("customer", "birthDate"))
                .andExpect(view().name("customers/customerData"));
    }
}

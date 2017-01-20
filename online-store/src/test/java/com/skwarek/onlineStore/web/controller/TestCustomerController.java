package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import com.skwarek.onlineStore.service.AccountService;
import com.skwarek.onlineStore.service.CustomerService;
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
public class TestCustomerController {

    private final static String VIEWS_CUSTOMER_FORM = "customers/customerData";
    private final static String REDIRECT_TO = "redirect:";

    private final static String ACCOUNT_USERNAME = "aaa";
    private final static Long CUSTOMER_ID = 1L;

    private Account account;
    private Customer customer;

    private AccountService accountService;
    private CustomerService customerService;
    private CustomerController customerController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MyEmbeddedDatabase myDB = new MyEmbeddedDatabase();

        this.account = myDB.getAccount_no_1();
        this.customer = myDB.getCustomer_no_1();

        this.accountService = mock(AccountService.class);
        this.customerService = mock(CustomerService.class);

        this.customerController = new CustomerController(accountService, customerService);

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.customerController)
                .build();
    }

    @Test
    public void initCreateCustomerForm_ShouldAddEmptyCustomerToModelAndRenderEmptyCustomerFormView() throws Exception {
        mockMvc.perform(get("/customers/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attribute("customer", hasProperty("id", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("firstName", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("lastName", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("birthDate", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("billingAddress", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("numberOfOrders", is(0))))
                .andExpect(forwardedUrl(VIEWS_CUSTOMER_FORM))
                .andExpect(view().name(VIEWS_CUSTOMER_FORM));

        verifyZeroInteractions(accountService);
        verifyZeroInteractions(customerService);
    }

    @Test
    public void processCreateCustomerForm_ShouldHasErrors() throws Exception {
        mockMvc.perform(post("/customers/new")
                .param("firstName", "")
                .param("lastName", "")
                .param("birthDate", "2000-VI-16")
                .param("phoneNumber", "123456789")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attributeHasErrors("customer"))
                .andExpect(model().attributeHasFieldErrors("customer", "firstName"))
                .andExpect(model().attributeHasFieldErrors("customer", "lastName"))
                .andExpect(model().attributeHasFieldErrors("customer", "birthDate"))
                .andExpect(model().attribute("customer", hasProperty("id", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("firstName", isEmptyString())))
                .andExpect(model().attribute("customer", hasProperty("lastName", isEmptyString())))
                .andExpect(model().attribute("customer", hasProperty("birthDate", is("2000-VI-16"))))
                .andExpect(model().attribute("customer", hasProperty("billingAddress", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is("123456789"))))
                .andExpect(model().attribute("customer", hasProperty("numberOfOrders", is(0))))
                .andExpect(forwardedUrl(VIEWS_CUSTOMER_FORM))
                .andExpect(view().name(VIEWS_CUSTOMER_FORM));

        verifyZeroInteractions(accountService);
        verifyZeroInteractions(customerService);
    }

    @Test
    public void processCreateCustomerForm_ShouldBeFine() throws Exception {
        mockMvc.perform(post("/customers/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", "John")
                .param("lastName", "Doe")
                .param("birthDate", "2000-06-16")
                .param("phoneNumber", "123456789")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/addresses/new"))
                .andExpect(view().name(REDIRECT_TO + "/addresses/new"));

        ArgumentCaptor<Customer> formObjectArgument = ArgumentCaptor.forClass(Customer.class);
        verify(customerService, times(1)).createCustomer(formObjectArgument.capture());
        verifyZeroInteractions(accountService);
        verifyZeroInteractions(customerService);

        Customer formCustomer = formObjectArgument.getValue();

        assertThat(formCustomer.getId(), nullValue());
        assertThat(formCustomer.getFirstName(), is("John"));
        assertThat(formCustomer.getLastName(), is("Doe"));
        assertThat(formCustomer.getBirthDate(), is("2000-06-16"));
        assertThat(formCustomer.getBillingAddress(), nullValue());
        assertThat(formCustomer.getPhoneNumber(), is("123456789"));
        assertThat(formCustomer.getNumberOfOrders(), is(0));
    }

    @Test
    public void initUpdateCustomerForm_ShouldAddCustomerToModelAndRenderCustomerFormView() throws Exception {
        given(this.accountService.findAccountByUsername(ACCOUNT_USERNAME)).willReturn(account);

        mockMvc.perform(get("/customers/edit/{username}", ACCOUNT_USERNAME))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attribute("customer", customer))
                .andExpect(model().attribute("customer", hasProperty("id", is(CUSTOMER_ID))))
                .andExpect(model().attribute("customer", hasProperty("firstName", is("Michal"))))
                .andExpect(model().attribute("customer", hasProperty("lastName", is("Abacki"))))
                .andExpect(model().attribute("customer", hasProperty("birthDate", is("1990-01-20"))))
                .andExpect(model().attribute("customer", hasProperty("billingAddress", is(customer.getBillingAddress()))))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is("111222333"))))
                .andExpect(model().attribute("customer", hasProperty("numberOfOrders", is(1))))
                .andExpect(forwardedUrl(VIEWS_CUSTOMER_FORM))
                .andExpect(view().name(VIEWS_CUSTOMER_FORM));

        verify(accountService, times(1)).findAccountByUsername(ACCOUNT_USERNAME);
        verifyNoMoreInteractions(accountService);
        verifyZeroInteractions(customerService);
    }

    @Test
    public void processUpdateCustomerForm_ShouldHasErrors() throws Exception {
        mockMvc.perform(post("/customers/edit/{username}", ACCOUNT_USERNAME)
                .param("firstName", "")
                .param("lastName", "")
                .param("birthDate", "2000-VI-16")
                .param("phoneNumber", "123456789")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attributeHasErrors("customer"))
                .andExpect(model().attributeHasFieldErrors("customer", "firstName"))
                .andExpect(model().attributeHasFieldErrors("customer", "lastName"))
                .andExpect(model().attributeHasFieldErrors("customer", "birthDate"))
                .andExpect(model().attribute("customer", hasProperty("id", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("firstName", isEmptyString())))
                .andExpect(model().attribute("customer", hasProperty("lastName", isEmptyString())))
                .andExpect(model().attribute("customer", hasProperty("birthDate", is("2000-VI-16"))))
                .andExpect(model().attribute("customer", hasProperty("billingAddress", nullValue())))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is("123456789"))))
                .andExpect(model().attribute("customer", hasProperty("numberOfOrders", is(0))))
                .andExpect(forwardedUrl(VIEWS_CUSTOMER_FORM))
                .andExpect(view().name(VIEWS_CUSTOMER_FORM));

        verifyZeroInteractions(accountService);
        verifyZeroInteractions(customerService);
    }

    @Test
    public void processUpdateCustomerForm_ShouldBeFine() throws Exception {
        mockMvc.perform(post("/customers/edit/{username}", ACCOUNT_USERNAME)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", "John")
                .param("lastName", "Doe")
                .param("birthDate", "2000-06-16")
                .param("phoneNumber", "123456789")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users/" + ACCOUNT_USERNAME))
                .andExpect(view().name(REDIRECT_TO + "/users/" + ACCOUNT_USERNAME));

        ArgumentCaptor<Customer> formObjectArgument = ArgumentCaptor.forClass(Customer.class);
        verify(customerService, times(1)).updateCustomer(formObjectArgument.capture());
        verifyZeroInteractions(accountService);
        verifyZeroInteractions(customerService);

        Customer formCustomer = formObjectArgument.getValue();

        assertThat(formCustomer.getId(), nullValue());
        assertThat(formCustomer.getFirstName(), is("John"));
        assertThat(formCustomer.getLastName(), is("Doe"));
        assertThat(formCustomer.getBirthDate(), is("2000-06-16"));
        assertThat(formCustomer.getBillingAddress(), nullValue());
        assertThat(formCustomer.getPhoneNumber(), is("123456789"));
        assertThat(formCustomer.getNumberOfOrders(), is(0));
    }
}

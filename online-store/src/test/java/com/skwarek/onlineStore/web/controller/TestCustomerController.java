//package com.skwarek.onlineStore.web.controller;
//
//import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
//import com.skwarek.onlineStore.data.dao.AccountDao;
//import com.skwarek.onlineStore.data.entity.user.Account;
//import com.skwarek.onlineStore.data.entity.user.Customer;
//import com.skwarek.onlineStore.service.AccountService;
//import com.skwarek.onlineStore.service.CustomerService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
///**
// * Created by Michal on 29/11/2016.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ApplicationContextConfiguration.class)
//@WebAppConfiguration
////@Transactional
//public class TestCustomerController {
//
//    private static final long ID = 1;
//
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private CustomerService customerService;
//
//    @Mock
//    private AccountDao accountDao;
//
//    private Customer newCustomer;
//
//    @Before
//    public void setUp() {
//        newCustomer = new Customer();
//        newCustomer.setFirstName("John");
//        newCustomer.setLastName("Doe");
//        newCustomer.setBirthDate("2000-06-16");
//        newCustomer.setPhoneNumber("123456789");
//        newCustomer.setNumberOfOrders(1);
//
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
//                .build();
//        accountService.createAccount(newAccount);
//        System.out.println("dupa " + this.accountService.findAccountByUsername("user"));
//        given(this.accountDao.findAccountByUsername("user")).willReturn(newAccount);
//    }
//
//    @Test
//    public void testInitCreateCustomerForm() throws Exception {
//        mockMvc.perform(get("/customers/new"))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("customer"))
//                .andExpect(view().name("customers/customerData"));
//    }
//
//    @Test
//    public void testProcessCreateCustomerFormSuccess() throws Exception {
//        mockMvc.perform(post("/customers/new")
//                .param("firstName", "John")
//                .param("lastName", "Doe")
//                .param("birthDate", "2000-06-16")
//                .param("phoneNumber", "123456789")
//        )
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/addresses/new"));
//    }
//
//    @Test
//    public void testProcessCreateCustomerFormHasErrors() throws Exception {
//        mockMvc.perform(post("/customers/new")
//                .param("firstName", "")
//                .param("lastName", "")
//                .param("birthDate", "2000-VI-16")
//                .param("phoneNumber", "123456789")
//        )
//                .andExpect(status().isOk())
//                .andExpect(model().attributeHasErrors("customer"))
//                .andExpect(model().attributeHasFieldErrors("customer", "firstName"))
//                .andExpect(model().attributeHasFieldErrors("customer", "lastName"))
//                .andExpect(model().attributeHasFieldErrors("customer", "birthDate"))
//                .andExpect(view().name("customers/customerData"));
//    }
//
//    @Test
//    public void testInitUpdateCustomerForm() throws Exception {
//        mockMvc.perform(get("/customers/edit/{username}", newAccount.getUsername()))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("account"))
//                .andExpect(model().attribute("account", hasProperty("username", is("user"))))
//                .andExpect(model().attribute("account", hasProperty("password", is("pass"))))
//                .andExpect(model().attribute("account", hasProperty("email", is("email@gmail.com"))))
//                .andExpect(view().name("accounts/accountData"));
//    }
//
//    @Test
//    public void testProcessUpdateCustomerFormSuccess() throws Exception {
////        accountService.createAccount(newAccount);
//        mockMvc.perform(post("/customers/edit/{username}", newCustomer.getUsername())
//                .param("firstName", "John1")
//                .param("lastName", "Doe1")
//                .param("birthDate", "2000-06-17")
//                .param("phoneNumber", "111222333")
//        )
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/users/{username}"));
//    }
//
//    @Test
//    public void testProcessUpdateCustomerFormHasErrors() throws Exception {
//        accountService.createAccount(newAccount);
//        mockMvc.perform(post("/customers/edit/{username}", newCustomer.getUsername())
//                .param("firstName", "")
//                .param("lastName", "")
//                .param("birthDate", "2000-VI-17")
//                .param("phoneNumber", "111222333")
//        )
//                .andExpect(status().isOk())
//                .andExpect(model().attributeHasErrors("customer"))
//                .andExpect(model().attributeHasFieldErrors("customer", "firstName"))
//                .andExpect(model().attributeHasFieldErrors("customer", "lastName"))
//                .andExpect(model().attributeHasFieldErrors("customer", "birthDate"))
//                .andExpect(view().name("customers/customerData"));
//    }
//}

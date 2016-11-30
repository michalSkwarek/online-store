//package com.skwarek.onlineStore.web.controller;
//
//import com.skwarek.onlineStore.configuration.ApplicationContextConfiguration;
//import com.skwarek.onlineStore.data.dao.AccountDao;
//import com.skwarek.onlineStore.data.entity.address.Address;
//import com.skwarek.onlineStore.data.entity.address.City;
//import com.skwarek.onlineStore.data.entity.user.Account;
//import com.skwarek.onlineStore.service.AccountService;
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
//public class TestAddressController {
//
//    private static final long ID = 1;
//
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private AccountService accountService;
//
//    @Mock
//    private AccountDao accountDao;
//
//    private City newCity;
//    private Address newAddress;
//
//    @Before
//    public void setUp() {
//        newCity = new City();
//        newCity.setName("New City");
//        newAddress = new Address();
//        newAddress.setStreet("Magic Street");
//        newAddress.setStreetNumber("1A");
//        newAddress.setDoorNumber("99");
//        newAddress.setZipCode("11-222");
//        newAddress.setCity(newCity);
//
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
//                .build();
//        accountService.createAccount(newAccount);
//        System.out.println("dupa " + this.accountService.findAccountByUsername("user"));
//        given(this.accountDao.findAccountByUsername("user")).willReturn(newAccount);
//    }
//
//    @Test
//    public void testInitCreateAddressForm() throws Exception {
//        mockMvc.perform(get("/addresses/new"))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("address"))
//                .andExpect(view().name("addresses/addressData"));
//    }
//
//    @Test
//    public void testProcessCreateAddressFormSuccess() throws Exception {
//        mockMvc.perform(post("/addresses/new")
//                .param("street", "Magic Street")
//                .param("streetNumber", "1A")
//                .param("doorNumber", "99")
//                .param("zipCode", "11-222")
//                .param("city.name", "New City")
//        )
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/addresses/new"));
//    }
//
//    @Test
//    public void testProcessCreateAddressFormHasErrors() throws Exception {
//        mockMvc.perform(post("/addresses/new")
//                .param("street", "")
//                .param("streetNumber", "")
//                .param("doorNumber", "99")
//                .param("zipCode", "11222")
//                .param("city.name", "")
//        )
//                .andExpect(status().isOk())
//                .andExpect(model().attributeHasErrors("address"))
//                .andExpect(model().attributeHasFieldErrors("address", "street"))
//                .andExpect(model().attributeHasFieldErrors("address", "streetNumber"))
//                .andExpect(model().attributeHasFieldErrors("address", "zipCode"))
//                .andExpect(model().attributeHasFieldErrors("address", "city.name"))
//                .andExpect(view().name("addresses/addressData"));
//    }
//
//    @Test
//    public void testInitUpdateAddressForm() throws Exception {
//        mockMvc.perform(get("/addresses/edit/{username}", newAccount.getUsername()))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("address"))
//                .andExpect(model().attribute("address", hasProperty("username", is("user"))))
//                .andExpect(model().attribute("address", hasProperty("password", is("pass"))))
//                .andExpect(model().attribute("address", hasProperty("email", is("email@gmail.com"))))
//                .andExpect(view().name("addresses/addressData"));
//    }
//
//    @Test
//    public void testProcessUpdateAccountFormSuccess() throws Exception {
////        accountService.createAccount(newAccount);
//        mockMvc.perform(post("/addresses/edit/{username}", "user")
//                .param("street", "Magic Street 1")
//                .param("streetNumber", "2A")
//                .param("doorNumber", "100")
//                .param("zipCode", "22-222")
//                .param("city.name", "New City 1")
//        )
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/users/{username}"));
//    }
//
//    @Test
//    public void testProcessUpdateAddressFormHasErrors() throws Exception {
//        accountService.createAccount(newAccount);
//        mockMvc.perform(post("/addresses/edit/{username}", newAccount.getUsername())
//                .param("street", "")
//                .param("streetNumber", "")
//                .param("doorNumber", "100")
//                .param("zipCode", "11222")
//                .param("city.name", "")
//        )
//                .andExpect(status().isOk())
//                .andExpect(model().attributeHasErrors("address"))
//                .andExpect(model().attributeHasFieldErrors("address", "street"))
//                .andExpect(model().attributeHasFieldErrors("address", "streetNumber"))
//                .andExpect(model().attributeHasFieldErrors("address", "zipCode"))
//                .andExpect(model().attributeHasFieldErrors("address", "city.name"))
//                .andExpect(view().name("addresses/addressData"));
//    }
//}

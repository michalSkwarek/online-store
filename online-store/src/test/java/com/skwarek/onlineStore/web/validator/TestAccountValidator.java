package com.skwarek.onlineStore.web.validator;

import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.data.entity.user.Customer;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Michal on 30/11/2016.
 */
public class TestAccountValidator {

    private Validator validator;

    private Account newAccount;
    private Customer newCustomer;

    @Before
    public void setUp() {
        this.newCustomer = new Customer();
        this.newCustomer.setFirstName("John");
        this.newCustomer.setLastName("Doe");
        this.newCustomer.setBirthDate("2000-06-16");
        this.newCustomer.setPhoneNumber("123456789");
        this.newCustomer.setNumberOfOrders(1);

        this.newAccount = new Account();
        this.newAccount.setUsername("user");
        this.newAccount.setPassword("pass");
        this.newAccount.setEmail("email@gmail.com");
        this.newAccount.setCustomer(newCustomer);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void accountIsValid() {
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(newAccount);

        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void usernameTooShort() {
        newAccount.setUsername("us");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(newAccount);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.username.validation.size}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void usernameTooLong() {
        newAccount.setUsername("userna");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(newAccount);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.username.validation.size}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void passwordTooShort() {
        newAccount.setPassword("ps");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(newAccount);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.password.validation.size}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void passwordTooLong() {
        newAccount.setPassword("passwo");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(newAccount);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.password.validation.size}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void emailIsNull() {
        newAccount.setEmail("");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(newAccount);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.email.validation.notEmpty}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void emailHasInvalidForm() {
        newAccount.setEmail("emailgmail.com");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(newAccount);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.email.validation.pattern}", constraintViolations.iterator().next().getMessage());
    }
}

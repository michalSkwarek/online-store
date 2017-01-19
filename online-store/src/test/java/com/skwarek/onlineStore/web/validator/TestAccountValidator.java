package com.skwarek.onlineStore.web.validator;

import com.skwarek.onlineStore.MyEmbeddedDatabase;
import com.skwarek.onlineStore.data.entity.user.Account;
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

    private Account account;

    @Before
    public void setUp() {
        MyEmbeddedDatabase myDB = new MyEmbeddedDatabase();

        this.account = myDB.getAccount_no_1();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void accountIsValid() {
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(account);

        assertEquals(0, constraintViolations.size());
    }

    @Test
    public void usernameTooShort() {
        account.setUsername("us");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(account);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.username.validation.size}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void usernameTooLong() {
        account.setUsername("userna");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(account);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.username.validation.size}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void passwordTooShort() {
        account.setPassword("ps");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(account);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.password.validation.size}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void passwordTooLong() {
        account.setPassword("passwo");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(account);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.password.validation.size}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void emailIsNull() {
        account.setEmail("");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(account);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.email.validation.notEmpty}", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void emailHasInvalidForm() {
        account.setEmail("emailgmail.com");
        Set<ConstraintViolation<Account>> constraintViolations =
                validator.validate(account);

        assertEquals(1, constraintViolations.size());
        assertEquals("{Account.email.validation.pattern}", constraintViolations.iterator().next().getMessage());
    }
}

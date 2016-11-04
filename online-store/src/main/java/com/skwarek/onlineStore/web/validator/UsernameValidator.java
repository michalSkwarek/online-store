package com.skwarek.onlineStore.web.validator;

import com.skwarek.onlineStore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Michal on 03/11/2016.
 */
@Component
public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Autowired
    private AccountService accountService;

    @Override
    public void initialize(Username constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return accountService.getAccountByUsername(value) == null;
    }
}

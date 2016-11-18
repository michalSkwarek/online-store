package com.skwarek.onlineStore.web.validator;

import com.skwarek.onlineStore.data.entity.user.Account;
import com.skwarek.onlineStore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Michal on 03/11/2016.
 */
@Component
public class UsernameValidator implements Validator {

    @Autowired
    private AccountService accountService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account account = (Account) target;
        if (accountService.findAccountByUsername(account.getUsername()) != null) {
            errors.rejectValue("username", "Account.username.validation.duplicate");
        }
    }
}

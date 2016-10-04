package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.AccountDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.user.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 04.10.2016.
 */
@Repository("accountDao")
public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements AccountDao {

}

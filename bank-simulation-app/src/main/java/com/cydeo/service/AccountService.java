package com.cydeo.service;

import com.cydeo.enums.AccountType;
import com.cydeo.model.Account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AccountService {

    //business logic creating a new account
    Account createNewAccount(BigDecimal balance, Date creationDate,
                             AccountType accountType,Long userId);

    //business logic storing list of accounts,
    List<Account> listAllAccount();
}

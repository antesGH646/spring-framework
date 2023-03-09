package com.cydeo.repository;

import com.cydeo.exception.RecordNotFoundException;
import com.cydeo.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AccountRepository {
    public static List<Account> accountList = new ArrayList<>();

    public Account save(Account account) {
        accountList.add(account);
        return account;
    }

    /**
     * Holds individual accounts
     * @return a list of accounts
     */
    public List<Account> findAll() {
        return accountList;
    }

    /**
     * The id must match with the id within the list of the accounts
     * @param id account id
     * @return matching id
     */
    public Account findById(UUID id) {
        //Task
        //finds accounts inside the list
        //throws RecordsNotFoundException, if not found
        return accountList.stream().filter(account ->account.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RecordNotFoundException(""));
    }
}

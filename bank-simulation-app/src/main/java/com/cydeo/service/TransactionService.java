package com.cydeo.service;

import com.cydeo.exception.BadRequestException;
import com.cydeo.model.Account;
import com.cydeo.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    //makes transactions
    Transaction makeTransfer(Account sender, Account receiver,
                             BigDecimal amount, Date creationDate, String message);

    //finds all transactions and stores them in a list
    List<Transaction> findAllTransaction();
}
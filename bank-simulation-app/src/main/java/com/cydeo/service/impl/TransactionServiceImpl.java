package com.cydeo.service.impl;

import com.cydeo.exception.BadRequestException;
import com.cydeo.model.Account;
import com.cydeo.model.Transaction;
import com.cydeo.repository.AccountRepository;
import com.cydeo.service.TransactionService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;

    public TransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Trows exception if the:
     *  -sender or receiver is null
     *  -sender and receiver is the same account
     *  -sender has enough balance
     *  -if both accounts are checking, if not, one of them saving, it needs to be same userId
     * @param sender
     * @param receiver
     * @param amount
     * @param creationDate
     * @param message
     * @return
     */
    @Override
    public Transaction makeTransfer(Account sender, Account receiver, BigDecimal amount,
                                    Date creationDate, String message) {

        validateAccount(sender,receiver);

        return null;
    }

    /**
     * Trows exception if the:
     *    -if any of the account is null
     *    -if account ids are the same(same account)
     *    -if the accounts exist in the database(repository)
     * @param sender
     * @param receiver
     */
    private void validateAccount(Account sender, Account receiver) {
        //is any of the account null
        //are the accounts the same
        //does the account exist in the database
        if(sender == null || receiver == null) {
            throw new BadRequestException("Sender or receiver cannot be null");
        }

        if(sender.getId().equals(receiver.getId())) {
            throw new BadRequestException(
                    "The Sender Account needs to be different the the Receiver Account");
        }

        findAccountById(sender.getId());

        findAccountById(receiver.getId());

        validateAccount(sender,receiver);
    }

    private void findAccountById(UUID id) {
        accountRepository.findById(id);
    }

    @Override
    public List<Transaction> findAllTransaction() {
        return null;
    }
}

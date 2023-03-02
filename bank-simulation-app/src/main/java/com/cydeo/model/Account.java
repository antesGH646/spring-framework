package com.cydeo.model;

import com.cydeo.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class Account {
    private UUID id; //Universal Unique Identifier
    private BigDecimal balance; //handles big decimals and is more precise
    private AccountType accountType;
    private Date creationDate;
    private Long userId;
}

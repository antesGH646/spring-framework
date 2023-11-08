package com.mycy.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity//marks to creat a table from this class, NB. a child class is annotated with entity
public class DebitAccount extends Account {
    private BigDecimal overDraftFee;
}

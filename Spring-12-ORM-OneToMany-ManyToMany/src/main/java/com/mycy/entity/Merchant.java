package com.mycy.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
public class Merchant extends BaseEntity{
    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;

    //no good to put cascading in Many-to-one relationship
    @OneToMany(mappedBy = "merchant")//one merchant to many payments
    private List<Payment> paymentList;//needs to be collection of objects

    //Constructor, id and relationship building objects are not included
    public Merchant(String name, String code, BigDecimal transactionFee,
                    BigDecimal commissionRate, Integer payoutDelayCount) {

        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}

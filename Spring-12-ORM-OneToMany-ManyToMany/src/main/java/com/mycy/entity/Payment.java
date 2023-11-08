package com.mycy.entity;

import com.mycy.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
public class Payment extends BaseEntity {

    @Column(columnDefinition = "Date")
    private LocalDate date;
    private BigDecimal amount;
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;

    @ManyToOne//no good to put cascading in Many-to-one relationship
    private Merchant merchant;//many payments to one merchant relationship

    @ManyToOne
    private Customer customer;

    //Constructor, id and relationship building objects are not included

    public Payment(LocalDate date, BigDecimal amount, Status status) {
        this.date = date;
        this.amount = amount;
        this.status = status;
    }
}

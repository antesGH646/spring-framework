package com.cydeo.repository;

import com.cydeo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * There are three ways to retrieve data from database tabes
 *  1) drive query: creating a method: syntax => findByfieldName(parameter) queries
 *  2) writing sq queries: uses @Query annotation
 *  3)PSQL(persistent sql query language): uses @Query annotation
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

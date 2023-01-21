package com.asiyesaribulak.account.repository;

import com.asiyesaribulak.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}

package com.asiyesaribulak.account.repository;

import com.asiyesaribulak.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {

}

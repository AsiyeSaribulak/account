package com.asiyesaribulak.account.service;

import com.asiyesaribulak.account.dto.AccountDto;
import com.asiyesaribulak.account.dto.CreateAccountRequest;
import com.asiyesaribulak.account.dto.converter.AccountDtoConverter;
import com.asiyesaribulak.account.model.Account;
import com.asiyesaribulak.account.model.Customer;
import com.asiyesaribulak.account.model.Transcation;
import com.asiyesaribulak.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;

    private final Clock clock;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, AccountDtoConverter accountDtoConverter, Clock clock) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.accountDtoConverter = accountDtoConverter;
        this.clock = clock;
    }
    protected AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer= customerService.findCustomerById(createAccountRequest.getId());

        Account account = new Account(customer,createAccountRequest.getInitialCredit(),getLocalDateTimeNow());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
            Transcation transcation=new Transcation(createAccountRequest.getInitialCredit(),getLocalDateTimeNow(),account);

            account.getTranscation().add(transcation);
        }
        return accountDtoConverter.convert(accountRepository.save(account));
    }

    private LocalDateTime getLocalDateTimeNow(){
        Instant instant=clock.instant();
        return LocalDateTime
                .ofInstant(instant,Clock.systemDefaultZone().getZone());
    }

}


package com.asiyesaribulak.account.controller;

import com.asiyesaribulak.account.dto.AccountDto;
import com.asiyesaribulak.account.dto.CreateAccountRequest;
import com.asiyesaribulak.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/V1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public ResponseEntity<AccountDto> createAccount(@RequestBody @Valid CreateAccountRequest request){
        return ResponseEntity.ok(accountService.createAccount(request));
    }
}

package com.asiyesaribulak.account.controller;

import com.asiyesaribulak.account.dto.CustomerDto;
import com.asiyesaribulak.account.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/V1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
@GetMapping("/{customerId}getCustomerById")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable @Valid String customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
}
@GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
}
}

package com.asiyesaribulak.account.service;

import com.asiyesaribulak.account.dto.CustomerDto;
import com.asiyesaribulak.account.dto.converter.CustomerDtoConverter;
import com.asiyesaribulak.account.exception.CustomerNotFoundException;
import com.asiyesaribulak.account.model.Customer;
import com.asiyesaribulak.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
   private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    protected Customer findCustomerById(String id){
       return customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("Customer could find by ıd" + id));
    }

    public CustomerDto getCustomerById(String id){
        return customerDtoConverter.convertToCustomerDto(findCustomerById(id));
    }
    public List<CustomerDto>  getAllCustomer(){
        return customerRepository.findAll()
                .stream()
                .map(customerDtoConverter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}

package com.asiyesaribulak.account.dto.converter;

import com.asiyesaribulak.account.dto.AccountCustomerDto;
import com.asiyesaribulak.account.dto.CustomerDto;
import com.asiyesaribulak.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }
    public AccountCustomerDto accountCustomerDtoConvert(Optional<Customer> from){
        return from.map(f-> new AccountCustomerDto(f.getId(),f.getName(),f.getSurname())).orElse(null);
    }

    public CustomerDto convert(Customer from){
        return new CustomerDto(from.getId(), from.getName(),
                from.getSurname(),
                from.getAccount()
                        .stream()
                        .map(customerAccountDtoConverter::convert)
                        .collect(Collectors.toSet()) );
    }
}

package com.asiyesaribulak.account.dto.converter;

import com.asiyesaribulak.account.dto.AccountDto;
import com.asiyesaribulak.account.dto.CustomerAccountDto;
import com.asiyesaribulak.account.dto.CustomerDto;
import com.asiyesaribulak.account.dto.TranscationDto;
import com.asiyesaribulak.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {
    private final TranscationDtoConverter transcationDtoConverter;

    public CustomerAccountDtoConverter(TranscationDtoConverter transcationDtoConverter) {
        this.transcationDtoConverter = transcationDtoConverter;
    }

    public CustomerAccountDto convert(Account from){
        return new CustomerAccountDto(
                Objects.requireNonNull(from.getId()),
                from.getBalance(),
                from.getCreationDate(),
                from.getTranscation()
                        .stream()
                        .map(transcationDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }

}

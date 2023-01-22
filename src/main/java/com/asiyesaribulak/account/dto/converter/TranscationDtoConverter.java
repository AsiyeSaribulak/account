package com.asiyesaribulak.account.dto.converter;

import com.asiyesaribulak.account.dto.TranscationDto;
import com.asiyesaribulak.account.model.Transcation;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TranscationDtoConverter {

    public TranscationDto convert(Transcation from){
        return new TranscationDto(
                Objects.requireNonNull(from.getId()),
                from.getTranscationType(),
                from.getAmount(),
                from.getTranscationDate()

        );
    }
}

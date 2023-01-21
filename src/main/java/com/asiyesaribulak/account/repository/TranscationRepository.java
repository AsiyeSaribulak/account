package com.asiyesaribulak.account.repository;

import com.asiyesaribulak.account.model.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscationRepository extends JpaRepository<Transcation,String> {
}

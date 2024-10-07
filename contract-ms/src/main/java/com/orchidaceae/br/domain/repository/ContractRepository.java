package com.orchidaceae.br.domain.repository;

import com.orchidaceae.br.domain.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}

package com.orchidaceae.br.domain.repository;

import com.orchidaceae.br.domain.model.ContractProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContractProductRepository extends JpaRepository<ContractProduct, Long> {

    Optional<ContractProduct> findByContractIdAndProductId(Long contractId, Long productId);

    @Query("SELECT cp FROM ContractProduct cp WHERE cp.productId = :productId")
    List<ContractProduct> findContractProductByProductId(Long productId);
}

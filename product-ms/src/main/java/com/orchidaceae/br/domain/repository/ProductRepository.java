package com.orchidaceae.br.domain.repository;

import com.orchidaceae.br.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

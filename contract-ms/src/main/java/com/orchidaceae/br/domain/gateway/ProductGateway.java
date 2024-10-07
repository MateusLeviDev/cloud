package com.orchidaceae.br.domain.gateway;

import com.orchidaceae.br.integration.dto.ProductDTO;

import java.util.Optional;

public interface ProductGateway {
    Optional<ProductDTO> findProductById(final Long id);
}

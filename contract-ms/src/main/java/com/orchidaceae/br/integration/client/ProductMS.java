package com.orchidaceae.br.integration.client;

import com.orchidaceae.br.integration.dto.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ProductMS {

    @GetExchange("/product/{productId}")
    ProductDTO findById(@PathVariable final Long productId);
}

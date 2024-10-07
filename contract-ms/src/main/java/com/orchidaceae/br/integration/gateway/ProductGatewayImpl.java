package com.orchidaceae.br.integration.gateway;

import com.orchidaceae.br.domain.gateway.ProductGateway;
import com.orchidaceae.br.integration.client.ProductMS;
import com.orchidaceae.br.integration.dto.ProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProductGatewayImpl implements ProductGateway {

    private final ProductMS productMS;

    @Override
    public Optional<ProductDTO> findProductById(Long id) {
        try {
            ProductDTO productDTO = productMS.findById(id);
            return Optional.ofNullable(productDTO);
        } catch (Exception e) {
            //TODO: exception
            return Optional.empty();
        }
    }
}

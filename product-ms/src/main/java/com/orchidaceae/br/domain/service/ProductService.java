package com.orchidaceae.br.domain.service;

import com.orchidaceae.br.api.dto.request.ProductRequestDTO;
import com.orchidaceae.br.api.mapper.ProductMapper;
import com.orchidaceae.br.domain.model.Product;
import com.orchidaceae.br.domain.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public Product save(final ProductRequestDTO productRequestDTO) {
        final Product model = productMapper.toModel(productRequestDTO);
        return productRepository.save(model);
    }

    public Product findById(final Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("erróóóóoóúuu")
        );
    }
}

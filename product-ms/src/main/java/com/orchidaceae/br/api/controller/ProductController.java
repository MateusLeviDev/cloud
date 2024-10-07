package com.orchidaceae.br.api.controller;

import com.orchidaceae.br.api.dto.request.ProductRequestDTO;
import com.orchidaceae.br.api.dto.response.ProductResponseDTO;
import com.orchidaceae.br.api.mapper.ProductMapper;
import com.orchidaceae.br.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody final ProductRequestDTO productRequestDTO) {
        final var savedProduct = productMapper.toDTO(productService.save(productRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable final Long productId) {
        final var savedProduct = productMapper.toDTO(productService.findById(productId));
        return ResponseEntity.ok(savedProduct);
    }
}

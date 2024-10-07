package com.orchidaceae.br.api.mapper;

import com.orchidaceae.br.api.dto.request.ProductRequestDTO;
import com.orchidaceae.br.api.dto.response.ProductResponseDTO;
import com.orchidaceae.br.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toModel(ProductRequestDTO productRequestDTO);

    ProductResponseDTO toDTO(Product product);
}

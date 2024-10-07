package com.orchidaceae.br.api.mapper;

import com.orchidaceae.br.api.dto.request.ContractRequestDTO;
import com.orchidaceae.br.api.dto.response.ContractProductResponseDTO;
import com.orchidaceae.br.api.dto.response.ContractResponseDTO;
import com.orchidaceae.br.domain.model.Contract;
import com.orchidaceae.br.domain.model.ContractProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContractProductMapper {

    @Mapping(target = "contractId", source = "contractProduct.contract.id")
    ContractProductResponseDTO toDTO(ContractProduct contractProduct);
}

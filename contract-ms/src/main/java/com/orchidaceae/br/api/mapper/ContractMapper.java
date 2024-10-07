package com.orchidaceae.br.api.mapper;

import com.orchidaceae.br.api.dto.request.ContractRequestDTO;
import com.orchidaceae.br.api.dto.response.ContractResponseDTO;
import com.orchidaceae.br.domain.model.Contract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    Contract toModel(ContractRequestDTO contractRequestDTO);

    ContractResponseDTO toDTO(Contract contract);
}

package com.orchidaceae.br.api.dto.response;

public record ContractProductResponseDTO(
        Long contractId,
        Long productId,
        String startDate
) {
}

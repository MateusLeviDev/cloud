package com.orchidaceae.br.api.dto.response;

import java.math.BigDecimal;

public record ContractResponseDTO(
        Long id,
        String invoiceDescription,
        BigDecimal globalLimit,
        Integer billingDay
) {
}

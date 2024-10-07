package com.orchidaceae.br.api.dto.request;

import java.math.BigDecimal;

public record ContractRequestDTO(
        String invoiceDescription,
        BigDecimal globalLimit,
        Integer billingDay
) {
}

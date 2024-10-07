package com.orchidaceae.br.api.controller;

import com.orchidaceae.br.api.dto.request.ContractProductRequestDTO;
import com.orchidaceae.br.api.dto.response.ContractProductResponseDTO;
import com.orchidaceae.br.api.mapper.ContractProductMapper;
import com.orchidaceae.br.domain.service.ContractProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContractProductController {

    private final ContractProductService contractProductService;
    private final ContractProductMapper contractProductMapper;

    @PostMapping("/{contractId}/product/{productId}")
    public ResponseEntity<ContractProductResponseDTO> attachProductToContract(
            @PathVariable(name = "contractId") final Long contractId,
            @PathVariable(name = "productId") final Long productId,
            @RequestBody final ContractProductRequestDTO contractProductRequestDTO) {
        final ContractProductResponseDTO contractProductResponseDTO = contractProductMapper.toDTO(
                contractProductService.attachProductToContract(contractId, productId, contractProductRequestDTO));

        return ResponseEntity.ok(contractProductResponseDTO);
    }

}

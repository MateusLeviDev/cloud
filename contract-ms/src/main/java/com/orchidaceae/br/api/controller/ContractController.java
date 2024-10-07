package com.orchidaceae.br.api.controller;

import com.orchidaceae.br.api.dto.request.ContractRequestDTO;
import com.orchidaceae.br.api.dto.response.ContractResponseDTO;
import com.orchidaceae.br.api.mapper.ContractMapper;
import com.orchidaceae.br.domain.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;
    private final ContractMapper contractMapper;

    @PostMapping
    public ResponseEntity<ContractResponseDTO> save(@RequestBody final ContractRequestDTO contractRequestDTO) {
        final var savedContract = contractMapper.toDTO(contractService.save(contractRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContract);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractResponseDTO> findById(@PathVariable final Long productId) {
        final var savedContract = contractMapper.toDTO(contractService.findById(productId));
        return ResponseEntity.ok(savedContract);
    }
}

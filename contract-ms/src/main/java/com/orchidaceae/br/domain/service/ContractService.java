package com.orchidaceae.br.domain.service;

import com.orchidaceae.br.api.dto.request.ContractRequestDTO;
import com.orchidaceae.br.api.mapper.ContractMapper;
import com.orchidaceae.br.domain.model.Contract;
import com.orchidaceae.br.domain.repository.ContractRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    @Transactional
    public Contract save(final ContractRequestDTO contractRequestDTO) {
        final var model = contractMapper.toModel(contractRequestDTO);
        return contractRepository.save(model);
    }

    public Contract findById(final Long id) {
        return contractRepository.findById(id).orElseThrow(
                () -> new RuntimeException("erróóóóoóúuu")
        );
    }
}

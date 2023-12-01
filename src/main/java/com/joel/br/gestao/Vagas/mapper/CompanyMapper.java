package com.joel.br.gestao.Vagas.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.br.gestao.Vagas.domain.Company;
import com.joel.br.gestao.Vagas.dto.CompanyDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CompanyMapper {

    private final ObjectMapper mapper;



    public Company toEntity(CompanyDTO dto) {
        return mapper.convertValue(dto, Company.class);
    }

    public CompanyDTO toDto(Company entity) {
        return mapper.convertValue(entity, CompanyDTO.class);
    }
}

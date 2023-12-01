package com.joel.br.gestao.Vagas.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.br.gestao.Vagas.domain.Company;
import com.joel.br.gestao.Vagas.domain.Jobs;
import com.joel.br.gestao.Vagas.dto.CompanyDTO;
import com.joel.br.gestao.Vagas.dto.JobsDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JobsMapper {

    private final ObjectMapper mapper;



    public Jobs toEntity(JobsDTO dto) {
        return mapper.convertValue(dto, Jobs.class);
    }

    public JobsDTO toDto(Jobs entity) {
        return mapper.convertValue(entity, JobsDTO.class);
    }
}

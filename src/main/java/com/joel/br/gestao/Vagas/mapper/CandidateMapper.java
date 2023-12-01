package com.joel.br.gestao.Vagas.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.br.gestao.Vagas.domain.Candidate;
import com.joel.br.gestao.Vagas.dto.CandidateDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CandidateMapper {


    private final ObjectMapper mapper;



    public CandidateDTO toEntity(Candidate candidate ) {
        return mapper.convertValue(candidate, CandidateDTO.class);
    }

    public Candidate toDomain(CandidateDTO candidateDTO ) {
        return mapper.convertValue(candidateDTO, Candidate.class);
    }

}

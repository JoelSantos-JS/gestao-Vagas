package com.joel.br.gestao.Vagas.services;

import com.joel.br.gestao.Vagas.domain.Candidate;
import com.joel.br.gestao.Vagas.dto.CandidateDTO;
import com.joel.br.gestao.Vagas.exceptions.UserAlreadyExists;
import com.joel.br.gestao.Vagas.mapper.CandidateMapper;
import com.joel.br.gestao.Vagas.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CandidateService {

    private final CandidateRepository repository;
    private final CandidateMapper mapper;



    public List<Candidate> candidates() {
        return repository.findAll();
    }

    public Candidate findById(UUID id) {
        return repository.findById(id).get();
    }

    public CandidateDTO save(CandidateDTO candidate ) {
        Candidate candidate1 = mapper.toDomain(candidate);
            verifyUserAndEmail(candidate1);

            repository.save(candidate1);
        return mapper.toEntity(candidate1);
    }


    public void verifyUserAndEmail(Candidate candidate) {

        repository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent(user -> {
                    throw new UserAlreadyExists("User or Email already exists");
                });


        }


}
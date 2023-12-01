package com.joel.br.gestao.Vagas.repository;

import com.joel.br.gestao.Vagas.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {

    Optional<Candidate> findByUsernameOrEmail(String username, String email);

}

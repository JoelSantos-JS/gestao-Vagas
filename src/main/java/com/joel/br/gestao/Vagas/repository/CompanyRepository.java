package com.joel.br.gestao.Vagas.repository;

import com.joel.br.gestao.Vagas.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findByUsername(String username);
}

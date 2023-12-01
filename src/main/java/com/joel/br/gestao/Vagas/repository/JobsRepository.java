package com.joel.br.gestao.Vagas.repository;

import com.joel.br.gestao.Vagas.domain.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs,Long> {
}

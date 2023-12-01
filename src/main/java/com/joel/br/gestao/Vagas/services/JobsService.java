package com.joel.br.gestao.Vagas.services;

import com.joel.br.gestao.Vagas.domain.Company;
import com.joel.br.gestao.Vagas.domain.Jobs;
import com.joel.br.gestao.Vagas.dto.JobsDTO;
import com.joel.br.gestao.Vagas.mapper.JobsMapper;
import com.joel.br.gestao.Vagas.repository.CompanyRepository;
import com.joel.br.gestao.Vagas.repository.JobsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor

public class JobsService {

    private final JobsRepository repository;
    private final JobsMapper mapper;

    private final CompanyRepository companyRepository;

    public List<Jobs> findAll() {
    return repository.findAll();
    }

    @Transactional(readOnly = true)
    public JobsDTO findById(Long id) {
        Jobs jobs = repository.findById(id).get();

        return mapper.toDto(jobs);
    }


    public JobsDTO save(JobsDTO jobsDTO) {
        Jobs jobs = mapper.toEntity(jobsDTO);
        Company company = companyRepository.findById(jobsDTO.getCompany().getId()).get();

        if(company !=null) {
            jobs.setCompany(company);
        }

        repository.save(jobs);
        return mapper.toDto(jobs);
    }

}

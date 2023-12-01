package com.joel.br.gestao.Vagas.services;

import com.joel.br.gestao.Vagas.domain.Company;
import com.joel.br.gestao.Vagas.domain.Jobs;
import com.joel.br.gestao.Vagas.dto.CompanyDTO;
import com.joel.br.gestao.Vagas.dto.JobsDTO;
import com.joel.br.gestao.Vagas.mapper.CompanyMapper;
import com.joel.br.gestao.Vagas.mapper.JobsMapper;
import com.joel.br.gestao.Vagas.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private  final CompanyMapper mapper;
    private final JobsMapper jobsMapper;

    @Transactional
    public CompanyDTO save(CompanyDTO company) {
        Company company1 = mapper.toEntity(company);


        if(company.getJobs() != null) {
            for (JobsDTO jobsDTO : company.getJobs()) {
                Jobs jobs = jobsMapper.toEntity(jobsDTO);
                company1.getJobs().add(jobs);
            }

        }
        companyRepository.save(company1);
        return mapper.toDto(company1);
    }

    @Transactional(readOnly = true)
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }




}

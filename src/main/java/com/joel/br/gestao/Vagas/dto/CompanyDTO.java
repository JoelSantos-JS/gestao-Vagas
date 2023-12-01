package com.joel.br.gestao.Vagas.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.List;
@Data
@NoArgsConstructor
public class CompanyDTO {
    private Long id;
    private String email;
    private String name;
    private String cnpj;
    private String webSite;
    private String username;
    private String password;
    private List<JobsDTO> jobs;
    private String description;

    public CompanyDTO( String email, String name, String cnpj, String webSite, String username, String password, List<JobsDTO> jobs, String description) {

        this.email = email;
        this.name = name;
        this.cnpj = cnpj;
        this.webSite = webSite;
        this.username = username;
        this.password = password;
        this.description = description;
        for (JobsDTO job : jobs) {
           this.jobs.add(job);
        }
    }

    // Getters and setters (gerados automaticamente ou implementados manualmente)


}

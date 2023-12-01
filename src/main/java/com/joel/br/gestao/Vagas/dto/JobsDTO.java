package com.joel.br.gestao.Vagas.dto;

import com.joel.br.gestao.Vagas.domain.Company;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class JobsDTO {
    private String title;
    private String description;
    private String level;
    private CompanyDTO company;

    public JobsDTO(String title, String description, String level, CompanyDTO company) {

        this.title = title;
        this.description = description;
        this.level = level;
        this.company = company;
    }

    // Getters and setters (gerados automaticamente ou implementados manualmente)


}

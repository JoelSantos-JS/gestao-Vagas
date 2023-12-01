package com.joel.br.gestao.Vagas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cnpj;
    private String email;
    private String username;
    private String password;
    private String description;
    private String webSite;
    @OneToMany(mappedBy = "company")
    private List<Jobs> jobs;
}

package com.joel.br.gestao.Vagas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();
    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String phone;

    private String description;
    private String resume;
}

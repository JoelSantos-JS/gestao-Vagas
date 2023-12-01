package com.joel.br.gestao.Vagas.controller;

import com.joel.br.gestao.Vagas.domain.Company;
import com.joel.br.gestao.Vagas.domain.Jobs;
import com.joel.br.gestao.Vagas.dto.CompanyDTO;
import com.joel.br.gestao.Vagas.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/company")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService service;


    @GetMapping
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> save(@RequestBody CompanyDTO company) {
        return ResponseEntity.ok().body(service.save(company));
    }
}

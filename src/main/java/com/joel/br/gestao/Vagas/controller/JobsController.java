package com.joel.br.gestao.Vagas.controller;

import com.joel.br.gestao.Vagas.domain.Jobs;
import com.joel.br.gestao.Vagas.dto.JobsDTO;
import com.joel.br.gestao.Vagas.services.JobsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/jobs")
@AllArgsConstructor
public class JobsController {

    private final JobsService service;



    @GetMapping
    public ResponseEntity<List<Jobs>> findAll() {
        return ResponseEntity.ok().body( service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JobsDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<JobsDTO> save(@RequestBody JobsDTO jobsDTO) {
        return ResponseEntity.ok().body(service.save(jobsDTO));
    }
}

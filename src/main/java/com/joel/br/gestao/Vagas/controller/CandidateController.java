package com.joel.br.gestao.Vagas.controller;

import com.joel.br.gestao.Vagas.domain.Candidate;
import com.joel.br.gestao.Vagas.dto.CandidateDTO;
import com.joel.br.gestao.Vagas.services.CandidateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/candidate")
@AllArgsConstructor
public class CandidateController {

    private final CandidateService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<CandidateDTO> save(@RequestBody @Valid CandidateDTO candidate) {
        return ResponseEntity.ok().body(service.save(candidate));
    }


}

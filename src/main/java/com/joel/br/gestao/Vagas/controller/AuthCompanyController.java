package com.joel.br.gestao.Vagas.controller;

import com.joel.br.gestao.Vagas.dto.AuthCompanyDTO;
import com.joel.br.gestao.Vagas.services.AuthCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth/company")
@AllArgsConstructor
public class AuthCompanyController {

    private final AuthCompanyService service;


    @PostMapping
    public ResponseEntity<Object> authentication(@RequestBody AuthCompanyDTO authCompanyDTO) {

        try {
            return ResponseEntity.ok().body(service.authentication(authCompanyDTO));

        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("password or username it's incorrect");

        }
    }


}

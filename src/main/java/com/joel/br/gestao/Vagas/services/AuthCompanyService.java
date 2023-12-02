package com.joel.br.gestao.Vagas.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.joel.br.gestao.Vagas.dto.AuthCompanyDTO;
import com.joel.br.gestao.Vagas.exceptions.UserNameNotFoundExeptions;
import com.joel.br.gestao.Vagas.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCompanyService {
    @Value("${spring.s.secrete}")
    private String secrete;

    private final CompanyRepository repository;
    private final PasswordEncoder passwordEncoder;

    public AuthCompanyService(CompanyRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public String  authentication(AuthCompanyDTO authCompanyDTO ) {
        var company = repository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(() -> new UserNameNotFoundExeptions("Company not found"));

      var passwordMatch =   this.passwordEncoder.matches(authCompanyDTO.getPassword(),company.getPassword());

      if(!passwordMatch) {
          throw new RuntimeException("Password not match");
      }
      // Gera token
        Algorithm algorithm = Algorithm.HMAC256(secrete);
      var token = JWT.create().withIssuer("GestaoVagas").withSubject(company.getId().toString()).sign(algorithm);

      return  token;
    }
}

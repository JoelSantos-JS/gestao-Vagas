package com.joel.br.gestao.Vagas.dto;

import java.util.UUID;

public record CandidateDTO ( String name, String email, String username, String password, String phone, String description, String resume ) {
}

package br.com.triersistemas.andromeda.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class ClienteModel {
    private String nome;
    private LocalDate niver;
    private String cpf;
    private UUID id;
    private String email;
}

